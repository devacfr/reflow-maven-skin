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

import java.util.Objects;

import javax.annotation.Nonnull;

import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.Xpp3Utils;

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

    /** */
    private final ImageBrand image;

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
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));
        this.filterMenu = config.getAttributeValue(COMPONENT, "filterMenu", String.class, null);
        Xpp3Dom element = config.get(COMPONENT);
        Xpp3Dom img = Xpp3Utils.getFirstChild(element, "image", config.getNamespace());
        if (img != null) {
            this.image =  new ImageBrand(config, img);
        } else {
            this.image = null;
        }
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
     * @return the image
     */
    public ImageBrand getImage() {
        return image;
    }

    /**
     * @return the filterMenu
     */
    public String getFilterMenu() {
        return filterMenu;
    }

    public static class ImageBrand {

        /** */
        private final String href;

        /** */
        private final int width;

        /** */
        private final int height;

        /**
         *
         * @param config a config (can <b>not</b> be {@code null}).
         * @param element the element assiciated to image brand.
         */
        ImageBrand(@Nonnull final SkinConfigTool config, @Nonnull  Xpp3Dom element) {
            Objects.requireNonNull(config);
            Objects.requireNonNull(element);
            href = config.getAttributeValue(element, "href", String.class, null);
            if (Strings.isNullOrEmpty(href)) {
                throw new IllegalArgumentException("the attribute 'href' of image element is required");
            }
            width = config.getAttributeValue(element, "width", Integer.class, 30);
            height = config.getAttributeValue(element, "height", Integer.class, 30);
        }

        /**
         * @return the href
         */
        public String getHref() {
            return href;
        }

        /**
         * @return the height
         */
        public int getHeight() {
            return height;
        }

        /**
         * @return the width
         */
        public int getWidth() {
            return width;
        }
    }
}
