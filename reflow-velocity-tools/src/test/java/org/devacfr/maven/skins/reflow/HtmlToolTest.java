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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.velocity.tools.generic.ValueParser;
import org.junit.Test;

import com.github.approval.Approvals;

public class HtmlToolTest {

    private static Path TEST_RESOURCES = Paths.get("src/test/resources");

    @Test
    public void fixTableHeadsWithTagListReportOuput() {
        final HtmlTool htmlTool = new HtmlTool();
        htmlTool.configure(new ValueParser());
        Approvals.verify(htmlTool.fixTableHeads(readFile(TEST_RESOURCES.resolve("HtmlTool.fixTableHeads.actual"))),
            TEST_RESOURCES.resolve("HtmlTool.fixTableHeads.approved"));
    }

    private static String readFile(final Path path) {
        try {
            return new String(Files.readAllBytes(TEST_RESOURCES.resolve("HtmlTool.fixTableHeads.actual")));
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
