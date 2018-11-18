<!---
 Licensed to the Apache Software Foundation (ASF) under one or more
 contributor license agreements.  See the NOTICE file distributed with
 this work for additional information regarding copyright ownership.
 The ASF licenses this file to You under the Apache License, Version 2.0
 (the "License"); you may not use this file except in compliance with
 the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
-->

[![Apache License, Version 2.0](https://img.shields.io/github/license/apache/maven.svg?label=License)][license]
[![Build Status](https://travis-ci.org/devacfr/reflow-maven-skin.svg?branch=master)](https://travis-ci.org/devacfr/reflow-maven-skin)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.devacfr.maven.skins/reflow-maven-skin.svg)][maven-repo]

[![Gitter](https://badges.gitter.im/Join%20In.svg)][gitter]

[license]: https://www.apache.org/licenses/LICENSE-2.0
[maven-repo]: http://mvnrepository.com/artifact/io.github.devacfr.maven.skins/reflow-maven-skin
[gitter]: https://gitter.im/reflow-maven-skin/public

# Reflow Maven skin

Reflow is an Apache Maven site skin built on [Bootstrap 4][bootstrap]. It allows various structural
and stylistic customizations to create a modern-looking Maven-generated website and documentatin generation.

To get started and see how the skin looks by default, check out [reflow-maven-skin][reflow]!

[reflow]: http://devacfr.github.io/reflow-maven-skin/
[migration]: http://devacfr.github.io/reflow-maven-skin/reflow-maven-skin/reflow-documentation.html#migration.html
[bootstrap]: http://getbootstrap.com

## Usage

To use this Maven skin, include it in your `site.xml` file:

```xml
<project>
  ...
  <skin>
    <groupId>io.github.devacfr.maven.skins</groupId>
    <artifactId>reflow-maven-skin</artifactId>
    <version>2.0.0-beta2</version>
  </skin>
  ...
</project>
```

The skin requires accompanying Reflow Velocity tools (`reflow-velocity-tools`) to be available when
generating Maven site. Add them as a dependency to `maven-site-plugin` in your POM file:

```xml
<build>
  <plugins>
    ...
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-site-plugin</artifactId>
      <version>3.7.1</version>
      <dependencies>
        ...
        <dependency>
          <groupId>io.github.devacfr.maven.skins</groupId>
          <artifactId>reflow-velocity-tools</artifactId>
          <version>2.0.0-beta2</version>
        </dependency>
        ...
      </dependencies>
      ...
    </plugin>
    ...
  </plugins>
</build>
```

### Configuration

The skin is configurable using the `<custom><reflowSkin>` element in your `site.xml` file.
Refer to [documentation][reflow-config] for all configuration options.

[reflow-config]: https://devacfr.github.io/reflow-maven-skin/reflow-maven-skin/reflow-documentation.html#get-started_toc_configuration

A sample configuration file is given below:

```xml
<project>
  ...
  <custom>
    <reflowSkin>
      <theme>bootswatch-spacelab</theme>
      <brand>
        <name>My Project</name>
        <href>http://devacfr.github.io/reflow-maven-skin/</href>
      </brand>
      <slogan>Super interesting project doing good things.</slogan>
      <titleTemplate>%2$s | %1$s</titleTemplate>
      <toc>top</toc>
      <navbar filterMenu="Download|reports" />
      <bottomNav>
        <column>Main|Download</column>
        <column>Documentation</column>
        <column>reports|modules</column>
      </bottomNav>
      <bottomDescription>This is a very good project doing interesting
        and valuable things.</bottomDescription>
      <pages>
        <index project="project-id">
          <shortTitle>Welcome</shortTitle>
          <breadcrumbs>false</breadcrumbs>
          <toc>false</toc>
          <sections>
            <carousel />
            <body />
            <sidebar />
            <thumbs>2</thumbs>
            <columns>3</columns>
          </sections>
        </index>
        <developer-info>
          <toc>sidebar</toc>
        </developer-info>
      </pages>
    </reflowSkin>
  </custom>
  ...
</project>
```

Note that when using `<localResources>`, you need to provide the necessary local versions of
Bootstrap and jQuery files. Reflow skin provides package containing the default web dependencies files in module `reflow-default-webdeps`. this package should be unpack as following example:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <executions>
        <execution>
        <id>unpack</id>
        <phase>pre-site</phase>
        <goals>
            <goal>unpack</goal>
        </goals>
        <configuration>
            <artifactItems>
                <artifactItem>
                    <groupId>io.github.devacfr.maven.skins</groupId>
                    <artifactId>reflow-default-webdeps</artifactId>
                    <version>2.0.0-beta1</version>
                    <type>jar</type>
                    <overWrite>false</overWrite>
                    <includes>
                        **/css/bootstrap.min.css, <!-- can be remove if use bootswatch theme-->
                        **/css/fontawesome/**/*,
                        **/css/themes/flaty/*.css, <!-- use flaty bootswatch theme-->
                        **/js/*.js,
                        **/js/languages/*,
                        **/js/styles/github.min.css <!-- use github highlight theme-->
                    </includes>
                </artifactItem>
            </artifactItems>
            <outputDirectory>${main.basedir}/site</outputDirectory>
        </configuration>
        </execution>
    </executions>
</plugin>
```

**Note**: `${main.basedir}` equals to `${session.executionRootDirectory}` for relativize url (see  [Multi-module site][reflow-multi-modules] documentation)

[reflow-multi-modules]: https://devacfr.github.io/reflow-maven-skin/reflow-maven-skin/reflow-documentation.html#multi-module.html

## Site Deployment

Use following command to deploy site.

```bash
$ ./mvnw clean package site site:stage scm-publish:publish-scm
```

## Bug tracker

Have a bug or a feature request? Please create an issue here on GitHub that conforms with
[necolas's guidelines](http://github.com/necolas/issue-guidelines).

[http://github.com/devacfr/reflow-maven-skin/issues](http://github.com/devacfr/reflow-maven-skin/issues)

## Contributing

Fork the repository and submit pull requests on **develop** branch. Reflow use gitflow workflow to define a strict branching model designed around the project release (see [Release Management Documentation][release-management] for more information).

> Pull request on master will be refused.

## Author

**Andrius Velykis**

- [http://andrius.velykis.lt](http://andrius.velykis.lt)
- [http://github.com/andriusvelykis](http://github.com/andriusvelykis)

**Christophe Friederich**

- [http://devacfr.github.io/](http://devacfr.github.io/)

## Copyright and license

Copyright 2012-2018 Christophe Friederich

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this work except in compliance with the License.
You may obtain a copy of the License in the LICENSE file, or at:

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

[release-management]: http://devacfr.github.io/maven-config/doc/contribute.html#Release_Management
