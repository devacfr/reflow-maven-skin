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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.text.StringEscapeUtils;
import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.TagType;
import org.devacfr.maven.skins.reflow.snippet.SnippetComponent.Type;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resolve the type and tag type of component.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public class ComponentResolver {

  private static final Logger LOGGER = LoggerFactory.getLogger(ComponentResolver.class);

  /** **/
  private static final Pattern RESOLVER_PATTERN = Pattern.compile(
    "\\{\\{(<|%) (\\/?)([\\w\\-_]*)(\\s?(?:[\\w\\-_]*)(?:=[\\u201c|\"](?:[\\s\\w\\p{Punct}]*)[\\u201d|\"])?)* (\\/?)(>|%)\\}\\}",
    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

  private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("\\s?(\\w*)=(\\\")?(\\w*)\2\\s?",
    Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CHARACTER_CLASS);

  private final SnippetParser parser;

  /**
   * Default constructor
   */
  public ComponentResolver() {
    this(new SnippetParser());
  }

  public ComponentResolver(final SnippetParser parser) {
    super();
    this.parser = requireNonNull(parser);
  }

  public boolean isSnippet(final Node node) {
    return parser.isSnippet(node);
  }

  /**
   * Collects all (start,end,empty) Element corresponding to a snippet component.
   *
   * @param document
   *          the Jsoup element to use
   * @return Return a {@link Elements} representing all web components contained in Jsoup document.
   */
  public Elements collect(final Element document) {
    return collect(document, RESOLVER_PATTERN);
  }

  /**
   * Normalise the {@link Document} to enclose inline snippet in html element.
   *
   * @param document
   *          the document to use
   * @return Returns the same normalised {@link Document}.
   */
  public Element normalize(final Document document) {

    final Elements elements = collect(document);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Snippet Collected");
      LOGGER.debug(elements.toString());
    }
    // remove all section tags
    if (!elements.isEmpty()) {
      final Elements sections = document.getElementsByTag("section");
      sections.forEach(Element::unwrap);
    }

    elements.forEach(element -> {
      String text = StringEscapeUtils.unescapeHtml4(element.html());
      final Matcher matcher = RESOLVER_PATTERN.matcher(text);

      final List<MatchResult> results = Lists.newArrayList();

      while (matcher.find()) {
        final MatchResult matchResult = matcher.toMatchResult();
        // add only inner matches
        if (matchResult.start() >= 0 || matchResult.end() <= text.length()) {
          results.add(0, matcher.toMatchResult());
        }
      }
      String convertedText = text;
      // process from end to start
      if (!results.isEmpty()) {
        for (final MatchResult matchResult : results) {
          // escape snippet tag
          final String snippet = text.substring(matchResult.start(), matchResult.end());
          // wrap snippet in span for display
          text = text.substring(0, matchResult.start()) + "<span>" + StringEscapeUtils.escapeHtml4(snippet) + "</span>"
              + text.substring(matchResult.end());
          // convert snippet to html
          final String convertedSnippet = convertSnippetTagsToHtml(
            convertedText.substring(matchResult.start(), matchResult.end()));
          // replace in text
          convertedText = convertedText.substring(0, matchResult.start()) + convertedSnippet
              + convertedText.substring(matchResult.end());
        }
        // convert to html
        // remove all snippet tags to defirentiate inline snippet in paragraph to
        // sequence of snippets.
        Element body = JsoupUtils.createHtmlDocument(convertSnippetTagsToHtml(convertedText)).body();
        body.children().forEach(e -> {
          if (parser.isSnippet(e))
            e.remove();
        });
        boolean containsOnlySnippets = !JsoupUtils.hasTextNode(body);
        element.html(text);

        // remove <p> tag if not necessary, i.e. contains only snippet components
        if (element.tagName().equals("p") && containsOnlySnippets) {
          element.unwrap();
        }
      }
    });
    return document;
  }

  /**
   * Create a {@link ComponentToken} corresponding to the element.
   *
   * @param element
   *          the element to use.
   * @return Return a new instance of {@link ComponentToken} representing the element.
   */
  public ComponentToken create(final Element element) {
    if (isSnippet(element)) {
      Type type = Type.webComponent;
      return new ComponentToken(element, element.tagName(), TagType.html, type);
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
    TagType tag = TagType.start;
    if ("/".equals(matcher.group(2))) {
      tag = TagType.end;
    } else if ("/".equals(matcher.group(5))) {
      tag = TagType.empty;
    }
    final Type type = "<".equals(matcher.group(1)) ? Type.shortcode : Type.webComponent;

    return new ComponentToken(element, matcher.group(3), tag, type);
  }

  protected static Map<String, String> extractAttributes(final String text) {
    final Map<String, String> attrs = Maps.newHashMap();
    final Matcher matcher = ATTRIBUTE_PATTERN.matcher(text);
    while (matcher.find()) {
      attrs.put(matcher.group(1).toLowerCase(), matcher.group(3));
    }
    return attrs;
  }

  public Elements collect(final Element root, final Pattern searchPattern) {
    final Elements elements = new Elements();
    NodeTraversor.traverse(new Accumulator(parser, root, elements, searchPattern), root);
    return elements;
  }

  /**
   * Converts the text of element to html format.
   *
   * @param element
   *          the html element to use.
   * @return Returns a {@link String} representing the snippet element in html format.
   */
  public static String convertElementTextToHtml(final Element element) {
    return convertSnippetTagsToHtml(element.text());
  }

  /**
   * Converts the snippet tags to html format.
   *
   * @param html
   *          the html to use.
   * @return Returns a {@link String} representing the snippet html in html format.
   */
  public static String convertSnippetTagsToHtml(final String html) {
    String text = StringEscapeUtils.unescapeHtml4(html);
    return text.replace("{{< ", "<")
        .replace(" />}}", "/>")
        .replace(" /%}}", "/>")
        .replace(" >}}", ">")
        .replace("{{% ", "<")
        .replace(" %}}", ">")
        .replaceAll("\\u201c|\\u201d", "\"");
  }

  private static class Accumulator implements NodeVisitor {

    /** */
    private final Pattern searchPattern;

    private final Element root;

    private final Elements elements;

    private final SnippetParser parser;

    Accumulator(final SnippetParser parser, final Element root, final Elements elements, final Pattern searchPattern) {
      this.root = root;
      this.elements = elements;
      this.searchPattern = searchPattern;
      this.parser = parser;
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
      if (node instanceof Element && parser.isSnippet(node)) {
        elements.add((Element) node);
      }
    }
  }
}
