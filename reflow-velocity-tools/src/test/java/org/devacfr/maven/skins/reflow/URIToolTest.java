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

import org.devacfr.testing.TestCase;
import org.junit.Test;

public class URIToolTest extends TestCase {

    @Test
    public void relativeRootLink() throws IOException {
        String absoluteResourceURL = "https://devacfr.github.io/reflow-maven-skin";
        String currentFilename = "index.html";
        String projectUrl = "https://devacfr.github.io/reflow-maven-skin/";

        String currentFileDir = URITool.toURI(projectUrl).resolve(currentFilename).resolve(".").toString();
        String actual = URITool.relativizeLink(currentFileDir, absoluteResourceURL);
        assertEquals(".", actual);
    }

    @Test
    public void relativeSubModuleLink() throws IOException {
        String absoluteResourceURL = "https://devacfr.github.io/reflow-maven-skin";
        String currentFilename = "index.html";
        String projectUrl = "https://devacfr.github.io/reflow-maven-skin/skin/";

        String currentFileDir = URITool.toURI(projectUrl).resolve(currentFilename).resolve(".").toString();
        String actual = URITool.relativizeLink(currentFileDir, absoluteResourceURL);
        assertEquals("..", actual);
    }

    @Test
    public void relativeSubFolderLink() throws IOException {
        String absoluteResourceURL = "https://devacfr.github.io/reflow-maven-skin";
        String currentFilename = "themes/index.html";
        String projectUrl = "https://devacfr.github.io/reflow-maven-skin/skin/";

        String currentFileDir = URITool.toURI(projectUrl).resolve(currentFilename).resolve(".").toString();
        String actual = URITool.relativizeLink(currentFileDir, absoluteResourceURL);
        assertEquals("../..", actual);
    }

}
