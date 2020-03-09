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
package org.devacfr.maven.skins.reflow.context;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.HtmlTool;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.model.Component;
import org.devacfr.maven.skins.reflow.model.Footer;
import org.devacfr.maven.skins.reflow.model.NavSideMenu;
import org.devacfr.maven.skins.reflow.model.Navbar;
import org.devacfr.maven.skins.reflow.model.ScrollTop;
import org.devacfr.maven.skins.reflow.model.SideNavMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/**
 * The base class of all contexts depending type of page.
 *
 * @author Christophe Friederich
 * @since 2.0
 * @param <T>
 *            type of inherrit context object.
 */
public abstract class Context<T extends Context<?>> extends Component {

    /** map containing the equivalence of font awesome characters with image found in report pages. */
    private static final Map<String, String> ICON_REPLACEMENTS = ImmutableMap.<String, String> builder()
            .put("img[src$=images/add.gif]", "<i class=\"fas fa-plus\"></i>")
            .put("img[src$=images/remove.gif]", "<i class=\"fas fa-minus\"></i>")
            .put("img[src$=images/fix.gif]", "<i class=\"fas fa-wrench\"></i>")
            .put("img[src$=images/update.gif]", "<i class=\"fas fa-redo\"></i>")
            .put("img[src$=images/icon_help_sml.gif]", "<i class=\"fas fa-question\"></i>")
            .put("img[src$=images/icon_success_sml.gif]", "<i class=\"fas fa-check-circle\"></i>")
            .put("img[src$=images/icon_warning_sml.gif]", "<i class=\"fas fa-exclamation-triangle\"></i>")
            .put("img[src$=images/icon_error_sml.gif]", "<i class=\"fas fa-exclamation-circle\"></i>")
            .put("img[src$=images/icon_info_sml.gif]", "<i class=\"fas fa-info\"></i>")
            .build();

    /** */
    private static final Logger LOGGER = LoggerFactory.getLogger(Context.class);

    /** */
    private ContextType type;

    /** */
    private final Navbar navbar;

    /** */
    private final Footer footer;

    /** */
    private final ScrollTop scrollTop;

    /**
     * Build a context depending of current type of page.
     *
     * @param config
     *            a config (can not be {@code null}).
     * @return Returns a new instance of {@link Context} depending of current page.
     */
    @Nonnull
    public static Context<?> buildContext(@Nonnull final ISkinConfig config) {
        requireNonNull(config);

        ContextType type = ContextType.page;
        final List<SideNavMenuItem> allSideNaveMenuItems = NavSideMenu.findAllSideNavMenuItems(config);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("findAllSideNavMenuItems: " + allSideNaveMenuItems);
        }
        final Xpp3Dom pageProperties = config.getPageProperties();
        final String fileId = config.getFileId();

        if (pageProperties != null) {
            if (pageProperties.getAttribute("type") != null) {
                type = ContextType.valueOf(pageProperties.getAttribute("type"));
            }

            // frame type whether page associates to document page
            if (allSideNaveMenuItems.stream().filter(item -> fileId.equals(item.getSlugName())).count() > 0) {
                type = ContextType.frame;
            }
        }
        // if (type== null) {
        // type = ContextType.page;
        // }
        Context<?> context = null;
        switch (type) {
            case doc:
                context = new DocumentContext(config);
                break;

            case frame:
                // search the parent document page
                final Optional<SideNavMenuItem> menuItem = allSideNaveMenuItems.stream()
                        .filter(item -> fileId.equals(item.getSlugName()))
                        .findFirst();
                final SideNavMenuItem item = menuItem.get();
                final String documentParent = item.getParent();
                context = new FrameContext(config, documentParent);
                break;
            case body:
                context = new BodyContext(config);
                break;
            case page:
            default:
                context = new PageContext(config);
                break;
        }
        return context;
    }

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     * @param type
     *            the type of context (can not be {@code null}).
     */
    public Context(@Nonnull final ISkinConfig config, @Nonnull final ContextType type) {
        requireNonNull(config);
        this.withType(requireNonNull(type));
        this.navbar = new Navbar(config);
        this.scrollTop = new ScrollTop(config);
        this.footer = new Footer(config);

        this.initialize(config);

        // the ordering is important for execute preRender method
        this.addChildren(this.navbar, this.scrollTop, this.footer);
    }

    /**
     * Allows to initialize the context.
     * @param config
     *            a config (can not be {@code null}).
     */
    protected void initialize(@Nonnull final ISkinConfig config) {
        // enable AnchorJS
        if(!config.not("anchorJS")) {
            this.addCssOptions("anchorjs-enabled");
        }
    }

    /**
     * Allows to execute action before rendering of component.
     *
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns the {@link String} representing the transformed body content.
     * @since 2.1
     */
    public String preRender(@Nonnull final ISkinConfig skinConfig) {
        return onPreRender(skinConfig, getBodyContent(skinConfig));
    }

    @Override
    protected String onPreRender(final ISkinConfig skinConfig, final String bodyContent) {
        final HtmlTool htmlTool = getHtmlTool(skinConfig);
        String content = bodyContent;
        if (!skinConfig.not("imgLightbox")) {
            // lightbox is enabled by default, so check for false and negate
            content = htmlTool.setAttr(content,
                "a[href$=jpg], a[href$=JPG], a[href$=jpeg], a[href$=JPEG], "
                        + "a[href$=png], a[href$=gif],a[href$=bmp]:has(img)",
                "data-lightbox",
                "page");
        }
        if (!skinConfig.not("imgLightbox")) {

            // lightbox is enabled by default, so check for false and negate
            content = htmlTool.setAttr(content,
                "a[href$=jpg], a[href$=JPG], a[href$=jpeg], a[href$=JPEG], "
                        + "a[href$=png], a[href$=gif], a[href$=bmp]:has(img)",
                "data-lightbox",
                "page");
        }
        if (!skinConfig.not("html5Anchor")) {
            // HTML5-style anchors are enabled by default, so check for false and negate
            content = htmlTool.headingAnchorToId(content);
        }
        if (!skinConfig.not("bootstrapCss")) {
            // Bootstrap CSS class conversion is enabled by default, so check for false and negate
            content = htmlTool
                    .addClass(content, "table.bodyTable", Lists.newArrayList("table", "table-striped", "table-hover"));
            // image is responsive by default
            content = htmlTool.addClass(content, "img", Lists.newArrayList("img-fluid"));
            content = htmlTool.fixTableHeads(content);
        }

        if (!skinConfig.not("bootstrapIcons")) {
            // Bootstrap Icons are enabled by default, so check for false and negate

            content = htmlTool.replaceAll(content, ICON_REPLACEMENTS);
            // The <tt> tag is not supported in HTML5 (see https://www.w3schools.com/tags/tag_tt.asp).
            content = htmlTool.replaceWith(content, "tt", "<code class=\"literal\">");
        }
        return super.onPreRender(skinConfig, content);
    }

    /**
     * @return Returns the {@link Navbar}.
     */
    public Navbar getNavbar() {
        return navbar;
    }

    /**
     * @return Returns the {@link ScrollTop}.
     */
    public ScrollTop getScrollTop() {
        return scrollTop;
    }

    /**
     * @return Returns the {@link Footer}.
     */
    public Footer getFooter() {
        return footer;
    }

    /**
     * Sets the type of context.
     *
     * @param type
     *            the of context.
     * @return Returns the fluent instance context.
     */
    protected T withType(final ContextType type) {
        this.type = type;
        return self();
    }

    /**
     * @return Returns the type of context of page.
     */
    public String getType() {
        return type.name();
    }

    /**
     * @return Returns the fluent instance.
     */
    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
