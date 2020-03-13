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
 * @author Christophe Friederich
 * @version 2.4
 */
public final class ContainsOwnText extends Evaluator {

    /** */
    private final Pattern searchPattern;

    /** */
    private int fromSiblingIndex = 0;

    public ContainsOwnText(@Nonnull final Pattern regex) {
        this(regex, 0);
    }

    public ContainsOwnText(@Nonnull final Pattern regex, final int fromSiblingIndex) {
        this.searchPattern = regex;
        this.fromSiblingIndex = fromSiblingIndex;
    }

    @Override
    public boolean matches(final Element root, final Element element) {
        if (element.siblingIndex() >= fromSiblingIndex) {
            return searchPattern.matcher(element.ownText()).matches();
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format(":containsOwn(%s)", searchPattern.toString());
    }
}