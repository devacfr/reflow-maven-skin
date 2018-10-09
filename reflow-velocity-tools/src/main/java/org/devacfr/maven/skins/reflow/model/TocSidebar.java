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

public class TocSidebar extends Toc<TocSidebar> {

    /** static position by default */
    private boolean fixed = true;

    /** expanded by default. */
    private boolean expanded = true;

    /** auto expandable by default. */
    private boolean autoExpandable = true;

    public TocSidebar() {
        super("sidebar");
    }

    @Override
    public String getCssClass() {
        String css = isEnabled() ? "m-toc-sidebar-enabled" : "";
        if (isExpanded()) {
            css += " m-toc-sidebar-expanded";
        }
        if (isAutoExpandable()) {
            css += " m-toc-sidebar-autoexpandable";
        }

        return css;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(final boolean fixed) {
        this.fixed = fixed;
    }

    public TocSidebar withFixed(final boolean fixed) {
        setFixed(fixed);
        return self();
    }

    public boolean isExpanded() {
        return expanded;
    }


    public void setExpanded(final boolean expanded) {
        this.expanded = expanded;
    }

    public TocSidebar withExpanded(final boolean expanded) {
        setExpanded(expanded);
        return self();
    }

    public boolean isAutoExpandable() {
        return autoExpandable;
    }

    public void setAutoExpandable(final boolean autoExpandable) {
        this.autoExpandable = autoExpandable;
    }

    public TocSidebar withAutoExpandable(final boolean autoExpandable) {
        setAutoExpandable(autoExpandable);
        return self();
    }

}
