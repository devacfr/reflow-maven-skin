/*
* Copyright 2012-2025 Christophe Friederich
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

import org.devacfr.maven.skins.reflow.snippet.ComponentToken.TagType;
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ComponentResolverTest extends MockitoTestCase {

  @Mock
  private SnippetContext context;

  @Test
  public void shouldBeStartWebComponent() {
    check("{{% component %}}", "component", TagType.start);
  }

  @Test
  public void shouldBeStartWebComponentWithAttributes() {
    check("{{% component style=\"width: 18rem;\" attr2=\"val\" %}}", "component", TagType.start);
  }

  @Test
  public void shouldBeStartWebComponentWithAttributesLeftAndRightDoubleQuote() {
    check("{{% component style=“width: 18rem;” attr2=“val” %}}", "component", TagType.start);
  }

  @Test
  public void shouldBeStartWebComponentWithAttributeWithoutValue() {
    check("{{% component pill %}}", "component", TagType.start);
  }

  @Test
  public void shouldBeStartWebComponentWithNumberAttributes() {
    check("{{% component length=\"120\" %}}", "component", TagType.start);
  }

  @Test
  public void shouldBeEndWebComponent() {
    check("{{% /component %}}", "component", TagType.end);
  }

  @Test
  public void shouldBeEmptyWebComponent() {
    check("{{% component /%}}", "component", TagType.empty);
  }

  @Test
  public void shouldBeStartShortcode() {
    check("{{< component >}}", "component", TagType.start);
  }

  @Test
  public void shouldBeEndShortcode() {
    check("{{< /component >}}", "component", TagType.end);
  }

  @Test
  public void shouldBeEmptyShortcode() {
    check("{{< component />}}", "component", TagType.empty);
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
    check("{{% component attr=\"value\" attr1=\"value1\" %}}", "component", TagType.start);
  }

  private ComponentToken check(final String text, final String name, final TagType state) {
    final ComponentToken element = new ComponentResolver().create(new Element("p").text(text));
    assertEquals(name, element.name());
    assertEquals(state, element.tag());
    return element;
  }
}
