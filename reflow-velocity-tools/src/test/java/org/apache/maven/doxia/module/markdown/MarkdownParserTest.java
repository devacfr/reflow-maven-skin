/*
 * Copyright 2012-2020 Christophe Friederich
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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

import org.apache.maven.doxia.parser.Parser;
import org.devacfr.testing.jupiter.PlexusTestCase;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.base.Throwables;

public class MarkdownParserTest extends PlexusTestCase {

    private MarkdownParser parser;

    @BeforeEach
    @Override
    public void setUp() throws Exception {
        super.setUp();
        parser = lookup(Parser.ROLE, MarkdownParser.ROLE_HINT, MarkdownParser.class);
    }

    @AfterEach
    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void shouldParseToHtml() {
        assertNotNull(parser);
        verify((conten) -> {
            try {
                return Jsoup.parse(parseFileToHtml(".md")).html();
            } catch (final Exception e) {
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }
        }, ".md");
    }

    protected String parseFileToHtml(final String suffix) throws Exception {
        try (Reader reader = new StringReader(getActualResource(suffix))) {
            // final Method toHtml = parser.getClass().getDeclaredMethod("toHtml", Reader.class);
            // toHtml.setAccessible(true);
            // return (String) toHtml.invoke(parser, reader);
            return parser.toHtml(reader);
        }
    }

}
