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
import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.model.Footer;
import org.devacfr.maven.skins.reflow.model.NavSideMenu;
import org.devacfr.maven.skins.reflow.model.Navbar;
import org.devacfr.maven.skins.reflow.model.Component;
import org.devacfr.maven.skins.reflow.model.ScrollTop;
import org.devacfr.maven.skins.reflow.model.SideNavMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The base class of all contexts depending type of page.
 *
 * @author Christophe Friederich
 * @since 2.0
 * @param <T>
 *            type of inherrit context object.
 */
public class Context<T extends Context<?>> extends Component {

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
    public static Context<?> buildContext(@Nonnull final SkinConfigTool config) {
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
    public Context(@Nonnull final SkinConfigTool config, @Nonnull final ContextType type) {
        requireNonNull(config);
        this.withType(requireNonNull(type));
        this.navbar = new Navbar(config);
        this.scrollTop = new ScrollTop(config);
        this.footer = new Footer(config);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssOptions() {
        String css = super.getCssOptions();
        css += " " + getNavbar().getCssOptions() + " " + getScrollTop().getCssOptions();
        return css;
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
