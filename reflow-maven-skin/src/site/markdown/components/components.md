# Components

## Page title

### Generate or set short title

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

Short title is used in site breadcrumbs and other places. In some cases it is created by Maven
site (e.g. when set in APT), etc. In other cases, however, it is missing - a glaring omission
from Markdown pages.

Reflow skin provides a couple options to circumvent this, either generate or set the short title
explicitly using `<shortTitle>` element:

```xml
<shortTitle>generate|*</shortTitle>
```

- **generate** - a short title will always be generated from the headings in the page. If `<h1>`
    heading is available, it is used. Otherwise first `<h2>` heading is used.
- **Some short title** - use this explicitly indicated short title
- **false** - disable any short title generation altogether
- **no `<shortTitle>` element (default)** - short title will be generated (as above) if one is
    not available

### Custom page title

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

By default, the page title is generated from the project name and its short title. The skin allows
setting own page title, e.g. to allow for titles such as "_My Page | My Super Website_", etc.

```xml
<titleTemplate>template</titleTemplate>
```

- **Some template** - use [Java format String][java-format] here, where `%1$s` is the project
    name and `%2$s` is the short title of the page.
    This allows omitting any of these names, or just specifying custom uniform title for pages
    without any of the variables.
- **no `<titleTemplate>` element (default)** - default title template `%1$s - %2$s` is used

[java-format]: http://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html

## Bottom description

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

The bottom navigation provides space for site description, logo or other content. It is placed on
the right of the bottom navigation area. Site description takes up space remaining after the bottom
navigation (controlled via [`maxSpan` attribute](#Bottom_navigation), site description occupies
`12 - maxSpan` then). The bottom description is set using `<bottomDescription>` element:

```xml
<bottomDescription quote="true|false">description</bottomDescription>
```

The `quote` attribute wraps the text into a `<blockquote>` element:

- **true (default)** - Text is wrapped into a `<blockquote>` element
- **false** - Text is printed as-is

The **description** can be plain text or a `CDATA` element and thus wrap the text with HTML formatting.

Alternatively, `<bottomDescription>` can contain HTML elements directly, which will be embedded
in the bottom description area.

Note that the bottom description must be enabled if Maven site
[date or version are set to position **navigation-bottom**](#Date_and_version).

## Breadcrumbs

element <span class="badge badge-primary">site.xml</span>

Breadcrumbs are defined using standard Maven site element
[`<body><breadcrumbs>`][mvn-site-breadcrumbs] in `site.xml`.
Reflow skin provides a `<breadcrumbs>` flag to enable/disable them:

```xml
<breadcrumbs>true|false</breadcrumbs>
```

- **true (default)** - Breadcrumb trail is displayed below the banner
- **false** - Do not display breadcrumbs

Note that the breadcrumbs bar must be enabled if Maven site
[date or version are set to position **left** or **right**](#Date_and_version).

[mvn-site-breadcrumbs]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Breadcrumbs

## Date and version

element <span class="badge badge-primary">site.xml</span>

Reflow skin supports displaying Maven site publish date and version. They are defined using
standard Maven site elements [`<publishDate>`][mvn-site-date] and [`<version>`][mvn-site-version].

Reflow skin supports the following values for `position` of these components:

- **left** - Left in breadcrumbs bar (requires [`<breadcrumbs>` flag](#Breadcrumbs)
    to be enabled)
- **right** - Right in breadcrumbs bar (requires [`<breadcrumbs>` flag](#Breadcrumbs)
    to be enabled)
- **navigation-bottom** - Bottom right in the bottom navigation (requires 
    [`<bottomDescription>`](#Bottom_description) to be enabled)
- **bottom (default)** - Subfooter (the last part of the page, as in this website)
- **none** - Date or version are disabled

Note that **navigation-top** position is not supported by Reflow skin.

[mvn-site-date]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Publish_Date
[mvn-site-version]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Version

### Override publish date

element <span class="badge badge-primary">site.xml</span>

The website publish date can be indicated explicitly in the configuration by using `<publishDate>`
element:

```xml
<publishDate>2013-01-08</publishDate>
```
