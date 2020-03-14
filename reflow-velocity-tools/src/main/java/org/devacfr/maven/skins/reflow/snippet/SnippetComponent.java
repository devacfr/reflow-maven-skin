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

import javax.annotation.Nonnull;

import org.jsoup.nodes.Element;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetComponent<T extends SnippetComponent<T>> extends Component<T> {

    /** */
    private final String id;

    public static SnippetComponent<?> createSnippet(@Nonnull final SnippetContext context,
        @Nonnull final Element element) {
        return new SnippetComponent<>(context, element.tagName()).addAttributes(element.attributes())
                .withHtml(element.outerHtml());
    }

    /**
     * @param context
     * @param name
     */
    public SnippetComponent(@Nonnull final SnippetContext context, @Nonnull final String name) {
        super(name, false);
        this.id = context.generateSnippetIdentifier();
    }

    /**
     * @return
     */
    public String getSnippetId() {
        return id;
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
