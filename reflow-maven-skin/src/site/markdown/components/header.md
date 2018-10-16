# Header

Standard Maven site allows customising the website _banner_. Reflow skin adds further components to
the site header: _brand_ and _slogan_.

## Banner

The banner (big _Reflow Maven Skin_ text on this website) is defined using 
[standard `<bannerLeft>` or `<bannerRight>` elements][mvn-site-banner] in `site.xml` site
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
    <href>http://devacfr.github.io/reflow-maven-skin</href>
  </bannerLeft>
  ...
</project>
```

Note that `<name>` element can have `CDATA` element as its contents, allowing custom HTML content
in the banner.

[mvn-site-banner]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Banner

## Brand

The brand text (or image) appearing in the left of the top navigation bar can be customised using
`<brand>` element. You can set both the contents and the link.

```xml
<brand>
  <name>text</name>
  <href>link</href>
</brand>
```

- **name** element sets the text of the top-left brand
- **href** element sets the link to open when the brand text is clicked

Note that the `<name>` element can be used to embed custom HTML content. To do that, use `CDATA`
element as the contents of `<name>` (writing HTML without `CDATA` will not work):

```xml
<brand>
  <name>
    <![CDATA[
    <span class="color-highlight">Reflow</span> Maven Skin
    ]]>
  </name>
  ..
</brand>
```

The above example is taken from this website, in order to have the _Reflow_ part in different
colour. Images could also be added there in a similar manner.

## Slogan

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
