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

import static org.hamcrest.Matchers.isA;

import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.project.MavenProject;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.testing.MockitoTestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ContextTest extends MockitoTestCase {

    @Mock
    private ISkinConfig config;

    @Before
    public void setup() {
        final MavenProject project = new MavenProject();
        project.setName("reflow");
        project.setArtifactId("reflow-artifact");
        when(config.getProject()).thenReturn(project);

        final DecorationModel decoration = new DecorationModel();
        when(config.getDecoration()).thenReturn(decoration);
    }

    /**
     * test the page context is the default context when any type is defined.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void shouldBuildpageContext() {
        when(config.getAttributeValue(any(String.class), any(String.class), any(Class.class), any(Object.class)))
                .then(invocation -> invocation.getArguments()[3]);
        when(config.getPropertyValue(any(String.class), any(Class.class), any(Object.class)))
                .then(invocation -> invocation.getArguments()[2]);

        final Context<?> context = Context.buildContext(config);
        assertThat((PageContext) context, isA(PageContext.class));
    }
}
