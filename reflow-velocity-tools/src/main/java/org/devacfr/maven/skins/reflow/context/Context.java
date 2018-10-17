/*
 * Copyright 2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow.context;

import static org.devacfr.maven.skins.reflow.model.Toc.createToc;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.Xpp3Utils;
import org.devacfr.maven.skins.reflow.model.Navbar;
import org.devacfr.maven.skins.reflow.model.PageElement;
import org.devacfr.maven.skins.reflow.model.ScrollTop;
import org.devacfr.maven.skins.reflow.model.SideNavMenu;
import org.devacfr.maven.skins.reflow.model.SideNavMenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class Context<T extends Context<?>> extends PageElement {

    private static Logger LOGGER = LoggerFactory.getLogger(Context.class);

    /** */
    private String type;

    /** */
    private Navbar navbar;

    /** */
    private ScrollTop scrollTop;

    public static Context<?> buildContext(final SkinConfigTool config) {
        final Xpp3Dom pagesNode = Xpp3Utils.getFirstChild(config.getGlobalProperties(), "pages", config.getNamespace());
        String type = "page";
        final List<SideNavMenuItem> pagesInDocuments = SideNavMenu.findAllDocumentMenuItems(pagesNode);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("findPagesIncludeInDocument: " + pagesInDocuments);
        }
        final Xpp3Dom pageProperties = config.getPageProperties();
        final String fileId = config.getFileId();

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
            context = new DocumentContext(config);
            break;

        case "frame":
            final Optional<SideNavMenuItem> menuItem = pagesInDocuments.stream()
                    .filter(item -> fileId.equals(item.getSlugName())).findFirst();
            final SideNavMenuItem item = menuItem.get();
            final String documentParent = item.getParent();
            context = new FrameContext(config).withDocumentParent(documentParent).withItem(item);
            break;
        case "page":
        default:
            context = new PageContext(config).withToc(createToc(config, null));
            break;
        }
        return context;
    }

    public Context(final @Nonnull SkinConfigTool config) {
        this.navbar = new Navbar(config);
        this.scrollTop = new ScrollTop(config);
    }

    @Override
    public String getCssOptions() {
        String css = super.getCssOptions();
        css += " " + getNavbar().getCssOptions() +
        " " + getScrollTop().getCssOptions();
        return css;
    }
    /**
     * @return the navbar
     */
    public Navbar getNavbar() {
        return navbar;
    }

    /**
     * @return the scrollTop
     */
    public ScrollTop getScrollTop() {
        return scrollTop;
    }

    public T withType(final String type) {
        this.type = type;
        return self();
    }

    public String getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
