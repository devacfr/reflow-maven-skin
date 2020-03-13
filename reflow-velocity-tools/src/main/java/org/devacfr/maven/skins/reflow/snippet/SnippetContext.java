
/*
 * Copyright 2012-2020 Christophe Friederich
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
package org.devacfr.maven.skins.reflow.snippet;

import static java.util.Objects.requireNonNull;

import java.io.StringWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.snippet.component.Carousel;
import org.devacfr.maven.skins.reflow.snippet.component.SnippetComponent;
import org.jsoup.nodes.Element;

import com.google.common.collect.Lists;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetContext {

    /** */
    private final List<SnippetComponent<?>> components = Lists.newArrayList();

    /** **/
    private String htmlSource;

    public SnippetContext(@Nonnull final String htmlSource) {
        this.htmlSource = requireNonNull(htmlSource);
    }

    public String generateSnippetIdentifier() {
        return "snippet-placement-" + UUID.randomUUID().toString();
    }

    public List<SnippetComponent<?>> getComponents() {
        return components;
    }

    void addComponent(final SnippetComponent<?> component) {
        this.components.add(component);
    }

    void setHtmlSource(final String htmlSource) {
        this.htmlSource = htmlSource;
    }

    public String html() {
        return htmlSource;
    }

    @Nullable
    public SnippetComponent<?> create(@Nonnull final Element element) {
        requireNonNull(element);
        SnippetComponent<?> component = null;
        switch (element.tagName()) {
            case "carousel":
                component = Carousel.createCarousel(this, element);
            default:
                break;
        }
        addComponent(component);
        return component;
    }

    // public String render1(final SnippetComponent<?> component)
    // throws ResourceNotFoundException, ParseErrorException, Exception {

    // final String path = "META-INF/maven/snippets/snippets.vm";
    // final Object velocityComponent = this.skinConfig.getContainer().lookup(VelocityComponent.ROLE);

    // Method method;
    // Object engine;
    // try {
    // method = velocityComponent.getClass().getDeclaredMethod("getEngine");
    // engine = method.invoke(velocityComponent);
    // method = engine.getClass().getDeclaredMethod("getTemplate", String.class);
    // final Object template = method.invoke(engine, path);

    // final ToolContext context = this.skinConfig.getVelocityContext();
    // context.put("snippet", component);

    // final StringWriter writer = new StringWriter();
    // method = template.getClass().getDeclaredMethod("merge", Context.class, Writer.class);
    // method.invoke(template, context, writer);
    // return writer.toString();

    // } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
    // | InvocationTargetException e) {
    // throw new RuntimeException(e.getMessage(), e);
    // }

    // }

    public String render(final SnippetComponent<?> component) {
        final String path = "META-INF/skin/snippets/" + component.getName() + ".vm";
        final VelocityContext context = new VelocityContext();
        context.put("snippet", component);

        final StringWriter writer = new StringWriter();
        Velocity.mergeTemplate(path,
            RuntimeSingleton.getString(RuntimeConstants.INPUT_ENCODING, RuntimeConstants.ENCODING_DEFAULT),
            context,
            writer);
        final String html = writer.toString();
        return html;
    }

}
