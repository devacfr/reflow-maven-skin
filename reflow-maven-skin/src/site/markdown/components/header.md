# Header Components

Standard Maven site allows customising the website _banner_.

![header scheme](images/header-scheme.png)

## Header
support <span class="badge badge-primary">v2.2</span><br/>
element <span class="badge badge-secondary">reflow</span>

The Header is the container of the bootstrap Jumbotron and the bootstrap Breadcrumb.

```xml
<header enabled="true|false"
	cssClass="bootstrap classes"
     	theme="your specific theme"
     	background="bootstrap colour theme"></header>
```

- **enabled** <span class="badge badge-light">v2.2</span> - Indicates whether the header is visible. The header is displayed by default.
- **cssClass** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap support. The default value is `null`. **note**: `cssClass` override attributes `theme` and `background` if is filled.
- **theme** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap theme . The default value is `null`. the prefix css theme is `header-`.
- **background** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap colour theme. The default value is `null`.

## Banner

element <span class="badge badge-secondary">site.xml</span>

The banner (big _Reflow Maven Skin_ text on this website) is defined using [standard `<bannerLeft>` or `<bannerRight>` elements][mvn-site-banner] in `site.xml` site
descriptor instead of using `<custom><reflowSkin>`:

```xml
<project ...>
...
  <bannerLeft>
    <!-- Reflow Maven Skin, but with "Reflow" highlighted -->
    <name><![CDATA[
      <span class="color-highlight">Reflow</span> Maven Skin
      ]]>
    </name>
    <src>./logo.png</src>
    <href>http://devacfr.github.io/reflow-maven-skin</href>
  </bannerLeft>
  ...
</project>
```

<div class="alert alert-info">
    <strong>Note</strong>
    <p>Before, you had the solution to display either a logo or a title. Now, you have the choice to display a logo and a title.</p>
    <p>Unlike maven fluido skin plugin, <code>&lt;name&gt;</code> is used to display h1 heading title. Use <code>alt</code> element instead <code>name</code>.</p>
    <p><code>&lt;name&gt;</code> element can have `CDATA` element as its contents, allowing custom HTML content in the banner.</p>
</div>

[mvn-site-banner]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Banner

## Slogan

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span>

The skin allows setting a website slogan in the banner. It would appear underneath the website
title, either on the left or the right side.

This website features a slogan
"_Responsive Apache Maven skin to reflow the standard Maven site with a modern feel_".

```xml
<slogan position="bannerRight|bannerLeft">The best website in the world</slogan>
```

The `position` attribute indicates where to place the slogan:

- **bannerLeft (default)** - aligned to the left (as in this website)
- **bannerRight** - aligned to the right

## Breadcrumb

element <span class="badge badge-secondary">site.xml</span>

Breadcrumbs are defined using standard Maven site element
[`<body><breadcrumbs>`][mvn-site-breadcrumbs] in `site.xml`.
Reflow skin provides a `<breadcrumbs>` flag to enable/disable them:

```xml
<breadcrumbs>true|false</breadcrumbs>
```

- **true (default)** - Breadcrumb trail is displayed below the banner
- **false** - Do not display breadcrumbs

<div class="alert alert-info">
    <strong>Note</strong>
    <p>The breadcrumbs bar must be enabled if Maven site date or version are set to position <b>left</b> or <b>right</b>.</p>
</div>


[mvn-site-breadcrumbs]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Breadcrumbs
