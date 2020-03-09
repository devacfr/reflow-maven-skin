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
package org.devacfr.maven.skins.reflow.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.ISkinConfig;

/**
 * Represents the header component.
 *
 * @author devacfr
 * @since 2.2
 */
public class Header extends BsComponent {

    /** */
    private static final String COMPONENT = "header";

    private static final List<String> HEADER_TYPES = Lists.newArrayList("jumbotron", "banner", "custom");

    /** */
    private boolean enabled = true;

    /** */
    private String type;

    /** */
    private String content;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     */
    public Header(@Nonnull final ISkinConfig config) {
        super(COMPONENT);
        requireNonNull(config);
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, null));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, null));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));

        this.type = config.getAttributeValue(COMPONENT, "type", String.class, HEADER_TYPES.get(0)).toLowerCase();
        if (!HEADER_TYPES.contains(this.type)) {
            this.type = HEADER_TYPES.get(0);
        }
        this.enabled = config.getAttributeValue(COMPONENT, "enabled", Boolean.class, true);

        Xpp3Dom component = config.get(COMPONENT);
        if (component != null) {
            this.content = component.getValue();
            if (!Strings.isNullOrEmpty(this.content)) {
                this.type = HEADER_TYPES.get(2); // enforce the type to custom
            }
        }
    }

    /**
     * Gets the indicating whether the header is displayed.
     *
     * @return Returns {@code true} whether the header is displayed, otherwise {@code false}.
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Gets the type of header.
     * @return Returns a String representing the type of header.
     */
    public String getType() {
        return type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

}
