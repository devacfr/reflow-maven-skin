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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.snippet.Processor.ShortcodeProcessor;
import org.devacfr.maven.skins.reflow.snippet.Processor.WebComponentProcessor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetParser {

    /** */
    private final ComponentResolver resolver;

    /** */
    private final ArrayList<ComponentToken> stack;

    /** */
    private Iterator<Element> it;

    /** */
    private Processor state = null;

    /** */
    private final WebComponentProcessor webComponentProcessor;

    /** */
    private final ShortcodeProcessor shortcodeProcessor;

    /** */
    private final SnippetContext snippetContext;

    /** */
    private ComponentToken currentToken;

    public SnippetParser() {
        resolver = new ComponentResolver();
        stack = new ArrayList<>(32);
        snippetContext = new SnippetContext();
        webComponentProcessor = new WebComponentProcessor(this);
        shortcodeProcessor = new ShortcodeProcessor(this);
    }

    public SnippetParser insertResourcePath(final String path, final int index) {
        snippetContext.insertResourcePath(path, index);
        return this;
    }

    public SnippetParser addResourcePath(final String path) {
        snippetContext.addResourcePath(path);
        return this;
    }

    public SnippetContext parse(@Nonnull final ISkinConfig config, @Nonnull final String htmlSource)
            throws IOException {
        requireNonNull(config);
        requireNonNull(htmlSource);

        snippetContext.reset();
        snippetContext.setConfig(config);

        // find all snippet start
        final Document doc = resolver.normalize(Jsoup.parse(htmlSource));

        final Elements elements = resolver.collect(doc);

        for (it = elements.iterator(); it.hasNext();) {
            try {
                parse();
            } catch (final Exception ex) {
                throw new RuntimeException("error on parse token " + currentToken, ex);
            }
        }
        snippetContext.setHtmlSource(doc.html());
        return snippetContext;
    }

    protected void parse() {
        if (!it.hasNext()) {
            throw new RuntimeException("EOF");
        }
        final Element element = it.next();
        currentToken = resolver.create(element);
        if (currentToken == null) {
            throw new RuntimeException("unknown component: " + element);
        }
        switch (currentToken.type()) {
            case webComponent:
                state = webComponentProcessor;
                break;
            case shortcode:
                state = shortcodeProcessor;
                break;
            default:
                break;
        }
        parse(currentToken);
        currentToken = null;
    }

    protected void parse(final ComponentToken token) {
        state.parse(token);
    }

    protected ComponentToken currentToken() {
        final int size = stack.size();
        return size > 0 ? stack.get(size - 1) : null;
    }

    protected ComponentToken pop() {
        final int size = stack.size();
        return stack.remove(size - 1);
    }

    protected void push(final ComponentToken element) {
        stack.add(element);
    }

    protected ArrayList<ComponentToken> getStack() {
        return stack;
    }

    protected boolean isElementInQueue(final ComponentToken element) {
        for (int pos = stack.size() - 1; pos >= 0; pos--) {
            final ComponentToken next = stack.get(pos);
            if (next == element) {
                return true;
            }
        }
        return false;
    }

    protected SnippetContext getSnippetContext() {
        return snippetContext;
    }

    protected ComponentResolver getResolver() {
        return resolver;
    }

}
