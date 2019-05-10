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

import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.maven.skins.reflow.SkinConfigTool;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * Represents the footer component.
 *
 * @author devacfr
 * @since 2.0
 */
public class Footer extends BsComponent {

    /** */
    private static final String COMPONENT = "footer";

    /** */
    private final List<Column> columns = Lists.newArrayList();

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     */
    public Footer(@Nonnull final SkinConfigTool config) {
        super(COMPONENT);
        requireNonNull(config);
        this.setTheme(config.getAttributeValue(COMPONENT, "theme", String.class, "light"));
        this.setBackground(config.getAttributeValue(COMPONENT, "background", String.class, "light"));
        this.setCssClass(config.getAttributeValue(COMPONENT, "cssClass", String.class, null));

        final Xpp3Dom bottomNav = config.get("bottomNav");
        final DecorationModel decoration = config.getDecoration();

        if (decoration.getBody() != null && decoration.getBody().getMenus() != null) {
            final List<org.apache.maven.doxia.site.decoration.Menu> menus = decoration.getBody().getMenus();
            if (bottomNav != null && bottomNav.getChildren().length > 0) {
                // foreach columns
                for (final Xpp3Dom col : bottomNav.getChildren()) {
                    final String regex = col.getValue();
                    if (Strings.isNullOrEmpty(regex)) {
                        continue;
                    }
                    final List<Menu> amenus = Lists.newArrayList();
                    for (final org.apache.maven.doxia.site.decoration.Menu menu : menus) {
                        // add in column, if matches with regex
                        if (Menu.matches(regex, menu)) {
                            amenus.add(new Menu(config, menu));
                        }
                    }
                    this.columns.add(new Column(config, amenus));
                }
            } else {
                final List<Menu> amenus = Lists.newArrayList();
                for (final org.apache.maven.doxia.site.decoration.Menu menu : menus) {
                    amenus.add(new Menu(config, menu));
                }
                this.columns.add(new Column(config, amenus));
            }
        }
    }

    /**
     * @return Returns a list of {@link Column}.
     */
    public List<Column> getColumns() {
        return columns;
    }

    /**
     * @author Christophe Friederich
     * @since 2.0
     */
    public static class Column {

        /** */
        private final List<Menu> menus;

        /**
         * @param config
         *            a config (can not be {@code null}).
         * @param menus
         *            list of menu.
         */
        public Column(@Nonnull final SkinConfigTool config, @Nonnull final List<Menu> menus) {
            requireNonNull(config);
            requireNonNull(menus);
            this.menus = menus;
        }

        /**
         * @return Returns a list of {@link Menu}.
         */
        public List<Menu> getMenus() {
            return menus;
        }
    }

}
