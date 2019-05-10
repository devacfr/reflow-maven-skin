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

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.maven.doxia.site.decoration.LinkItem;
import org.devacfr.maven.skins.reflow.SkinConfigTool;

import com.google.common.collect.Lists;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class Menu {

    /** */
    private final String name;

    /** */
    private final String alt;

    /** */
    private final String border;

    /** */
    private final String height;

    /** */
    private final String width;

    /** */
    private final String href;

    /** */
    private final String image;

    /** */
    private final String position;

    /** */
    private final String target;

    /** */
    private final String title;

    /** **/
    private final String inherit;

    /** */
    private final boolean active;

    /** */
    private final List<MenuItem> menuItems = Lists.newArrayList();

    /**
     * Initialize with {@link LinkItem}.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @param item
     *            link item used to.
     */
    public Menu(@Nonnull final SkinConfigTool config, @Nonnull final LinkItem item) {
        Objects.requireNonNull(item);
        this.alt = item.getAlt();
        this.border = item.getBorder();
        this.height = item.getHeight();
        this.width = item.getWidth();
        this.href = config.relativeLink(item.getHref());
        this.image = item.getImg();
        this.name = item.getName();
        this.position = item.getPosition();
        this.target = item.getTarget();
        this.title = item.getTitle();
        this.active = config.isActiveLink(this.href);
        this.inherit = null;
    }

    /**
     * Initialize with {@link org.apache.maven.doxia.site.decoration.Menu}.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @param menu
     *            menu used to.
     */
    public Menu(@Nonnull final SkinConfigTool config, @Nonnull final org.apache.maven.doxia.site.decoration.Menu menu) {
        Objects.requireNonNull(menu);
        this.alt = menu.getAlt();
        this.border = menu.getBorder();
        this.height = menu.getHeight();
        this.width = menu.getWidth();
        this.href = null;
        this.image = menu.getImg();
        this.name = menu.getName();
        this.position = menu.getPosition();
        this.target = null;
        this.title = menu.getTitle();
        this.inherit = menu.getInherit();
        this.active = false;
        final List<org.apache.maven.doxia.site.decoration.MenuItem> items = menu.getItems();
        for (final org.apache.maven.doxia.site.decoration.MenuItem menuItem : items) {
            this.menuItems.add(new MenuItem(config, menuItem));
        }
    }

    /**
     * @return the menuItems
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the inherit
     */
    public String getInherit() {
        return inherit;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        boolean active = this.active;
        if (active) {
            return active;
        }
        for (final MenuItem menuItem : menuItems) {
            active = menuItem.isActive();
            if (active) {
                break;
            }
        }
        return active;
    }

    /**
     * @return the alt
     */
    public String getAlt() {
        return alt;
    }

    /**
     * @return the border
     */
    public String getBorder() {
        return border;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the width
     */
    public String getWidth() {
        return width;
    }

    /**
     * Gets indicating whether menu by their ref or name, and returns the matching results. The regex is used to check
     * the match.
     *
     * @param regex
     *            regex to use.
     * @param menu
     *            the menu to check
     * @return Returns {@code true} whether menu matches with regex.
     */
    public static boolean matches(@Nonnull final String regex,
        @Nonnull final org.apache.maven.doxia.site.decoration.Menu menu) {
        requireNonNull(regex);
        requireNonNull(menu);
        return menu.getRef() != null && menu.getRef().matches(regex)
                || menu.getName() != null && menu.getName().matches(regex);
    }

}