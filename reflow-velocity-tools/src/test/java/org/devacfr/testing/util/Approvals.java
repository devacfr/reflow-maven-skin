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

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.text.IsEqualIgnoringWhiteSpace;
import org.junit.Assert;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

/**
 * @author Christophe Friederich
 * @since 1.0
 */
public final class Approvals {

    private Approvals() {
        throw new UnsupportedOperationException();
    }

    /**
     *
     * @param location  path location of actual fil.
     * @param testClass the executed test class.
     * @param testName  the testname
     * @return
     * @throws IOException
     */
    public static String getActualResource(@Nonnull final Path location, @Nonnull final Class<?> testClass,
            @Nonnull final String testName) {
        final String fileName = String.format("%s.%s.actual", testClass.getSimpleName(), testName);
        return readFile(location.resolve(fileName));
    }

    /**
     *
     * @param location  path location of expected file.
     * @param testClass the executed test class.
     * @param testName  the testname
     * @return
     * @throws IOException
     */
    public static String getExpectedResource(@Nonnull final Path location, @Nonnull final Class<?> testClass,
            @Nonnull final String testName) {
        final String fileName = String.format("%s.%s.approved", testClass.getSimpleName(), testName);
        return readFile(location.resolve(fileName));
    }

    /**
     * Verify the {@code actual} text is equals to expected text stored in file
     * [testClass].[testName].approved.
     *
     * @param location  path location of expected file.
     * @param testClass the executed test class.
     * @param testName  the testname
     * @param actual    the actual value to test
     */
    public static void verify(@Nonnull final Path location, @Nonnull final Class<?> testClass,
            @Nonnull final String testName, @Nullable final String actual) {
        final String expected = getExpectedResource(location, testClass, testName);
        Assert.assertThat(actual, IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace(expected));
    }

    public static void verify(@Nonnull final Path location, @Nonnull final Class<?> testClass,
            @Nonnull final String testName, Function<String, String> transform) {
        String actual = getActualResource(location, testClass, testName);
        if (actual != null && transform != null) {
            actual = transform.apply(actual);
        }
        final String expected = getExpectedResource(location, testClass, testName);
        Assert.assertThat(actual, IsEqualIgnoringWhiteSpace.equalToIgnoringWhiteSpace(expected));
    }

    /**
     * Verify the {@code actual} text is equals to expected text stored in file
     * [testClass].[testName].approved.
     *
     * @param location   path location of expected file.
     * @param testClass  the executed test class.
     * @param testName   the testname
     * @param actualFile the actual value stored in file to test
     */
    public static void verify(@Nonnull final Path location, @Nonnull final Class<?> testClass,
            @Nonnull final String testName, @Nonnull final Path actualFile) {

        verify(location, testClass, testName, readFile(location.resolve(actualFile)));

    }

    private static String readFile(final Path path) {
        try {
            return Resources.toString(Resources.getResource(path.toString()), Charsets.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}
