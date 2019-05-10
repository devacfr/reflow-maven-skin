# Header Components

Standard Maven site allows customising the website _banner_.

![header scheme](images/header-scheme.png)

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
    <p>Unlike the **maven fluido skin**, <code>&lt;name&gt;</code> is used to display h1 heading title.</p>
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
