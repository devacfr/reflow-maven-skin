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
package org.devacfr.maven.skins.reflow;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.tools.ToolContext;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.context.Context;

/**
 * Interface of skin config.
 *
 * @author devacfr
 * @since 2.1
 */
public interface ISkinConfig {

    /**
     * A convenience method to check if the value of the {@code property} is {@code "false"}. Useful for properties that
     * are enabled by default - checks if the property is set to {@code "false"} explicitly.
     *
     * @param property
     *                     the property of interest
     * @return {@code true} if the configuration value is set either in page or globally, and is equal to
     *         {@code "false"}. Note that this will return {@code false} if property is not set at all.
     * @see #get(String)
     * @since 1.0
     */
    boolean not(String property);

    /**
     * Gets the associated value to {@code key} stored in Velocity context.
     *
     * @param key
     *                 the key name of associated value in Velocity context.
     * @param type
     *                 the the type of expected value.
     * @return Returns the associated value to {@code key} stored in Velocity context.
     * @param <T>
     *                the type of expected value.
     * @since 2.1
     */
    <T> T getContextValue(@Nonnull String key, @Nonnull Class<T> type);

    /**
     * Sets the value in Velocity context associated to {@code key}.
     *
     * @param key
     *                  the key name of associated value in Velocity context.
     * @param value
     *                  the new value
     * @since 2.1
     */
    void setContextValue(@Nonnull String key, Object value);

    /**
     * Gets the associated tool to {@code name} stored in toolbox of Velocity context.
     *
     * @param toolName
     *                     the name of tool associated in Velocity context.
     * @param toolType
     *                     the expected class of tool.
     * @return Returns the associated tool to {@code name} stored in toolbox of Velocity context.
     * @param <T>
     *                the type of expected tool.
     * @since 2.1
     */
    @Nullable
    <T> T getToolbox(@Nonnull String toolName, @Nonnull Class<T> toolType);

    /**
     * @return Returns the root level {@link Xpp3Dom}.
     */
    @Nonnull
    Xpp3Dom getGlobalProperties();

    /**
     * @return Returns the page level {@link Xpp3Dom}.
     */
    @Nonnull
    Xpp3Dom getPageProperties();

    /**
     * @return Returns a {@link String} representing the namespace.
     */
    @Nonnull
    String getNamespace();

    /**
     * @return Returns the {@link String} representing the fileId.
     */
    @Nullable
    String getFileId();

    /**
     * @return the context
     */
    @Nonnull
    Context<?> getContext();

    /**
     * @return Returns the {@link String} representing the projectId.
     */
    @Nullable
    Object getProjectId();

    /**
     * @return the project
     */
    @Nonnull
    MavenProject getProject();

    /**
     * @return the decoration
     */
    @Nonnull
    DecorationModel getDecoration();

    /**
     * Default accessor for config properties. Instead of using {@code $config.get("myproperty")}, one can utilise
     * Velocity fallback onto the default getter and use {@code $config.myproperty}.
     *
     * @param property
     *                     the property of interest
     * @return configuration node if found in the following sequence:
     *         <ol>
     *         <li>In page configuration</li>
     *         <li>In global configuration</li>
     *         <li>{@code null} otherwise</li>
     *         </ol>
     * @since 1.0
     */
    @Nullable
    Xpp3Dom get(@Nonnull String property);

    /**
     * Gets the text value of the given {@code property}.
     *
     * @param property
     *                         the property to use
     * @param targetType
     *                         the returned target type use to convert value.
     * @param defaultValue
     *                         the default value used if property doesn't exist.
     * @return Returns a converted value of the given {@code property}.
     * @since 2.0
     * @param <T>
     *                the type of returned object.
     */
    @Nullable
    <T> T getPropertyValue(@Nonnull String property, @Nonnull Class<T> targetType, @Nullable T defaultValue);

    /**
     * Gets the attribute value of the given {@code attribute} of {@code property}.
     *
     * @param property
     *                         the property to use
     * @param attribute
     *                         the attribute to use.
     * @param targetType
     *                         the returned target type use to convert value.
     * @param defaultValue
     *                         the default value used if property doesn't exist.
     * @return Returns a converted value of the given {@code property}.
     * @since 2.0
     * @param <T>
     *                the type of returned object.
     */
    @Nullable
    <T> T getAttributeValue(@Nonnull String property,
        @Nonnull String attribute,
        @Nonnull Class<T> targetType,
        @Nullable T defaultValue);

    /**
     * Get the value contained in specific attribute of {@code element} parameter.
     *
     * @param element
     *                         the xml element.
     * @param attribute
     *                         the attribute name.
     * @param targetType
     *                         the class of converted returned value.
     * @param defaultValue
     *                         the value to return if attribute is empty or {@code null}.
     * @return Returns the converted value of specific attribute of {@code element} parameter if exists, otherwise
     *         returns the default value.
     * @param <T>
     *                the type of returned value.
     */
    @Nullable
    <T> T getAttributeValue(@Nonnull Xpp3Dom element,
        @Nonnull String attribute,
        @Nonnull Class<T> targetType,
        T defaultValue);

    /**
     * @param href
     *                 link to relative.
     * @return Returns Relativizes the link.
     */
    @Nullable
    String relativeLink(String href);

    /**
     * Gets the indicating if the link is active.
     *
     * @param href
     *                 the link to check.
     * @return Returns {@code true} the link is active, otherwise {@code false}.
     */
    boolean isActiveLink(@Nullable String href);

    /**
     * Evaluate a velocity expression in the current context.
     *
     * @param vtl
     *                          The velocity expression to evaluate
     * @param requiredClass
     *                          the class of returned value.
     * @return Returns the value returned by the evaluated velocity expression.
     * @param <T>
     *                Tthe type of expected returned value.
     */
    @Nullable
    <T> T eval(@Nullable String vtl, @Nonnull Class<T> requiredClass);

}
