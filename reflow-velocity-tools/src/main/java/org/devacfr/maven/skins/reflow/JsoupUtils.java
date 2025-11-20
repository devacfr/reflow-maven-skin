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
package org.devacfr.maven.skins.reflow;

import static java.util.Objects.requireNonNull;

import java.nio.charset.StandardCharsets;
import javax.annotation.Nonnull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
public final class JsoupUtils {

  private JsoupUtils() {
    // util
  }

  /**
   * Parse HTML string into a Jsoup Document with XML output settings.
   *
   * @param html
   *          HTML string
   * @return Jsoup Document
   */
  @Nonnull
  public static Document createHtmlDocument(@Nonnull String html) {
    requireNonNull(html);
    Document doc = Jsoup.parse(html, "", createHtmlParser());
    // doc.outputSettings()
    // .outline(false)
    // .syntax(Document.OutputSettings.Syntax.xml)
    // .prettyPrint(false)
    // .escapeMode(Entities.EscapeMode.xhtml)
    // .charset(StandardCharsets.UTF_8);
    return doc;
  }

  @Nonnull
  public static Document createXmlDocument(@Nonnull String html) {
    requireNonNull(html);
    Document doc = Jsoup.parse(html, "", createXmlParser());
    doc.outputSettings()
        .outline(false)
        .syntax(Document.OutputSettings.Syntax.xml)
        .prettyPrint(false)
        .escapeMode(org.jsoup.nodes.Entities.EscapeMode.xhtml)
        .charset(StandardCharsets.UTF_8);
    return doc;
  }

  @Nonnull
  public static Parser createHtmlParser() {
    Parser parser = Parser.htmlParser();
    parser.tagSet().onNewTag(tag -> {
      if (!tag.isKnownTag())
        tag.set(Tag.SelfClose);
    });
    return parser;
  }

  @Nonnull
  public static Parser createXmlParser() {
    Parser parser = Parser.xmlParser();
    return parser;
  }

  public static Element link(Document doc,
    String href,
    String name,
    String target,
    String img,
    String icon,
    String className) {
    Element a = doc.createElement("a");
    if (href != null && !href.isEmpty()) {
      a.attr("href", href);
    }
    if (name != null && !name.isEmpty()) {
      a.attr("title", name);
    }
    if (target != null && !target.isEmpty()) {
      a.attr("target", target);
    }
    if (className != null && !className.isEmpty()) {
      a.addClass(className);
    }
    if (img != null && !img.isEmpty()) {
      // Image on the left side of the name
      Element image = image(doc, img, "", "", "", "");
      a.appendChild(image);
      a.appendText(name);
    } else if (icon != null && !icon.isEmpty()) {
      // No image - optional icon though on the right of the name
      a.appendText(name);
      Element i = doc.createElement("i");
      i.addClass(icon);
      a.appendChild(i);
    } else {
      // No image - no icon
      a.appendText(name);
    }
    return a;
  }

  public static Element image(Document doc, String src, String alt, String border, String width, String height) {
    Element image = doc.createElement("img");
    image.addClass("image-link");
    image.attr("src", src);
    if (alt != null && !alt.isEmpty()) {
      image.attr("alt", alt);
    }
    if (border != null && !border.isEmpty()) {
      image.attr("border", border);
    }
    if (width != null && !width.isEmpty()) {
      image.attr("width", width);
    }
    if (height != null && !height.isEmpty()) {
      image.attr("height", height);
    }
    return image;
  }

  public static String getNodeName(Node node) {
    if (node instanceof Element) {
      return ((Element) node).tagName();
    } else {
      return node.nodeName();
    }
  }

  public static boolean hasTextNode(Node node) {
    return node.childNodes().stream().anyMatch(n -> {
      boolean match = n.nodeName().equals("#text") && !n.toString().trim().isEmpty();
      return match;
    });
  }

}
