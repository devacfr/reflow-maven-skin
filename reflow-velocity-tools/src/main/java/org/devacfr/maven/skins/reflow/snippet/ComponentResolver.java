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

import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringEscapeUtils;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Tag;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Resolve the type and tag type of component.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public class ComponentResolver {

    /** **/
    private static final Pattern RESOLVER_PATTERN = Pattern.compile(
        "\\{\\{(<|%) (\\/?)([a-zA-Z\\-_]*)(?:\\s+([^\\/>%]*))(\\/?)(>|%)\\}\\}",
        Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

    private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("\\s?(\\w*)=\"(\\w*)\"\\s?",
        Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

    /**
     * Default constructor
     */
    public ComponentResolver() {
        super();

    }

    public static boolean isSnippet(final Node node) {
        return node.hasAttr("shortcode") || node.hasAttr("webcomponent");
    }

    /**
     * Collects all (start,end,empty) Element corresponding to a snippet component.
     *
     * @param document
     *            the Jsoup document to use
     * @return Return a {@link Elements} representing all web components contained in Jsoup document.
     */
    public Elements collect(final Document document) {
        return collect(document, RESOLVER_PATTERN);
    }

    /**
     * Normalise the {@link Document} to enclose inline snippet in html element.
     *
     * @param document
     *            the document to use
     * @return Returns the same normalised {@link Document}.
     */
    public Document normalize(final Document document) {

        final Elements elements = collect(document);
        if (!elements.isEmpty()) {
            final Elements sections = Collector.collect(new Evaluator.Tag("section"), document);
            sections.forEach((section) -> section.unwrap());
        }

        elements.forEach((element) -> {
            String text = StringEscapeUtils.unescapeHtml(element.html());
            final Matcher matcher = RESOLVER_PATTERN.matcher(text);

            final List<MatchResult> results = Lists.newArrayList();

            while (matcher.find()) {
                final MatchResult matchResult = matcher.toMatchResult();
                if (matchResult.start() > 0 || matchResult.end() < text.length()) {
                    results.add(0, matcher.toMatchResult());
                }
            }
            if (!results.isEmpty()) {
                for (final MatchResult matchResult : results) {
                    final String snippet = text.substring(matchResult.start(), matchResult.end());
                    text = text.substring(0, matchResult.start()) + "<span>" + StringEscapeUtils.escapeHtml(snippet)
                            + "</span>" + text.substring(matchResult.end());
                }
                element.html(text);

            }
        });
        return document;
    }

    /**
     * Create a {@link ComponentToken} corresponding to the element.
     *
     * @param element
     *            the element to use.
     * @return Return a new instance of {@link ComponentToken} representing the element.
     */
    public ComponentToken create(final Element element) {
        if (isSnippet(element)) {
            Type type = null;
            if (element.hasAttr("shortcode")) {
                type = Type.shortcode;
            } else if (element.hasAttr("webcomponent")) {
                type = Type.webComponent;
            }
            return new ComponentToken(element, element.tagName(), Tag.html, type);
        } else {
            final Matcher matcher = RESOLVER_PATTERN.matcher(element.ownText());

            if (matcher.matches()) {
                return createToken(element, matcher);
            }
        }
        return null;
    }

    private ComponentToken createToken(final Element element, final Matcher matcher) {
        if (!Strings.isNullOrEmpty(matcher.group(2)) && !Strings.isNullOrEmpty(matcher.group(5))) {
            // can not have same time empty and end identifier.
            throw new RuntimeException("malformed component");
        }
        final Type type = "<".equals(matcher.group(1)) ? Type.shortcode : Type.webComponent;
        Tag tag = Tag.start;
        if ("/".equals(matcher.group(2))) {
            tag = Tag.end;
        } else if ("/".equals(matcher.group(5))) {
            tag = Tag.empty;
        }

        return new ComponentToken(element, matcher.group(3), tag, type);
    }

    protected static Map<String, String> extractAttributes(final String text) {
        final Map<String, String> attrs = Maps.newHashMap();
        final Matcher matcher = ATTRIBUTE_PATTERN.matcher(text);
        while (matcher.find()) {
            attrs.put(matcher.group(1).toLowerCase(), matcher.group(2));
        }
        return attrs;
    }

    public static Elements collect(final Element root, final Pattern searchPattern) {
        final Elements elements = new Elements();
        NodeTraversor.traverse(new Accumulator(root, elements, searchPattern), root);
        return elements;
    }

    private static class Accumulator implements NodeVisitor {

        /** */
        private final Pattern searchPattern;

        private final Element root;

        private final Elements elements;

        Accumulator(final Element root, final Elements elements, final Pattern searchPattern) {
            this.root = root;
            this.elements = elements;
            this.searchPattern = searchPattern;
        }

        @Override
        public void head(final Node node, final int depth) {
            if (node instanceof Element) {
                final Element el = (Element) node;
                if (matches(root, el)) {
                    elements.add(el);
                }
            }
        }

        public boolean matches(final Element root, final Element element) {
            // exclude if in <pre> element, allowing highlight component in documentation
            if ("pre".equals(element.tagName()) || "code".equals(element.tagName())
                    || element.hasParent() && "pre".equals(element.parent().tagName())) {
                return false;
            }
            return searchPattern.matcher(element.ownText()).find();
        }

        @Override
        public void tail(final Node node, final int depth) {
            if (node instanceof Element && isSnippet(node)) {
                elements.add((Element) node);
            }
        }
    }

}
