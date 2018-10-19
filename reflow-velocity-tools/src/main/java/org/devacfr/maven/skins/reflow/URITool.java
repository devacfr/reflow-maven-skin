/*
 * Copyright 2018 Christophe Friederich
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.devacfr.maven.skins.reflow;

import java.net.URI;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Strings;

import org.apache.maven.doxia.site.decoration.inheritance.URIPathDescriptor;
import org.apache.velocity.tools.config.DefaultKey;

/**
 * An Apache Velocity tool that provides utility methods to work with URIs/URLs and links.
 *
 * @author Andrius Velykis
 * @since 1.0
 */
// instancied by Velocity
@SuppressWarnings({ "checkstyle:finalclass", "checkstyle:hideutilityclassconstructor" })
@DefaultKey("uriTool")
public class URITool {

    /**
     * Resolves the link as relative to the base dir URI.
     * <p>
     * Relativizes only absolute links, if the link has the same scheme, host and port as the base, it is made into a
     * relative link as viewed from the base.
     * </p>
     * <p>
     * This is the same method that's used to relativize project links in Maven site.
     * </p>
     *
     * @param baseDirUri
     *            URI that will serve as the base to calculate the relative one
     * @param link
     *            The link to relativize (make it relative to the base URI if possible)
     * @return the relative link, if calculated, or the original link if not.
     * @since 1.0
     */
    @Nullable
    public static String relativizeLink(@Nonnull final String baseDirUri, @Nonnull final String link) {
        // taken from
        // org.apache.maven.doxia.site.decoration.inheritance.DecorationModelInheritanceAssembler

        if (link == null || baseDirUri == null) {
            return link;
        }
        try {
            final URIPathDescriptor path = new URIPathDescriptor(baseDirUri, link);
            return normalisedBaseUrl(path.relativizeLink().toString());
        } catch (final IllegalArgumentException e) {
            return link;
        }
    }

    /**
     * Creates a URI by parsing the given string.
     *
     * @param uri
     *            The string to be parsed into a URI
     * @return Returns the new URI.
     */
    @Nonnull
    public static URI toURI(@Nonnull final String uri) {
        return URI.create(uri);
    }

    /**
     * remove url path separator ('/') to the end of path.
     *
     * @param baseUrl
     *            a base url
     * @return Returns new <code>String</code> base path instance.
     */
    public static String normalisedBaseUrl(@Nonnull final String baseUrl) {
        if (Strings.isNullOrEmpty(baseUrl)) {
            return baseUrl;
        }
        if (baseUrl.endsWith("/")) {
            return baseUrl.substring(0, baseUrl.length() - 1);
        }

        return baseUrl;
    }
}
