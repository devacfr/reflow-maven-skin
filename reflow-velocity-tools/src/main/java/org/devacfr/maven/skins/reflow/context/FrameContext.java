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
package org.devacfr.maven.skins.reflow.context;

import javax.annotation.Nonnull;

import org.devacfr.maven.skins.reflow.SkinConfigTool;
import org.devacfr.maven.skins.reflow.model.SideNavMenuItem;
import org.devacfr.maven.skins.reflow.model.Toc;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class FrameContext extends Context<FrameContext> {

    /** */
    private String documentParent;

    /** */
    private SideNavMenuItem item;

    private Toc<?> toc;

    public FrameContext(final @Nonnull SkinConfigTool config) {
        super(config);
        this.withType("frame");
        toc = Toc.createToc(config, "sidebar");
    }

    @Override
    public String getCssOptions() {
        String css = super.getCssOptions();
        if (getToc() != null) {
            css += " " + getToc().getCssOptions();
        }
        return css;
    }

    public String getDocumentParent() {
        return documentParent;
    }

    public String getSlugDocumentParent() {
        return SkinConfigTool.slugFilename(documentParent);
    }

    public FrameContext withDocumentParent(final String documentParent) {
        this.documentParent = documentParent;
        return self();
    }

    public SideNavMenuItem getItem() {
        return item;
    }

    public FrameContext withItem(final SideNavMenuItem item) {
        this.item = item;
        return self();
    }

    public Toc<?> getToc() {
        return toc;
    }

    public FrameContext withToc(final Toc<?> toc) {
        this.toc = toc;
        return self();
    }

}
