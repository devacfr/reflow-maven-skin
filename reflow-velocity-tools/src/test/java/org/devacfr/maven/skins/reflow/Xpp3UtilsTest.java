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

import java.util.List;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.testing.TestCase;
import org.hamcrest.Matchers;
import org.junit.Test;

public class Xpp3UtilsTest extends TestCase {

    @Test
    public void shouldFirstChildReturnNullWhenParentIsNull() {
        assertNull(Xpp3Utils.getFirstChild(null, "", ""));
    }

    @Test
    public void shouldChildrenNodesReturnEmptyListWhenParentIsNull() {
        List<Xpp3Dom> list = Xpp3Utils.getChildrenNodes(null, "");
        assertThat(list, Matchers.empty());
    }

    public void shouldChildrenReturnEmptyListWhenParentIsNull() {
        List<String> list = Xpp3Utils.getChildren(null);
        assertThat(list, Matchers.empty());
    }

}
