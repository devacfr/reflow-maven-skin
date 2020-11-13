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

import org.codehaus.plexus.ContainerConfiguration;
import org.codehaus.plexus.DefaultContainerConfiguration;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.PlexusContainerException;
import org.codehaus.plexus.configuration.PlexusConfiguration;
import org.codehaus.plexus.context.Context;
import org.codehaus.plexus.context.DefaultContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;

/**
 * @author Christophe Friederich
 * @since 2.4
 */
public abstract class PlexusTestCase extends TestCase {

    private PlexusContainer container;

    private static String basedirPath;

    public PlexusTestCase() {
    }

    public void setupContainer() {

        final DefaultContext context = new DefaultContext();

        context.put("basedir", getBasedir());

        customizeContext(context);

        final boolean hasPlexusHome = context.contains("plexus.home");

        if (!hasPlexusHome) {
            final File f = getTestFile("target/plexus-home");

            if (!f.isDirectory()) {
                f.mkdir();
            }

            context.put("plexus.home", f.getAbsolutePath());
        }

        final String config = getCustomConfigurationName();

        final ContainerConfiguration containerConfiguration = new DefaultContainerConfiguration().setName("test")
                .setContext(context.getContextData());

        if (config != null) {
            containerConfiguration.setContainerConfiguration(config);
        } else {
            final String resource = getConfigurationName(null);

            containerConfiguration.setContainerConfiguration(resource);
        }

        customizeContainerConfiguration(containerConfiguration);

        try {
            container = new DefaultPlexusContainer(containerConfiguration);
        } catch (final PlexusContainerException e) {
            e.printStackTrace();
            Assertions.fail("Failed to create plexus container.");
        }

    }

    /**
     * Allow custom test case implementations do augment the default container configuration before executing tests.
     *
     * @param containerConfiguration
     */
    protected void customizeContainerConfiguration(final ContainerConfiguration containerConfiguration) {
    }

    protected void customizeContext(final Context context) {
    }

    protected PlexusConfiguration customizeComponentConfiguration() {
        return null;
    }

    @AfterEach
    public void tearDown() throws Exception {
        if (container != null) {
            container.dispose();
        }
        container = null;
    }

    protected PlexusContainer getContainer() {
        if (container == null) {
            setupContainer();
        }

        return container;
    }

    protected InputStream getConfiguration() throws Exception {
        return getConfiguration(null);
    }

    protected InputStream getConfiguration(final String subname) throws Exception {
        return getResourceAsStream(getConfigurationName(subname));
    }

    protected String getCustomConfigurationName() {
        return null;
    }

    /**
     * Allow the retrieval of a container configuration that is based on the name of the test class being run. So if you
     * have a test class called org.foo.FunTest, then this will produce a resource name of org/foo/FunTest.xml which
     * would be used to configure the Plexus container before running your test.
     *
     * @param subname
     *                    the subname
     * @return A configruation name
     */
    protected String getConfigurationName(final String subname) {
        return getClass().getName().replace('.', '/') + ".xml";
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

    @SuppressWarnings("unchecked")
    protected <T> T lookup(final String componentKey) throws Exception {
        return (T) getContainer().lookup(componentKey);
    }

    @SuppressWarnings("unchecked")
    protected <T> T lookup(final String role, final String roleHint) throws Exception {
        return (T) getContainer().lookup(role, roleHint);
    }

    protected <T> T lookup(final Class<T> componentClass) throws Exception {
        return getContainer().lookup(componentClass);
    }

    protected <T> T lookup(final Class<T> componentClass, final String roleHint) throws Exception {
        return getContainer().lookup(componentClass, roleHint);
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

    public String getTestConfiguration() {
        return getTestConfiguration(getClass());
    }

    public static String getTestConfiguration(final Class<?> clazz) {
        final String s = clazz.getName().replace('.', '/');

        return s.substring(0, s.indexOf("$")) + ".xml";
    }

}
