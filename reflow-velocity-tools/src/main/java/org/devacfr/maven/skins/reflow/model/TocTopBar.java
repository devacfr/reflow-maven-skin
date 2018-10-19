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

    public TocTopBar(final @Nonnull SkinConfigTool config) {
        super("top");
        this.setCssClass(
            config.getConfigAttribute("toc", "cssClass", String.class, "navbar-dark bg-dark border rounded"));
        this.withFlatten(config.getConfigAttribute("toc", "flatten", Boolean.class, false))
                .withNumberItems(config.getConfigAttribute("toc", "numberItems", Integer.class, -1))
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
     * @return
     */
    public boolean isFlatten() {
        return flatten;
    }

    /**
     * @param flatten
     * @return
     */
    protected TocTopBar withFlatten(final boolean flatten) {
        this.flatten = flatten;
        return self();
    }

    /**
     * @return
     */
    public int getNumberItems() {
        return numberItems;
    }

    /**
     * @param numberItems
     * @return
     */
    protected TocTopBar withNumberItems(final int numberItems) {
        this.numberItems = numberItems;
        return self();
    }

}
