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
package org.devacfr.maven.skins.reflow.snippet;

import java.util.ArrayList;

import org.jsoup.internal.StringUtil;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class Components extends ArrayList<Component<?>> {

    /** */
    private static final long serialVersionUID = 1L;

    /** */
    private static final Components EMPTY = new Components();

    /** */
    public static Components empty() {
        return EMPTY;
    }

    /**
    *
    */
    public Components() {
    }

    /**
     * @return
     */
    public String html() {
        final StringBuilder sb = StringUtil.borrowBuilder();
        for (final Component<?> component : this) {
            if (sb.length() != 0) {
                sb.append("\n");
            }
            final String html = component.getHtml();
            if (html != null) {
                sb.append(html);
            }
        }
        return StringUtil.releaseBuilder(sb);
    }

    /**
     * Get the first matched element.
     *
     * @return The first matched component, or <code>null</code> if contents is empty.
     */
    public Component<?> first() {
        return isEmpty() ? null : get(0);
    }

    /**
     * Get the last matched component.
     *
     * @return The last matched component, or <code>null</code> if contents is empty.
     */
    public Component<?> last() {
        return isEmpty() ? null : get(size() - 1);
    }

}
