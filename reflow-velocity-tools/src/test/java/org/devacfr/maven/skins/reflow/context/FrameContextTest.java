/*
 * Copyright 2012-2019 Christophe Friederich
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isA;

import java.io.StringReader;

import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.Xpp3DomBuilder;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.model.Footer;
import org.devacfr.maven.skins.reflow.model.Navbar;
import org.devacfr.maven.skins.reflow.model.ScrollTop;
import org.devacfr.maven.skins.reflow.model.Toc;
import org.devacfr.maven.skins.reflow.model.TocSidebar;
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class FrameContextTest extends MockitoTestCase {

    @Mock
    private ISkinConfig config;

    @SuppressWarnings("unchecked")
    @BeforeEach
    public void setup() {
        final MavenProject project = new MavenProject();
        project.setName("reflow");
        project.setArtifactId("reflow-artifact");
        when(config.getProject()).thenReturn(project);

        final DecorationModel decoration = new DecorationModel();
        when(config.getDecoration()).thenReturn(decoration);
        when(config.getAttributeValue(any(String.class), any(String.class), any(Class.class), any(Object.class)))
                .then(invocation -> invocation.getArguments()[3]);
        when(config.getPropertyValue(any(String.class), any(Class.class), any(Object.class)))
                .then(invocation -> invocation.getArguments()[2]);
    }

    @Test
    public void shouldBuildFrameContext() throws Exception {
        final String xml = "<reflowSkin><pages>" + //
                "<development-documentation type=\"doc\">" + //
                "          <menu name=\"Development Documentation\">" + //
                "            <item name=\"Contribute\" href=\"dev/contribute.html\" />" + //
                "            <item name=\"Code Conventions\" href=\"dev/code-conventions.html\"/>" + //
                "            <item name=\"Release Management\" href=\"dev/release-management.html\"/>" + //
                "          </menu>" + //
                "        </development-documentation>" + //
                "</pages></reflowSkin>";
        final Xpp3Dom globalProperties = Xpp3DomBuilder.build(new StringReader(xml));
        when(config.getPageProperties()).thenReturn(new Xpp3Dom("dev-contribute"));
        when(config.getGlobalProperties()).thenReturn(globalProperties);
        when(config.getFileId()).thenReturn("dev-contribute");
        when(config.getNamespace()).thenReturn("");

        final Context<?> context = Context.buildContext(config);
        assertThat((FrameContext) context, isA(FrameContext.class));
        final FrameContext frameContext = (FrameContext) context;

        assertEquals("development-documentation", frameContext.getDocumentParent());

        final Toc<?> toc = frameContext.getToc();
        assertNotNull(toc, "toc should be exist");
        assertThat((TocSidebar) frameContext.getToc(), isA(TocSidebar.class));

        final TocSidebar tocSidebar = (TocSidebar) toc;
        assertEquals(Integer.MAX_VALUE, tocSidebar.getLevel());
        assertEquals("sidebar-light bg-light", tocSidebar.getCssClass());
        assertEquals("m-toc-sidebar-enabled m-toc-sidebar-expanded m-toc-sidebar-autoexpandable toc-sidebar-fixed",
            tocSidebar.getCssOptions());

        final Footer footer = frameContext.getFooter();
        assertNotNull(footer, "footer should be exist");
        assertEquals("footer-light bg-light", footer.getCssClass());
        assertEquals("", footer.getCssOptions());

        final Navbar navbar = frameContext.getNavbar();
        assertNotNull(navbar, "Navbar should be exist");
        assertEquals("navbar-light bg-light", navbar.getCssClass());
        assertEquals("", navbar.getCssOptions());

        final ScrollTop scrollTop = frameContext.getScrollTop();
        assertNotNull(scrollTop, "ScrollTop should be exist");
        assertEquals("", scrollTop.getCssClass());
        assertEquals(true, scrollTop.isSmooth());
        assertEquals("scrolltop-smooth-enabled", scrollTop.getCssOptions());

    }

}
