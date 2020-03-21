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

import javax.annotation.Nonnull;

import org.apache.commons.lang.StringEscapeUtils;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Tag;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;

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

    /**
     * Collects all (start,end,empty) Element corresponding to a snippet component.
     *
     * @param document
     *            the Jsoup document to use
     * @return Return a {@link Elements} representing all web components contained in Jsoup document.
     */
    public Elements collect(final Document document) {
        final Evaluator evaluator = new ContainsOwnText(RESOLVER_PATTERN, -1);
        return Collector.collect(evaluator, document);
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
        final Matcher matcher = RESOLVER_PATTERN.matcher(element.ownText());

        if (matcher.matches()) {
            return createToken(element, matcher);
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

    /**
     * JSoup {@link Evaluator} allowing to evaluate that an element matches the regex selector.
     *
     * @author Christophe Friederich
     * @version 2.4
     */
    public static final class ContainsOwnText extends Evaluator {

        /** */
        private final Pattern searchPattern;

        /** */
        private int fromSiblingIndex = -1;

        /**
         * Default constructor.
         *
         * @param regex
         *            a regex pattern.
         * @param fromSiblingIndex
         *            the sibling index from where begin to match.
         */
        public ContainsOwnText(@Nonnull final Pattern regex, final int fromSiblingIndex) {
            this.searchPattern = regex;
            this.fromSiblingIndex = fromSiblingIndex;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean matches(final Element root, final Element element) {
            // exclude if in <pre> element, allowing highlight component in documentation
            if ("pre".equals(element.tagName()) || "code".equals(element.tagName())
                    || element.hasParent() && "pre".equals(element.parent().tagName())) {
                return false;
            }
            if (fromSiblingIndex == -1 || element.siblingIndex() >= fromSiblingIndex) {
                return searchPattern.matcher(element.ownText()).find();
            }
            return false;
        }

    }

}
