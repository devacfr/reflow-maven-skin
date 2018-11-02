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

/**
 * The abstract class of all component used in Reflow rendering.
 *
 * @author devacfr
 * @since 2.0
 */
public abstract class Component {

    /** */
    private String cssClass;

    /**
     * @return Returns a {@link String} representing the css classes to apply to component.
     */
    public String getCssClass() {
        return cssClass;
    }

    /**
     * @param cssClass
     *            the cssClass to set
     */
    protected void setCssClass(final String cssClass) {
        this.cssClass = cssClass;
    }

    /**
     * Gets the css options associated to component. A css option is css class that can be set directly on the component
     * or on {@code <body>} element as global state.
     * <p>
     * Used generally in association with javascript to adapt specific javascript action to current state of component.
     * </p>
     *
     * @return Returns a {@link String} representing the css options associated to component.
     */
    public String getCssOptions() {
        return "";
    }

}
