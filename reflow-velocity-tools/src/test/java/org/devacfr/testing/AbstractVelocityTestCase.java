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

import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractVelocityTestCase extends MockitoTestCase {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private VelocityEngine engine = null;

    private String template = "";

    private Context context = null;

    private String expected = null;

    protected final Logger getLog() {
        return this.log;
    }

    @Before
    protected void setUp() throws Exception {
        this.setEngine(VelocityTestTool.newEngine());
        this.setTemplate("");
        this.setContext(new VelocityContext());
        this.setExpected("");
    }

    @After
    protected void tearDown() throws Exception {
        this.setEngine(null);
        this.setTemplate(null);
        this.setContext(null);
        this.setExpected(null);
    }

    /**
     * @return Returns the engine.
     */
    protected VelocityEngine getEngine() {
        return this.engine;
    }

    /**
     * @param engine
     *            The engine to set.
     */
    protected void setEngine(final VelocityEngine engine) {
        this.engine = engine;
    }

    /**
     * @return Returns the template.
     */
    protected String getTemplate() {
        return this.template;
    }

    /**
     * @param template
     *            The template to set.
     */
    protected void setTemplate(final String template) {
        this.template = template;
    }

    /**
     * @return Returns the context.
     */
    protected Context getContext() {
        return this.context;
    }

    /**
     * @param context
     *            The context to set.
     */
    protected void setContext(final Context context) {
        this.context = context;
    }

    /**
     * @return Returns the expected.
     */
    protected String getExpected() {
        return this.expected;
    }

    /**
     * @param expected
     *            The expected to set.
     */
    protected void setExpected(final String expected) {
        this.expected = expected;
    }

    protected void assertVelocity()
            throws ParseErrorException, MethodInvocationException, ResourceNotFoundException, IOException, Exception {
        this.getEngine().init();

        final StringWriter writer = new StringWriter();
        assertTrue(this.getEngine().evaluate(this.getContext(), writer, this.getName(), this.getTemplate()));

        assertEquals(this.getExpected(), String.valueOf(writer));
    }
}