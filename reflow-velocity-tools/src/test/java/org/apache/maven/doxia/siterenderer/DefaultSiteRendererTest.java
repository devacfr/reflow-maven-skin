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
package org.apache.maven.doxia.siterenderer;

import static org.codehaus.plexus.testing.PlexusExtension.getBasedir;
import static org.codehaus.plexus.testing.PlexusExtension.getTestFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;

import javax.inject.Inject;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.DefaultArtifact;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.doxia.site.decoration.DecorationModel;
import org.apache.maven.doxia.site.decoration.io.xpp3.DecorationXpp3Reader;
import org.apache.maven.doxia.xsd.AbstractXmlValidator;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.testing.PlexusTest;
import org.codehaus.plexus.util.FileUtils;
import org.codehaus.plexus.util.IOUtil;
import org.codehaus.plexus.util.ReaderFactory;
import org.codehaus.plexus.util.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.EntityResolver;

import com.vladsch.flexmark.ext.typographic.TypographicExtension;

/**
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @author <a href="mailto:evenisse@codehaus.org">Emmanuel Venisse</a>
 */
@PlexusTest
public class DefaultSiteRendererTest {

    /**
     * All output produced by this test will go here.
     */
    private static final String OUTPUT = "target/output";

    /**
     * The renderer used to produce output.
     */
    private Renderer renderer;

    /**
     * The locale before executing tests.
     */
    private Locale oldLocale;

    @Inject
    private PlexusContainer container;

    private final File skinJar = new File(getBasedir(), "target/test-classes/skin.jar");

    private final File minimalSkinJar = new File(getBasedir(), "target/test-classes/minimal-skin.jar");

    /**
     * @throws java.lang.Exception
     *             if something goes wrong.
     */
    @BeforeEach
    protected void setUp() throws Exception {
        renderer = container.lookup(Renderer.class);

        InputStream skinIS = getClass().getResourceAsStream("velocity-toolmanager.vm");
        JarOutputStream jarOS = new JarOutputStream(new FileOutputStream(skinJar));
        try {
            jarOS.putNextEntry(new ZipEntry("META-INF/maven/site.vm"));
            IOUtil.copy(skinIS, jarOS);
            jarOS.closeEntry();
        } finally {
            IOUtil.close(skinIS);
            IOUtil.close(jarOS);
        }

        skinIS = new ByteArrayInputStream(
                "<main id=\"contentBox\">$bodyContent</main>".getBytes(StandardCharsets.UTF_8));
        jarOS = new JarOutputStream(new FileOutputStream(minimalSkinJar));
        try {
            jarOS.putNextEntry(new ZipEntry("META-INF/maven/site.vm"));
            IOUtil.copy(skinIS, jarOS);
            jarOS.closeEntry();
        } finally {
            IOUtil.close(skinIS);
            IOUtil.close(jarOS);
        }

        oldLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    /**
     * @throws java.lang.Exception
     *             if something goes wrong.
     */
    @AfterEach
    protected void tearDown() throws Exception {
        container.release(renderer);

        Locale.setDefault(oldLocale);
    }

    /**
     * @throws Exception
     *             if something goes wrong.
     */
    @Test
    public void testRender() throws Exception {
        // Safety
        FileUtils.deleteDirectory(getTestFile(OUTPUT));

        // ----------------------------------------------------------------------
        // Render the site from src/test/resources/site to OUTPUT
        // ----------------------------------------------------------------------
        final DecorationModel decoration = new DecorationXpp3Reader()
                .read(new FileInputStream(getTestFile("src/test/resources/site/site.xml")));

        final SiteRenderingContext ctxt = getSiteRenderingContext(decoration, "src/test/resources/site", false);
        ctxt.setRootDirectory(getTestFile(""));
        renderer.render(renderer.locateDocumentFiles(ctxt, true).values(), ctxt, getTestFile(OUTPUT));

    }

    private SiteRenderingContext getSiteRenderingContext(final DecorationModel decoration,
        final String siteDir,
        final boolean validate) throws RendererException, IOException {
        final File skinFile = minimalSkinJar;

        final Map<String, String> attributes = new HashMap<>();
        attributes.put("outputEncoding", "UTF-8");

        final Artifact skin = new DefaultArtifact("org.group", "artifact", VersionRange.createFromVersion("1.1"), null,
                "jar", "", null);
        skin.setFile(skinFile);
        final SiteRenderingContext siteRenderingContext = renderer
                .createContextForSkin(skin, attributes, decoration, "defaultWindowTitle", Locale.ENGLISH);
        siteRenderingContext.addSiteDirectory(getTestFile(siteDir));
        siteRenderingContext.setValidate(validate);

        return siteRenderingContext;
    }

    /**
     * Validate the generated pages.
     *
     * @throws Exception
     *             if something goes wrong.
     * @since 1.1.1
     */
    public void validatePages() throws Exception {
        new Xhtml5ValidatorTest().validateGeneratedPages();
    }

    protected static class Xhtml5ValidatorTest extends AbstractXmlValidator {

        /**
         * Validate the generated documents.
         *
         * @throws Exception
         */
        public void validateGeneratedPages() throws Exception {
            setValidate(false);
            try {
                testValidateFiles();
            } finally {
                tearDown();
            }
        }

        private static String[] getIncludes() {
            return new String[] { "**/*.html" };
        }

        /** {@inheritDoc} */
        @Override
        protected String addNamespaces(final String content) {
            return content;
        }

        /** {@inheritDoc} */
        @Override
        protected EntityResolver getEntityResolver() {
            /* HTML5 restricts use of entities to XML only */
            return null;
        }

        /** {@inheritDoc} */
        @Override
        protected Map<String, String> getTestDocuments() throws IOException {
            final Map<String, String> testDocs = new HashMap<>();

            final File dir = new File(getBasedir(), "target/output");

            final List<String> l = FileUtils
                    .getFileNames(dir, getIncludes()[0], FileUtils.getDefaultExcludesAsString(), true);

            for (String file : l) {
                file = StringUtils.replace(file, "\\", "/");

                final Reader reader = ReaderFactory.newXmlReader(new File(file));
                try {
                    testDocs.put(file, IOUtil.toString(reader));
                } finally {
                    IOUtil.close(reader);
                }
            }

            return testDocs;
        }

        /** {@inheritDoc} */
        @Override
        protected boolean isFailErrorMessage(final String message) {
            return true;
        }
    }
}