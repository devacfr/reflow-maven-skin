# Migration to v2

Reflow is a major rewrite of the entire project. The most notable changes are summarized below, followed by more specific changes to relevant components.

## Stable changes

Moving from v1 to stable v2 release, there are no breaking changes, but there are some notable changes.

### Upgrade to Bootstrap v4

See [Bootstrap Migration to v4][bootstrap-migration] for a complete informatin on changes.

- Dropped the Glyphicons icon font, use Font Awesome free 5.2.
- Remove `<bootstrapCSS>` element
- Remove `<navbarInverse>` element, replace by `cssClass` attribute (see [Navbar component](#migration_toc_navbar_component)
- Dropped the Affix jQuery plugin, replaced by position `sticky` (can remove all affix css).

#### Bootswatch Themes

- Add new themes. <span class="badge badge-secondary">MISSING DOC</span>
- Remove `reflow-maven-skin/src/main/resources/css/bootswatch.css`

#### Using customized Bootstrap

- Remove `css/bootstrap-responsive.min.css` link
- Remove `js/html5.js` link
- Add css/bootstrap-theme.min.css

### Documentary support

### Local resources

- Add new 'reflow-default-webdeps' module containing all required web dependencies to work locally.

#### Using default Bootstrap theme

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
                <version>${project.version}</version>
                <type>jar</type>
                <overWrite>false</overWrite>
                <includes>
                **/css/*, <!-- add bootstrap and awesome font -->
                **/js/*.js,  <!-- add all javascripts -->
                **/js/languages/*,  <!-- add all highlight languages -->
                **/js/styles/default.min.css <!-- add 'default' highlight style -->
                </includes>
            </artifactItem>
            </artifactItems>
            <outputDirectory>${main.basedir}/target/site</outputDirectory>
        </configuration>
        </execution>
    </executions>
</plugin>
```

**Note**: `${main.basedir}` equals to `${session.executionRootDirectory}` for relativize url (see https://devacfr.github.io/reflow-maven-skin/skin/multi-module.html )

#### Using Bootswatch theme

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
                <version>${project.version}</version>
                <type>jar</type>
                <overWrite>false</overWrite>
                <includes>
                **/css/fontawesome/*, <!-- add all awesome -->
                **/css/themes/cerulean/*.css, <!-- add specific theme -->
                **/js/*.js,  <!-- add all javascripts -->
                **/js/languages/*,  <!-- add all highlight languages -->
                **/js/styles/default.min.css <!-- add 'default' highlight style -->
                </includes>
            </artifactItem>
            </artifactItems>
            <outputDirectory>${main.basedir}/target/site</outputDirectory>
        </configuration>
        </execution>
    </executions>
</plugin>
```


### By component

This list highlights key changes by component between v1.4 and v2.0.0.

#### TOC topbar component

```xml
<toc cssClass="navbar-dark bg-dark border rounded|bootstrap classes" numberItems="number|-1" flatten="false|true">top</toc>
```

- Add ccsClass attribute (default value `navbar-dark bg-dark border rounded`) to `<toc>` element.
- Replace `tocTopMax` element by `numberItems` attribute to `<toc>` element.
- Replace `tocTopFlatten` element by `flatten` attribute to `<toc>` element.

#### TOC sidebar component

```xml
<toc position="fixed|relative" >sidebar</toc>
```

- Change `type` attribure by `position` attribute.
- Replace `static` option of `position` attribute by `relative`.

#### Navbar component

```xml
<navbar cssClass="navbar-light bg-light border-bottom|bootstrap classes">
```

- Add `cssClass` attribute (default value `navbar-light bg-light border-bottom`)

[bootstrap-migration]: https://getbootstrap.com/docs/4.1/migration
