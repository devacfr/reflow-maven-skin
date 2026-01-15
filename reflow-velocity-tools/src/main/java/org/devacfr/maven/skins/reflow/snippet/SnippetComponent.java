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

import javax.annotation.Nonnull;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.velocity.context.Context;
import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Christophe Friederich
 * @version 2.4
 * @param <T>
 *          type of component
 */
public class SnippetComponent<T extends SnippetComponent<T>> extends Component<T> {

  /**
   * type of snippet component
   *
   * @author Christophe Friederich
   * @version 2.4
   */
  public enum Type {
    /** web component */
    webComponent,
    /** shortcode component */
    shortcode
  }

  private static Logger LOGGER = LoggerFactory.getLogger(SnippetComponent.class);

  /** */
  private final Type type;

  @Nonnull
  public static SnippetComponent<?> createSnippet(@Nonnull final Element element,
    final Component<?> parent,
    final Type type) {
    requireNonNull(element);
    return new SnippetComponent<>(element, type).withParent(parent);
  }

  /**
   * Constructor.
   *
   * @param element
   *          the element
   */
  public SnippetComponent(@Nonnull final Element element, final Type type) {
    super(element);
    this.type = requireNonNull(type);
    this.addAttributes(element.attributes());
  }

  /**
   * Get the type of snippet component.
   */
  @Nonnull
  public Type getType() {
    return type;
  }

  /**
   * Get the root parent {@link SnippetComponent}.
   */
  @Override
  protected @Nonnull SnippetComponent<?> getRootParent() {
    return this;
  }

  /**
   * Render the {@link SnippetComponent} between the {@code startElement} and {@code endElement} include.
   *
   * @param context
   *          the snippet context to use
   */
  public void render(final SnippetContext context) {
    final Context renderContext = context.getConfig().getVelocityContext();
    final Element element = getElement();
    if (element == null) {
      LOGGER.warn("Element is null for snippet component: {}, file:{}", this, context.getConfig().getFileId());
      return;
    }
    try {
      final String html = context.renderComponent(this, renderContext);

      final Document doc = JsoupUtils.createHtmlDocument(html);
      final Elements root = doc.body().children();
      if (root.isEmpty()) {
        element.remove();
        return;
      }
      // normally, when debug trace is activated
      if (root.size() > 1 && root.first().tagName().equals("pre")) {
        final Element div = new Element("div");
        root.forEach((e) -> div.appendChild(e));
        element.replaceWith(div);
      } else {
        for (final Element el : root) {
          // if snippet contains rendered snippet.
          if (context.getParser().hasIncludedSnippetComponent(el)) {
            final SnippetParser parser = context.createChildParser();
            final Element childDoc = parser.parse(context.getConfig(), el.outerHtml()).document();
            childDoc.children().forEach((e) -> element.before(e));
          } else {
            element.before(el);
          }
        }
        element.remove();
      }
    } catch (final Exception e) {
      LOGGER.error("Rendering Snippet component failed:{}, file:{}", this, context.getConfig().getFileId());
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this);
  }

}
