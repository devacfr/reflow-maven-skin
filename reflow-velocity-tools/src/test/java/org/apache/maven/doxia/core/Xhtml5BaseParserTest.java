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
package org.apache.maven.doxia.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;
import org.apache.maven.doxia.parser.AbstractParser;
import org.apache.maven.doxia.parser.AbstractParserTest;
import org.apache.maven.doxia.parser.Xhtml5BaseParser;
import org.apache.maven.doxia.sink.impl.SinkEventElement;
import org.apache.maven.doxia.sink.impl.SinkEventTestingSink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test for Xhtml5BaseParser.
 */
public class Xhtml5BaseParserTest extends AbstractParserTest {

  private Xhtml5BaseParser parser;

  private final SinkEventTestingSink sink = new SinkEventTestingSink();

  @Override
  protected AbstractParser createParser() {
    parser = new Xhtml5BaseParser();
    return parser;
  }

  @Override
  protected String outputExtension() {
    return "xhtml";
  }

  @BeforeEach
  protected void setUp() throws Exception {
    parser = new Xhtml5BaseParser();
    sink.reset();
  }

  @Test
  public void test() throws Exception {
    final String text = "<p>element {{&lt; badge color=“secondary” text=“site.xml” /&gt;}}</p>";

    parser.parse(text, sink);

    final Iterator<SinkEventElement> it = sink.getEventList().iterator();

    SinkEventElement element = it.next();
    assertEquals("paragraph", element.getName());
    element = it.next();
    assertEquals("text", element.getName());
    assertEquals("element {{", element.getArgs()[0]);
    element = it.next();
    assertEquals("text", element.getName());
    assertEquals("<", element.getArgs()[0]);
    element = it.next();
    assertEquals("text", element.getName());
    assertEquals(" badge color=“secondary” text=“site.xml” /", element.getArgs()[0]);
    element = it.next();
    assertEquals("text", element.getName());
    assertEquals(">", element.getArgs()[0]);
    element = it.next();
    assertEquals("text", element.getName());
    assertEquals("}}", element.getArgs()[0]);
    element = it.next();
    assertEquals("paragraph_", element.getName());
    assertFalse(it.hasNext());
  }

  @Override
  protected String getVerbatimSource() {
    return "<pre>&lt;&gt;{}=#*</pre>";
  }

  @Override
  protected String getVerbatimCodeSource() {
    return "<pre><code>&lt;&gt;{}=#*</code></pre>";
  }
}
