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
package org.devacfr.maven.skins.reflow.model;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.Xpp3Utils;

import com.google.common.collect.Lists;

/**
 * Represents the navside menu component used in document page.
 * <p>
 * A sample configuration would be like that:
 * </p>
 *
 * <pre>
 * {@code
 * <custom>
 *   <reflowSkin>
 *     <pages>
 *       <document type="doc">
 *          <menu name="Documentation" selectFirstOnExpand="true">
 *              <item name="Get Started" href="get-started.html" />
 *              <item name="Layouts">
 *                  <item name="Overview" href="layouts.html" />
 *                  <item name="Body" href="body.html" />
 *              </item>
 *              <item name="Migration" href="migration.html" />
 *          </menu>
 *       </document>
 *     </pages>
 *   </reflowSkin>
 * </custom>
 * }∂
 * </pre>
 *
 * @author Christophe Friederich
 * @since 2.0
 */
public class NavSideMenu extends BsComponent {

    /** */
    private static final String COMPONENT = "navside-menu";

    /** */
    private String name;

    /** */
    private List<SideNavMenuItem> items;

    /** */
    private boolean selectFirstOnExpand = false;

    /**
     * Find all {@link SideNavMenuItem sidenav menu items} declared in all document pages.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns a list of all all {@link SideNavMenuItem sidenav menu items} declared in all document pages
     *         (returns list can <b>not</b> be {@code null}).
     */
    @Nonnull
    public static List<SideNavMenuItem> findAllSideNavMenuItems(@Nonnull final SkinConfigTool config) {
        requireNonNull(config);
        final Xpp3Dom pagesNode = Xpp3Utils.getFirstChild(config.getGlobalProperties(), "pages", config.getNamespace());
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
                // create a flatten list containing all menuItem.
                addMenuItemRecursively(includePages, menu, pageName, true);
            }
        }
        return includePages;
    }

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     */
    public NavSideMenu(@Nonnull final SkinConfigTool config) {
        super("navside");
        requireNonNull(config);
        final Xpp3Dom pageNode = config.getPageProperties();
        final Xpp3Dom menu = pageNode.getChild("menu");
        final List<SideNavMenuItem> items = Lists.newArrayList();
        if (menu != null) {
            final String pageName = pageNode.getName();
            addMenuItemRecursively(items, menu, pageName, false);
        }
        this.withName(menu.getAttribute("name"))
                .withItems(items)
                .withSelectFirstOnSelect(
                    config.getAttributeValue("menu", "selectFirstOnExpand", Boolean.class, true));
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssOptions() {
        String css = "m-sidenav-enabled";

        if (isSelectFirstOnExpand()) {
            css += " m-sidenav-select-first-on-select";
        }
        return css;
    }

    /**
     * Gets the name of menu displayed on top of navside menu.
     *
     * @return Returns a {@link String} representing the name of menu.
     */
    @Nullable
    public String getName() {
        return name;
    }

    /**
     * Sets the name of menu displayed on top of navside menu.
     *
     * @param name
     *            the name to use.
     * @return Returns the fluent instance.
     */
    protected NavSideMenu withName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the indicating whether menu contains a least one menu item.
     *
     * @return Returns {@code true} whether menu contains a least one menu item, otherwise returns {@code false}.
     */
    public boolean isHasItems() {
        return items != null && items.size() > 0;
    }

    /**
     * @return Returns the {@link List} of {@link SideNavMenuItem} containing in {@code <menu> element}.
     */
    @Nonnull
    public List<SideNavMenuItem> getItems() {
        return items;
    }

    /**
     * Sets the {@link List} of {@link SideNavMenuItem}.
     *
     * @param items
     *            list of items to use.
     * @return Returns the fluent instance.
     */
    protected NavSideMenu withItems(final List<SideNavMenuItem> items) {
        this.items = items;
        return this;
    }

    /**
     * Gets the indicating whether the first sub menu item should be selected when a dropdown menu item is selected and
     * should expand.
     *
     * @return Returns {@code true} whether the first sub menu item should be selected when a dropdown menu item is
     *         selected and expanded, otherwise returns {@code false}.
     */
    public boolean isSelectFirstOnExpand() {
        return selectFirstOnExpand;
    }

    /**
     * Sets the indicating whether the first sub menu item should be selected when a dropdown menu item is selected and
     * should expand.
     *
     * @param selectFirstOnExpand
     *            a value to use.
     * @return Returns the fluent instance.
     */
    protected NavSideMenu withSelectFirstOnSelect(final boolean selectFirstOnExpand) {
        this.selectFirstOnExpand = selectFirstOnExpand;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

    /**
     * @param menuItems
     * @param parentNode
     * @param pageName
     * @param flatten
     */
    private static void addMenuItemRecursively(final List<SideNavMenuItem> menuItems,
        final Xpp3Dom parentNode,
        final String pageName,
        final boolean flatten) {
        for (final Xpp3Dom item : Xpp3Utils.getChildrenNodes(parentNode, "item")) {
            final String href = item.getAttribute("href");
            final SideNavMenuItem menuItem = new SideNavMenuItem().withName(item.getAttribute("name"))
                    .withParent(pageName)
                    .withHref(href)
                    .withIcon(item.getAttribute("icon"));
            menuItems.add(menuItem);
            if (flatten) {
                addMenuItemRecursively(menuItems, item, pageName, true);
            } else {
                final List<SideNavMenuItem> list = new ArrayList<>();
                menuItem.withItems(list);
                addMenuItemRecursively(list, item, pageName, false);
            }
        }
    }
}
