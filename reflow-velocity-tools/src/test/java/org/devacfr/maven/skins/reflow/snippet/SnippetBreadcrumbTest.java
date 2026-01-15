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
import org.devacfr.maven.skins.reflow.context.PositionType;
import org.junit.jupiter.api.Test;

public class SnippetBreadcrumbTest extends BaseSnippetTest {

  @Test
  public void shouldDisplayDatePositionToLeft() throws Exception {
    when(config.getDatePosition()).thenReturn(PositionType.left.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldDisplayDatePositionToRight() throws Exception {
    when(config.getDatePosition()).thenReturn(PositionType.right.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldDisplayVersionPositionToLeft() throws Exception {
    when(config.getVersionPosition()).thenReturn(PositionType.left.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldDisplayVersionPositionToRight() throws Exception {
    when(config.getVersionPosition()).thenReturn(PositionType.right.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldNotDisplayDate() throws Exception {
    when(config.getDatePosition()).thenReturn(PositionType.none.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

  @Test
  public void shouldNotDisplayDateForUnrecognizedPosition() throws Exception {
    when(config.getDatePosition()).thenReturn(PositionType.bottom.toString());
    verify((htmlSource) -> {
      try {
        return createParser().parse(config, htmlSource).html();
      } catch (final IOException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }, "html");
  }

}
