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

import static com.google.common.collect.FluentIterable.concat;
import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.HtmlTool;
import org.devacfr.maven.skins.reflow.ISkinConfig;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;

/**
 * The abstract class of all component used in Reflow rendering.
 *
 * @author devacfr
 * @since 2.0
 */
public abstract class Component {

    /** */
    private String cssClass;

    /** */
    private final List<String> cssOptions = Lists.newArrayList();

    /** */
    private final List<Component> children = Lists.newArrayList();

    /**
     * @return Returns a {@link String} representing the css classes to apply to component.
     */
    @Nonnull
    public String getCssClass() {
        if (Strings.isNullOrEmpty(cssClass)) {
            return "";
        }
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
    @Nonnull
    public final String getCssOptions() {
        return concat(this.cssOptions,
            concat(FluentIterable.from(children).transform(component -> component.cssOptions))).join(Joiner.on(' '));
    }

    /**
     * Add components to this component.
     *
     * @param components
     *            list of component
     */
    protected void addChildren(final Component... components) {
        this.children.addAll(Lists.newArrayList(components));
    }

    /**
     * Add cssOption to this component.
     *
     * @param cssOptions
     *            a css option.
     */
    protected final void addCssOptions(@Nonnull final String... cssOptions) {
        this.cssOptions.addAll(Lists.newArrayList(cssOptions));
    }

    /**
     * Allows to execute action before rendering of component.
     *
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @since 2.1
     */
    public void preRender(@Nonnull final ISkinConfig skinConfig) {
    }

    /**
     * Gets the tool {@link HtmlTool}.
     *
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns the tool {@link HtmlTool}.
     * @since 2.1
     */
    protected HtmlTool getHtmlTool(@Nonnull final ISkinConfig skinConfig) {
        return requireNonNull(skinConfig).getToolbox("htmlTool", HtmlTool.class);
    }

    /**
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns the html body content stored in velocity context.
     * @since 2.1
     */
    protected String getBodyContent(@Nonnull final ISkinConfig skinConfig) {
        return requireNonNull(skinConfig).getContextValue("bodyContent", String.class);
    }

    /**
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @param bodyContent
     *            the html body to store in velocity context.
     * @since 2.1
     */
    protected void setBodyContent(@Nonnull final ISkinConfig skinConfig, final String bodyContent) {
        requireNonNull(skinConfig).setContextValue("bodyContent", bodyContent);
    }

}
