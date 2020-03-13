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

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.snippet.SnippetContext;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetComponent<T extends SnippetComponent<T>> extends Component<T> {

    private final String id;

    /** */
    private final String name;

    public SnippetComponent(@Nonnull final SnippetContext context, @Nonnull final String name) {
        this.name = requireNonNull(name);
        this.id = context.generateSnippetIdentifier();
    }

    public String getSnippetId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String render(final SnippetContext context) {
        try {
            return context.render(this);
        } catch (final Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
