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

import java.io.IOException;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Tag;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Specific process for each type of snippet component.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public abstract class Processor {

    /** */
    protected final SnippetParser parser;

    /**
     * Default constructor
     *
     * @param parser
     *            current parser.
     */
    public Processor(final SnippetParser parser) {
        this.parser = parser;
    }

    /**
     * Specific parsing for each {@link ComponentToken}.
     *
     * @param token
     *            the current token.
     */
    public void parse(final ComponentToken token) {
        switch (token.tag()) {
            case empty: {
                parser.getSnippetContext().render(createSnippetComponent(token, null));
                break;
            }
            case start: {
                parser.push(token);
                parser.parse();
                break;
            }
            case end: {
                final ComponentToken startToken = parser.pop();
                if (!token.isCloseTagOf(startToken)) {
                    throw new RuntimeException(
                            "start token " + startToken + " should be closed, but next token is " + token);
                }
                parser.getSnippetContext().render(createSnippetComponent(startToken, token));
                break;
            }
            case html: {
                parser.getSnippetContext().render(createSnippetComponent(token, null));
                break;
            }
            default:
                throw new SnippetParseException("unknown token tag " + token.tag());
        }

    }

    /**
     * Append child {@link Node} in html rendering.
     *
     * @param node
     *            the node to use.
     * @param writer
     *            the html writer
     * @throws IOException
     *             If an I/O error occurs.
     */
    protected abstract void appendChildrenToHtml(final Node node, final Appendable writer) throws IOException;

    /**
     * Convert the snippet to html.
     *
     * @param startToken
     *            the start token
     * @param endToken
     *            the end token.
     * @return Returns a new {@link Element} representing html represention of snippet.
     */
    protected Element convertToHtml(@Nonnull final ComponentToken startToken, @Nullable final ComponentToken endToken) {
        final Element startElement = startToken.getElement();
        final Node previousElement = startElement.previousSibling();
        Element endElement = null;
        if (endToken != null) {
            endElement = endToken.getElement();
        }
        final Element tmp = new Element("component");
        final Node parent = startElement.parentNode();

        final StringBuilder html = new StringBuilder(convertElementToHtml(startElement));
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
            html.append(convertElementToHtml(endElement));
        }
        tmp.append(html.toString());
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
        nodesToRemove.forEach((node) -> node.remove());
        return component;
    }

    /**
     * Create a {@link SnippetComponent}.
     *
     * @param startToken
     *            the start token.
     * @param endToken
     *            the end token.
     * @return Returns a new instance of {@link SnippetComponent} representing the information contained between
     *         {@code startToken} and {@code endToken}.
     */
    protected SnippetComponent<?> createSnippetComponent(final ComponentToken startToken,
        final ComponentToken endToken) {
        final SnippetContext snippetContext = parser.getSnippetContext();
        Element componentElement = null;
        if (Tag.html.equals(startToken.tag())) {
            componentElement = startToken.getElement();
        } else {
            componentElement = convertToHtml(startToken, endToken);
        }
        return snippetContext.create(componentElement, startToken, endToken);
    }

    /**
     * Converts the snippet element to html format.
     *
     * @param element
     *            the html element to use.
     * @return Returns a {@link String} representing the snippet element in html format.
     */
    protected String convertElementToHtml(final Element element) {
        return element.text()
                .replace("{{< ", "<")
                .replace(" />}}", "/>")
                .replace(" /%}}", "/>")
                .replace(" >}}", ">")
                .replace("{{% ", "<")
                .replace(" %}}", ">")

                .replaceAll("\\u201c|\\u201d", "\"");
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
         *            current parser.
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
                    if (Iterables.tryFind(el.childNodes(), (n) -> n instanceof Comment).isPresent()) {
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

    }

    /**
     * Specific process for snippet shortcode component.
     *
     * @author Christophe Friederich
     * @version 2.4
     */
    public static class ShortcodeProcessor extends Processor {

        /**
         * Default constructor
         *
         * @param parser
         *            current parser.
         */
        public ShortcodeProcessor(final SnippetParser parser) {
            super(parser);
        }

        @Override
        protected void appendChildrenToHtml(final Node node, final Appendable writer) throws IOException {
            writer.append(node.outerHtml());
        }

    }
}
