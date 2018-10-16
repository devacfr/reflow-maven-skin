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
package org.devacfr.maven.skins.reflow.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.Xpp3Utils;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class SideNavMenu extends PageElement {

    private String name;

    private List<SideNavMenuItem> items;

    private boolean selectOnExpand = false;


    /**
     * @param pagesNode
     * @return
     */
    public static List<SideNavMenuItem> findAllDocumentMenuItems(final Xpp3Dom pagesNode) {
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

    public SideNavMenu(final SkinConfigTool config) {

        final Xpp3Dom pageNode = config.getPageProperties();
        final Xpp3Dom menu = pageNode.getChild("menu");
        if (menu == null) {
            return;
        }
        final String pageName = pageNode.getName();
        final List<SideNavMenuItem> items = new ArrayList<>();
        this.withName(menu.getAttribute("name")).withItems(items)
                .withSelectOnExpand(config.getConfigAttribute("menu", "selectOnExpand", Boolean.class, false));
        addMenuItemRecursively(items, menu, pageName, false);
    }

    @Override
    public String getCssOptions() {
        String css = "m-sidenav-enabled";

        if (isSelectOnExpand()) {
            css += " m-sidenav-select-onexpand";
        }
        return css;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public SideNavMenu withName(final String name) {
        setName(name);
        return this;
    }

    public boolean isHasItems() {
        return items != null && items.size() > 0;
    }

    public List<SideNavMenuItem> getItems() {
        return items;
    }

    public void setItems(final List<SideNavMenuItem> items) {
        this.items = items;
    }

    public SideNavMenu withItems(final List<SideNavMenuItem> items) {
        setItems(items);
        return this;
    }

    public boolean isSelectOnExpand() {
        return selectOnExpand;
    }

    public void setSelectOnExpand(final boolean selectOnExpand) {
        this.selectOnExpand = selectOnExpand;
    }

    public SideNavMenu withSelectOnExpand(final boolean selectOnExpand) {
        setSelectOnExpand(selectOnExpand);
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

    /**
     * @param includePages
     * @param parentNode
     */
    private static void addMenuItemRecursively(final List<SideNavMenuItem> includePages, final Xpp3Dom parentNode,
            final String pageName, final boolean includSameList) {
        for (final Xpp3Dom item : Xpp3Utils.getChildrenNodes(parentNode, "item")) {
            final String href = item.getAttribute("href");
            final SideNavMenuItem menuItem = new SideNavMenuItem().withName(item.getAttribute("name"))
                    .withParent(pageName).withHref(href).withIcon(item.getAttribute("icon"));
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
}
