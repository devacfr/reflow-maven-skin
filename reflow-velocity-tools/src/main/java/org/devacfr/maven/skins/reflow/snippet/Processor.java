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

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Specific process for each type of snippet component.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public abstract class Processor {

  private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

  /** */
  protected final SnippetParser parser;

  /**
   * Default constructor
   *
   * @param parser
   *          current parser.
   */
  public Processor(final SnippetParser parser) {
    this.parser = parser;
  }

  /**
   * Specific parsing for each {@link ComponentToken}.
   *
   * @param token
   *          the current token.
   */
  public void parse(final ComponentToken token) {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Parse Token: {}", token);
    }
    switch (token.tag()) {
      case empty:
        this.handleEmptyTag(token);
        break;

      case start:
        this.handleStartTag(token);
        parser.push(token);
        parser.parse();
        break;

      case end:
        final ComponentToken startToken = parser.pop();
        final ComponentToken endToken = token;
        this.handleCloseTag(startToken, endToken);
        break;
      case html:
        this.handleHtmlTag(token);
        break;
      default:
        throw new SnippetParseException("unknown token tag " + token.tag());
    }
  }

  /**
   * Append child {@link Node} in html rendering.
   *
   * @param node
   *          the node to use.
   * @param writer
   *          the html writer
   * @throws IOException
   *           If an I/O error occurs.
   */
  protected abstract void appendChildrenToHtml(Node node, Appendable writer) throws IOException;

  /**
   * Handle start tag mismatch.
   *
   * @param token
   *          the token
   */
  protected void handleStartTag(final ComponentToken token) {
    // do nothing
  }

  /**
   * Handle close tag mismatch.
   *
   * @param startToken
   *          the start token
   * @param endToken
   *          the end token.
   */
  protected void handleCloseTag(final ComponentToken startToken, final ComponentToken endToken) {
    // do nothing
  }

  /**
   * Handle empty tag.
   *
   * @param token
   *          the token
   */
  protected void handleEmptyTag(final ComponentToken token) {
    // do nothing
  }

  /**
   * Handle html tag.
   *
   * @param token
   *          the token
   */
  protected void handleHtmlTag(final ComponentToken token) {
    // do nothing
  }

  /**
   * Convert the snippet to html.
   *
   * @param startToken
   *          the start token
   * @param endToken
   *          the end token.
   * @return Returns a new {@link Element} representing html represention of snippet.
   */
  protected Element convertToHtml(@Nonnull final ComponentToken startToken, @Nullable final ComponentToken endToken) {
    final Element startElement = startToken.getElement();
    final Node previousElement = startElement.previousSibling();
    Element endElement = null;
    if (endToken != null) {
      endElement = endToken.getElement();
    }
    final Document doc = JsoupUtils.createHtmlDocument("");
    final Element tmp = doc.body();
    final Node parent = startElement.parentNode();

    final StringBuilder html = new StringBuilder(ComponentResolver.convertElementTextToHtml(startElement));
    final List<Node> nodesToRemove = Lists.newArrayList();
    nodesToRemove.add(startElement);
    if (endElement != null) {
      boolean startCopy = false;

      for (final Node n : parent.childNodes()) {
        if (n.equals(endElement)) {
          nodesToRemove.add(n);
          break;
        }
        if (startCopy) {
          try {
            appendChildrenToHtml(n, html);
          } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
          }
          nodesToRemove.add(n);
        }
        if (n.equals(startElement)) {
          startCopy = true;
        }
      }
      html.append(ComponentResolver.convertElementTextToHtml(endElement));
    }
    tmp.html(html.toString());
    final Element component = tmp.children().first();
    final Element parentElement = startElement.parent();

    if (previousElement != null) {
      previousElement.after(component);
    } else {
      if (parentElement.children().first() != null) {
        parentElement.children().first().before(component);
      } else {
        parentElement.children().add(component);
      }
    }
    nodesToRemove.forEach(Node::remove);
    return component;
  }

  /**
   * Specific process for snippet web component.
   *
   * @author Christophe Friederich
   * @version 2.4
   */
  public static class WebComponentProcessor extends Processor {

    /**
     * Default constructor
     *
     * @param parser
     *          current parser.
     */
    public WebComponentProcessor(final SnippetParser parser) {
      super(parser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void appendChildrenToHtml(final Node node, final Appendable writer) throws IOException {
      if (node instanceof Element) {
        final Element el = (Element) node;
        // when use code highlighting
        if ("div".equals(el.tagName()) && el.hasClass("source")) {
          writer.append(el.text());
        } else {
          // comment can be enclose in <p> element.
          if (Iterables.tryFind(el.childNodes(), n -> n instanceof Comment).isPresent()) {
            writer.append(el.data());
          } else {
            writer.append(el.outerHtml());
          }
        }
      } else if (node instanceof Comment) {
        writer.append(((Comment) node).getData());
      } else if (node instanceof TextNode) {
        writer.append(((TextNode) node).text());
      }
    }

    @Override
    protected void handleStartTag(ComponentToken token) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void handleEmptyTag(final ComponentToken token) {
      SnippetContext snippetContext = parser.getSnippetContext();
      Element componentElement = convertToHtml(token, null);
      Component<?> component = snippetContext.create(componentElement, token, null);
      snippetContext.render(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void handleCloseTag(final ComponentToken startToken, final ComponentToken endToken) {
      SnippetContext snippetContext = parser.getSnippetContext();
      // if (snippetContext.getCurrentWebComponentToken() != null) {
      // return;
      // }
      if (!endToken.isCloseTagOf(startToken)) {
        throw new RuntimeException("start token " + startToken + " should be closed by " + startToken.getCloseTag()
            + ", but found " + endToken);
      }

      Element componentElement = convertToHtml(startToken, endToken);
      Component<?> component = snippetContext.create(componentElement, startToken, endToken);
      snippetContext.render(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void handleHtmlTag(final ComponentToken token) {
      SnippetContext snippetContext = parser.getSnippetContext();
      Element componentElement = token.getElement();
      Component<?> component = snippetContext.create(componentElement, token, null);
      snippetContext.render(component);
    }

  }

}
