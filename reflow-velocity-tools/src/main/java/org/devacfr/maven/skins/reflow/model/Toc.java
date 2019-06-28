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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.devacfr.maven.skins.reflow.HtmlTool;
import org.devacfr.maven.skins.reflow.HtmlTool.IdElement;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.Xpp3Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the base of Table of content component.
 *
 * @author devacfr
 * @since 2.0
 * @param <T>
 *            the type of inherit of {@link Toc}.
 */
public abstract class Toc<T extends Toc<?>> extends BsComponent {

    /** */
    public static final String COMPONENT = "toc";

    /** */
    private static final Logger LOGGER = LoggerFactory.getLogger(Toc.class);

    /** enable by default */
    private boolean enabled = true;

    /** */
    private final String type;

    /**
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @param preferredType
     *            the default type of Toc to use.
     * @return Returns new instance corresponding {@link Toc} to configuration.
     */
    public static Toc<?> createToc(@Nonnull final ISkinConfig config, @Nullable final String preferredType) {
        Toc<?> toc = null;
        String type = config.getPropertyValue(COMPONENT, String.class, preferredType);
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Page '{}' Find Toc: {}", config.getFileId(), type);
        }
        final Set<String> types = new HashSet<>(Arrays.asList("sidebar", "top", "false"));
        if (!types.contains(type)) {
            type = preferredType;
        }
        if (type == null) {
            type = "";
        }
        switch (type) {
            case "sidebar":
                toc = createSidebar(config);
                break;
            case "top":
                toc = createTopBar(config);
                break;
            default:
                // create a disabled empty toc
                toc = new Toc<Toc<?>>("", "") {

                };
                toc.withEnabled(false);
                break;
        }

        return toc;
    }

    /**
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns new instance of Toc sidebar.
     */
    public static Toc<?> createSidebar(@Nonnull final ISkinConfig config) {
        return new TocSidebar(config);
    }

    /**
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns new instance Toc top bar.
     */
    public static Toc<?> createTopBar(@Nonnull final ISkinConfig config) {
        return new TocTopBar(config);
    }

    /**
     * @param type
     *            the {@link String} representation of Toc.
     * @param component
     *            the bootstrap component name.
     */
    protected Toc(final String type, final String component) {
        super(component);
        this.type = type;
    }

    /**
     * @return Returns the fluent instance.
     */
    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    /**
     * @return Returns the {@link String} reprensenting the type of {@link Toc}.
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the indicating whether is enable.
     *
     * @return Returns {@code true} if is enable, otherwise {@code false}.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param skinConfig
     *            a config (can <b>not</b> be {@code null}).
     * @return Returns a list of {@link IdElement} representing the heading tree containing in current page.
     * @since 2.1
     */
    public List<? extends IdElement> getTocItems(final ISkinConfig skinConfig) {
        final HtmlTool htmlTool = getHtmlTool(skinConfig);
        final String bodyContent = getBodyContent(skinConfig);

        final List<? extends IdElement> tocItems = htmlTool.headingTree(bodyContent,
            Xpp3Utils.getChildren(skinConfig.get("sections")));
        return tocItems;
    }

    /**
     * Sets the indicating whether is enable.
     *
     * @param enabled
     *            status to use.
     * @return Returns the fluent instance.
     */
    protected T withEnabled(final boolean enabled) {
        this.enabled = enabled;
        return self();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preRender(final ISkinConfig skinConfig) {
        final HtmlTool htmlTool = getHtmlTool(skinConfig);
        String bodyContent = getBodyContent(skinConfig);
        bodyContent = htmlTool
                .ensureHeadingIds(skinConfig.getContext().getType(), skinConfig.getFileId(), bodyContent, "_");
        setBodyContent(skinConfig, bodyContent);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
