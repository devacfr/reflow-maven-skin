/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.maven.doxia.module.markdown;

import javax.inject.Inject;

import java.io.Reader;
import java.io.StringReader;

import com.google.common.base.Throwables;

import org.apache.maven.doxia.parser.AbstractParser;
import org.apache.maven.doxia.parser.Parser;
import org.devacfr.testing.jupiter.ParserTestCase;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MarkdownParserTest extends ParserTestCase {

    @Inject
    private MarkdownParser parser;

    /**
     * {@inheritDoc}
     */
    @Override
    protected AbstractParser createParser() {
        return parser;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String outputExtension() {
        return MarkdownParserModule.FILE_EXTENSION;
    }

    @Test
    public void shouldParseToHtml() {
        assertNotNull(parser);
        verify(content -> {
            try {
                final String html = parseFileToHtml(content);
                return Jsoup.parse(html).html();
            } catch (final Exception e) {
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }
        }, "md");
    }

    @Test
    public void shouldParseSnippetToHtml() {
        assertNotNull(parser);
        verify(content -> {
            try {
                final String html = parseFileToHtml(content);
                return Jsoup.parse(html).html();
            } catch (final Exception e) {
                Throwables.throwIfUnchecked(e);
                throw new RuntimeException(e);
            }
        }, "md");
    }

    protected String parseFileToHtml(final String content) throws Exception {
        try (Reader reader = new StringReader(content)) {
            // final Method toHtml = parser.getClass().getDeclaredMethod("toHtml", Reader.class);
            // toHtml.setAccessible(true);
            // return (String) toHtml.invoke(parser, reader);
            return parser.toHtml(reader).toString();
        }
    }

    @Override
    protected String getVerbatimSource() {
        /**
         * Markdown doesn't support verbatim text which is not code:
         * https://spec.commonmark.org/0.31.2/#fenced-code-blocks and https://spec.commonmark.org/0.31.2/#indented-code-blocks
         */
        return null;
    }

    @Override
    protected String getVerbatimCodeSource() {
        return null;
    }
}
