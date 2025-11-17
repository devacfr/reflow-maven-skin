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
package org.apache.maven.doxia.module.markdown;

import java.io.IOException;
import java.util.Arrays;

import org.devacfr.testing.jupiter.TestCase;
import org.junit.jupiter.api.Test;

import com.vladsch.flexmark.ext.abbreviation.AbbreviationExtension;
import com.vladsch.flexmark.ext.autolink.AutolinkExtension;
import com.vladsch.flexmark.ext.definition.DefinitionExtension;
import com.vladsch.flexmark.ext.escaped.character.EscapedCharacterExtension;
import com.vladsch.flexmark.ext.gfm.strikethrough.StrikethroughExtension;
import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.ext.typographic.TypographicExtension;
import com.vladsch.flexmark.ext.wikilink.WikiLinkExtension;
import com.vladsch.flexmark.ext.yaml.front.matter.YamlFrontMatterExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;

public class FlexmarkParserTest extends TestCase {

    /**
     * Flexmark's Markdown parser (one static instance fits all)
     */
    private static final com.vladsch.flexmark.parser.Parser FLEXMARK_PARSER;

    /**
     * Flexmark's HTML renderer (its output will be re-parsed and converted to Sink events)
     */
    private static final HtmlRenderer FLEXMARK_HTML_RENDERER;

    // Initialize the Flexmark parser and renderer, once and for all
    static {
        MutableDataSet flexmarkOptions = new MutableDataSet();

        // Enable the extensions that we used to have in Pegdown
        flexmarkOptions.set(com.vladsch.flexmark.parser.Parser.EXTENSIONS,
            Arrays.asList(EscapedCharacterExtension.create(),
                AbbreviationExtension.create(),
                AutolinkExtension.create(),
                DefinitionExtension.create(),
                TypographicExtension.create(),
                TablesExtension.create(),
                WikiLinkExtension.create(),
                StrikethroughExtension.create()));

        // Disable wrong apostrophe replacement
        flexmarkOptions.set(TypographicExtension.SINGLE_QUOTE_UNMATCHED, "&apos;");

        // Additional options on the HTML rendering
        flexmarkOptions.set(HtmlRenderer.HTML_BLOCK_OPEN_TAG_EOL, false);
        flexmarkOptions.set(HtmlRenderer.HTML_BLOCK_CLOSE_TAG_EOL, false);
        flexmarkOptions.set(HtmlRenderer.MAX_TRAILING_BLANK_LINES, -1);

        // Build the Markdown parser
        FLEXMARK_PARSER = com.vladsch.flexmark.parser.Parser.builder(flexmarkOptions).build();

        MutableDataSet flexmarkMetadataOptions = new MutableDataSet();
        flexmarkMetadataOptions.set(com.vladsch.flexmark.parser.Parser.EXTENSIONS,
            Arrays.asList(YamlFrontMatterExtension.create()));

        // Build the HTML renderer
        FLEXMARK_HTML_RENDERER = HtmlRenderer.builder(flexmarkOptions)
                .linkResolverFactory(new FlexmarkDoxiaLinkResolver.Factory())
                .build();
    }

    @Test
    public void shouldConvertMarkdown() {
        verify((content) -> {
            StringBuilder html = new StringBuilder();
            try {
                return render(content, html);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, "md", "html");
    }

    private String render(String content, Appendable html) throws IOException {
        Node documentRoot = FLEXMARK_PARSER.parse(content);
        FLEXMARK_HTML_RENDERER.render(documentRoot, html);
        return html.toString();

    }
}
