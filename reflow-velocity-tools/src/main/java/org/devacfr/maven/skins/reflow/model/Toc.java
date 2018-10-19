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
package org.devacfr.maven.skins.reflow.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author devacfr
 * @since 2.0
 */
public abstract class Toc<T extends Toc<?>> extends PageElement {

    private static Logger LOGGER = LoggerFactory.getLogger(Toc.class);

    /** enable by default */
    private boolean enabled = true;

    /** */
    private final String type;

    /**
     * @param config
     * @param preferredType
     * @return
     */
    public static Toc<?> createToc(final SkinConfigTool config, final String preferredType) {
        Toc<?> toc = null;
        String type = config.value("toc");
        if (LOGGER.isTraceEnabled()) {
            LOGGER.trace("Page '{}' Find Toc: {}", config.getFileId(), type);
        }
        final Set<String> types = new HashSet<>(Arrays.asList("sidebar", "top", "false"));
        if (!types.contains(type)) {
            type = preferredType;
        }
        if (type == null) {
            type = "";
        }
        switch (type) {
            case "sidebar":
                toc = new TocSidebar(config);
                break;
            case "top":
                toc = new TocTopBar(config);
                break;
            default:
                // create a disabled empty toc
                toc = new Toc<Toc<?>>("") {

                    @Override
                    public String getCssOptions() {
                        return "";
                    }
                };
                toc.withEnabled(false);
                break;
        }

        return toc;
    }

    protected Toc(final String type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    public String getType() {
        return type;
    }

    public boolean isEnabled() {
        return enabled;
    }

    protected T withEnabled(final boolean enabled) {
        this.enabled = enabled;
        return self();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
