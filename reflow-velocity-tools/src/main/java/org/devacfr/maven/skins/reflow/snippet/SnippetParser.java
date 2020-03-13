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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.snippet.component.SnippetComponent;
import org.devacfr.maven.skins.reflow.snippet.internal.ContainsOwnText;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetParser {

    /** */
    private static final Logger LOGGER = LoggerFactory.getLogger(SnippetParser.class);

    /** */
    private final Pattern startPattern = Pattern.compile("\\{\\{% ([^\\\\/]\\w*)(\\s?(?:.*)) %\\}\\}",
        Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

    /** */
    private final Evaluator startEvaluator = new ContainsOwnText(startPattern, 0);

    public SnippetContext parse(final String htmlSource) throws IOException {
        final SnippetContext contextSnippet = new SnippetContext(htmlSource);

        // find all snippet start
        final Document doc = Jsoup.parse(htmlSource);
        final Elements elements = Collector.collect(this.startEvaluator, doc);

        for (final Element element : elements) {
            final String tagName = extractTag(element, startPattern);

            final Element parent = element.parent();
            final Pattern endPattern = Pattern.compile("\\{\\{% \\/" + tagName + " %\\}\\}",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

            // find end tag in same depth
            final Element endElement = Collector.findFirst(new ContainsOwnText(endPattern, element.siblingIndex()),
                parent);
            if (endElement == null) {
                throw new RuntimeException("End snippet should be on same depth");
            }

            final Element componentElement = createCopyElementFrom(element, endElement);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("snippet: {}", componentElement);
            }
            final SnippetComponent<?> component = contextSnippet.create(componentElement.children().first());
            renderingComponentToHtml(contextSnippet, component, element, endElement);
        }
        contextSnippet.setHtmlSource(doc.html());
        return contextSnippet;
    }

    private Element createCopyElementFrom(final Element startElement, final Element endElement) {
        final Element tmp = new Element("component");
        final Node parent = startElement.parentNode();
        boolean startCopy = false;
        final StringBuilder html = new StringBuilder(convertToHtml(startElement));
        for (final Node n : parent.childNodes()) {
            if (n.equals(endElement)) {
                break;
            }
            if (startCopy) {
                if (n instanceof Element) {
                    html.append(((Element) n).text());
                } else if (n instanceof Comment) {
                    html.append(((Comment) n).getData());
                }
            }
            if (n.equals(startElement)) {
                startCopy = true;
            }
        }
        html.append(convertToHtml(endElement));
        tmp.append(html.toString());
        return tmp;

    }

    private void renderingComponentToHtml(final SnippetContext contextSnippet,
        final SnippetComponent<?> component,
        final Element startElement,
        final Element endElement) {
        final Element parent = startElement.parent();
        final Element previousElement = startElement.previousElementSibling();
        boolean startCopy = false;
        final List<Node> nodesToRemove = Lists.newArrayList();
        for (final Node n : parent.childNodes()) {

            if (n.equals(startElement)) {
                startCopy = true;
            }
            if (startCopy) {
                nodesToRemove.add(n);
            }
            if (n.equals(endElement)) {
                break;
            }
        }
        nodesToRemove.forEach((node) -> node.remove());
        if (previousElement != null) {
            previousElement.after(component.render(contextSnippet));
        } else {
            if (parent.children().first() != null) {
                parent.children().first().before(component.render(contextSnippet));
            } else {
                parent.append(component.render(contextSnippet));
            }
        }

    }

    private String extractTag(final Element element, final Pattern pattern) {
        final Matcher matcher = pattern.matcher(element.text());
        if (matcher.matches()) {
            return matcher.group(1);
        }
        throw new RuntimeException("no match");
    }

    private String convertToHtml(final Element element) {
        return element.text().replace("{{% ", "<").replace(" %}}", ">").replaceAll("\\u201c|\\u201d", "\"");
    }

}
