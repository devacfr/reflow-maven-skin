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
import java.io.StringReader;
import java.nio.file.Path;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.hamcrest.TypeSafeMatcher;

import com.cloudbees.diff.Diff;
import com.cloudbees.diff.provider.BuiltInDiffProvider;
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
     * @param extension
     *            the extension file
     * @return
     * @throws IOException
     */
    public static String getActualResource(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String extension) {
        final String suf = !Strings.isNullOrEmpty(extension) ? "." + extension : "";
        final String fileName = String.format("%s.%s.actual%s", testClass.getSimpleName(), testName, suf);
        return readFile(location.resolve(fileName));
    }

    /**
     * @param location
     *            path location of expected file.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the testname.
     * @param extension
     *            the extension file.
     * @return
     * @throws IOException
     */
    public static String getExpectedResource(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String extension,
        final Function<String, String> transformer) {
        final String ext = !Strings.isNullOrEmpty(extension) ? "." + extension : "";
        final String fileName = String.format("%s.%s.approved%s", testClass.getSimpleName(), testName, ext);
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
     *            the test name.
     * @param actual
     *            the actual value to test.
     * @param extension
     *            the extension file.
     */
    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nullable final String actual,
        @Nullable final String extension) {
        final String expected = getExpectedResource(location, testClass, testName, extension, null);
        assertThat(actual, equalToCompressingWhiteSpace(expected));
    }

    /**
     * Verify the {@code actual} text is equals to expected text stored in file [testClass].[testName].approved.
     *
     * @param location
     *            path location of expected file.
     * @param testClass
     *            the executed test class.
     * @param testName
     *            the test name
     * @param transform
     *            transform function
     * @param extension
     *            the extension file.
     */
    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        final Function<String, String> transform,
        @Nullable final String extension) {
        String actual = getActualResource(location, testClass, testName, extension);
        if (actual != null && transform != null) {
            actual = transform.apply(actual);
        }
        final String expected = getExpectedResource(location, testClass, testName, extension, null);

        final Matcher<String> matcher = IsEqualCompressingWhiteSpace.equalToCompressingWhiteSpace(expected);
        if (!matcher.matches(actual)) {
            final Description description = new StringDescription();
            matcher.describeMismatch(actual, description);

            throw new AssertionError(description.toString());
        }

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
     * @param extension
     *            the extension file
     */
    public static void verify(@Nonnull final Path location,
        @Nonnull final Class<?> testClass,
        @Nonnull final String testName,
        @Nonnull final Path actualFile,
        @Nullable final String extension) {

        verify(location, testClass, testName, readFile(location.resolve(actualFile)), extension);

    }

    private static String readFile(final Path path) {
        try {
            return Resources.toString(Resources.getResource(path.toString()), Charsets.UTF_8);
        } catch (final IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static class IsEqualCompressingWhiteSpace extends TypeSafeMatcher<String> {

        // TODO: Replace String with CharSequence to allow for easy interoperability between
        // String, StringBuffer, StringBuilder, CharBuffer, etc (joe).

        private final String string;

        public IsEqualCompressingWhiteSpace(final String string) {
            if (string == null) {
                throw new IllegalArgumentException("Non-null value required");
            }
            this.string = string;
        }

        @Override
        public boolean matchesSafely(final String item) {
            return stripSpaces(string).equals(stripSpaces(item));
        }

        @Override
        public void describeMismatchSafely(final String item, final Description mismatchDescription) {
            mismatchDescription.appendText(getInternalDiff(item, string));
        }

        @Override
        public void describeTo(final Description description) {
            description.appendText("a string equal to ").appendValue(string).appendText(" compressing white space");
        }

        public String stripSpaces(final String toBeStripped) {
            return toBeStripped.replaceAll("\\s+", " ").trim();
        }

        public static Matcher<String> equalToCompressingWhiteSpace(final String expectedString) {
            return new IsEqualCompressingWhiteSpace(expectedString);
        }

        private String getInternalDiff(final String expected, final String actual) {
            final BuiltInDiffProvider provider = new BuiltInDiffProvider();
            Diff diffs = null;
            try {
                diffs = provider.computeDiff(new StringReader(actual), new StringReader(expected));
                return diffs
                        .toUnifiedDiff("actual", "expected", new StringReader(actual), new StringReader(expected), 3);
            } catch (final IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }

        }

    }

}
