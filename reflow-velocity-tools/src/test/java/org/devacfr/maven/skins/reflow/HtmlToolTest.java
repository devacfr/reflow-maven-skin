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
package org.devacfr.maven.skins.reflow;

import static org.hamcrest.Matchers.contains;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.generic.ValueParser;
import org.devacfr.maven.skins.reflow.HtmlTool.ExtractResult;
import org.devacfr.maven.skins.reflow.HtmlTool.IdElement;
import org.devacfr.maven.skins.reflow.HtmlTool.JoinSeparator;
import org.devacfr.testing.TestCase;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class HtmlToolTest extends TestCase {

    private HtmlTool htmlTool;

    @Before
    public void setup() {
        htmlTool = new HtmlTool();
        htmlTool.configure(new ValueParser(ImmutableMap.<String, Object> builder()
                .put("velocityContext",
                    new ToolContext(ImmutableMap.<String, Object> builder().put("outputEncoding", "utf-8").build()))
                .build()));
    }

    /**
     * Simple split Test
     */
    @Test
    public void shouldSplitBodyFragment() {
        final String body = getActualResource();
        final List<String> fragments = htmlTool.split(body, "hr");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }

    /**
     * Test split html with unexiting element.
     */
    @Test
    public void shouldNotSplit() {
        final String body = getActualResource();
        final List<String> fragments = htmlTool.split(body, "p");
        assertEquals(1, fragments.size());
    }

    /**
     * Test split not include nested separator.
     */
    @Test
    public void shouldSplitRecursively() {
        final String body = getActualResource();
        final List<String> fragments = htmlTool.split(body, ".section");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<div>  \n</div>", fragments.get(0));
        assertEquals("<div>  \n</div>", fragments.get(1));
    }

    @Test
    public void shouldSplitJoinSeparatorBefore() {
        final String body = getActualResource();
        List<String> fragments = htmlTool.split(body, "hr", JoinSeparator.BEFORE);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<hr>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body, "hr", "before");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>\n<hr>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }

    @Test
    public void shouldSplitJoinSeparatorAfter() {
        final String body = getActualResource();
        List<String> fragments = htmlTool.split(body, "hr", JoinSeparator.AFTER);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<hr>\n<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body, "hr", "after");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<hr>\n<h2>section2</h2>", fragments.get(1));
    }

    @Test
    public void shouldSplitJoinSeparatorNo() {
        final String body = getActualResource();
        List<String> fragments = htmlTool.split(body, "hr", JoinSeparator.NO);
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));

        fragments = htmlTool.split(body, "hr", "");
        assertEquals(2, fragments.size());
        assertEquals("<h2>section1</h2>", fragments.get(0));
        assertEquals("<h2>section2</h2>", fragments.get(1));
    }

    @Test
    public void shouldSplitOnStarts() {
        final String body = getActualResource();
        final List<String> fragments = htmlTool.splitOnStarts(body, "hr");
        assertEquals(1, fragments.size());
        assertEquals("<hr>\n<h2>section2</h2>", fragments.get(0));
    }

    @Test
    public void fixTableHeadsWithTagListReportOuput() throws IOException {
        verify(htmlTool::fixTableHeads);
    }

    @Test
    public void shouldReorderToTopOneSection() {
        verify((content) -> {
            return htmlTool.reorderToTop(content, "a:has(img), img", 1, "<div class=\"caption\"></div>");
        }, ".html");
    }

    @Test
    public void shouldExtract() {
        final String section = getActualResource(".html");

        final ExtractResult results = htmlTool.extract(section, "a:has(img), img", 3);
        assertNotNull(results);
        final List<String> actuals = results.getExtracted();
        assertNotNull(actuals);
        assertThat(actuals,
            contains("<a href=\"themes/bootswatch-cerulean.html\"><img src=\"images/1.png\"></a>",
                "<img src=\"images/2.png\">",
                "<img src=\"images/3.png\">"));
        final String remainder = results.getRemainder();
        assertEquals(getExpectedResource(".html"), remainder);
    }

    @Test
    public void shouldSetAttribute() {
        final String content = "<div><span></span></div>";
        final String actual = htmlTool.setAttr(content, "span", "class", "section");
        assertEquals("<div>\n <span class=\"section\"></span>\n</div>", actual);
    }

    @Test
    public void shouldgetAttribute() {
        final String content = "<div class=\"section\"><span class=\"title\"></span></div>";
        final List<String> actuals = htmlTool.getAttr(content, "span", "class");
        assertThat(actuals, contains("title"));
    }

    @Test
    public void shouldAddClass() {
        final String content = "<div><span></span></div>";
        final String actual = htmlTool.addClass(content, "span", "section");
        assertEquals("<div>\n <span class=\"section\"></span>\n</div>", actual);
    }

    @Test
    public void shouldWrapElement() {
        final String content = "<div><span></span></div>";
        final String actual = htmlTool.wrap(content, "span", "<a href=\"http://reflow.com\"></a>", 1);
        assertEquals("<div>\n <a href=\"http://reflow.com\"><span></span></a>\n</div>", actual);
    }

    @Test
    public void shouldRemoveElement() {
        final String content = "<div><span></span></div>";
        final String actual = htmlTool.remove(content, "span");
        assertEquals("<div></div>", actual);
    }

    @Test
    public void shouldReplace() {
        final String content = "<div><span></span></div>";
        final String actual = htmlTool.replace(content, "span", "<a href=\"http://reflow.com\"></a>");
        assertEquals("<div>\n <a href=\"http://reflow.com\"></a>\n</div>", actual);
    }

    @Test
    public void shouldReplaceWith() {
        final String actual = htmlTool
                .replaceWith("<p>text <tt>foo value</tt> end text.</p>", "tt", "<code class=\"literal\">");
        assertEquals("<p>text <code class=\"literal\">foo value</code> end text.</p>", actual);
    }

    @Test
    public void shouldExtractText() {
        final String content = "<div><span>paragraph</span></div>";
        final List<String> actuals = htmlTool.text(content, "span");
        assertThat(actuals, contains("paragraph"));
    }

    @Test
    public void shouldHeadingAnchorToId() {
        verify((content) -> {
            return htmlTool.headingAnchorToId(content);
        }, ".html");
    }

    @Test
    public void shouldEnsureHeadingIds() {
        verify((content) -> {
            return htmlTool.ensureHeadingIds("page", "overview", content, HtmlTool.DEFAULT_SLUG_SEPARATOR);
        }, ".html");
    }

    @Test
    public void shouldEnsureHeadingIdsForFrame() {
        verify((content) -> {
            return htmlTool.ensureHeadingIds("frame", "overview", content, HtmlTool.DEFAULT_SLUG_SEPARATOR);
        }, ".html");
    }

    @Test
    public void shouldHeadingTree() {
        final String content = htmlTool
                .ensureHeadingIds("page", "overview", getActualResource(".html"), HtmlTool.DEFAULT_SLUG_SEPARATOR);
        final List<? extends IdElement> idElements = htmlTool.headingTree(content, Collections.emptyList());
        // check root element
        assertThat(idElements.stream().map((el) -> el.getId()).collect(Collectors.toList()),
            contains("apache-maven-site-plugin"));
        assertThat(idElements.stream().map((el) -> el.getTagName()).collect(Collectors.toList()), contains("h2"));
        assertThat(idElements.stream().map((el) -> el.getText()).collect(Collectors.toList()),
            contains("Apache Maven Site Plugin"));

        // check children
        assertThat(idElements.stream().map((el) -> el.getHeadingLevel()).collect(Collectors.toList()), contains(2));
        assertThat(idElements.get(0).getItems().stream().map((el) -> el.getId()).collect(Collectors.toList()),
            contains("goals-overview", "usage"));
        assertThat(idElements.get(0).getItems().stream().map((el) -> el.getHeadingLevel()).collect(Collectors.toList()),
            contains(3, 3));

    }
}
