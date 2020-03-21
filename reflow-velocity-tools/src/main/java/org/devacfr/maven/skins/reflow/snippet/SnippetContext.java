
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
import java.io.Writer;
import java.util.List;
import java.util.UUID;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.EasyFactoryConfiguration;
import org.apache.velocity.tools.generic.AlternatorTool;
import org.apache.velocity.tools.generic.ClassTool;
import org.apache.velocity.tools.generic.ComparisonDateTool;
import org.apache.velocity.tools.generic.ContextTool;
import org.apache.velocity.tools.generic.ConversionTool;
import org.apache.velocity.tools.generic.DisplayTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.apache.velocity.tools.generic.FieldTool;
import org.apache.velocity.tools.generic.LinkTool;
import org.apache.velocity.tools.generic.LoopTool;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.apache.velocity.tools.generic.RenderTool;
import org.apache.velocity.tools.generic.ResourceTool;
import org.apache.velocity.tools.generic.SortTool;
import org.apache.velocity.tools.generic.XmlTool;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetContext {

    /** */
    private static final Logger LOGGER = LoggerFactory.getLogger(SnippetContext.class);

    /** */
    private static final List<String> DEFAULT_PATHS = Lists.newArrayList("src/site/snippets", "META-INF/skin/snippets");

    /** */
    private final List<SnippetComponent<?>> components = Lists.newArrayList();

    /** **/
    private String htmlSource;

    /** */
    private final List<String> snippetPaths = Lists.newArrayList(DEFAULT_PATHS);

    /** */
    private ISkinConfig config;

    public SnippetContext() {
    }

    public void reset() {
        this.htmlSource = null;
        this.components.clear();
        this.config = null;
    }

    public String generateSnippetIdentifier() {
        return "snippet-placement-" + UUID.randomUUID().toString();
    }

    public List<SnippetComponent<?>> getComponents() {
        return components;
    }

    void setConfig(final ISkinConfig config) {
        this.config = config;
    }

    void addComponent(final SnippetComponent<?> component) {
        this.components.add(component);
    }

    void insertResourcePath(final String path, final int index) {
        this.snippetPaths.add(index, path);
    }

    void addResourcePath(final String path) {
        this.snippetPaths.add(path);
    }

    void setHtmlSource(final String htmlSource) {
        this.htmlSource = htmlSource;
    }

    public String html() {
        return htmlSource;
    }

    @Nullable
    public SnippetComponent<?> create(@Nonnull final Element element, final Type type) {
        requireNonNull(element);
        final SnippetComponent<?> component = SnippetComponent.createSnippet(element, type);
        addComponent(component);
        recurciveCreateComponent(element, component);
        return component;
    }

    private void recurciveCreateComponent(@Nonnull final Node element, final Component<?> parent) {
        element.childNodes().forEach((child) -> {
            boolean isKnownHtmlTag = false;
            Component<?> component = null;
            // accept textnode not empty as component.
            if (child instanceof TextNode && ((TextNode) child).text().length() > 1) {
                isKnownHtmlTag = true;
                component = Component.createComponent(child, parent, isKnownHtmlTag);
            } else if (child instanceof Element) {
                final Element el = (Element) child;
                isKnownHtmlTag = el.tag().isKnownTag();
                component = Component.createComponent(el, parent, isKnownHtmlTag);
            }
            if (component == null) {
                return;
            }
            parent.addChild(component);
            // is html tag?
            if (!isKnownHtmlTag) {
                recurciveCreateComponent(child, component);
            }

        });
    }

    public String render(final SnippetComponent<?> component) {

        final StringWriter writer = new StringWriter();
        mergeTemplate(component, writer);

        final String html = writer.toString();
        return html;
    }

    protected void mergeTemplate(final SnippetComponent<?> component, final Writer writer) {
        boolean found = false;

        for (final String path : this.snippetPaths) {

            final String filePath = path + '/' + component.getName() + ".vm";
            if (Velocity.resourceExists(filePath)) {
                found = true;
                final Context context = createToolManagedVelocityContext();
                context.put("snippet", component);
                context.put("snippetPath", filePath);
                context.put("config", this.config);
                context.put("decoration", this.config.getDecoration());
                // Use config option <absoluteResourceURL>http://mysite.com/</absoluteResourceURL>
                context.put("resourcePath", this.config.getResourcePath());

                Velocity.mergeTemplate("META-INF/skin/snippets/_snippet.vm",
                    RuntimeSingleton.getString(RuntimeConstants.INPUT_ENCODING, RuntimeConstants.ENCODING_DEFAULT),
                    context,
                    writer);
            }

        }
        if (!found) {
            LOGGER.warn("The snippet '{}' template doesn't exist", component.getName());
        }

    }

    /**
     * Creates a Velocity Context with all generic tools configured wit the site rendering context.
     *
     * @return a Velocity tools managed context
     */
    protected Context createToolManagedVelocityContext() {

        final EasyFactoryConfiguration config = new EasyFactoryConfiguration(false);
        config.property("safeMode", Boolean.FALSE);
        config.toolbox(Scope.REQUEST)
                .tool(ContextTool.class)
                .tool(LinkTool.class)
                .tool(LoopTool.class)
                .tool(RenderTool.class);
        config.toolbox(Scope.APPLICATION)
                .tool(AlternatorTool.class)
                .tool(ClassTool.class)
                .tool(ComparisonDateTool.class)
                .tool(ConversionTool.class)
                .tool(DisplayTool.class)
                .tool(EscapeTool.class)
                .tool(FieldTool.class)
                .tool(MathTool.class)
                .tool(NumberTool.class)
                .tool(ResourceTool.class)
                .tool(SortTool.class)
                .tool(XmlTool.class);

        final ToolManager manager = new ToolManager(false, false);
        manager.configure(config);

        return manager.createContext();
    }

}
