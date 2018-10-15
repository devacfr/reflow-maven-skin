/*
 * Copyright 2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow;

import java.io.IOException;

import org.apache.velocity.tools.generic.ValueParser;
import org.devacfr.testing.TestCase;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

public class HtmlToolTest extends TestCase {

    @Test
    public void fixTableHeadsWithTagListReportOuput() throws IOException {
        final HtmlTool htmlTool = new HtmlTool();
        htmlTool.configure(new ValueParser());
        verify(htmlTool.fixTableHeads(Resources.toString(
            Resources.getResource(
                getPackagePath().resolve("HtmlToolTest.fixTableHeadsWithTagListReportOuput.actual").toString()),
            Charsets.UTF_8)));
    }

    @Test
    public void replaceWith() {
        final HtmlTool htmlTool = new HtmlTool();
        String actual = htmlTool.replaceWith("<p>text <tt>foo value</tt> end text.</p>", "tt", "<code class=\"literal\">");
        assertEquals("<p>text <code class=\"literal\">foo value</code> end text.</p>", actual);
    }

}
