# Header Components

Standard Maven site allows customising the website _banner_.

## Header

support <span class="badge badge-primary">v2.2</span><br/>
element <span class="badge badge-secondary">reflow</span>

The Header is the component displayed to top of page. If header element contains a specific html, the contained will be used instead of the generated banner text.

```xml
<header enabled="true|false"
    type="jumbotron|banner|custom"
    cssClass="css classes"
    theme="your specific theme"
    background="bootstrap colour theme" ><![CDATA[ custom html representing the header content ]]></header>
```

- **type** <span class="badge badge-light">v2.3</span> - indicates the type of header.
- **enabled** <span class="badge badge-light">v2.2</span> - Indicates whether the header is visible. The header is displayed by default.
- **cssClass** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap support. The default value is `null`.
- **theme** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap theme . The default value is `null`. the prefix css theme is `header-`.
- **background** <span class="badge badge-light">v2.2</span> - Sets the css class with built-in Bootstrap colour theme. The default value is `null`.

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

<div class="bd-callout bd-callout-info">
    <h4 class="no-anchor">Note</h4>
    <p>You can remark in example above, <code>theme</code> and <code>background</code> attributes are associated with <code>jumbotron</code> component rather the <code>header</code> container.</p>
</div>

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

<div class="bd-callout bd-callout-info">
    <h4 class="no-anchor">Note</h4>
    <p>Before, you had the solution to display either a logo or a title. Now, you have the choice to display a logo and a title. Unlike maven fluido skin plugin, <code>&lt;name&gt;</code> is used to display h1 heading title. Use <code>alt</code> element instead <code>name</code>. <code>&lt;name&gt;</code> element can have <code>CDATA</code> element as its contents, allowing custom HTML content in the banner.</p>
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
