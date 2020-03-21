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

import static java.util.Objects.requireNonNull;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.model.Toc;
import org.devacfr.maven.skins.reflow.model.TocSidebar;

/**
 * The context associate to page of frame page.
 *
 * @author Christophe Friederich
 * @since 2.0
 */
public class FrameContext extends Context<FrameContext> {

    /** */
    private final String documentParent;

    /** */
    private final Toc<?> toc;

    /**
     * @param config
     *            a config (can not be {@code null}).
     * @param documentParent
     *            name of parent.
     */
    public FrameContext(final @Nonnull ISkinConfig config, @Nonnull final String documentParent) {
        super(config, ContextType.frame);
        final String type = config.getPropertyValue(Toc.COMPONENT, String.class, "sidebar");
        // enforce sidebar
        if ("top".equals(type) || "sidebar".equals(type)) {
            toc = new TocSidebar(config);
        } else {
            toc = new Toc<Toc<?>>("", "") {};
        }

        this.documentParent = requireNonNull(documentParent);

        this.addChildren(this.toc);
    }

    /**
     * @return Returns a {@link String} representing the name of parent page.
     */
    public String getDocumentParent() {
        return documentParent;
    }

    /**
     * @return Returns a {@link String} representing the slugged name(pageId) of parent page.
     */
    public String getSlugDocumentParent() {
        return SkinConfigTool.slugFilename(documentParent);
    }

    /**
     * @return returns the {@link Toc}.
     */
    public Toc<?> getToc() {
        return toc;
    }

}
