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
package org.devacfr.maven.skins.reflow.snippet.component;

import static java.util.Objects.requireNonNull;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class Component<T extends Component<T>> {

    private String html;

    /** */
    private final Map<String, String> attributes = Maps.newHashMap();

    public String getCssClass() {
        return getAttribute("class");
    }

    public String getHtml() {
        return html;
    }

    public T withHtml(final String html) {
        if (Strings.isNullOrEmpty(html)) {
            this.html = null;
        } else {
            this.html = html;
        }
        return self();
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public T addAttribute(@Nonnull final String name, @Nonnull final String value) {
        this.attributes.put(requireNonNull(name).toLowerCase(), requireNonNull(value));
        return self();
    }

    protected T addAttributes(@Nonnull final Attributes attrs) {
        attrs.asList().stream().forEach(this::addAttribute);
        return self();
    }

    protected T addAttribute(@Nonnull final Attribute attr) {
        this.attributes.put(requireNonNull(attr.getKey()).toLowerCase(), requireNonNull(attr.getValue()));
        return self();
    }

    public String getAttribute(@Nonnull String name) {
        requireNonNull(name);
        return getAttribute(name, String.class, null);
    }

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

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

}
