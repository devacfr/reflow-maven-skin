/*
 * Copyright 2012-2025 Christophe Friederich
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

import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.maven.doxia.site.Image;
import org.apache.maven.doxia.site.LinkItem;
import org.devacfr.maven.skins.reflow.ISkinConfig;

import com.google.common.collect.Lists;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class Menu {

    /** */
    private final String name;

    /** */
    private final String href;

    /** */
    private final Image image;

    /** */
    private final String target;

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
    public Menu(@Nonnull final ISkinConfig config, @Nonnull final LinkItem item) {
        Objects.requireNonNull(item);
        this.href = config.relativeLink(item.getHref());
        this.image = item.getImage();
        this.name = item.getName();
        this.target = item.getTarget();
        this.active = config.isActiveLink(this.href);
        this.inherit = null;
    }

    /**
     * Initialize with {@link org.apache.maven.doxia.site.Menu}.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @param menu
     *            menu used to.
     */
    public Menu(@Nonnull final ISkinConfig config, @Nonnull final org.apache.maven.doxia.site.Menu menu) {
        Objects.requireNonNull(menu);
        this.href = null;
        this.image = menu.getImage();
        this.name = menu.getName();
        this.target = null;
        this.inherit = menu.getInherit();
        this.active = false;
        final List<org.apache.maven.doxia.site.MenuItem> items = menu.getItems();
        for (final org.apache.maven.doxia.site.MenuItem menuItem : items) {
            if (isNullOrEmpty(menu.getName())) {
                continue;
            }
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
     * @return the href
     */
    public String getHref() {
        return href;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @return the target
     */
    public String getTarget() {
        return target;
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
    public static boolean matches(@Nonnull final String regex, @Nonnull final org.apache.maven.doxia.site.Menu menu) {
        requireNonNull(regex);
        requireNonNull(menu);
        return menu.getRef() != null && menu.getRef().matches(regex)
                || menu.getName() != null && menu.getName().matches(regex);
    }
}
