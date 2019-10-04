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

import org.devacfr.maven.skins.reflow.ISkinConfig;

/**
 * Represents the scoll top component.
 *
 * @author devacfr
 * @since 2.0
 */
public class ScrollTop extends Component {

    /** */
    private final boolean smooth;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     */
    public ScrollTop(final @Nonnull ISkinConfig config) {

        this.smooth = config.getPropertyValue("smoothScroll", Boolean.class, true);
        if (isSmooth()) {
            this.addCssOptions("scrolltop-smooth-enabled");
        }
    }

    /**
     * Gets the indicating whether the scrolling is smooth.
     *
     * @return Returns {@code true} whether the scrolling is smooth, otherwise returns {@code false}.
     */
    public boolean isSmooth() {
        return smooth;
    }
}
