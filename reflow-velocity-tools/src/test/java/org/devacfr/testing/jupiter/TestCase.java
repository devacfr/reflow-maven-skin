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
package org.devacfr.testing.jupiter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.devacfr.testing.util.Approvals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import com.google.common.io.ByteSource;
import com.google.common.io.Resources;

public class TestCase extends Assertions {

    private TestInfo testInfo;

    @BeforeEach
    public final void beforeEachMethod(final TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * Gets the file system path representation of this test class.
     *
     * @return Returns {@code String} representing the file system location path of this test class.
     */
    @Nonnull
    public final Path getPackagePath() {
        return Paths.get(getPackagePath(this.getClass()));
    }

    public ByteSource getResource(final String filename) {
        return Resources.asByteSource(Resources.getResource(getPackagePath().resolve(filename).toString()));
    }

    /**
     * Gets the file system path representation of this test class.
     *
     * @param testClass
     *            test class to use.
     * @return Returns {@code String} representing the file system location path of this test class.
     */
    @Nonnull
    public static final String getPackagePath(@Nonnull final Class<?> testClass) {
        return testClass.getPackage().getName().replace('.', '/');
    }

    public String getActualResource() {
        return Approvals.getActualResource(getPackagePath(), this.getClass(), getMethodName(), null);
    }

    public String getExpectedResource() {
        return Approvals.getExpectedResource(getPackagePath(), this.getClass(), getMethodName(), null, null);
    }

    public String getActualResource(final String suffix) {
        return Approvals.getActualResource(getPackagePath(), this.getClass(), getMethodName(), suffix);
    }

    public String getExpectedResource(final String suffix) {
        return Approvals.getExpectedResource(getPackagePath(), this.getClass(), getMethodName(), suffix, null);
    }

    public String getExpectedResource(final String suffix, final Function<String, String> transformer) {
        return Approvals.getExpectedResource(getPackagePath(), this.getClass(), getMethodName(), suffix, transformer);
    }

    public void verify() {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), (Function<String, String>) null, null);
    }

    /**
     * @param suffix
     */
    public void verify(final String suffix) {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), (Function<String, String>) null, suffix);
    }

    public void verify(final Function<String, String> transform) {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), transform, null);
    }

    /**
     * @param transform
     */
    public void verify(final Function<String, String> transform, @Nullable final String suffix) {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), transform, suffix);
    }

    /**
     * @param location
     * @param actual
     * @throws IOException
     */
    public void verify(@Nullable final String actual, @Nullable final String suffix) {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), actual, suffix);
    }

    /**
     * @param location
     * @param actualFile
     * @throws IOException
     */
    public void verify(@Nonnull final Path actualFile, @Nullable final String suffix) {
        Approvals.verify(getPackagePath(), this.getClass(), getMethodName(), actualFile, suffix);
    }

    private String getMethodName() {
        if (testInfo == null) {
            return null;
        }
        return this.testInfo.getTestMethod().get().getName();
    }

}
