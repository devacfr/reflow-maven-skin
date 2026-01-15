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

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;

/**
 * Base of Snippet component.
 *
 * @author Christophe Friederich
 * @version 2.4
 * @param <T>
 *          type of component
 */
public class Component<T extends Component<T>> {

  private final static Set<String> knownTags = Sets.newHashSet("svg");

  /** */
  private final Map<String, String> attributes = Maps.newHashMap();

  /** */
  private Component<?> parent;

  /** */
  private final Components children = new Components();

  /** */
  private final Map<String, Components> childrenMap = Maps.newHashMap();

  /** */
  private final Node node;

  /**
   * @param node
   *          a node (can <b>not</b> be {@code null}).
   * @param parent
   *          the parent component
   * @return the created component
   */
  public static Component<?> createComponent(@Nonnull final Node node, final Component<?> parent) {
    return new Component<>(node).withParent(parent).addAttributes(node.attributes());
  }

  /**
   * @param node
   *          a node (can <b>not</b> be {@code null}).
   */
  protected Component(@Nonnull final Node node) {
    this.node = requireNonNull(node);
  }

  /**
   * @return the name
   */
  public String getName() {
    return node.nodeName();
  }

  /**
   * @return
   */
  public boolean isHtmlTag() {
    return node instanceof TextNode || Tag.isKnownTag(node.nodeName()) || knownTags.contains(node.nodeName());
  }

  /**
   * @return the html content
   */
  public String getHtml() {
    if (!isHtmlTag()) {
      if (children.isEmpty()) {
        return "";
      } else {
        return children.html();
      }
    } else {
      return this.node.outerHtml();
    }
  }

  /**
   * @return
   */
  public String getOwnHtml() {
    if (!isHtmlTag()) {
      return null;
    } else {
      return this.node.outerHtml();
    }
  }

  /**
   * @return the parent
   */
  public Component<?> getParent() {
    return parent;
  }

  @Nullable protected Element getElement() {
    if (this.node instanceof Element) {
      return (Element) this.node;
    }
    return null;
  }

  /**
   * @param name
   *          the name
   * @return the attribute or child component value
   */
  public Object get(@Nonnull final String name) {
    requireNonNull(name);
    String key = name.toLowerCase();
    // if attribute
    if (this.attributes.containsKey(key)) {
      return this.attributes.get(key);
    } else {
      // is children component?
      // check if 's' suffix allowing to retrieve children component as list
      if (key.endsWith("s") && !this.childrenMap.containsKey(key)) {
        key = key.substring(0, key.length() - 1);
        if (this.childrenMap.containsKey(key)) {
          return this.childrenMap.get(key);
        }
      } else if (this.childrenMap.containsKey(key)) {
        final Components value = this.childrenMap.get(key);
        // TODO i don't know if good idea, but it's works.
        if (value.size() > 1) {
          return value;
        }
        return value.first();
      }
    }
    return null;
  }

  public Map<String, String> getAttrs() {
    return this.attributes;
  }

  public String getAttribute(String name) {
    if (!this.attributes.containsKey(name)) {
      return null;
    }
    return this.attributes.get(name);
  }

  public boolean hasAttribute(String name) {
    return this.attributes.containsKey(name);
  }

  /**
   * @return the ARIA attributes
   */
  public Map<String, String> getAriaAttributes() {
    return this.attributes.entrySet()
        .stream()
        .filter(e -> e.getKey().startsWith("aria-"))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /**
   * @return the data attributes
   */
  public Map<String, String> getDataAttributes() {
    return this.attributes.entrySet()
        .stream()
        .filter(e -> e.getKey().startsWith("data-"))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  /**
   * @return the children
   */
  public Components getChildren() {
    return children;
  }

  public Components getChildren(final String name) {
    final String key = requireNonNull(name).toLowerCase();
    if (this.childrenMap.containsKey(key)) {
      return this.childrenMap.get(key);
    }
    return Components.empty();
  }

  public T addChild(final Component<?> component) {
    final String key = component.getName();
    Components value = null;
    if (!this.childrenMap.containsKey(key)) {
      value = new Components();
      this.childrenMap.put(key, value);
    } else {
      value = this.childrenMap.get(key);
    }
    value.add(component);
    this.children.add(component);
    return self();
  }

  protected T withParent(final Component<?> parent) {
    this.parent = parent;
    return self();
  }

  @Nonnull
  protected SnippetComponent<?> getRootParent() {
    Component<?> parent = this.parent;
    while (!(parent instanceof SnippetComponent<?>)) {
      parent = parent.parent;
    }
    return (SnippetComponent<?>) parent;
  }

  /**
   * @param attrs
   *          list of attributes
   * @return the fluent instance
   */
  protected T addAttributes(@Nonnull final Attributes attrs) {
    attrs.asList().stream().forEach(this::addAttribute);
    return self();
  }

  /**
   * @param attr
   *          attribute
   * @return the fluent instance
   */
  protected T addAttribute(@Nonnull final Attribute attr) {
    this.attributes.put(requireNonNull(attr.getKey()).toLowerCase(),
      Strings.isNullOrEmpty(attr.getValue()) ? "true" : attr.getValue());
    return self();
  }

  /**
   * @return the fluent instance
   */
  @SuppressWarnings("unchecked")
  protected T self() {
    return (T) this;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("name", this.getName())
        .add("isHtmlTag", this.isHtmlTag())
        .add("attributes", this.attributes)
        .add("children", this.children.stream().map((cpt) -> cpt.getName()).collect(Collectors.toList()))
        .toString();
  }
}
