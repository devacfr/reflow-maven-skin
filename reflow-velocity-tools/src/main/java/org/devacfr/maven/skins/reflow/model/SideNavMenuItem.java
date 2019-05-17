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

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.devacfr.maven.skins.reflow.SkinConfigTool;

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
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * @return
     */
    public SideNavMenuItem withName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @return
     */
    public String getParent() {
        return parent;
    }

    /***
     * @param parent
     * @return
     */
    public SideNavMenuItem withParent(final String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * @return
     */
    public String getHref() {
        return href;
    }

    /**
     * @param href
     * @return
     */
    public SideNavMenuItem withHref(final String href) {
        this.href = href;
        return this;
    }

    /**
     * @return
     */
    public String getSlugName() {
        return slugName;
    }

    /**
     * @param slugName
     * @return
     */
    public SideNavMenuItem withSlugName(final String slugName) {
        this.slugName = slugName;
        return this;
    }

    /**
     * @return
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     * @return
     */
    public SideNavMenuItem withIcon(final String icon) {
        this.icon = icon;
        return this;
    }

    /**
     * @return
     */
    public boolean isHasItems() {
        return items != null && items.size() > 0;
    }

    /**
     * @return
     */
    public List<SideNavMenuItem> getItems() {
        return items;
    }

    /**
     * @param items
     * @return
     */
    public SideNavMenuItem withItems(final List<SideNavMenuItem> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

}
