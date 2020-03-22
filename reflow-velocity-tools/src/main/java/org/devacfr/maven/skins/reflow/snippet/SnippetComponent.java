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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Element;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetComponent<T extends SnippetComponent<T>> extends Component<T> {

    /** */
    final private Type type;

    /**
     * @param element
     * @param startToken
     * @param endToken
     * @return
     */
    public static SnippetComponent<?> createSnippet(@Nonnull final Element element,
        @Nonnull final ComponentToken startToken,
        @Nullable final ComponentToken endToken) {
        requireNonNull(element);
        requireNonNull(startToken);
        final Type type = startToken.type();
        return new SnippetComponent<>(element.tagName(), type).addAttributes(element.attributes());
    }

    /**
     * @param name
     */
    public SnippetComponent(@Nonnull final String name, @Nonnull final Type type) {
        super(name, false);
        this.type = requireNonNull(type);
    }

    /**
     * @return
     */
    @Nonnull
    public Type getType() {
        return type;
    }

    @Override
    protected SnippetComponent<?> getRootParent() {
        return this;
    }

    /**
     * @param context
     * @return
     */
    public String render(final SnippetContext context) {
        try {
            return context.render(this);
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
