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
package org.devacfr.maven.skins.reflow.context;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.ISkinConfig;

/**
 * @author Christophe Friederich
 * @since 2.3
 */
public class BodyContext extends Context<BodyContext> {

    /**
     * Default constructor.
     *
     * @param config
     *            a config (can not be {@code null}).
     */
    public BodyContext(final @Nonnull ISkinConfig config) {
        super(config, ContextType.body);
    }

    @Override
    protected void initialize(ISkinConfig config) {
        // not use all default context initializations.
    }

    @Override
    protected String onPreRender(final ISkinConfig skinConfig, final String bodyContent) {
        return bodyContent;
    }

}
