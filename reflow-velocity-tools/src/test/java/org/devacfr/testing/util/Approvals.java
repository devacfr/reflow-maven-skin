/*
 * Copyright 2018 Christophe Friederich
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
package org.devacfr.testing.util;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Matchers;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Resources;

/**
 * @author Christophe Friederich
 * @since 1.0
 */
public final class Approvals {

    public static final Function<String, String> REMOVE_CARRIAGE_RETURN_LINEFEED = (text) -> text.replaceAll("\r", "");

    private Approvals() {
        throw new UnsupportedOperationException();
    }

    /**
     * @param location
     *            path location of actual fil.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the testname
     * @param suffix
     *            the suffix
     * @return
     * @throws IOException
     */
    public static String getActualResource(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String suffix) {
        final String suf = !Strings.isNullOrEmpty(suffix) ? suffix : "";
        final String fileName = String.format("%s.%s.actual%s", testClass.getSimpleName(), testName, suf);
        return readFile(location.resolve(fileName));
    }

    /**
     * @param location
     *            path location of expected file.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the testname
     * @param suffix
     *            the suffix
     * @return
     * @throws IOException
     */
    public static String getExpectedResource(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String suffix,
        final Function<String, String> transformer) {
        final String suf = !Strings.isNullOrEmpty(suffix) ? suffix : "";
        final String fileName = String.format("%s.%s.approved%s", testClass.getSimpleName(), testName, suf);
        final String text = Approvals.REMOVE_CARRIAGE_RETURN_LINEFEED.apply(readFile(location.resolve(fileName)));
        if (transformer != null) {
            return transformer.apply(text);
        }
        return text;
    }

    /**
     * Verify the {@code actual} text is equals to expected text stored in file [testClass].[testName].approved.
     *
     * @param location
     *            path location of expected file.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the testname
     * @param actual
     *            the actual value to test
     */
    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String actual,
        @Nullable final String suffix) {
        final String expected = getExpectedResource(location, testClass, testName, suffix, null);
        assertThat(actual, equalToCompressingWhiteSpace(expected));
    }

    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        final Function<String, String> transform,
        @Nullable final String suffix) {
        String actual = getActualResource(location, testClass, testName, suffix);
        if (actual != null && transform != null) {
            actual = transform.apply(actual);
        }
        final String expected = getExpectedResource(location, testClass, testName, suffix, null);
        assertThat(actual, Matchers.equalToCompressingWhiteSpace(expected));
    }

    /**
     * Verify the {@code actual} text is equals to expected text stored in file [testClass].[testName].approved.
     *
     * @param location
     *            path location of expected file.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the testname
     * @param actualFile
     *            the actual value stored in file to test
     * @param suffix
     *            the suffix
     */
    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nonnull final Path actualFile,
        @Nullable final String suffix) {

        verify(location, testClass, testName, readFile(location.resolve(actualFile)), suffix);

    }

    private static String readFile(final Path path) {
        try {
            return Resources.toString(Resources.getResource(path.toString()), Charsets.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
