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
package org.devacfr.maven.skins.reflow.snippet;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.maven.doxia.macro.AbstractMacro;
import org.apache.maven.doxia.macro.Macro;
import org.apache.maven.doxia.macro.MacroExecutionException;
import org.apache.maven.doxia.macro.MacroRequest;
import org.apache.maven.doxia.sink.Sink;
import org.codehaus.plexus.PlexusConstants;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.component.annotations.Component;
import org.codehaus.plexus.context.Context;
import org.codehaus.plexus.context.ContextException;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Contextualizable;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

/**
 * @author Christophe Friederich
 * @since 2.4
 */
@Component(role = Macro.class, hint = "template")
public class TemplateMacro extends AbstractMacro implements Contextualizable {

    /** */

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateMacro.class);

    /** */
    @SuppressWarnings("unused")
    private PlexusContainer container;

    /**
     * in case of Exception during snippet download error will ignored and empty content returned.
     */
    private final boolean ignoreDownloadError = true;

    @Override
    public void contextualize(final Context context) throws ContextException {
        container = (PlexusContainer) context.get(PlexusConstants.PLEXUS_KEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Sink sink, final MacroRequest request) throws MacroExecutionException {
        final String filePath = (String) request.getParameter("file");
        String encoding = (String) request.getParameter("encoding");

        File file;

        if (Strings.isNullOrEmpty(encoding)) {
            encoding = Charsets.UTF_8.name();
        }

        if (!Strings.isNullOrEmpty(filePath)) {
            file = new File(filePath);

            if (!file.isAbsolute()) {
                file = new File(request.getBasedir(), filePath);
            }
        } else {
            throw new IllegalArgumentException("The 'file' param has to be given.");
        }

        try {
            sink.rawText(getSnippet(file, encoding));
        } catch (final IOException e) {
            throw new MacroExecutionException("Error reading snippet", e);
        }

    }

    private String getSnippet(final File file, final String encoding) throws IOException {
        try {
            return convertSnippet(Files.asByteSource(file).asCharSource(Charset.forName(encoding)));

        } catch (final IOException e) {
            if (ignoreDownloadError) {
                getLog().debug("IOException which reading " + file + ": " + e);
                return "Error during retrieving content skip as ignoreDownloadError activated.";
            } else {
                throw e;
            }

        }
    }

    String convertSnippet(final CharSource source) throws IOException {
        final String src = source.read();
        final Document doc = Jsoup.parse(src);
        return new ComponentResolver().normalize(doc).html();
    }

}