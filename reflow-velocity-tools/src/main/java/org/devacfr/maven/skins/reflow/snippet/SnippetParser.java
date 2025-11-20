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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.apache.commons.io.FilenameUtils;
import org.apache.velocity.context.Context;
import org.devacfr.maven.skins.reflow.ISkinConfig;
import org.devacfr.maven.skins.reflow.JsoupUtils;
import org.devacfr.maven.skins.reflow.snippet.Processor.WebComponentProcessor;
import org.devacfr.maven.skins.reflow.snippet.SnippetContext.SnippetResource;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.QueryParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Christophe Friederich
 * @version 2.4
 */
public class SnippetParser {

  /** */
  private static final Logger LOGGER = LoggerFactory.getLogger(SnippetParser.class);

  /** */
  private static final List<String> DEFAULT_PATHS = Lists.newArrayList("src/site/layouts/snippets",
    "META-INF/skin/snippets");

  /** */
  private final ComponentResolver resolver;

  /** */
  private final ArrayList<ComponentToken> stack;

  /** */
  private Iterator<Element> it;

  /** */
  private Processor state = null;

  /** */
  private final Processor processor;

  /** */
  private final SnippetContext snippetContext;

  /** */
  private ComponentToken currentToken;

  /** */
  private final List<String> snippetPaths = Lists.newArrayList(DEFAULT_PATHS);

  /** */
  private final Map<String, SnippetResource> snippetResources = Maps.newHashMap();

  public SnippetParser() {
    stack = Lists.newArrayListWithCapacity(32);
    snippetContext = new SnippetContext(this);
    resolver = new ComponentResolver(this);
    processor = new WebComponentProcessor(this);
    snippetResources.putAll(loadSnippetResources(getSnippetPaths()));
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Loaded {} snippet resources: {}", snippetResources.size(), getSnippets());
    }
  }

  @Nonnull
  protected Map<String, SnippetResource> getSnippetResources() {
    return Collections.unmodifiableMap(snippetResources);
  }

  @Nonnull
  protected List<String> getSnippets() {
    return snippetResources.keySet().stream().collect(Collectors.toList());
  }

  @Nonnull
  public List<String> getSnippetPaths() {
    return Collections.unmodifiableList(snippetPaths);
  }

  public SnippetParser insertResourcePath(final @Nonnull String path, final int index) {
    this.snippetPaths.add(index, path);
    return this;
  }

  public SnippetParser addResourcePath(final @Nonnull String path) {
    this.snippetPaths.add(path);
    return this;
  }

  public SnippetParser refreshParser() {
    snippetResources.clear();
    snippetResources.putAll(loadSnippetResources(getSnippetPaths()));
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Reloaded {} snippet resources: {}", snippetResources.size(), getSnippets());
    }
    return this;
  }

  public boolean isSnippet(final Node node) {
    return getSnippets().stream().anyMatch(snippet -> snippet.equalsIgnoreCase(JsoupUtils.getNodeName(node)));
  }

  /**
   * @param document
   *          the Jsoup element to use
   * @return Returns {@code true} if the document contains at least one snippet component.
   */
  public boolean hasIncludedSnippetComponent(final Element document) {
    final String tags = getSnippets().stream().collect(Collectors.joining(","));
    return Collector.findFirst(QueryParser.parse(tags), document) != null;
  }

  public SnippetContext parse(final ISkinConfig config, @Nullable String htmlSource) throws IOException {
    if (htmlSource == null) {
      htmlSource = "";
    }

    snippetContext.reset();
    snippetContext.setConfig(config);
    snippetContext.setHtmlSource(htmlSource);

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Parse Snippet");
      LOGGER.debug(htmlSource);
    }

    // find all snippets
    final Element doc = resolver.normalize(JsoupUtils.createHtmlDocument(htmlSource));

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Normalized HTML source:");
      LOGGER.debug(doc.html());
    }

    final Elements elements = resolver.collect(doc);

    for (it = elements.iterator(); it.hasNext();) {
      try {
        parse();
      } catch (final Exception ex) {
        throw new SnippetParseException(
            "error on parse token " + currentToken + " when generate file " + config.getFileId(), ex);
      }
    }
    snippetContext.setHtmlSource(doc.html());
    return snippetContext;
  }

  protected void parse() {
    if (!it.hasNext()) {
      throw new SnippetParseException("EOF");
    }
    final Element element = it.next();
    currentToken = resolver.create(element);
    if (currentToken == null) {
      throw new SnippetParseException("unknown component: " + element);
    }
    state = processor;
    parse(currentToken);
    currentToken = null;
  }

  protected void parse(final ComponentToken token) {
    state.parse(token);
  }

  protected ComponentToken currentToken() {
    final int size = stack.size();
    return size > 0 ? stack.get(size - 1) : null;
  }

  protected ComponentToken pop() {
    final int size = stack.size();
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Stack size befor pop: {}", size);
    }

    if (size == 0) {
      throw new SnippetParseException("Cannot pop from empty stack");
    }
    try {

      final ComponentToken element = stack.remove(size - 1);
      if (LOGGER.isDebugEnabled()) {
        LOGGER.debug("Remove component from stack: {}", element);
      }
      return element;
    } catch (final Exception e) {
      throw new SnippetParseException("Error while popping from stack", e);
    }
  }

  protected void push(final ComponentToken element) {
    stack.add(element);
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Add component to stack: {}", element);
    }
  }

  public SnippetContext getSnippetContext() {
    return snippetContext;
  }

  public Context getVelocityContext() {
    return this.snippetContext.getConfig().getVelocityContext();
  }

  private Map<String, SnippetResource> loadSnippetResources(final List<String> snippetPaths) {
    final Map<String, SnippetResource> resources = Maps.newHashMap();
    final List<String> paths = Lists.newArrayList(snippetPaths);
    Collections.reverse(paths);
    for (final String path : paths) {
      try {
        final List<String> files = getResources(path);
        for (final String file : files) {
          final SnippetResource resource = new SnippetResource(file, path + '/' + file);
          final String name = FilenameUtils.getBaseName(file);
          if (!name.startsWith("_")) {
            resources.put(name, resource);
          }
        }
      } catch (final Exception e) {
        LOGGER.warn("Cannot load snippet resources from path: {}", path, e);
      }
    }
    return resources;
  }

  /**
   * Get resource as stream.
   *
   * @param resource
   *          the resource
   * @return the resource as stream
   */
  private static List<String> getResources(final String path) throws Exception {
    final List<String> filenames = Lists.newArrayList();

    final URL url = getResource(path);
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Loading resources from path: {} (url={})", path, url);
    }
    if (url != null) {
      if (url.getProtocol().equals("file")) {
        final File file = Paths.get(url.toURI()).toFile();
        if (file != null) {
          final File[] files = file.listFiles();
          if (files != null) {
            for (final File filename : files) {
              filenames.add(filename.toString());
            }
          }
        }
      } else if (url.getProtocol().equals("jar")) {
        final String dirname = path + "/";
        final String p = url.getPath();
        final String jarPath = p.substring(5, p.indexOf("!"));
        try (JarFile jar = new JarFile(URLDecoder.decode(jarPath, StandardCharsets.UTF_8.name()))) {
          final Enumeration<JarEntry> entries = jar.entries();
          while (entries.hasMoreElements()) {
            final JarEntry entry = entries.nextElement();
            final String name = entry.getName();
            if (name.startsWith(dirname) && !dirname.equals(name)) {
              final URL resource = getResource(name);
              filenames.add(resource.toString());
            }
          }
        }
      }
    }
    if (LOGGER.isTraceEnabled()) {
      LOGGER.trace("Found {} resources ({}) in path: {}", filenames.size(), filenames, path);
    }
    return filenames;
  }

  private static URL getResource(final String resource) {
    final URL url = getContextClassLoader().getResource(resource);
    return url == null ? SnippetContext.class.getClassLoader().getResource(resource) : url;
  }

  /**
   * Get the context class loader.
   *
   * @return the context class loader
   */
  private static ClassLoader getContextClassLoader() {
    return Thread.currentThread().getContextClassLoader();
  }

}
