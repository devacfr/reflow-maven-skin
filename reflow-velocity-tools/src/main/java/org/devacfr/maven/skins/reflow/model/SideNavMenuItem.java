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
    private List<SideNavMenuItem> items;

    private String parent;

    public SideNavMenuItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public SideNavMenuItem withName(final String name) {
        setName(name);
        return this;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(final String parent) {
        this.parent = parent;
    }

    public SideNavMenuItem withParent(final String parent) {
        setParent(parent);
        return this;
    }

    public String getHref() {
        return href;
    }

    public void setHref(final String href) {
        this.href = href;
    }

    public SideNavMenuItem withHref(final String href) {
        setHref(href);
        return this;
    }

    public String getSlugName() {
        return SkinConfigTool.slugFilename(href);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(final String icon) {
        this.icon = icon;
    }

    public SideNavMenuItem withIcon(final String icon) {
        setIcon(icon);
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

    public SideNavMenuItem withItems(final List<SideNavMenuItem> items) {
        setItems(items);
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

}
