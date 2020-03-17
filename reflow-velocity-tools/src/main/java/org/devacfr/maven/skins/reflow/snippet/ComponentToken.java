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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.jsoup.nodes.Element;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class ComponentToken {

    /**
     * @author Christophe Friederich
     * @version 2.4
     */
    public enum Tag {
        /** empty-tag */
        empty,
        /** start-tag */
        start,
        /** end-tag */
        end
    }

    /**
     * type of snippet component
     *
     * @author Christophe Friederich
     * @version 2.4
     */
    public enum Type {
        /** web component */
        webComponent,
        /** shortcode component */
        shortcode
    }

    /** */
    private final Element element;

    /** */
    private final Tag tag;

    /** */
    private final Type type;

    /** */
    private final String name;

    /**
     * @param tag
     * @param type
     */
    public ComponentToken(final Element element, final String name, final Tag tag, final Type type) {
        this.element = element;
        this.name = name;
        this.tag = tag;
        this.type = type;
    }

    public Element getElement() {
        return element;
    }

    public String name() {
        return name;
    }

    public Type type() {
        return type;
    }

    public Tag tag() {
        return tag;
    }

    public boolean isClosedTagOf(final ComponentToken startElement) {
        return name.equals(startElement.name) && type.equals(startElement.type) && Tag.start.equals(startElement.tag)
                && Tag.end.equals(tag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}