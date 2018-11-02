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

import javax.annotation.Nonnull;

import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;

import com.google.common.base.Strings;

/**
 * Represents the navbar component.
 *
 * @author devacfr
 * @since 2.0
 */
public class Navbar extends BsComponent {

    /** */
    private static final String COMPONENT = "navbar";

    /** */
    private String brandName;

    /** */
    private String brandHref;

    /** */
    private final String filterMenu;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can <b>not</b> be {@code null}).
     */
    public Navbar(@Nonnull final SkinConfigTool config) {
        super(COMPONENT);
        requireNonNull(config);
        final MavenProject project = config.getProject();
        final Xpp3Dom brand = config.get("brand");
        if (brand != null) {
            final Xpp3Dom name = brand.getChild("name");
            if (name != null) {
                brandName = name.getValue();
            }
            final Xpp3Dom href = brand.getChild("href");
            if (href != null) {
                brandHref = href.getValue();
            }
        } else {
            brandName = project.getName();
        }
        if (Strings.isNullOrEmpty(brandName)) {
            brandName = project.getArtifactId();
        }
        this.setTheme(config.getConfigAttribute(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getConfigAttribute(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getConfigAttribute(COMPONENT, "cssClass", String.class, null));
        this.filterMenu = config.getConfigAttribute(COMPONENT, "filterMenu", String.class, null);
    }

    /**
     * @return the brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @return the brandHref
     */
    public String getBrandHref() {
        return brandHref;
    }

    /**
     * @return the filterMenu
     */
    public String getFilterMenu() {
        return filterMenu;
    }
}
