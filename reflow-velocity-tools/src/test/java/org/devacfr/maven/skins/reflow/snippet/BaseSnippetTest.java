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
package org.devacfr.maven.skins.reflow.snippet;

import java.sql.Date;
import org.apache.maven.doxia.site.Body;
import org.apache.maven.doxia.site.LinkItem;
import org.apache.maven.doxia.site.PublishDate;
import org.apache.maven.doxia.site.SiteModel;
import org.apache.maven.doxia.site.Version;
import org.apache.maven.project.MavenProject;
import org.apache.velocity.tools.ToolContext;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.context.PageContext;
import org.devacfr.maven.skins.reflow.context.PositionType;
import org.devacfr.testing.jupiter.MockitoTestCase;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;

public abstract class BaseSnippetTest extends MockitoTestCase {

  @Mock(lenient = true)
  protected ISkinConfig config;

  protected ToolContext velocityContext;

  protected SiteModel siteModel;

  protected PageContext context;

  @Mock(lenient = true)
  protected MavenProject mavenProject;

  @SuppressWarnings("unchecked")
  @BeforeEach
  public void setup() throws Exception {
    velocityContext = SnippetContext.createToolManaged().createContext();
    siteModel = new SiteModel();
    when(config.getSiteModel()).thenReturn(siteModel);
    when(config.getProject()).thenReturn(mavenProject);
    when(config.getVelocityContext()).thenReturn(velocityContext);
    when(config.getAttributeValue(any(String.class), any(String.class), any(Class.class), any())).then((a) -> {
      Object[] args = a.getArguments();
      return args[3];
    });
    when(config.getPropertyValue(any(String.class), any(Class.class), any())).then((a) -> {
      Object[] args = a.getArguments();
      return args[2];
    });
    when(config.relativeLink(any())).then((a) -> {
      Object[] args = a.getArguments();
      return args[0];
    });
    context = new PageContext(config);
    when(config.getContext()).thenReturn(context);
    when(config.getToolbox(any(), any())).then((a) -> {
      Object[] args = a.getArguments();
      return velocityContext.getToolbox().get(args[0]);
    });
    when(config.not("breadcrumbs")).thenReturn(false);
    PublishDate publishDate = new PublishDate();
    publishDate.setPosition(PositionType.none.toString());
    siteModel.setPublishDate(publishDate);
    when(config.getVersion()).thenReturn("1.0.0");
    when(config.getVersionMessage()).thenReturn("Version: 1.0.0");
    when(config.getBuildOutputTimestamp()).thenReturn(Date.valueOf("2025-11-16"));
    when(config.getPublishDateMessage()).thenReturn("Last Published: 2025-11-16");
    when(config.getShortTitle()).thenReturn("Documentation");
    Body body = new Body();
    Version version = new Version();
    version.setPosition(PositionType.none.toString());
    siteModel.setVersion(version);
    LinkItem linkItem = new LinkItem();
    linkItem.setName("Reflow");
    linkItem.setHref("../..");
    body.addBreadcrumb(linkItem);
    siteModel.setBody(body);
  }

  protected SnippetParser createParser() {
    return new SnippetParser().insertResourcePath(0, getPackagePath().toString());
  }
}
