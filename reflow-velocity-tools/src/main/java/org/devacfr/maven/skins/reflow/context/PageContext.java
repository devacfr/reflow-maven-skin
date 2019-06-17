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
package org.devacfr.maven.skins.reflow.context;

import static org.devacfr.maven.skins.reflow.model.Toc.createToc;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.model.Toc;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class PageContext extends Context<PageContext> {

    /** */
    private final Toc<?> toc;

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     */
    public PageContext(final @Nonnull ISkinConfig config) {
        super(config, ContextType.page);
        this.toc = createToc(config, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCssOptions() {
        String css = super.getCssOptions();
        if (getToc() != null) {
            css += " " + getToc().getCssOptions();
        }
        return css;
    }

    /**
     * @return Returns the {@link Toc}.
     */
    public Toc<?> getToc() {
        return toc;
    }

}
