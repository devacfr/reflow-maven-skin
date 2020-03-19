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
package org.devacfr.maven.skins.reflow.snippet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Tag;
import org.devacfr.maven.skins.reflow.snippet.ComponentToken.Type;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComponentResolverTest {

    @Test
    public void shouldBeStartWebComponent() {
        check("{{% component %}}", "component", Type.webComponent, Tag.start);
    }

    @Test
    public void shouldBeEndWebComponent() {
        check("{{% /component %}}", "component", Type.webComponent, Tag.end);
    }

    @Test
    public void shouldBeEmptyWebComponent() {
        check("{{% component /%}}", "component", Type.webComponent, Tag.empty);
    }

    @Test
    public void shouldBeStartShortcode() {
        check("{{< component >}}", "component", Type.shortcode, Tag.start);
    }

    @Test
    public void shouldBeEndShortcode() {
        check("{{< /component >}}", "component", Type.shortcode, Tag.end);
    }

    @Test
    public void shouldBeEmptyShortcode() {
        check("{{< component />}}", "component", Type.shortcode, Tag.empty);
    }

    @Test
    public void shouldFailedOnMalformed() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            new ComponentResolver().create(new Element("p").text("{{% /component /%}}"));
        });
    }

    @Test
    public void shouldFailedUnknownComponent() {
        assertNull(new ComponentResolver().create(new Element("p").text("{{- /component -}}")));
    }

    @Test
    public void shouldElementStartWebComponentContainingAttributes() {
        check("{{% component attr=\"value\" attr1=\"value1\" %}}", "component", Type.webComponent, Tag.start);
    }

    private void check(final String text, final String name, final Type type, final Tag state) {
        final ComponentToken element = new ComponentResolver().create(new Element("p").text(text));
        assertEquals(name, element.name());
        assertEquals(type, element.type());
        assertEquals(state, element.tag());
    }

}
