/*
* Copyright 2012-2025 Christophe Friederich
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
import java.util.UUID;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.ToolManager;
import org.apache.velocity.tools.config.EasyFactoryConfiguration;
import org.apache.velocity.tools.generic.ClassTool;
import org.apache.velocity.tools.generic.ComparisonDateTool;
import org.apache.velocity.tools.generic.ContextTool;
import org.apache.velocity.tools.generic.DisplayTool;
import org.apache.velocity.tools.generic.EscapeTool;
import org.apache.velocity.tools.generic.FieldTool;
import org.apache.velocity.tools.generic.LinkTool;
import org.apache.velocity.tools.generic.LoopTool;
import org.apache.velocity.tools.generic.MathTool;
import org.apache.velocity.tools.generic.NumberTool;
import org.apache.velocity.tools.generic.RenderTool;
import org.apache.velocity.tools.generic.ResourceTool;
import org.apache.velocity.tools.generic.XmlTool;
import org.devacfr.maven.skins.reflow.HtmlTool;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.devacfr.maven.skins.reflow.URITool;
import org.devacfr.maven.skins.reflow.snippet.SnippetComponent.Type;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetContext {

  /** */
  private static final Logger LOGGER = LoggerFactory.getLogger(SnippetContext.class);

  /** **/
  private String htmlSource;

  /** */
  private ISkinConfig config;

  /** */
  private final SnippetParser parser;

  /**
   * Constructor.
   *
   * @param parser
   */
  public SnippetContext(@Nonnull final SnippetParser parser) {
    this.parser = requireNonNull(parser);
  }

  /**
   * Reset the context.
   */
  public void reset() {
    this.htmlSource = null;
    this.config = null;
  }

  public String generateSnippetIdentifier() {
    return "snippet-placement-" + UUID.randomUUID().toString();
  }

  public SnippetParser getParser() {
    return this.parser;
  }

  public ISkinConfig getConfig() {
    return config;
  }

  public SnippetParser createChildParser() {
    final SnippetParser parser = new SnippetParser();
    return parser;
  }

  public void setConfig(final ISkinConfig config) {
    this.config = config;
  }

  void setHtmlSource(final String htmlSource) {
    this.htmlSource = htmlSource;
  }

  public String html() {
    return htmlSource;
  }

  public Element document() {
    return JsoupUtils.createHtmlDocument(html());
  }

  @Nonnull
  public SnippetComponent<?> create(@Nonnull final Element element,
    @Nonnull final ComponentToken startToken,
    @Nullable final ComponentToken endToken) {
    requireNonNull(element);
    requireNonNull(startToken);
    final SnippetComponent<?> component = SnippetComponent.createSnippet(element, null, startToken.type());
    recurciveCreateComponent(element, component);
    return component;
  }

  @Nonnull
  public SnippetComponent<?> create(@Nonnull final Element element, final Component<?> commponent) {
    requireNonNull(element);
    final SnippetComponent<?> component = SnippetComponent.createSnippet(element, commponent, Type.webComponent);
    recurciveCreateComponent(element, component);
    return component;
  }

  private void recurciveCreateComponent(@Nonnull final Node element, final Component<?> parent) {
    element.childNodes().forEach(child -> {
      Component<?> component = null;
      // accept textnode not empty as component.
      if (child instanceof TextNode && ((TextNode) child).text().trim().length() > 0) {
        component = Component.createComponent(child, parent);
      } else if ("p".equals(child.nodeName()) && child.outerHtml().length() == 7) {
        // skip empty <p> tags
      } else if (child instanceof Element) {
        final Element el = (Element) child;
        if (parser.isSnippet(el)) {
          component = create(el, parent);
        } else {
          component = Component.createComponent(el, parent);
          recurciveCreateComponent(el, component);
        }
      }
      if (component != null) {
        parent.addChild(component);
      }
    });
  }

  protected void render(final SnippetComponent<?> component) {
    traverseTee(component, c -> {
      if (c instanceof SnippetComponent) {
        ((SnippetComponent<?>) c).render(this);
      }
    });
    component.render(this);
  }

  private void traverseTee(final Component<?> component, final Consumer<Component<?>> consumer) {
    final Consumer<Component<?>> traverse = c -> traverseTee(c, consumer);
    component.getChildren().forEach(consumer.andThen(traverse));
  }

  protected String renderComponent(final SnippetComponent<?> component, final Context context) {
    final StringWriter writer = new StringWriter();
    try {
      mergeTemplate(component, context, writer);
      return writer.toString();
    } finally {
      IOUtils.closeQuietly(writer);
    }
  }

  protected void mergeTemplate(final SnippetComponent<?> component, final Context contextParent, final Writer writer) {
    boolean found = false;
    for (final String path : this.parser.getSnippetPaths()) {
      final String filePath = path + '/' + component.getName() + ".vm";
      if (Velocity.resourceExists(filePath)) {
        found = true;
        final Context context = createVelocityContext(contextParent);
        context.put("snippet", component);
        context.put("snippetPath", filePath);
        context.put("config", this.config);
        if (this.config.getContext() != null) {
          context.put("pageContext", this.config.getContext());
          context.put("pageType", this.config.getContext().getType());
        }
        context.put("velocity", Velocity.class);
        context.put("site", this.config.getSiteModel());

        Velocity.mergeTemplate("META-INF/skin/snippets/_snippet.vm",
          RuntimeSingleton.getString(RuntimeConstants.INPUT_ENCODING, RuntimeConstants.ENCODING_DEFAULT),
          context,
          writer);
        break;
      } else {
        if (LOGGER.isDebugEnabled()) {
          LOGGER.debug("Template for component '{}' not found in path:{} ", component, filePath);
        }
      }
    }
    if (!found) {
      LOGGER.warn("The snippet '{}' template doesn't exist", component.getName());
    }
  }

  /**
   * Creates a Velocity Context with all generic tools configured wit the site rendering context.
   *
   * @param contextParent
   *          velocity context parent
   * @return a Velocity tools managed context
   */
  protected Context createVelocityContext(final Context contextParent) {
    final VelocityContext context = new VelocityContext(contextParent);
    return context;
  }

  protected static ToolManager createToolManaged() {

    final EasyFactoryConfiguration config = new EasyFactoryConfiguration(false);
    config.property("safeMode", Boolean.FALSE);
    config.toolbox(Scope.REQUEST)
        .tool(ContextTool.class)
        .tool(LinkTool.class)
        .tool(LoopTool.class)
        .tool(RenderTool.class);
    config.toolbox(Scope.APPLICATION)
        .tool(ClassTool.class)
        .tool(ComparisonDateTool.class)
        .tool(DisplayTool.class)
        .tool(EscapeTool.class)
        .tool(FieldTool.class)
        .tool(MathTool.class)
        .tool(NumberTool.class)
        .tool(ResourceTool.class)
        .tool(XmlTool.class)
        .tool(URITool.class)
        .tool(HtmlTool.class);

    final ToolManager manager = new ToolManager(false, false);
    manager.configure(config);
    return manager;
  }

  public static class SnippetResource {

    private final String name;

    private final String path;

    public SnippetResource(final String name, final String path) {
      this.name = name;
      this.path = path;
    }

    public String getName() {
      return name;
    }

    public String getPath() {
      return path;
    }

    @Override
    public String toString() {
      return "SnippetResource [name=" + name + ", path=" + path + "]";
    }
  }

}
