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

import static java.util.Objects.requireNonNull;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * Base of Snippet component.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public class Component<T extends Component<T>> {

    /** */
    private final String name;

    /** */
    private String html;

    /** */
    private final boolean isHtmlTag;

    /** */
    private final Map<String, String> attributes = Maps.newHashMap();

    /** */
    private Component<?> parent;

    /** */
    private final Components children = new Components();

    /** */
    private final Map<String, Components> childrenMap = Maps.newHashMap();

    /**
     * @param element
     * @param parent
     * @param isKnownHtmlTag
     * @return
     */
    public static Component<?> createComponent(@Nonnull final Element element,
        final Component<?> parent,
        final boolean isKnownHtmlTag) {
        String html = "".intern();
        if (isKnownHtmlTag) {
            html = element.outerHtml();
        } else if (element.children().isEmpty()) {
            html = element.html();
        }

        return new Component<>(element.tagName(), isKnownHtmlTag).withParent(parent)
                .addAttributes(element.attributes())
                .withHtml(html);
    }

    /**
     * @param name
     */
    public Component(@Nonnull final String name, final boolean isHtmlTag) {
        this.name = requireNonNull(name);
        this.isHtmlTag = isHtmlTag;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public boolean isHtml() {
        return isHtmlTag;
    }

    /**
     * @return
     */
    public String getHtml() {
        if (this.children.isEmpty()) {
            return this.html;
        }
        return this.children.html();
    }

    /**
     * @return the parent
     */
    public Component<?> getParent() {
        return parent;
    }

    protected T withParent(final Component<?> parent) {
        this.parent = parent;
        return self();
    }

    /**
     * @param html
     * @return
     */
    public T withHtml(final String html) {
        if (Strings.isNullOrEmpty(html)) {
            this.html = null;
        } else {
            this.html = html;
        }
        return self();
    }

    /**
     * @param name
     * @param value
     * @return
     */
    public T addAttribute(@Nonnull final String name, @Nonnull final String value) {
        this.attributes.put(requireNonNull(name).toLowerCase(), requireNonNull(value));
        return self();
    }

    /**
     * @param name
     * @return
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

    /**
     * @param name
     * @return
     */
    public String getAttribute(@Nonnull final String name) {
        requireNonNull(name);
        return getAttribute(name, String.class, null);
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

    /**
     * @param <R>
     * @param name
     * @param targetType
     * @param defaultValue
     * @return
     */
    @SuppressWarnings("unchecked")
    public <R> R getAttribute(@Nonnull final String name,
        @Nonnull final Class<R> targetType,
        @Nullable final R defaultValue) {
        requireNonNull(name);
        requireNonNull(targetType);
        final String value = this.attributes.get(name.toLowerCase());
        if (Strings.isNullOrEmpty(value)) {
            return defaultValue;
        }

        Object returnedValue = value;
        if (targetType.isAssignableFrom(Boolean.class)) {
            returnedValue = Boolean.valueOf(value);
        } else if (targetType.isAssignableFrom(Integer.class)) {
            returnedValue = Integer.valueOf(value);
        } else if (targetType.isAssignableFrom(Long.class)) {
            returnedValue = Long.valueOf(value);
        }
        return (R) returnedValue;
    }

    public T addChild(final Component<?> component) {
        final String key = component.getName().toLowerCase();
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

    public T addChildren(final Iterable<Component<?>> components) {
        components.forEach((c) -> addChild(c));
        return self();
    }

    /**
     * @param attrs
     * @return
     */
    protected T addAttributes(@Nonnull final Attributes attrs) {
        attrs.asList().stream().forEach(this::addAttribute);
        return self();
    }

    /**
     * @param attr
     * @return
     */
    protected T addAttribute(@Nonnull final Attribute attr) {
        this.attributes.put(requireNonNull(attr.getKey()).toLowerCase(), requireNonNull(attr.getValue()));
        return self();
    }

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

}
