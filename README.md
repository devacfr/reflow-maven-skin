[![Build Status](https://travis-ci.org/devacfr/reflow-maven-skin.svg?branch=master)](https://travis-ci.org/devacfr/reflow-maven-skin)

# [Reflow Maven skin]( http://devacfr.github.io/reflow-maven-skin/v2 )

Reflow is an Apache Maven site skin built on [Bootstrap 4][bootstrap]. It allows various structural
and stylistic customizations to create a modern-looking Maven-generated website.

To get started and see how the skin looks by default, check out
http://devacfr.github.io/reflow-maven-skin/v2!

> **Reflow supported version**
>
> - **1.5.0** - using Bootrap 3, http://devacfr.github.io/reflow-maven-skin
> - **2.0.0-beta1** - built in on Bootrap 4, http://devacfr.github.io/reflow-maven-skin/v2

[bootstrap]: http://getbootstrap.com

## Usage

To use this Maven skin, include it in your `site.xml` file:

```xml
<project>
  ...
  <skin>
    <groupId>io.github.devacfr.maven.skins</groupId>
    <artifactId>reflow-maven-skin</artifactId>
    <version>2.0.0-beta1</version>
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
          <version>2.0.0-beta1</version>
        </dependency>
        ...
      </dependencies>
      ...
    </plugin>
    ...
  </plugins>
</build>
```

The skin is provided on the "works on my computer" basis at the moment. I am using the newest
versions of `maven-site-plugin` and other components and at the moment do not have any feedback
on using the skin with Maven 2 site or other configurations.


### Configuration

The skin is configurable using the `<custom><reflowSkin>` element in your `site.xml` file.
Refer to [documentation][reflow-config] for all configuration options.

[reflow-config]: http://devacfr.github.io/reflow-maven-skin/v2/skin/config.html

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
                    <version>2.0.0</version>
                    <type>jar</type>
                    <overWrite>false</overWrite>
                    <includes>
                        **/css/bootstrap.min.css,
                        **/fonts/*,
                        **/js/*.js,
                        **/js/languages/*,
                        **/js/styles/github.min.css
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

[reflow-multi-modules]: https://devacfr.github.io/reflow-maven-skin/skin/v2/multi-module.html

## Bug tracker

Have a bug or a feature request? Please create an issue here on GitHub that conforms with
[necolas's guidelines](http://github.com/necolas/issue-guidelines).

http://github.com/devacfr/reflow-maven-skin/issues


## Contributing

Fork the repository and submit pull requests on **develop** branch. Reflow use gitflow workflow to define a strict branching model designed around the project release (see [Release Management Documentation][release-management] for more information).

    Pull request on master will be refused.


## Author

**Andrius Velykis**

+ http://andrius.velykis.lt
+ http://github.com/andriusvelykis

**Christophe Friederich**

+ http://devacfr.github.io/


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
