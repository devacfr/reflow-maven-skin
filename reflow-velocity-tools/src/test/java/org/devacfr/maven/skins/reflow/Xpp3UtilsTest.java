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

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.devacfr.testing.TestCase;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class Xpp3UtilsTest extends TestCase {

    @Test
    public void shouldFirstChildReturnNullWhenParentIsNull() {
        assertNull(Xpp3Utils.getFirstChild(null, "", ""));
    }

    @Test
    public void shouldChildNodeExist() {
        final Xpp3Dom expectedChild = new Xpp3Dom("expected-child");
        final Xpp3Dom parent = new Xpp3Dom("parent");
        parent.addChild(new Xpp3Dom("child"));
        parent.addChild(expectedChild);

        assertEquals(expectedChild, Xpp3Utils.getFirstChild(parent, "expected-child", ""));
    }

    @Test
    public void shouldChildNodeNotExist() {
        final Xpp3Dom expectedChild = new Xpp3Dom("expected-child");
        final Xpp3Dom parent = new Xpp3Dom("parent");
        parent.addChild(new Xpp3Dom("child"));
        parent.addChild(expectedChild);

        assertNull(Xpp3Utils.getFirstChild(parent, "wrong-child", ""));
    }

    @Test
    public void shouldChildrenNodesReturnEmptyListWhenParentIsNull() {
        final List<Xpp3Dom> list = Xpp3Utils.getChildrenNodes(null, "");
        assertThat(list, Matchers.empty());
    }

    @Test
    public void shouldChildrenReturnEmptyListWhenParentIsNull() {
        final List<String> list = Xpp3Utils.getChildren(null);
        assertThat(list, Matchers.empty());
    }

    @Test
    public void shouldChildrenReturnAllChildrenNodes() {
        final Xpp3Dom parent = new Xpp3Dom("parent");
        for (int i = 0; i < 10; i++) {
            parent.addChild(new Xpp3Dom("child"));
        }

        final List<String> list = Xpp3Utils.getChildren(parent);
        assertThat(list, Matchers.hasSize(10));
    }

    @Test
    public void shouldChildrenNodesReturnSpecificChildrenNodes() {
        final Xpp3Dom parent = new Xpp3Dom("parent");
        for (int i = 0; i < 10; i++) {
            parent.addChild(new Xpp3Dom("child"));
        }
        for (int i = 0; i < 10; i++) {
            parent.addChild(new Xpp3Dom("child-other"));
        }

        final List<Xpp3Dom> list = Xpp3Utils.getChildrenNodes(parent, "child");
        assertThat(list, Matchers.hasSize(10));
    }

    @Test
    public void shouldChildrenNodesReturnEmptyChildrenNodes() {
        final Xpp3Dom parent = new Xpp3Dom("parent");
        final List<Xpp3Dom> list = Xpp3Utils.getChildrenNodes(parent, "child");
        assertThat(list, Matchers.empty());
    }

}
