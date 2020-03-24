# Other configuration

This page lists various general configuration options for Reflow Maven skin.

## Page title

### Generate or set short title

support {{< badge color="primary" text="v1.0" />}}<br/>
element {{< badge color="secondary" text="reflow" />}} {{< badge color="info" text="component" />}}

Short title is used in site breadcrumbs and other places. In some cases it is created by Maven site (e.g. when set in APT), etc. In other cases, however, it is missing - a glaring omission from Markdown pages.

Reflow skin provides a couple options to circumvent this, either generate or set the short title explicitly using `<shortTitle>` element:

```xml
<shortTitle>generate|*</shortTitle>
```

- **generate** - a short title will always be generated from the headings in the page. If `<h1>` heading is available, it is used. Otherwise first `<h2>` heading is used.
- **Some short title** - use this explicitly indicated short title
- **false** - disable any short title generation altogether
- **no `<shortTitle>` element (default)** - short title will be generated (as above) if one is not available

### Custom page title

support {{< badge color="primary" text="v1.0" />}}<br/>
element {{< badge color="secondary" text="reflow" />}} {{< badge color="info" text="component" />}}

By default, the page title is generated from the project name and its short title. The skin allows setting own page title, e.g. to allow for titles such as "_My Page | My Super Website_", etc.

```xml
<titleTemplate>template</titleTemplate>
```

- **Some template** - use [Java format String][java-format] here, where `%1$s` is the project name and `%2$s` is the short title of the page. This allows omitting any of these names, or just specifying custom uniform title for pages without any of the variables.
- **no `<titleTemplate>` element (default)** - default title template `%1$s - %2$s` is used

[java-format]: http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html

## Date and version

element {{< badge color="secondary" text="site.xml" />}}

Reflow skin supports displaying Maven site publish date and version. They are defined using standard Maven site elements [`<publishDate>`][mvn-site-date] and [`<version>`][mvn-site-version].

Reflow skin supports the following values for `position` of these components:

- **left** - Left in breadcrumbs bar (requires [`<breadcrumbs>` flag](#Breadcrumbs)
    to be enabled)
- **right** - Right in breadcrumbs bar (requires [`<breadcrumbs>` flag](#Breadcrumbs)
    to be enabled)
- **navigation-bottom** - Bottom right in the bottom navigation (requires [`<bottomDescription>`](#components-footer_toc_bottom-navigation) to be enabled)
- **bottom (default)** - Subfooter (the last part of the page, as in this website)
- **none** - Date or version are disabled

Note that **navigation-top** position is not supported by Reflow skin.

[mvn-site-date]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Publish_Date
[mvn-site-version]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Version

### Override publish date

element {{< badge color="secondary" text="site.xml" />}}

The website publish date can be indicated explicitly in the configuration by using `<publishDate>`
element:

```xml
<publishDate>2013-01-08</publishDate>
```

## Menus

Menus in Reflow skin can be placed both at the top navigation bar and at the bottom navigation columns. The menus themselves are defined as normally in Maven site, [using `<project><body><menu>` XML items][mvn-site-menus]. The skin allows customizing where which menu items are placed in the website.

Both top and bottom navigation allows specifying regular expressions that filter the menus to be displayed in the particular place. The regular expressions can match both the name of the menu item and its `ref` value, e.g. to match `<menu ref="modules" inherit="bottom" />`.

[mvn-site-menus]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Including_Generated_Content

### Links

element {{< badge color="secondary" text="site.xml" />}}

All links from defined in [`<body><links>` element][mvn-site-links] of `site.xml` site descriptor are placed in the top navigation bar. This allows having top-level links in navigation (menus are always drop-down).

[mvn-site-links]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Links

## JavaScript goodies

### Code highlight

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

Code highlighting can be provided for source code sections in pages using [highlight.js][highlight-js]. It detects the language automatically and provides code highlighting functionality. To enable it, use `<highlightJs>` flag:

```xml
<highlightJs>true|false</highlightJs>
```

- **true** - Source code is highlighted (syntax colouring) - requires JavaScript
- **false (default)** - Source code is displayed in fixed font without syntax colouring

Code highlighting theme can be changed to match your website theme. Available themes are listed in [highlight.js website][highlight-js-themes]. The theme can be selected using `<highlightJsTheme>` element:

```xml
<highlightJsTheme>default|*</highlightJsTheme>
```

- **default (default)** - Default code highlighting theme is used
- **theme name** - Entered theme is used

[highlight-js]: http://softwaremaniacs.org/soft/highlight/en/
[highlight-js-themes]: http://softwaremaniacs.org/media/soft/highlight/test.html#styleswitcher

### Image previews (lightbox)

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

Reflow skin enables CSS pop-ups for image links on the website using [Lightbox 2][lightbox]. See one in action by opening [this link to an image][lightbox-test]. The previews are enabled by default but can be disabled using `<imgLightbox>` flag:

```xml
<imgLightbox>true|false</imgLightbox>
```

- **true (default)** - when image link is opened in the website, opens a lightweight CSS pop-up
    with the image over the page
- **false** - disable lightbox, image link will open the image itself

[lightbox]: http://lokeshdhakar.com/projects/lightbox2/
[lightbox-test]: images/doc/snowdon.jpg "Lightbox example - climbing Snowdon in Wales, UK"

### Smooth scroll

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

Reflow skin enables smooth scrolling for in-page navigation (e.g. for table of contents links). Smooth scrolling can be disabled using `<smoothScroll>` flag:

```xml
<smoothScroll>true|false</smoothScroll>
```

- **true (default)** - smooth scrolling for in-page navigation (requires JavaScript)
- **false** - default in-page jumps

### Anchor Link (AnchorJS)

support {< badge color="primary" text="v2.3" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

Reflow skin enables deep anchor links heading elements in body section. AnchorJS can be disabled using `<anchorJS>` flag:

```xml
<anchorJS>true|false</anchorJS>
```

- **true (default)** - drop deep anchor links heading elements.
- **false** - disable AnchorJS.

## Bootstrap

The generated Maven site code is updated by default, e.g. update CSS of generated tables, use Bootstrap icons and other goodies. The flags to disable these updates are described below.

### Bootstrap CSS

[Bootstrap][bootstrap] provides nice CSS effects for certain elements, such as tables, etc. Reflow skin rewrites some Maven site generated elements to add Bootstrap classes and configurations.

[bootstrap]: http://twitter.github.com/bootstrap/

### Bootstrap icons

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

To match [Bootstrap][bootstrap] themes, Reflow skin replaces some icons used by Maven site with corresponding Bootstrap icons, e.g. in change log page and others:

![Add](images/add.gif)
![Fix](images/fix.gif)
![Error](images/icon_error_sml.gif)
![Success](images/icon_success_sml.gif)

This can be disabled using `bootstrapIcons` flag:

```xml
<bootstrapIcons>true|false</bootstrapIcons>
```

- **true (default)** - replaces images (add, remove, warning, info etc) with corresponding Bootstrap icons
- **false** - keep original images

### HTML5-style anchors

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

Anchors (links to page elements) in HTML5 are defined using `id` attribute on any element.
Previously anchors used the `<a name="...">` element. Reflow transforms these `<a>` anchors
to HTML5 equivalents where applicable by default. Disable with `html5Anchor` flag.

```xml
<html5Anchor>true|false</html5Anchor>
```

- **true (default)** - HTML4-style anchors `<a name="...">` are replaced with `id` attributes where applicable
- **false** - keep the original anchors

## Mark page header

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

By default, the first `<h1>` or `<h2>` heading in the page body is marked as _page header_. It allows Bootstrap CSS to give it an emphasised presentation. To disable page header being marked, use the `<markPageHeader>` flag:

```xml
<markPageHeader>true|false</markPageHeader>
```

- **true (default)** - The first heading (`<h1>` or else `<h2>`) in page is marked
- **false** - Page content is unchanged

## Skin attribution

support {< badge color="primary" text="v1.0" />}}<br/>
element {< badge color="secondary" text="reflow" />}}

The Reflow skin is released under the [Apache license][apache-license] and thus can be used freely. By default, a link to the skin website and the author homepage is added at the bottom of the skin: _Reflow Maven skin by devacfr_. I would appreciate if you kept the link - it will help with the popularity of the skin. If you want, it can be disabled using `<skinAttribution>` flag:

```xml
<skinAttribution>true|false</skinAttribution>
```

- **true (default)** - Include links to Reflow skin homepage and author's website
- **false** - Remove skin attribution text and links

[apache-license]: http://www.apache.org/licenses/LICENSE-2.0
