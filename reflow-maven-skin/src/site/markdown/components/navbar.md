# Navbar Component

Navbar is Bootstrap responsive navigation header component fixed to the top of page. It contains all [`<body><links>` element][site-links] and filtered [`<body><menu>`][site-menus] declared in site.xml.

![navbar scheme](images/navbar-scheme.png)

## Usage

support <span class="badge badge-primary">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

```xml
<navbar filterMenu="Regex filter"
        cssClass="css classes"
        theme="light|dark"
        background="bootstrap colour theme"
        center="true|false"
        alignMenu="left|right">
    <image src="image path" width="number|30" height="number|30" />
    <additionalMenu>
        <![CDATA[
            html content
          ]]>
    </additionalMenu>
</navbar>
```

- **filterMenu** <span class="badge badge-light">v2.0</span> - applies the regular expression to menu names and `ref` attributes. If the regular expression matches, adds the menu to the top navigation.
    expression matches, adds the menu to the top navigation.
- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. The default value is `null`.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.
- **center** <span class="badge badge-light">v2.1</span> - Sets the centering of the component with values `true`  (**default**) or `false`. `center` use bootstrap containers otherwise use default bootstrap alignment.
- **alignMenu** <span class="badge badge-light">v2.1</span> - Sets the alignment of menu to the `left` or pushing to the `right` (**default**).

### Image element

Add image to the brand part of navbar.

- **src** <span class="badge badge-light">v2.0</span> - the path location of image to use.
- **width** <span class="badge badge-light">v2.0</span> - the width of image, 30 is the default if value is empty or `null`.
- **height** <span class="badge badge-light">v2.0</span> - the height of image, 30 is the default if value is empty or `null`.

### Additional Menu

{{< badge color="primary" text="New in v2.4" />}}

It is placed on the right of the navbar component. The additional menu is set using `<additionalMenu>` element:

```xml
<navbar>
    <additionalMenu>
        <![CDATA[
          <ul class="navbar-nav navbar-additional ml-md-auto">
            <li class="nav-item dropdown">
            <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="m-versions" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                v2.3
            </a>
            <div class="dropdown-menu dropdown-menu-md-right" aria-labelledby="bd-versions">
                <a class="dropdown-item active" href="#">Latest (2.3.x)</a>
                <a class="dropdown-item" href="#">v2.1.1</a>
                <a class="dropdown-item" href="#">v2.0.0</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">v1.5.1</a>
                <a class="dropdown-item" href="#">v1.4.0</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">All versions</a>
            </div>
            </li>
            <li class="nav-item">
                <a href="#"><i class="fab fa-lg fa-github"></i></a>
            </li>
            <li class="nav-item">
                <a href="#"><i class="fab fa-lg fa-twitter"></i></a>
            </li>
          </ul>
          ]]>
    </additionalMenu>
</navbar>
```

`<additionalMenu>` contains HTML elements, which will be embedded in the collapse part of navbar (See above [sample](test/navbar-additional-menu.html)).

### Centering and Alignement Sample Pages

Here is a table containing different configuration of Navbar.

| Page                                                  | Centered | Alignment |
|-------------------------------------------------------|----------|-----------|
| [centered-right](test/navbar-centered-right.html)     | true     | right     |
| [centered-left](test/navbar-centered-left.html)       | true     | left      |
| [uncentered-right](test/navbar-uncentered-right.html) | false    | right     |
| [uncentered-left](test/navbar-uncentered-left.html)   | false    | left      |

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
