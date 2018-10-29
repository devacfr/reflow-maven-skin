/*
 * Copyright 2012-2018 Christophe Friederich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.maven.skins.reflow.model;

import javax.annotation.Nonnull;

import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;

import com.google.common.base.Strings;

/**
 * @author devacfr
 * @since 2.0
 */
public class Navbar extends PageElement {

    /** */
    private String brandName;

    /** */
    private String brandHref;

    /** */
    private final String filterMenu;

    public Navbar(final @Nonnull SkinConfigTool config) {
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
        this.setCssClass(
            config.getConfigAttribute("navbar", "cssClass", String.class, "navbar-light bg-light"));
        this.filterMenu = config.getConfigAttribute("navbar", "filterMenu", String.class, null);
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
