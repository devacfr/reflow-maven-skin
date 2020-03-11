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
package org.devacfr.testing.jupiter;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.context.Context;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

/**
 * @author Christophe Friederich
 * @since 2.4
 */
public abstract class PlexusTestCase extends TestCase {

    protected PlexusContainer container;

    private static String basedirPath;

    public PlexusTestCase() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        InputStream configuration = null;

        try {
            configuration = getCustomConfiguration();

            if (configuration == null) {
                configuration = getConfiguration();
            }
        } catch (final Exception e) {
            System.out.println("Error with configuration:");

            System.out.println("configuration = " + configuration);

            fail(e.getMessage());
        }

        container = createContainerInstance();

        container.addContextValue("basedir", getBasedir());

        // this method was deprecated
        customizeContext();

        customizeContext(getContext());

        final boolean hasPlexusHome = getContext().contains("plexus.home");

        if (!hasPlexusHome) {
            final File f = getTestFile("target/plexus-home");

            if (!f.isDirectory()) {
                f.mkdir();
            }

            getContext().put("plexus.home", f.getAbsolutePath());
        }

        if (configuration != null) {
            container.setConfigurationResource(new InputStreamReader(configuration));
        }

        container.initialize();

        container.start();
    }

    @AfterEach
    public void tearDown() throws Exception {
        container.dispose();

        container = null;
    }

    protected PlexusContainer createContainerInstance() {
        return new DefaultPlexusContainer();
    }

    private Context getContext() {
        return container.getContext();
    }

    // !!! this should probably take a context as a parameter so that the
    // user is not forced to do getContainer().addContextValue(..)
    // this would require a change to PlexusContainer in order to get
    // hold of the context ...
    // @deprecated use void customizeContext( Context context )
    protected void customizeContext() throws Exception {
    }

    protected void customizeContext(final Context context) throws Exception {
    }

    protected InputStream getCustomConfiguration() throws Exception {
        return null;
    }

    protected PlexusContainer getContainer() {
        return container;
    }

    protected InputStream getConfiguration() throws Exception {
        return getConfiguration(null);
    }

    protected InputStream getConfiguration(final String subname) throws Exception {
        final String className = getClass().getName();

        final String base = className.substring(className.lastIndexOf(".") + 1);

        String config = null;

        if (subname == null || subname.equals("")) {
            config = base + ".xml";
        } else {
            config = base + "-" + subname + ".xml";
        }

        final InputStream configStream = getResourceAsStream(config);

        return configStream;
    }

    protected InputStream getResourceAsStream(final String resource) {
        return getClass().getResourceAsStream(resource);
    }

    protected ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }

    // ----------------------------------------------------------------------
    // Container access
    // ----------------------------------------------------------------------

    protected Object lookup(final String componentKey) throws Exception {
        return getContainer().lookup(componentKey);
    }

    @SuppressWarnings("unchecked")
    protected <T> T lookup(final String role, final String id, final Class<T> cls) throws Exception {
        return (T) getContainer().lookup(role, id);
    }

    protected void release(final Object component) throws Exception {
        getContainer().release(component);
    }

    // ----------------------------------------------------------------------
    // Helper methods for sub classes
    // ----------------------------------------------------------------------

    public static File getTestFile(final String path) {
        return new File(getBasedir(), path);
    }

    public static File getTestFile(final String basedir, final String path) {
        File basedirFile = new File(basedir);

        if (!basedirFile.isAbsolute()) {
            basedirFile = getTestFile(basedir);
        }

        return new File(basedirFile, path);
    }

    public static String getTestPath(final String path) {
        return getTestFile(path).getAbsolutePath();
    }

    public static String getTestPath(final String basedir, final String path) {
        return getTestFile(basedir, path).getAbsolutePath();
    }

    public static String getBasedir() {
        if (basedirPath != null) {
            return basedirPath;
        }

        basedirPath = System.getProperty("basedir");

        if (basedirPath == null) {
            basedirPath = new File("").getAbsolutePath();
        }

        return basedirPath;
    }
}