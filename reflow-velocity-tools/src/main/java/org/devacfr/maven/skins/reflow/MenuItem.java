/*
 * Copyright 2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class MenuItem {

    /** */
    private final String name;

    private final String slugName;

    private final String href;

    /** */
    private final String icon;

    /** */
    private final boolean toc;

    public MenuItem(final String name, final String slugName, final String href, final String icon, final boolean toc) {
        this.name = name;
        this.slugName = slugName;
        this.href = href;
        this.icon = icon;
        this.toc = toc;

    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    public String getSlugName() {
        return slugName;
    }

    public String getIcon() {
        return icon;
    }

    public boolean isToc() {
        return toc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }

}
