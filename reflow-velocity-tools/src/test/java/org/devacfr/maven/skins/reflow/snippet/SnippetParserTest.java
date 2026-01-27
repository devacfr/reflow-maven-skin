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

import java.io.IOException;
import org.jsoup.nodes.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnippetParserTest extends BaseSnippetTest {

  @BeforeEach
  public void setup() {
    velocityContext = SnippetContext.createToolManaged().createContext();
    when(config.getVelocityContext()).thenReturn(velocityContext);
  }

  @Test
  public void shouldContainSnippetComponent() {
    SnippetParser parser = createParser();
    parser.addResourcePath(getPackagePath().toString());
    assertEquals(true, parser.hasIncludedSnippetComponent(new Element("body").append("<test class=\"cl\"></test>")));
    assertEquals(false, parser.hasIncludedSnippetComponent(new Element("body").append("<test1></test1>")));
  }

  @Test
  public void shouldReplaceSnippetByHtml() throws Exception {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderCard() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderDebug() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderCardRecursively() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderRecursively() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderBadge() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderLayout() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldRenderNestedComponent() {
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

}
