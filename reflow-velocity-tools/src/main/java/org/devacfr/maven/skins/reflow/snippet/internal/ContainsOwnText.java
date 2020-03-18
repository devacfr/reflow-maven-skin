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
package org.devacfr.maven.skins.reflow.snippet.internal;

import java.util.regex.Pattern;

import javax.annotation.Nonnull;

import org.jsoup.nodes.Element;
import org.jsoup.select.Evaluator;

/**
 * JSoup {@link Evaluator} allowing to evaluate that an element matches the regex selector.
 *
 * @author Christophe Friederich
 * @version 2.4
 */
public final class ContainsOwnText extends Evaluator {

    /** */
    private final Pattern searchPattern;

    /** */
    private int fromSiblingIndex = 0;

    /**
     * Default constructor.
     *
     * @param regex
     *            a regex pattern.
     */
    public ContainsOwnText(@Nonnull final Pattern regex) {
        this(regex, 0);
    }

    /**
     * Default constructor.
     *
     * @param regex
     *            a regex pattern.
     * @param fromSiblingIndex
     *            the sibling index from where begin to match.
     */
    public ContainsOwnText(@Nonnull final Pattern regex, final int fromSiblingIndex) {
        this.searchPattern = regex;
        this.fromSiblingIndex = fromSiblingIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean matches(final Element root, final Element element) {
        // exclude if in <pre> element, allowing highlight component in documentation
        if ("pre".equals(element.tagName()) || "code".equals(element.tagName())
                || element.hasParent() && "pre".equals(element.parent().tagName())) {
            return false;
        }
        if (fromSiblingIndex == -1 || element.siblingIndex() >= fromSiblingIndex) {
            return searchPattern.matcher(element.ownText()).find();
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format(":containsOwn(%s)", searchPattern.toString());
    }
}