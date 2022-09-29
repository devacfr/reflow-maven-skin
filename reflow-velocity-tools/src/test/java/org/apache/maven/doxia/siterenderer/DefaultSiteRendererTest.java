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

import static org.apache.commons.io.IOUtils.closeQuietly;
import static org.apache.commons.io.IOUtils.copy;
import static org.codehaus.plexus.testing.PlexusExtension.getBasedir;
import static org.codehaus.plexus.testing.PlexusExtension.getTestFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.HashMap;
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
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.testing.PlexusTest;
import org.codehaus.plexus.util.FileUtils;
import org.devacfr.testing.jupiter.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:vincent.siveton@gmail.com">Vincent Siveton</a>
 * @author <a href="mailto:evenisse@codehaus.org">Emmanuel Venisse</a>
 */
@PlexusTest
public class DefaultSiteRendererTest extends TestCase {

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

        InputStream skinIS = getResource("velocity-toolmanager.vm").openStream();
        JarOutputStream jarOS = new JarOutputStream(new FileOutputStream(skinJar));
        try {
            jarOS.putNextEntry(new ZipEntry("META-INF/maven/site.vm"));
            copy(skinIS, jarOS);
            jarOS.closeEntry();
        } finally {
            closeQuietly(skinIS);
            closeQuietly(jarOS);
        }

        skinIS = new ByteArrayInputStream(
                "<main id=\"contentBox\">$bodyContent</main>".getBytes(StandardCharsets.UTF_8));
        jarOS = new JarOutputStream(new FileOutputStream(minimalSkinJar));
        try {
            jarOS.putNextEntry(new ZipEntry("META-INF/maven/site.vm"));
            copy(skinIS, jarOS);
            jarOS.closeEntry();
        } finally {
            closeQuietly(skinIS);
            closeQuietly(jarOS);
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
    public void shouldAcceptSnippet() throws Exception {
        // Safety
        FileUtils.deleteDirectory(getTestFile(OUTPUT));

        // ----------------------------------------------------------------------
        // Render the site from src/test/resources/site to OUTPUT
        // ----------------------------------------------------------------------
        final DecorationModel decoration = new DecorationXpp3Reader()
                .read(new FileInputStream(getTestFile("src/test/resources/site/site.xml")));

        final Path targetSite = getTestFile(OUTPUT).toPath();
        final Path srcSite = getTestFile("src/test/resources/site").toPath();
        final SiteRenderingContext ctxt = getSiteRenderingContext(decoration, srcSite, false);

        ctxt.setRootDirectory(getTestFile(""));
        renderer.render(renderer.locateDocumentFiles(ctxt, true).values(), ctxt, targetSite.toFile());

        verify(targetSite.resolve("snippet.html"), getPackagePath().resolve("snippet.approved.html"));
    }

    private SiteRenderingContext getSiteRenderingContext(final DecorationModel decoration,
        final Path siteDir,
        final boolean validate) throws RendererException, IOException {
        final File skinFile = minimalSkinJar;

        final Map<String, String> attributes = new HashMap<>();
        attributes.put("outputEncoding", "UTF-8");

        final Artifact skin = new DefaultArtifact("org.group", "artifact", VersionRange.createFromVersion("1.1"), null,
                "jar", "", null);
        skin.setFile(skinFile);
        final SiteRenderingContext siteRenderingContext = renderer
                .createContextForSkin(skin, attributes, decoration, "defaultWindowTitle", Locale.ENGLISH);
        siteRenderingContext.addSiteDirectory(siteDir.toFile());
        siteRenderingContext.setValidate(validate);

        return siteRenderingContext;
    }

}