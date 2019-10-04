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
package org.devacfr.testing;

import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;

public class VelocityTestTool {

    public static VelocityEngine newEngine() {
        final VelocityEngine engine = new VelocityEngine();

        engine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, SLF4JLogChute.class.getName());
        engine.setProperty("runtime.log.logsystem.commons.logging.name", "test.velocity.log");

        return engine;
    }

    public static void initSingletonLogger() {
        Velocity.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, SLF4JLogChute.class.getName());
        Velocity.setProperty("runtime.log.logsystem.commons.logging.name", "test.velocity.log");
    }

}