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

    /** heading level limit to display. all by default */
    private int level = 0;

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
                .withFixed("fixed".equals(position))
                .withLevel(config.getAttributeValue("toc", "level", Integer.class, 0));
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

    /**
     * Gets the indicating whether is fixed.
     *
     * @return Returns {@code true} if is fixed, otherwise {@code false}.
     */
    public boolean isFixed() {
        return fixed;
    }

    /**
     * Sets the indicating whether is fixed.
     *
     * @param fixed
     *            {@code true} is fixed.
     * @return Returns the fluent instance.
     */
    protected TocSidebar withFixed(final boolean fixed) {
        this.fixed = fixed;
        return self();
    }

    /**
     * Gets the indicating whether is expanded.
     *
     * @return Returns {@code true} if is expanded, otherwise {@code false}.
     */
    public boolean isExpanded() {
        return expanded;
    }

    /**
     * Sets the indicating whether is expanded.
     *
     * @param expanded
     *            {@code true} is expanded.
     * @return Returns the fluent instance.
     */
    protected TocSidebar withExpanded(final boolean expanded) {
        this.expanded = expanded;
        return self();
    }

    /**
     * Gets the indicating whether is auto-expanded.
     *
     * @return Returns {@code true} if is expanded, otherwise {@code false}.
     */
    public boolean isAutoExpandable() {
        return autoExpandable;
    }

    /**
     * Sets the indicating whether is auto-expanded.
     *
     * @param autoExpandable
     *            {@code true} is auto-expanded.
     * @return Returns the fluent instance.
     */
    protected TocSidebar withAutoExpandable(final boolean autoExpandable) {
        this.autoExpandable = autoExpandable;
        return self();
    }

    /**
     * @return Returns the level limit to display.
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level limit to display
     *
     * @param level
     *            the level to use.
     * @return Returns the fluent instance.
     */
    protected TocSidebar withLevel(final int level) {
        if (level < 1) {
            this.level = Integer.MAX_VALUE;
        } else {
            this.level = level;
        }
        return self();
    }

}
