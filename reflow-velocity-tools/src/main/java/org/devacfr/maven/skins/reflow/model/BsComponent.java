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

import javax.annotation.Nullable;

import com.google.common.base.Strings;

/**
 * Describe a Bootstrap component.
 *
 * @author devacfr
 * @since 2.0
 */
public abstract class BsComponent extends Component {

    /** */
    private final String component;

    /** */
    private String theme = "light";

    /** */
    private String background = "light";

    /**
     * Default constructor.
     *
     * @param component
     *            the bootstrap component name.
     */
    public BsComponent(final String component) {
        this.component = component;
    }

    @Override
    public String getCssClass() {
        if (!Strings.isNullOrEmpty(super.getCssClass())) {
            return super.getCssClass();
        }
        String css = component;
        if (!Strings.isNullOrEmpty(getTheme())) {
            css += "-" + getTheme();
        }
        if (!Strings.isNullOrEmpty(getBackground())) {
            css += " bg-" + getBackground();
        }
        return css;

    }

    /**
     * @return Returns a {@link String} representing the bootstrap theme to apply.
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme
     *            a bootstrap theme to use.
     */
    protected void setTheme(@Nullable final String theme) {
        this.theme = theme;
    }

    /**
     * @return Returns a {@link String} representing the bootstrap background color to apply.
     */
    public String getBackground() {
        return background;
    }

    /**
     * @param background
     *            a bootstrap background colour to use.
     */
    protected void setBackground(@Nullable final String background) {
        this.background = background;
    }

}
