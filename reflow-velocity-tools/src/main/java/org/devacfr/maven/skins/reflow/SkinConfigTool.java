/*
 * Copyright 2012 Andrius Velykis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.maven.skins.reflow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.generic.SafeConfig;
import org.apache.velocity.tools.generic.ValueParser;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.context.Context;
import org.devacfr.maven.skins.reflow.context.DocumentContext;
import org.devacfr.maven.skins.reflow.context.FrameContext;
import org.devacfr.maven.skins.reflow.context.PageContext;
import org.devacfr.maven.skins.reflow.model.SideNavMenu;
import org.devacfr.maven.skins.reflow.model.SideNavMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 * @since 1.0
 */
@DefaultKey("config")
public class SkinConfigTool extends SafeConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(SkinConfigTool.class);

    public static final String DEFAULT_KEY = "config";

    /** By default use Reflow skin configuration tag */
    public static final String SKIN_KEY = "reflowSkin";

    /** */
    private String key = DEFAULT_KEY;

    /** */
    private String skinKey = SKIN_KEY;

    /* Create dummy nodes to avoid null checks */
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
        final Object velocityContext = values.get("velocityContext");

        if (!(velocityContext instanceof ToolContext)) {
            return;
        }

        final ToolContext ctxt = (ToolContext) velocityContext;

        final Object projectObj = ctxt.get("project");
        if (projectObj instanceof MavenProject) {
            final MavenProject project = (MavenProject) projectObj;
            final String artifactId = project.getArtifactId();
            // use artifactId "sluggified" as the projectId
            projectId = HtmlTool.slug(artifactId);
        }

        // calculate the page ID from the current file name
        final Object currentFileObj = ctxt.get("currentFileName");
        if (currentFileObj instanceof String) {
            fileId = slugFilename((String) currentFileObj);
        }

        final Object decorationObj = ctxt.get("decoration");

        if (!(decorationObj instanceof DecorationModel)) {
            return;
        }

        final DecorationModel decoration = (DecorationModel) decorationObj;
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
            final Xpp3Dom pagesNode = getChild(skinNode, "pages");
            if (pagesNode != null) {

                // Get the page for the file
                Xpp3Dom page = getChild(pagesNode, fileId);

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
            this.context = buildContext(pagesNode);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Current Filename: " + currentFileObj);
            LOGGER.info("Project id: " + projectId);
            LOGGER.info("File id: " + fileId);
            LOGGER.info("Context: " + this.context);
            LOGGER.info("---------------------------------------------------");
        }
    }

    /**
     * Retrieves the child node. Tests both default name and with namespace.
     *
     * @param parentNode
     * @param name
     * @return
     */
    private Xpp3Dom getChild(final Xpp3Dom parentNode, final String name) {
        final Xpp3Dom child = parentNode.getChild(name);
        if (child != null) {
            return child;
        }

        return parentNode.getChild(namespace + name);
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
        return getChildrenNodes(parentNode, null).stream().map(node -> node.getName()).collect(Collectors.toList());
    }

    /**
     * Sets the key under which this tool has been configured.
     *
     * @since 1.0
     */
    protected void setKey(final String key) {
        if (key == null) {
            throw new NullPointerException("SkinConfigTool key cannot be null");
        }
        this.key = key;
    }

    /**
     * Should return the key under which this tool has been configured. The default is `config`.
     *
     * @since 1.0
     */
    public String getKey() {
        return this.key;
    }

    /**
     * Default accessor for config properties. Instead of using {@code $config.get("myproperty")}, one can utilise
     * Velocity fallback onto the default getter and use {@code $config.myproperty}.
     *
     * @param property
     *            the property of interest
     * @return configuration node if found in the following sequence:
     *         <ol>
     *         <li>In page configuration</li>
     *         <li>In global configuration</li>
     *         <li>{@code null} otherwise</li>
     *         </ol>
     * @since 1.0
     */
    public Xpp3Dom get(final String property) {

        // first try page properties
        Xpp3Dom propNode = getChild(pageProperties, property);
        if (propNode == null) {
            // try global
            propNode = getChild(globalProperties, property);
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
    public String value(final String property) {

        final Xpp3Dom propNode = get(property);

        if (propNode == null) {
            // not found
            return null;
        }

        return propNode.getValue();
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

    public String getProjectId() {
        return projectId;
    }

    public String getFileId() {
        return fileId;
    }

    public Context<?> getContext() {
        return context;
    }

    /**
     * @param fileName
     * @return
     */
    public static String slugFilename(final String fileName) {
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
     * @param pagesNode
     * @return
     */
    private static List<SideNavMenuItem> findAllDocumentMenuItems(final Xpp3Dom pagesNode) {
        if (pagesNode == null) {
            return Collections.emptyList();
        }
        final Xpp3Dom[] pages = pagesNode.getChildren();
        final List<SideNavMenuItem> includePages = new ArrayList<>();
        for (final Xpp3Dom page : pages) {
            final String type = page.getAttribute("type");
            if ("doc".equals(type)) {
                final Xpp3Dom menu = page.getChild("menu");
                if (menu == null) {
                    continue;
                }
                final String pageName = page.getName();
                addMenuItemRecursively(includePages, menu, pageName, true);
            }
        }
        return includePages;
    }

    private static SideNavMenu getDocumentMenu(final Xpp3Dom pageNode) {
        final Xpp3Dom menu = pageNode.getChild("menu");
        if (menu == null) {
            return null;
        }
        final String pageName = pageNode.getName();
        final List<SideNavMenuItem> items = new ArrayList<>();
        final SideNavMenu documentMenu = new SideNavMenu().withName(menu.getAttribute("name")).withItems(items);
        addMenuItemRecursively(items, menu, pageName, false);
        return documentMenu;
    }

    /**
     * @param includePages
     * @param parentNode
     */
    private static void addMenuItemRecursively(final List<SideNavMenuItem> includePages,
        final Xpp3Dom parentNode,
        final String pageName,
        final boolean includSameList) {
        for (final Xpp3Dom item : getChildrenNodes(parentNode, "item")) {
            final String href = item.getAttribute("href");
            final String toc = item.getAttribute("toc");
            final SideNavMenuItem menuItem = new SideNavMenuItem().withName(item.getAttribute("name"))
                    .withParent(pageName)
                    .withHref(href)
                    .withIcon(item.getAttribute("icon"))
                    .withToc(toc == null || "true".equals(toc) ? true : false);
            includePages.add(menuItem);
            if (includSameList) {
                addMenuItemRecursively(includePages, item, pageName, true);
            } else {
                final List<SideNavMenuItem> list = new ArrayList<>();
                menuItem.withItems(list);
                addMenuItemRecursively(list, item, pageName, false);
            }
        }
    }

    /**
     * @param parentNode
     * @param name
     * @return
     */
    public static List<Xpp3Dom> getChildrenNodes(final Xpp3Dom parentNode, final String name) {
        if (parentNode == null) {
            return Collections.emptyList();
        }
        final Xpp3Dom[] children = parentNode.getChildren();
        if (children == null) {
            return Collections.emptyList();
        }
        final List<Xpp3Dom> list = new ArrayList<>(children.length);
        for (final Xpp3Dom child : children) {
            if (name != null) {
                if (name.equals(child.getName())) {
                    list.add(child);
                }
            } else {
                list.add(child);
            }
        }

        return list;
    }

    private Context<?> buildContext(final Xpp3Dom pagesNode) {
        String type = "page";
        final List<SideNavMenuItem> pagesInDocuments = findAllDocumentMenuItems(pagesNode);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("findPagesIncludeInDocument: " + pagesInDocuments);
        }
        if (pageProperties != null) {
            if (pageProperties.getAttribute("type") != null) {
                type = pageProperties.getAttribute("type");
            }

            // frame type whether page associates to document page
            if (pagesInDocuments.stream().filter(item -> fileId.equals(item.getSlugName())).count() > 0) {
                type = "frame";
            }
        }
        Context<?> context = null;
        switch (type) {
            case "doc":
                context = new DocumentContext().withMenu(getDocumentMenu(pageProperties));
                break;

            case "frame":
                final Optional<SideNavMenuItem> menuItem = pagesInDocuments.stream()
                        .filter(item -> fileId.equals(item.getSlugName()))
                        .findFirst();
                final SideNavMenuItem item = menuItem.get();
                final String documentParent = item.getParent();
                context = new FrameContext().withDocumentParent(documentParent).withItem(item);
                break;
            case "page":
            default:
                context = new PageContext();
                break;
        }
        return context;
    }
}
