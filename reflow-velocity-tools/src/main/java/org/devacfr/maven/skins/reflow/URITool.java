/*
 * Copyright 2012-2018 Christophe Friederich
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

import java.net.URI;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.maven.doxia.site.decoration.inheritance.URIPathDescriptor;
import org.apache.velocity.tools.config.DefaultKey;

import com.google.common.base.Strings;

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
     * @return
     */
    public static URLRebaser createURLRebaser(final String parentBaseUrl, final String childBaseUrl) {
        return new URLRebaser(parentBaseUrl, childBaseUrl);
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

    /**
     * URL rebaser: based on an old and a new path, can rebase a link based on old path to a value based on the new
     * path.
     */
    public static class URLRebaser {

        /** */
        private final String oldPath;

        /** */
        private final String newPath;

        /**
         * Construct a URL rebaser.
         *
         * @param oldPath
         *            the old path.
         * @param newPath
         *            the new path.
         */
        URLRebaser(final String oldPath, final String newPath) {
            this.oldPath = oldPath;
            this.newPath = newPath;
        }

        /**
         * Get the new path.
         *
         * @return the new path.
         */
        public String getNewPath() {
            return this.newPath;
        }

        /**
         * Get the old path.
         *
         * @return the old path.
         */
        public String getOldPath() {
            return this.oldPath;
        }

        /**
         * Rebase only affects relative links, a relative link wrt an old base gets translated, so it points to the same
         * location as viewed from a new base.
         *
         * @param link
         *            link to rebase
         * @return Returns a {@link String} representing link rebased.
         */
        public String rebaseLink(final String link) {
            if (link == null || getOldPath() == null) {
                return link;
            }

            if (link.contains("${project.")) {
                throw new IllegalArgumentException("site.xml late interpolation ${project.*} expression found"
                        + " in link: '" + link + "'. Use early interpolation ${this.*}");
            }

            final URIPathDescriptor oldPath = new URIPathDescriptor(getOldPath(), link);

            return oldPath.rebaseLink(getNewPath()).toString();
        }
    }
}
