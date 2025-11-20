/*
                * Copyright 2012-2025 Christophe Friederich
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
package org.devacfr.maven.skins.reflow;

import com.google.common.collect.ImmutableMap;
import java.io.InputStream;
import lombok.Builder;
import lombok.Data;
import org.apache.maven.doxia.site.SiteModel;
import org.apache.maven.doxia.site.io.xpp3.SiteXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.generic.RenderTool;
import org.apache.velocity.tools.generic.ValueParser;
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.junit.jupiter.api.Test;

public class SkinConfigToolTest extends MockitoTestCase {

    @Test
    public void testIs() throws Exception {
        ReflowContext context = createSkinConfig();
        assertEquals(true, context.getSkinConfig().is("localResources"));
        assertEquals(false, context.getSkinConfig().is("markPageHeader"));
    }

    @Test
    public void testNot() throws Exception {
        ReflowContext context = createSkinConfig();
        SkinConfigTool skinConfig = context.getSkinConfig();
        assertEquals(true, skinConfig.not("markPageHeader"));
        assertEquals(false, skinConfig.not("localResources"));
    }

    @Test
    public void testIsValue() throws Exception {
        ReflowContext context = createSkinConfig();
        SkinConfigTool skinConfig = context.getSkinConfig();
        assertEquals(true, skinConfig.isValue("localResources", "true"));
        assertEquals(false, skinConfig.isValue("localResources", "value"));
    }

    @Test
    public void testIsActiveLink() throws Exception {
        ReflowContext context = createSkinConfig();
        SkinConfigTool skinConfig = context.getSkinConfig();
        ToolContext velocityContext = context.getVelocityContext();
        velocityContext.put("alignedFileName", "index.html");
        assertEquals(true, skinConfig.isActiveLink("."), "should be active");
        assertEquals(true, skinConfig.isActiveLink(""), "should be active");

        velocityContext.put("alignedFileName", "summary.html");
        assertEquals(false, skinConfig.isActiveLink(null), "should be not active");
        assertEquals(false, skinConfig.isActiveLink("."), "should be not active");
        assertEquals(false, skinConfig.isActiveLink("index.html"), "should be not active");
    }

    @Test
    public void testIsExternalLink() throws Exception {
        ReflowContext context = createSkinConfig();
        SkinConfigTool skinConfig = context.getSkinConfig();
        assertEquals(true, skinConfig.isExternalLink("http://foo.com"), "should be external");
        assertEquals(true, skinConfig.isExternalLink("https://foo.com"), "should be external");
        assertEquals(true, skinConfig.isExternalLink("ftp://foo.com"), "should be external");
        assertEquals(true, skinConfig.isExternalLink("mailto:john@foo.com"), "should be external");
        assertEquals(true, skinConfig.isExternalLink("file://foo.com"), "should be external");

        assertEquals(false, skinConfig.isExternalLink(null), "should be internal");
        assertEquals(false, skinConfig.isExternalLink("summary.html"), "should be internal");
        assertEquals(false,
            skinConfig.isExternalLink("https://devacfr.github.io/reflow-maven-skin/dev/summary.html"),
            "should be internal");
    }

    @Test
    public void testSlugFilename() throws Exception {
        assertEquals("dev-release-management", SkinConfigTool.slugFilename("dev/release-management.html"));
        assertEquals("dev-develop_guide", SkinConfigTool.slugFilename("dev/develop_guide.html"));
        assertEquals("dev-develop_guide", SkinConfigTool.slugFilename("dev/develop_guide"));
    }

    @Test
    public void shouldReturnProjectLocationNotNull() throws Exception {
        ReflowContext context = createSkinConfig();
        SkinConfigTool skinConfig = context.getSkinConfig();
        context.getMaven().setUrl(null);
        assertEquals("https://localhost/", skinConfig.getProjectLocation());
    }

    private ReflowContext createSkinConfig() throws Exception {
        SkinConfigTool skinConfig;
        ToolContext velocityContext = new ToolContext();
        final SiteXpp3Reader reader = new SiteXpp3Reader();
        SiteModel siteModel = null;
        try (final InputStream in = getResource("default.site.xml").openBufferedStream()) {
            siteModel = reader.read(in);
        }
        ValueParser valueParser = new ValueParser(
                ImmutableMap.<String, Object> builder().put("velocityContext", velocityContext).build());

        final MavenProject maven = new MavenProject();
        maven.setArtifactId("maven-reflow-plugin");
        maven.setUrl("https://devacfr.github.io/reflow-maven-skin/");

        velocityContext.put("project", maven);
        velocityContext.put("site", siteModel);
        velocityContext.put("render", new RenderTool());
        velocityContext.put("currentFileName", "summary.html");
        velocityContext.put("alignedFileName", "summary.html");
        skinConfig = new SkinConfigTool();
        skinConfig.configure(valueParser);
        return ReflowContext.builder().maven(maven).velocityContext(velocityContext).skinConfig(skinConfig).build();
    }

    @Data
    @Builder
    private static class ReflowContext {

        private ToolContext velocityContext;

        private SkinConfigTool skinConfig;

        private MavenProject maven;

    }
}
