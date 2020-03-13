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
package org.devacfr.maven.skins.reflow.snippet;

import java.io.IOException;

import org.devacfr.testing.jupiter.MockitoTestCase;
import org.junit.jupiter.api.Test;

public class SnippetParserTest extends MockitoTestCase {

    @Test
    public void shouldReplaceSnippetByHtml() throws Exception {
        verify((htmlSource) -> {
            SnippetContext contextSnippet;
            try {
                contextSnippet = new SnippetParser().parse(htmlSource);
                final String html = contextSnippet.html();
                return html;
            } catch (final IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }

        }, "html");
    }

}
