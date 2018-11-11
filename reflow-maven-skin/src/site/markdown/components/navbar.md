# Top Navbar Component

Navbar is Bootstrap responsive navigation header component fixed to the top of page. It contains all [`<body><links>` element][site-links] and filtered [`<body><menu>`][site-menus] declared in site.xml.

![navbar scheme](images/navbar-scheme.png)

## Usage

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

```xml
<navbar filterMenu="Regex filter"
        cssClass="bootstrap classes"
        theme="light|dark"
        background="bootstrap colour theme">
    <image href="image path" width="number|30" height="number|30" />
</navbar>
```

- **filterMenu** <span class="badge badge-light">v2.0</span> - applies the regular expression to menu names and `ref` attributes. If the regular expression matches, adds the menu to the top navigation.
    expression matches, adds the menu to the top navigation.
- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. `navbar-light bg-light` is the default value if value is empty or `null`. **note**: `cssClass` override attributes `theme` and `background` if is filled.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

**Image element**

Add image to the brand part of navbar.

- **href** <span class="badge badge-light">v2.0</span> - the path location of image to use.
- **width** <span class="badge badge-light">v2.0</span> - the width of image, 30 is the default if value is empty or `null`.
- **height** <span class="badge badge-light">v2.0</span> - the height of image, 30 is the default if value is empty or `null`.

## Brand

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span>

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

[site-menus]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Including_Generated_Content
[site-links]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Links
