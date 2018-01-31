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
package org.devacfr.maven.skins.reflow.context;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public class Context<T extends Context<?>> {

    private String type;

    public Context() {
    }

    public void setType(final String type) {
        this.type = type;
    }

    public T withType(final String type) {
        setType(type);
        return self();
    }

    public String getType() {
        return type;
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
