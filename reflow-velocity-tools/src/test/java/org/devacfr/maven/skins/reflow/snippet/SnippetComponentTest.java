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

import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.devacfr.maven.skins.reflow.snippet.SnippetComponent.Type;
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SnippetComponentTest extends MockitoTestCase {

  @Test()
  @DisplayName("should return attribute true value for valueless attribute")
  public void shouldReturnTrueForValuelessAttribute() {
    SnippetComponent<?> snippet = SnippetComponent
        .createSnippet(createElement("<test attr1 attr2=\"true\"></test>"), null, Type.webComponent);
    assertNotNull(snippet);
    assertEquals("true", snippet.getAttribute("attr2"));
    assertTrue(snippet.hasAttribute("attr1"));
    assertEquals("true", snippet.getAttrs().get("attr1"));

  }

  private static Element createElement(final String html) {
    return JsoupUtils.createHtmlDocument(html).body().firstElementChild();
  }

}
