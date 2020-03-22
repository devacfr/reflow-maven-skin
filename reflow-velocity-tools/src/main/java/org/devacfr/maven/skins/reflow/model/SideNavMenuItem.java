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

import java.util.Collections;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class SideNavMenuItem {

    /** */
    private String name;

    /** */
    private String href;

    /** */
    private String icon;

    /** */
    private String slugName;

    /** */
    private List<SideNavMenuItem> items;

    /** */
    private String parent;

    /**
     * Default constructor.
     */
    public SideNavMenuItem() {
    }

    /**
     * @return Returns the name of item menu.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name of item menu
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @return Returns the name of parent page.
     */
    public String getParent() {
        return parent;
    }

    /***
     * @param parent
     *            the name of parent page
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withParent(final String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * @return Returns the link associated to this item menu.
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     *            the link to use.
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withHref(final String href) {
        this.href = href;
        return this;
    }

    /**
     * @return Returns the {@link String} representing the slugged link associate to this menu item.
     */
    public String getSlugName() {
        return slugName;
    }

    /**
     * @param slugName
     *            the slugged name.
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withSlugName(final String slugName) {
        this.slugName = slugName;
        return this;
    }

    /**
     * @return Returns the icon to use.
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Sets the icon associate to.
     *
     * @param icon
     *            the icon to use.
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withIcon(final String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * Gets the indicating whether has items.
     *
     * @return Returns {@code true} if has items, otherwise {@code false}.
     */
    public boolean isHasItems() {
        return items != null && !items.isEmpty();
    }

    /**
     * Gets the list of items.
     *
     * @return Returns a {@link List} representing the items.
     */
    @Nonnull
    public List<SideNavMenuItem> getItems() {
        if (items == null) {
            return Collections.emptyList();
        }
        return items;
    }

    /**
     * Sets the items associate.
     *
     * @param items
     *            the list of items.
     * @return Returns the fluent instance.
     */
    public SideNavMenuItem withItems(final List<SideNavMenuItem> items) {
        this.items = items;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

}
