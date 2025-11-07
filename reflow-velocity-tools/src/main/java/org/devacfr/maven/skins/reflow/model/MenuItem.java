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

import javax.annotation.Nonnull;

import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;

import org.apache.maven.doxia.site.Image;
import org.devacfr.maven.skins.reflow.ISkinConfig;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class MenuItem {

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
     * Initialize with {@link org.apache.maven.doxia.site.MenuItem}.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @param item
     *            item menu used to.
     */
    public MenuItem(@Nonnull final ISkinConfig config, final org.apache.maven.doxia.site.MenuItem item) {
        Objects.requireNonNull(item);;
        this.href = config.relativeLink(item.getHref());
        this.image = item.getImage();
        this.name = item.getName();
        this.target = item.getTarget();
        this.active = config.isActiveLink(this.href);
        this.inherit = null;
        recurciveAddItem(config, this.menuItems, item.getItems());
    }

    /**
     * recurcive
     */
    private void recurciveAddItem(final ISkinConfig config,
        final List<MenuItem> menuItems,
        final List<org.apache.maven.doxia.site.MenuItem> origMenuItems) {
        if (origMenuItems == null) {
            return;
        }
        for (final org.apache.maven.doxia.site.MenuItem menuItem : origMenuItems) {
            menuItems.add(new MenuItem(config, menuItem));
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the menuItems
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
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

}
