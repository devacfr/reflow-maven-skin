/*
 * Copyright 2012-2018 Christophe Friederich
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
package org.devacfr.maven.skins.reflow.context;

/**
 * Type of context depending of type of page.
 *
 * @author Christophe Friederich
 * @since 2.0
 */
public enum ContextType {
    /** context manage page (default format). */
    page,
    /** context manage document page. */
    doc,
    /** context manage frame used in document page. */
    frame,
    /** context manage body page. */
    body

}
