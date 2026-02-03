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

import com.google.common.base.MoreObjects;
import org.devacfr.maven.skins.reflow.snippet.SnippetComponent.Type;
import org.jsoup.nodes.Element;

/**
 * Component token.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public class ComponentToken {

  /**
   * @author Christophe Friederich
   * @version 2.4
   */
  public enum TagType {
    /** empty-tag */
    empty,
    /** start-tag */
    start,
    /** end-tag */
    end,
    /** snippet written in html format */
    html
  }

  /** */
  private final Element element;

  /** */
  private final TagType tag;

  /** */
  private final Type type;

  /** */
  private final String name;

  /**
   * Constructor.
   *
   * @param element
   *          the element
   * @param name
   *          the name
   * @param tag
   *          the tag
   */
  public ComponentToken(final Element element, final String name, final TagType tag, final Type type) {
    this.element = element;
    this.name = name;
    this.tag = tag;
    this.type = type;
  }

  /**
   * @return the element
   */
  public Element getElement() {
    return element;
  }

  /**
   * @return the name
   */
  public String name() {
    return name;
  }

  /**
   * @return the tag
   */
  public TagType tag() {
    return tag;
  }

  /**
   * @return the type
   */
  public Type type() {
    return type;
  }

  /**
   * @param startElement
   *          the start element
   * @return true if this element is the close tag of the given start element
   */
  public boolean isCloseTagOf(final ComponentToken startElement) {
    return name.equals(startElement.name) && type.equals(startElement.type) && TagType.start.equals(startElement.tag)
        && TagType.end.equals(tag);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this).add("name", name).add("type", type).add("tag", tag).toString();

  }

  /**
   * Get the close tag representation.
   *
   * @return the close tag representation.
   */
  public String getCloseTag() {
    return "< /" + name + " >";
  }
}
