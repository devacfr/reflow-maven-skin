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

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.SkinConfigTool;

/**
 * Represents the footer component.
 *
 * @author devacfr
 * @since 2.0
 */
public class Footer extends BsComponent {

    /** */
    private static final String COMPONENT = "footer";

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     */
    public Footer(@Nonnull final SkinConfigTool config) {
        super(COMPONENT);
        requireNonNull(config);
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));
    }

}
