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

import java.io.File;
import java.net.MalformedURLException;

import org.apache.maven.model.DistributionManagement;

/**
 * @author Christophe Friederich
 * @since 2.0
 */
public final class DecorationHelper {

    private DecorationHelper() {
        throw new UnsupportedOperationException();
    }

    /**
     * @param distMgmnt
     *            distribution Management
     * @return Returns distributionManagement.site.url if defined, null otherwise.
     */
    public static String getDistMgmntSiteUrl(final DistributionManagement distMgmnt) {
        if (distMgmnt != null && distMgmnt.getSite() != null && distMgmnt.getSite().getUrl() != null) {
            return urlEncode(distMgmnt.getSite().getUrl());
        }

        return null;
    }

    private static String urlEncode(final String url) {
        if (url == null) {
            return null;
        }

        try {
            return new File(url).toURI().toURL().toExternalForm();
        } catch (final MalformedURLException ex) {
            return url; // this will then throw somewhere else
        }
    }
}
