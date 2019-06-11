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
public class TocTopBar extends Toc<TocTopBar> {

    /** no flatten attribute (default) - flatten if single top heading */
    private boolean flatten = false;

    /** -1 or no numberItems attribute (default) - unlimited */
    private int numberItems = -1;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     */
    public TocTopBar(final @Nonnull SkinConfigTool config) {
        super("top", "navbar");
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));
        this.withFlatten(config.getAttributeValue(COMPONENT, "flatten", Boolean.class, false))
                .withNumberItems(config.getAttributeValue(COMPONENT, "numberItems", Integer.class, -1))
                .withEnabled(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssOptions() {
        return isEnabled() ? "m-toc-top-enabled" : "";
    }

    /**
     * Gets the indicating whether is flatten.
     *
     * @return Returns {@code true} if is flatten, otherwise {@code false}.
     */
    public boolean isFlatten() {
        return flatten;
    }

    /**
     * Sets the indicating whether is flatten.
     *
     * @param flatten
     *            {@code true} to flat.
     * @return Returns the fluent instance.
     */
    protected TocTopBar withFlatten(final boolean flatten) {
        this.flatten = flatten;
        return self();
    }

    /**
     * @return Returns the number of items to display.
     */
    public int getNumberItems() {
        return numberItems;
    }

    /**
     * Sets the number of items to display.
     * 
     * @param numberItems
     *            -1 or the number of items to display
     * @return Returns the fluent instance.
     */
    protected TocTopBar withNumberItems(final int numberItems) {
        this.numberItems = numberItems;
        return self();
    }

}
