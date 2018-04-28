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
package org.devacfr.testing;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.devacfr.testing.util.Approvals;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestName;

public class TestCase extends Assert {

    @Rule
    public TestName testNameRule = new TestName();

    /**
     * Gets the file system path representation of this test class.
     *
     * @return Returns {@code String} representing the file system location path of this test class.
     */
    @Nonnull
    public final Path getPackagePath() {
        return Paths.get(getPackagePath(this.getClass()));
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

    /**
     * @param location
     * @param actual
     * @throws IOException
     */
    public void verify(@Nullable final String actual) {
        Approvals.verify(getPackagePath(), this.getClass(), testNameRule.getMethodName(), actual);
    }

    /**
     * @param location
     * @param actualFile
     * @throws IOException
     */
    public void verify(@Nonnull final Path actualFile) {
        Approvals.verify(getPackagePath(), this.getClass(), testNameRule.getMethodName(), actualFile);
    }

    /**
     * @param suffix
     * @param actual
     * @throws IOException
     */
    public void verify(@Nonnull final String suffix, @Nullable final String actual) {
        Approvals.verify(getPackagePath(), this.getClass(), testNameRule.getMethodName() + '.' + suffix, actual);
    }

    /**
     * @param suffix
     * @param actual
     * @throws IOException
     */
    public void verify(@Nonnull final String suffix, @Nullable final Path actualFile) {
        Approvals.verify(getPackagePath(), this.getClass(), testNameRule.getMethodName() + '.' + suffix, actualFile);
    }
}
