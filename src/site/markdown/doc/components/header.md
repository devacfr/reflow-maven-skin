# Header Components

Standard Maven site allows customising the website _banner_.

## Header

support {{< badge color="primary" text="v2.2" />}}<br/>
element {{< badge color="secondary" text="reflow" />}}

The Header is the component displayed to top of page. If header element contains a specific html, the contained will be used instead of the generated banner text.

```xml
<header enabled="true|false"
    type="jumbotron|banner|custom"
    cssClass="css classes"
    theme="your specific theme"
    background="bootstrap colour theme" ><![CDATA[ custom html representing the header content ]]></header>
```

- **type** {{< badge color="light" text="v2.3" />}} - indicates the type of header.
- **enabled** {{< badge color="light" text="v2.2" />}} - Indicates whether the header is visible. The header is displayed by default.
- **cssClass** {{< badge color="light" text="v2.2" />}} - Sets the css class with built-in Bootstrap support. The default value is `null`.
- **theme** {{< badge color="light" text="v2.2" />}} - Sets the css class with built-in Bootstrap theme . The default value is `null`. the prefix css theme is `header-`.
- **background** {{< badge color="light" text="v2.2" />}} - Sets the css class with built-in Bootstrap colour theme. The default value is `null`.

### Jumbotron Header

The Jumbotron Header is the container of the bootstrap Jumbotron. the Jumbotron contains your slogan, logo and banner to top of the page. The following [sample page][header-jumbotron] displays the configuration below:

![header scheme](../images/doc/header-jumbotron-scheme.png)

```xml
<header type="jumbotron" background="dark" cssClass="text-light"></header>
```

Reflow renders following html:

```html
<div class="header " role="main">
    <div class="container container-fluid">
        <div class="jumbotron header--jumbotron bg-dark text-light">
            <div id="banner" class="row header--banner">
            <div class="col-md-12">
                <div class="float-left header--banner--left bannerLeft">
                      <img class="float-left m-2 img-fluid" src="./images/logo.svg" alt="Reflow skin" width="144" height="144">
                      <h1 class="d-inline-block"><span class="color-highlight">Reflow</span> Maven Skin</h1>
                    <p class="lead">Responsive Apache Maven skin to reflow the standard Maven site with a modern feel</p>
                </div>
                <div class="float-right header--banner--right bannerRight">
                </div>
            </div>
            </div>
        </div>
    </div>
</div>
```

{{< callout color="info" title="Note" level="5" >}}

You can remark in example above, `theme` and `background` attributes are associated with `jumbotron` component rather the `header` container.

{{< /callout >}}

[header-jumbotron]: test/header-jumbotron.html

### Banner Header

The Banner Header represents the simple way to display your slogan, logo and banner to top of the page. The following [sample page][header-banner] displays the configuration below:

![header scheme](../images/doc/header-banner-scheme.png)

```xml
<header type="banner" cssClass="text-light"></header>
```

Reflow renders following html:

```html
<div class="header text-light" role="main">
    <div class="container container-fluid">
        <div id="banner" class="header--banner">
            <div class="row m-1">
                <div class="col-md-12">
                    <div class="float-left header--banner--left bannerLeft">
                        <a href=".">
                            <img class="float-left m-2 img-fluid" src="./images/logo.svg" alt="Reflow skin" width="144" height="144">
                            <h1><span class="color-highlight">Reflow</span> Maven Skin</h1>
                        </a>
                        <p class="lead">Responsive Apache Maven skin to reflow the standard Maven site with a modern feel</p>
                    </div>
                    <div class="float-right header--banner--right bannerRight">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
```

[header-banner]: test/header-banner.html

### Custom Header

```xml
<header enabled="true" cssClass="text-center text-light">
    <![CDATA[
    <!-- header content -->
    ]]>
</header>
```

```html
<div class="header text-light" role="main">
    <div class="container container-fluid">
        <div class="header--subhead">
            <!-- Content of header element -->
        </div>
    </div>
</div>
```

## Banner

element {{< badge color="secondary" text="site.xml" />}}

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

{{< callout color="info" title="Note" level="5" >}}

Before, you had the solution to display either a logo or a title. Now, you have the choice to display a logo and a title. Unlike maven fluido skin plugin, `<name>` is used to display h1 heading title. Use `alt` element instead `name`. `<name>` element can have `CDATA` element as its contents, allowing custom HTML content in the banner.

{{< /callout >}}

[mvn-site-banner]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Banner

## Slogan

support {{< badge color="primary" text="v1.0" />}}<br/>
element {{< badge color="secondary" text="reflow" />}}

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
