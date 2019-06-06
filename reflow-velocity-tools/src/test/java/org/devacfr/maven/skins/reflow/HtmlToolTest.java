/*
 * Copyright 2012-2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow;

import java.io.IOException;
import java.util.List;

import org.apache.velocity.tools.generic.ValueParser;
import org.devacfr.maven.skins.reflow.HtmlTool.JoinSeparator;
import org.devacfr.testing.TestCase;
import org.junit.Test;

public class HtmlToolTest extends TestCase {

    /**
     * Simple split Test
     */
    @Test
    public void shouldSplitBodyFragment() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body, "hr");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }

    /**
     * Test split html with unexiting element.
     */
    @Test
    public void shouldNotSplit() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body,"p");
        assertEquals(1, fragments.size());
    }

    /**
     * Test split not include nested separator.
     */
    @Test
    public void shouldSplitRecursively() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body,".section");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<div>  \n</div>", fragments.get(0));
        assertEquals("<div>  \n</div>", fragments.get(1));
    }

    @Test
    public void shouldSplitJoinSeparatorBefore() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body,"hr", JoinSeparator.BEFORE);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<hr>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body,"hr", "before");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<hr>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }


    @Test
    public void shouldSplitJoinSeparatorAfter() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body,"hr", JoinSeparator.AFTER);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<hr>\n<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body,"hr", "after");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<hr>\n<h2>section2</h2>", fragments.get(1));
    }

    @Test
    public void shouldSplitJoinSeparatorNo() {
        String body = getActualResource();
        final HtmlTool htmlTool = new HtmlTool();
        List<String> fragments = htmlTool.split(body,"hr", JoinSeparator.NO);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body,"hr", "");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }

    @Test
    public void fixTableHeadsWithTagListReportOuput() throws IOException {
        final HtmlTool htmlTool = new HtmlTool();
        htmlTool.configure(new ValueParser());
        verify(htmlTool::fixTableHeads);
    }

    @Test
    public void replaceWith() {
        final HtmlTool htmlTool = new HtmlTool();
        final String actual = htmlTool.replaceWith("<p>text <tt>foo value</tt> end text.</p>", "tt",
                "<code class=\"literal\">");
        assertEquals("<p>text <code class=\"literal\">foo value</code> end text.</p>", actual);
    }

}
