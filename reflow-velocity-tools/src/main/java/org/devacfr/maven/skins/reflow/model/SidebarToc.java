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

public class SidebarToc extends Toc<SidebarToc> {

    /** static position by default */
    private boolean fixed = true;

    /** auto collapsed by default. */
    private boolean collapsed = true;

    public SidebarToc() {
        super("sidebar");
    }

    @Override
    public String getCssClass() {
        String css = isEnabled() ? "m-tocsidebar-enabled" : "";
        if (isCollapsed()) {
            css += " m-tocsidebar-collapsible";
        }

        return css;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(final boolean fixed) {
        this.fixed = fixed;
    }

    public SidebarToc withFixed(final boolean fixed) {
        setFixed(fixed);
        return self();
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public void setCollapsed(final boolean collapsed) {
        this.collapsed = collapsed;
    }

    public SidebarToc withCollapsed(final boolean collapsed) {
        setCollapsed(collapsed);
        return self();
    }

}
