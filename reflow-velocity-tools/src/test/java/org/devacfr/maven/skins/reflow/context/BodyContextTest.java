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
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BodyContextTest extends MockitoTestCase {

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
    public void shouldBuildBodyContext() throws Exception {
        final Xpp3Dom pageProperties = Xpp3DomBuilder.build(new StringReader("<document type=\"body\"></document>"));
        when(config.getPageProperties()).thenReturn(pageProperties);

        final Context<?> context = Context.buildContext(config);
        assertThat((BodyContext) context, isA(BodyContext.class));

        final BodyContext bodyContext = (BodyContext) context;

        final Footer footer = bodyContext.getFooter();
        assertNotNull(footer, "footer should be exist");
        assertEquals("footer-light bg-light", footer.getCssClass());
        assertEquals("", footer.getCssOptions());

        final Navbar navbar = bodyContext.getNavbar();
        assertNotNull(navbar, "Navbar should be exist");
        assertEquals("navbar-light bg-light", navbar.getCssClass());
        assertEquals("", navbar.getCssOptions());

        final ScrollTop scrollTop = bodyContext.getScrollTop();
        assertNotNull(scrollTop, "ScrollTop should be exist");
        assertEquals("", scrollTop.getCssClass());
        assertEquals(true, scrollTop.isSmooth());
        assertEquals("scrolltop-smooth-enabled", scrollTop.getCssOptions());

        assertEquals("scrolltop-smooth-enabled", bodyContext.getCssOptions());
        assertEquals("", bodyContext.getCssClass());
        assertEquals("body", bodyContext.getType());
    }

    @Test
    public void shouldRenderBodyWihoutModify() throws Exception {
        final Xpp3Dom pageProperties = Xpp3DomBuilder.build(new StringReader("<document type=\"body\"></document>"));
        when(config.getPageProperties()).thenReturn(pageProperties);

        final Context<?> context = Context.buildContext(config);
        assertThat((BodyContext) context, isA(BodyContext.class));

        final BodyContext bodyContext = (BodyContext) context;

        verify((content) -> {
            when(config.getContextValue("bodyContent", String.class)).thenReturn(content);
            return bodyContext.preRender(config);
        }, ".html");
    }

}
