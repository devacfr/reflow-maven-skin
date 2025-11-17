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

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Christophe Friederich
 * @version 2.4
 * @param <T>
 *            type of component
 */
public class SnippetComponent<T extends SnippetComponent<T>> extends Component<T> {

    /** */
    private final Type type;

    @Nonnull
    public static SnippetComponent<?> createSnippet(@Nonnull final Element element,
        final Component<?> parent,
        final Type type) {
        requireNonNull(element);
        return new SnippetComponent<>(element, type).addAttributes(element.attributes()).withParent(parent);
    }

    /**
     * @param element
     * @param type
     */
    public SnippetComponent(@Nonnull final Element element, @Nonnull final Type type) {
        super(element);
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
    protected @Nonnull SnippetComponent<?> getRootParent() {
        return this;
    }

    /**
     * Render the {@link SnippetComponent} between the {@code startElement} and {@code endElement} include.
     *
     * @param context
     *            the snippet context to use
     */
    public void render(final SnippetContext context) {
        try {
            final Element element = getElement();
            final String html = context.renderComponent(this);

            final Document doc = JsoupUtils.createHtmlDocument(html);
            Elements root = doc.body().children();
            if (root.isEmpty()) {
                return;
            }
            // normally, when debug trace is activated
            if (root.size() > 1) {
                final Element div = new Element("div");
                root.forEach((e) -> div.appendChild(e));
                element.replaceWith(div);
            } else {
                final Element el = root.first();
                // if snippet contains rendered snippet.
                if (ComponentResolver.hasIncludedSnippetComponent(el)) {
                    final SnippetParser parser = context.createChildParser();
                    final Element childDoc = parser.parse(context.getConfig(), el.outerHtml()).document();
                    element.replaceWith(childDoc.children().first());
                } else {
                    element.replaceWith(el);
                }
            }
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
