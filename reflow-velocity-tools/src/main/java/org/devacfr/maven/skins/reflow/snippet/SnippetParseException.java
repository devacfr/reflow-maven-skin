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

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetParseException extends RuntimeException {

    /** */
    private static final long serialVersionUID = 1L;

    public SnippetParseException(final String message) {
        super(message);

    }

    public SnippetParseException(final String message, final Throwable cause) {
        super(message, cause);

    }

    public SnippetParseException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
