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

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.SkinConfigTool;

/**
 * @author devacfr
 * @since 2.0
 */
public class TocSidebar extends Toc<TocSidebar> {

    /** fixed position by default */
    private boolean fixed = true;

    /** expanded by default. */
    private boolean expanded = true;

    /** auto expandable by default. */
    private boolean autoExpandable = true;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     */
    public TocSidebar(final @Nonnull SkinConfigTool config) {
        super("sidebar", "");
        final String position = config.getAttributeValue("toc", "position", String.class, "fixed").toLowerCase();
        this.withEnabled(true)
                .withExpanded(config.getAttributeValue("toc", "expanded", Boolean.class, true))
                .withAutoExpandable(config.getAttributeValue("toc", "autoExpandable", Boolean.class, true))
                .withFixed("fixed".equals(position));
    }

    @Override
    public String getCssOptions() {
        String css = isEnabled() ? "m-toc-sidebar-enabled" : "";
        if (isExpanded()) {
            css += " m-toc-sidebar-expanded";
        }
        if (isAutoExpandable()) {
            css += " m-toc-sidebar-autoexpandable";
        }
        if (isFixed()) {
            css += " toc-sidebar-fixed";
        } else {
            css += " toc-sidebar-relative";
        }

        return css;
    }

    public boolean isFixed() {
        return fixed;
    }

    protected TocSidebar withFixed(final boolean fixed) {
        this.fixed = fixed;
        return self();
    }

    public boolean isExpanded() {
        return expanded;
    }

    protected TocSidebar withExpanded(final boolean expanded) {
        this.expanded = expanded;
        return self();
    }

    public boolean isAutoExpandable() {
        return autoExpandable;
    }

    protected TocSidebar withAutoExpandable(final boolean autoExpandable) {
        this.autoExpandable = autoExpandable;
        return self();
    }

}
