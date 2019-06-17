/*
 * Copyright 2012-2018 Christophe Friederich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.maven.skins.reflow;

import static java.util.Objects.requireNonNull;

import java.net.URI;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.RenderTool;
import org.apache.velocity.tools.generic.SafeConfig;
import org.apache.velocity.tools.generic.ValueParser;
import org.codehaus.plexus.util.PathTool;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.URITool.URLRebaser;
import org.devacfr.maven.skins.reflow.context.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;

/**
 * An Apache Velocity tool that simplifies retrieval of custom configuration values for a Maven Site.
 * <p>
 * The tool is configured to access Maven site configuration of a skin inside {@code <custom>} element of site
 * descriptor. It supports global properties (defined at skin level) and per-page properties (defined in
 * {@code <page><mypage>} element). The per-page properties override the global ones.
 * </p>
 * <p>
 * A sample configuration would be like that:
 * </p>
 *
 * <pre>
 * {@code
 * <custom>
 *   <reflowSkin>
 *     <prop1>value1</prop1>
 *     <prop2>
 *       <prop21>value2</prop21>
 *     </prop2>
 *     <pages>
 *       <mypage project="myproject">
 *         <prop1>override value1</prop1>
 *       </mypage>
 *     </pages>
 *   </reflowSkin>
 * </custom>
 * }
 * </pre>
 * <p>
 * To get the value of {@code prop1}, one would simply use {@code $config.prop1}. This would return "override value1".
 * Then {@code $config.prop2} would return "value2" - the global value.
 * </p>
 * <p>
 * The tool allows querying the value easily, falling back from page to global configuration to {@code null}, if none is
 * available. It also provides convenience accessors for common values.
 * </p>
 * <p>
 * Note
 * </p>
 *
 * @author Andrius Velykis
 * @author Christophe Friederich
 * @since 1.0
 */
@DefaultKey("config")
public class SkinConfigTool extends SafeConfig implements ISkinConfig {

    /** */
    private static final Logger LOGGER = LoggerFactory.getLogger(SkinConfigTool.class);

    /** */
    public static final String DEFAULT_KEY = "config";

    /** By default use Reflow skin configuration tag. */
    public static final String SKIN_KEY = "reflowSkin";

    /** */
    private String key = DEFAULT_KEY;

    /** */
    private String skinKey = SKIN_KEY;

    /** Create dummy nodes to avoid null checks. */
    private Xpp3Dom globalProperties = new Xpp3Dom("");

    /** */
    private Xpp3Dom pageProperties = new Xpp3Dom("");

    /** */
    private String namespace = "";

    /** */
    private String projectId = null;

    /** */
    private String fileId = null;

    /** */
    private Context<?> context = null;

    /** */
    private MavenProject project = null;

    /** */
    private DecorationModel decoration;

    /** */
    private ToolContext velocityContext;

    /**
     * {@inheritDoc}
     *
     * @see SafeConfig#configure(ValueParser)
     */
    @Override
    protected void configure(final ValueParser values) {
        final String altkey = values.getString("key");
        if (altkey != null) {
            setKey(altkey);
        }

        // allow changing skin key in the configuration
        final String altSkinKey = values.getString("skinKey");
        if (altSkinKey != null) {
            this.skinKey = altSkinKey;
        }

        // retrieve the decoration model from Velocity context
        final Object vc = values.get("velocityContext");

        if (!(vc instanceof ToolContext)) {
            return;
        }

        this.velocityContext = (ToolContext) vc;

        final Object projectObj = velocityContext.get("project");
        if (projectObj instanceof MavenProject) {
            this.project = (MavenProject) projectObj;
            final String artifactId = project.getArtifactId();
            // use artifactId "sluggified" as the projectId
            projectId = HtmlTool.slug(artifactId);
        }

        // calculate the page ID from the current file name
        final String currentFileObj = getCurrentFileName();
        fileId = slugFilename(currentFileObj);

        final Object decorationObj = velocityContext.get("decoration");

        if (!(decorationObj instanceof DecorationModel)) {
            return;
        }

        this.decoration = (DecorationModel) decorationObj;
        final Object customObj = decoration.getCustom();

        if (!(customObj instanceof Xpp3Dom)) {
            return;
        }

        // Now that we have the custom node, get the global properties
        // under the skin tag
        final Xpp3Dom customNode = (Xpp3Dom) customObj;
        Xpp3Dom skinNode = customNode.getChild(skinKey);
        final String namespaceKey = ":" + skinKey;

        if (skinNode == null) {
            // try searching with any namespace
            for (final Xpp3Dom child : customNode.getChildren()) {
                if (child.getName().endsWith(namespaceKey)) {
                    skinNode = child;
                    break;
                }
            }
        }

        if (skinNode != null) {
            globalProperties = skinNode;

            if (skinNode.getName().endsWith(namespaceKey)) {
                // extract the namespace (including the colon)
                namespace = skinNode.getName().substring(0, skinNode.getName().length() - namespaceKey.length() + 1);
            }

            // for page properties, retrieve the file name and drop the `.html`
            // extension - this will be used, i.e. `index` instead of `index.html`
            final Xpp3Dom pagesNode = Xpp3Utils.getFirstChild(skinNode, "pages", namespace);
            if (pagesNode != null) {

                // Get the page for the file
                Xpp3Dom page = Xpp3Utils.getFirstChild(pagesNode, fileId, namespace);

                // Now check if the project artifact ID is set, and if so, if it matches the
                // current project. This allows preventing accidental reuse of parent page
                // configs in children modules
                if (page != null && projectId != null) {
                    final String pageProject = page.getAttribute("project");
                    if (pageProject != null && !projectId.equals(pageProject)) {
                        // project ID indicated, and is different - do not use the config
                        page = null;
                    }
                }

                if (page != null) {
                    pageProperties = page;
                }

            }

            // Config option <localResources>true</localResources> to force CDN-less Bootstrap & jQuery
            this.velocityContext.put("localResources", is("localResources"));
            // Use config option <absoluteResourceURL>http://mysite.com/</absoluteResourceURL>
            this.velocityContext.put("resourcePath", getResourcePath());

            this.context = Context.buildContext(this);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Current Filename: {}", currentFileObj);
            LOGGER.debug("Project id: {}", projectId);
            LOGGER.debug("File id: {}", fileId);
            LOGGER.debug("Context: {}", this.context);
            LOGGER.debug("Namespace: {}", this.namespace);
            LOGGER.debug("---------------------------------------------------");
        }
    }

    /**
     * Sets the key under which this tool has been configured.
     *
     * @param key
     *            the key of config
     * @since 1.0
     */
    protected void setKey(final String key) {
        this.key = requireNonNull(key, "SkinConfigTool key cannot be null");
    }

    /**
     * @return Returns the key under which this tool has been configured. The default is `config`.
     * @since 1.0
     */
    public String getKey() {
        return this.key;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public Xpp3Dom get(@Nonnull final String property) {
        requireNonNull(property);
        // first try page properties
        Xpp3Dom propNode = Xpp3Utils.getFirstChild(pageProperties, property, namespace);
        if (propNode == null) {
            // try global
            propNode = Xpp3Utils.getFirstChild(globalProperties, property, namespace);
        }

        return propNode;
    }

    /**
     * Retrieves the text value of the given {@code property}, e.g. as in {@code <myprop>value</myprop>}.
     *
     * @param property
     *            the property of interest
     * @return the configuration value if found in page or globally, {@code null} otherwise.
     * @see #get(String)
     * @since 1.0
     */
    @Nullable
    public String value(@Nonnull final String property) {
        requireNonNull(property);
        final Xpp3Dom propNode = get(property);

        if (propNode == null) {
            // not found
            return null;
        }

        return propNode.getValue();
    }

    /**
     * Gets the text value of the given {@code property}.
     *
     * @param property
     *            the property to use
     * @param targetType
     *            the returned target type use to convert value.
     * @param defaultValue
     *            the default value used if property doesn't exist.
     * @return Returns a converted value of the given {@code property}.
     * @since 2.0
     * @param <T>
     *            the type of returned object.
     */
    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public <T> T getPropertyValue(@Nonnull final String property,
        @Nonnull final Class<T> targetType,
        @Nullable final T defaultValue) {
        requireNonNull(property, "property is required");
        requireNonNull(targetType, "targetType is required");
        final String value = value(property);
        if (value == null) {
            return defaultValue;
        }
        Object returnedValue = value;
        if (targetType.isAssignableFrom(Boolean.class)) {
            returnedValue = Boolean.valueOf(value);
        } else if (targetType.isAssignableFrom(Integer.class)) {
            returnedValue = Integer.valueOf(value);
        } else if (targetType.isAssignableFrom(Long.class)) {
            returnedValue = Long.valueOf(value);
        }
        return (T) returnedValue;
    }

    /**
     * Gets the list of all children name for the {@code parentNode}.
     *
     * @param parentNode
     *            the parent node to use (can be {@code null}.
     * @return Returns a list of {@link String} representing the name of all children, which may be empty but never
     *         {@code null}.
     * @since 1.3
     */
    public List<String> getChildren(final Xpp3Dom parentNode) {
        return Xpp3Utils.getChildren(parentNode);
    }

    /**
     * Gets the attribute value of the given {@code attribute} of {@code property}.
     *
     * @param property
     *            the property to use
     * @param attribute
     *            the attribute to use.
     * @param targetType
     *            the returned target type use to convert value.
     * @param defaultValue
     *            the default value used if property doesn't exist.
     * @return Returns a converted value of the given {@code property}.
     * @since 2.0
     * @param <T>
     *            the type of returned object.
     */
    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public <T> T getAttributeValue(@Nonnull final String property,
        @Nonnull final String attribute,
        @Nonnull final Class<T> targetType,
        @Nullable final T defaultValue) {
        requireNonNull(property, "property is required");
        requireNonNull(attribute, "attribute is required");
        requireNonNull(targetType, "targetType is required");

        Xpp3Dom element = get(property);
        if (element == null) {
            return defaultValue;
        }
        String value = element.getAttribute(attribute);
        if (value == null) {
            return defaultValue;
        }

        if ("inherit".equals(value)) {
            element = Xpp3Utils.getFirstChild(globalProperties, property, namespace);
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Inherit value property '{}': {}", property, element);
            }
        }
        if (element == null) {
            return defaultValue;
        }
        value = element.getAttribute(attribute);
        if (value == null) {
            return defaultValue;
        }

        Object returnedValue = value;
        if (targetType.isAssignableFrom(Boolean.class)) {
            returnedValue = Boolean.valueOf(value);
        } else if (targetType.isAssignableFrom(Integer.class)) {
            returnedValue = Integer.valueOf(value);
        } else if (targetType.isAssignableFrom(Long.class)) {
            returnedValue = Long.valueOf(value);
        }
        return (T) returnedValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public <T> T getAttributeValue(@Nonnull final Xpp3Dom element,
        @Nonnull final String attribute,
        @Nonnull final Class<T> targetType,
        @Nullable final T defaultValue) {
        if (element == null) {
            return defaultValue;
        }
        final String value = element.getAttribute(attribute);
        if (value == null) {
            return defaultValue;
        }
        Object returnedValue = value;
        if (targetType.isAssignableFrom(Boolean.class)) {
            returnedValue = Boolean.valueOf(value);
        } else if (targetType.isAssignableFrom(Integer.class)) {
            returnedValue = Integer.valueOf(value);
        } else if (targetType.isAssignableFrom(Long.class)) {
            returnedValue = Long.valueOf(value);
        }
        return (T) returnedValue;
    }

    /**
     * A convenience method to check if the value of the {@code property} is {@code "true"}.
     *
     * @param property
     *            the property of interest
     * @return {@code true} if the configuration value is set either in page or globally, and is equal to
     *         {@code "true"}.
     * @see #get(String)
     * @since 1.0
     */
    public boolean is(final String property) {
        return "true".equals(value(property));
    }

    /**
     * A convenience method to check if the value of the {@code property} is {@code "false"}. Useful for properties that
     * are enabled by default - checks if the property is set to {@code "false"} explicitly.
     *
     * @param property
     *            the property of interest
     * @return {@code true} if the configuration value is set either in page or globally, and is equal to
     *         {@code "false"}. Note that this will return {@code false} if property is not set at all.
     * @see #get(String)
     * @since 1.0
     */
    public boolean not(final String property) {
        return "false".equals(value(property));
    }

    /**
     * A convenience method to check if the {@code property} is set to a specific value.
     *
     * @param property
     *            the property of interest
     * @param value
     *            the property value to check
     * @return {@code true} if the configuration value is set either in page or globally, and is equal to {@code value}.
     * @see #get(String)
     * @since 1.0
     */
    public boolean isValue(final String property, final String value) {
        return value != null && value.equals(value(property));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public String getProjectId() {
        return projectId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nullable
    public String getFileId() {
        return fileId;
    }

    /**
     * @return the context
     */
    public Context<?> getContext() {
        return context;
    }

    /**
     * @return the velocity Context
     */
    public ToolContext getVelocityContext() {
        return velocityContext;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public MavenProject getProject() {
        return project;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public DecorationModel getDecoration() {
        return decoration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public Xpp3Dom getPageProperties() {
        return pageProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public Xpp3Dom getGlobalProperties() {
        return globalProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Nonnull
    public String getNamespace() {
        return namespace;
    }

    /**
     * @return Returns the location of project.
     */
    @Nonnull
    public String getProjectLocation() {
        String projectSiteLoc = getProject().getUrl();
        if (!Strings.isNullOrEmpty(projectSiteLoc)) {

            if (!projectSiteLoc.endsWith("/")) {
                projectSiteLoc += "/";
            }
        }
        return projectSiteLoc;
    }

    /**
     * <p>
     * See <a href="https://maven.apache.org/doxia/doxia-sitetools/doxia-site-renderer/">Doxia Sitetools - Site
     * Renderer</a> for more information.
     *
     * @return Returns a {@link String} representing the name of current file of the (HTML) document being rendered,
     *         relative to the site root.
     */
    @Nonnull
    public String getCurrentFileName() {
        return (String) velocityContext.get("currentFileName");
    }

    /**
     * @return Returns a {@link String} representing the location path of current rendered file.
     */
    @Nonnull
    public String getCurrentFileLocation() {
        final String projectSiteLoc = getProjectLocation();
        return URITool.toURI(projectSiteLoc).resolve(getCurrentFileName()).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    @Nullable
    public <T> T eval(@Nullable final String vtl, @Nonnull final Class<T> requiredClass) {
        if (vtl == null) {
            return null;
        }
        final RenderTool renderTool = (RenderTool) getVelocityContext().get("render");
        try {
            return (T) renderTool.eval(getVelocityContext(), vtl);
        } catch (final Exception ex) {
            throw new RuntimeException("error when try evaluate '" + vtl + "'", ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String relativeLink(final String href) {
        if (href == null) {
            return null;
        }
        if (isExternalLink(href)) {
            return href;
        }
        final String relativePath = (String) velocityContext.get("relativePath");
        String relativeLink = PathTool.calculateLink(href, relativePath);
        relativeLink = relativeLink.replaceAll("\\\\", "/");
        if (Strings.isNullOrEmpty(relativeLink)) {
            relativeLink = "./";
        }
        // Attempt to normalise the relative link - this is useful for active link
        // calculations and better relative links for subdirectories.
        //
        // The issue is particularly visible with pages in subdirectories,
        // so that if you are in <root>/dev/index.html, the relative menu link to
        // the _same_ page would likely be ../dev/index.html instead of '' or
        // 'index.html'.
        final String currentFileLoc = getCurrentFileLocation();
        final String absoluteLink = URITool.toURI(currentFileLoc).resolve(relativeLink).normalize().toString();
        if (currentFileLoc.equals(absoluteLink)) {
            // for matching link, use empty relative link
            relativeLink = StringUtils.EMPTY;
        } else {
            // relativize the absolute link based on current directory
            // (uses Maven project link relativization)
            final String currentFileDir = PathTool.getDirectoryComponent(currentFileLoc);
            relativeLink = URITool.relativizeLink(currentFileDir, absoluteLink);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("-- Relative Link ----------------------------------");
            LOGGER.debug("link: {}", href);
            LOGGER.debug("currentFileLoc: {}", currentFileLoc);
            LOGGER.debug("absoluteLink: {}", absoluteLink);
            LOGGER.debug("relativeLink: {}", relativeLink);
            LOGGER.debug("---------------------------------------------------");
        }
        return relativeLink;
    }

    /**
     * @param url
     *            a url.
     * @return Returns {@code true} whether the link is a external link to the site.
     */
    public boolean isExternalLink(final String url) {
        if (url == null) {
            return false;
        }
        final String absoluteResourceURL = this.value("absoluteResourceURL");
        if (!Strings.isNullOrEmpty(absoluteResourceURL) && url.startsWith(absoluteResourceURL)) {
            return false;
        }
        return url.toLowerCase().startsWith("http:/") || url.toLowerCase().startsWith("https:/")
                || url.toLowerCase().startsWith("ftp:/") || url.toLowerCase().startsWith("mailto:")
                || url.toLowerCase().startsWith("file:/") || url.toLowerCase().indexOf("://") != -1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isActiveLink(@Nullable final String href) {
        final String alignedFileName = (String) velocityContext.get("alignedFileName");
        if (href == null) {
            return false;
        }
        // either empty link (pointing to a page), or if the current file is index.html,
        // the link may point to the whole directory
        return Strings.isNullOrEmpty(href) || alignedFileName.endsWith("index.html") && ".".equals(href);
    }

    /**
     * Rebase only affects relative links, a relative link wrt an old base gets translated, so it points to the same
     * location as viewed from a new base.
     *
     * @param link
     *            link to rebase
     * @return Returns a {@link String} representing link rebased.
     */
    public String rebaseLink(final String link) {
        return createURLRebaser().rebaseLink(link);
    }

    /**
     * Converts a filename to pageId format.
     *
     * @param fileName
     *            the filename to convert
     * @return Returns a {@link String} representing the pageId of {@code filename}.
     */
    @Nullable
    public static String slugFilename(@Nullable final String fileName) {
        if (fileName == null) {
            return null;
        }
        String currentFile = fileName;

        // drop the extension
        final int lastDot = currentFile.lastIndexOf(".");
        if (lastDot >= 0) {
            currentFile = currentFile.substring(0, lastDot);
        }

        // get the short ID (in case of nested files)
        // String fileName = new File(currentFile).getName();
        // fileShortId = HtmlTool.slug(fileName);

        // full file ID includes the nested dirs
        // replace nesting "/" with "-"
        return HtmlTool.slug(currentFile.replace("/", "-").replace("\\", "-"));
    }

    /**
     * @return Returns a {@link String} representing the relative path to root site.
     */
    @Nonnull
    private String getResourcePath() {
        final String absoluteResourceURL = this.value("absoluteResourceURL");
        String projectUrl = getProjectLocation();
        final String currentFileName = getCurrentFileName();
        if (!Strings.isNullOrEmpty(projectUrl) && currentFileName != null) {
            if (projectUrl.charAt(projectUrl.length() - 1) != '/') {
                projectUrl += '/';
            }
            final String currentFileDir = URITool.toURI(projectUrl).resolve(currentFileName).resolve(".").toString();
            return URITool.relativizeLink(currentFileDir, absoluteResourceURL);
        }
        return (String) velocityContext.get("relativePath");
    }

    /**
     * @return Returns new instance of {@link URLRebaser}.
     */
    @Nonnull
    private URLRebaser createURLRebaser() {
        String childBaseUrl = this.getProject().getUrl();
        if (Strings.isNullOrEmpty(childBaseUrl)) {
            childBaseUrl = null;
        }
        final String relativePath = getResourcePath();
        String parentBaseUrl = relativePath;
        if (childBaseUrl != null && childBaseUrl.length() > 0) {
            if (childBaseUrl.charAt(childBaseUrl.length() - 1) != '/') {
                childBaseUrl += '/';
            }
            final URI child = URI.create(childBaseUrl);
            parentBaseUrl = child.resolve(relativePath).normalize().toString();
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("parentBaseUrl: {}", parentBaseUrl);
            LOGGER.debug("childBaseUrl: {}", childBaseUrl);
            LOGGER.debug("relativePath: {}", relativePath);
        }

        return URITool.createURLRebaser(parentBaseUrl, childBaseUrl);
    }

}
