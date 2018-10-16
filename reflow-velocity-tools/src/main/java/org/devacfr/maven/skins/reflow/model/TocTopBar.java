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

public class TocTopBar extends Toc<TocTopBar> {

    /** no <tocTopFlatten> element (default) - flatten if single top heading */
    private boolean flatten = false;

    /** -1 or no <tocTopMax> element (default) - unlimited */
    private int topMax = -1;

    public TocTopBar() {
        super("top");
    }

    @Override
    public String getCssOptions() {
        return isEnabled() ? "m-toc-top-enabled" : "";
    }

    public boolean isFlatten() {
        return flatten;
    }

    public void setFlatten(final boolean flatten) {
        this.flatten = flatten;
    }

    public TocTopBar withFlatten(final boolean flatten) {
        setFlatten(flatten);
        return self();
    }

    public int getTopMax() {
        return topMax;
    }

    public void setTopMax(final int topMax) {
        this.topMax = topMax;
    }

    public TocTopBar withTopMax(final int topMax) {
        setTopMax(topMax);
        return self();
    }

}
