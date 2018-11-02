/*
 * Copyright 2012-2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.codehaus.plexus.util.xml.Xpp3Dom;

/**
 * Utility class to manipulate {@link Xpp3Dom} model.
 *
 * @author Christophe Friederich
 * @since 2.0
 */
public final class Xpp3Utils {

    private Xpp3Utils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Retrieves the child node. Tests both default name and with namespace.
     *
     * @param parentNode
     *            the parent
     * @param name
     *            the child name
     * @param namespace
     *            the namespace
     * @return Returns Returns {@link Xpp3Dom} representing the child of {@code parentNode} if exists, otherwise returns
     *         {@code null}.
     */
    @Nullable
    public static Xpp3Dom getFirstChild(@Nonnull final Xpp3Dom parentNode,
        @Nonnull final String name,
        @Nonnull final String namespace) {
        requireNonNull(namespace);
        final Xpp3Dom child = requireNonNull(parentNode).getChild(requireNonNull(name));
        if (child != null) {
            return child;
        }

        return parentNode.getChild(namespace + name);
    }

    /**
     * Gets the list of all children name for the {@code parentNode}.
     *
     * @param parentNode
     *            the parent node to use (can be {@code null}.
     * @return Returns a list of {@link String} representing the name of all children, which may be empty but never
     *         {@code null}.
     * @since 1.3
     */
    public static List<String> getChildren(final Xpp3Dom parentNode) {
        return getChildrenNodes(parentNode, null).stream().map(node -> node.getName()).collect(Collectors.toList());
    }

    /**
     * Gets children list filtered by name of {@code parentNode}.
     *
     * @param parentNode
     *            the parent node to use.
     * @param name
     *            the name of element to filter
     * @return Returns a list of {@link Xpp3Dom} representing all children element filtered by {@code name} of
     *         {@code parentNode}.
     */
    public static List<Xpp3Dom> getChildrenNodes(final Xpp3Dom parentNode, final String name) {
        if (parentNode == null) {
            return Collections.emptyList();
        }
        final Xpp3Dom[] children = parentNode.getChildren();
        if (children == null) {
            return Collections.emptyList();
        }
        final List<Xpp3Dom> list = new ArrayList<>(children.length);
        for (final Xpp3Dom child : children) {
            if (name != null) {
                if (name.equals(child.getName())) {
                    list.add(child);
                }
            } else {
                list.add(child);
            }
        }

        return list;
    }
}
