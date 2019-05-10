# Table of Contents Component

The skin supports automatic generation of table of contents (ToC) for any page based on the headings appearing in the page. Clicking on the ToC item jumps to the corresponding heading in the page.

The ToC style can be chosen with `<toc>` element:

```xml
<custom>
  <reflowSkin>
    ...
    <!-- global -->
    <toc>top|sidebar</toc>
    <pages>
        <page>
            <!-- specific one page -->
            <toc>top|sidebar</toc>
        </page>
    </pages>
    ...
  </reflowSkin>
</custom>
```

- **top** - top ToC bar (subnav)
- **sidebar** - sidebar ToC tree
- **any other value or no `<toc>` element (default)** - do not create ToC

Both styles are exclusive: either the top or the sidebar can be used in a single page. The
different styles and their further options are explained below.

## ToC Top Bar

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

Top ToC displays the table of contents as a horizontal menu just below the site header. Top items provide drop-down menus for subsections. Such menu s used throughout the whole site here.

The ToC snaps to the top of the screen to allow easy navigation in long pages.

```xml
<toc numberItems="number|-1" 
     flatten="true|false"
     cssClass="bootstrap classes"
     theme="light|dark"
     background="bootstrap colour theme">top</toc>
```

- **numberItems** <span class="badge badge-light">v2.0</span> -  Sets a integer greater than 0 to limit the number of top ToC items. All menu entries exceeding that number are grouped under the last dropdown menu. `-1` or no attribute (default) displays all items.
- **flatten** <span class="badge badge-light">v2.0</span> - Sets to `true` flatten first 2 levels of ToC. Top ToC for pages that have only a single top heading (e.g. h1) also includes the 2nd level headings as top menu items. This is to avoid having a single item in the whole menu. Otherwise only the top level headings are included. This option can be overridden to force always or disable altogether, otherwise `false` to always just use 1st level ToC items. this attribute replace `<tocTopFlatten>` element.
- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. `navbar-light bg-light` is the default value if value is empty or `null`. **note**: `cssClass` override attributes `theme` and `background` if is filled.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

### Limit the number of top ToC items

support <span class="badge badge-primary">v1.0</span>, removed in <span class="badge badge-danger">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span><br/>

Top ToC can be limited to a certain number of items in configuration. All menu entries exceeding
that number are grouped under the last dropdown menu. Exclude the option if unlimited.

```xml
<tocTopMax>6</tocTopMax>
```

- **number** - limit to this number of items
- **-1 or no `<tocTopMax>` element (default)** - unlimited

### Flatten first 2 levels of ToC

support <span class="badge badge-primary">v1.0</span>, removed in <span class="badge badge-danger">v2.0</span><br/>
element <span class="badge badge-secondary">reflow</span><br/>

Top ToC for pages that have only a single top heading (e.g. `h1`) also includes the 2nd level
headings as top menu items. This is to avoid having a single item in the whole menu. Otherwise
only the top level headings are included. This option can be overridden to force always or
disable altogether.

```xml
<tocTopFlatten>true|false</tocTopFlatten>
```

- **true** - force flattening 2 ToC levels
- **false** - never flatten, always just use 1st level ToC items
- **no `<tocTopFlatten>` element (default)** - flatten if single top heading

## ToC Sidebar

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

```xml
<toc position="fixed|relative"
     type="fixed|static"
     autoExpandable="true|false"
     expanded="true|false"
     level="number">sidebar</toc>
```

- **position** <span class="badge badge-light">v2.0</span> - The ToC can be displayed as a tree in the sidebar. This style `relative` does not snap to the page when scrolling, but scrolls with the whole page. The default position `fixed` allow to fix the position of ToC depending on where the user has scrolled. See it in action in the [sample page][toc-sidebar].
- **level** <span class="badge badge-light">v2.0</span> - Sets the number of heading level to display. `0` allows to display all heading level (**default value**).
- **type** <span class="badge badge-light">v1.3</span> - Indentical to attribute `position`. Option `static` is similar to `relative` option in attribute `position`. _Attribute removed in version_ <span class="badge badge-light">v2.0</span>
- **autoExpandable** <span class="badge badge-light">v2.0</span> - Sets to `true` (**default value**) to automatically expand and collapse sub-menu on select or during scroll whenever a new item becomes activated by the scrollspy, otherwise `false`.
- **expanded** <span class="badge badge-light">v2.0</span> - Sets to `true` (**default value**) to expand all menus in tree, otherwise `false` to show only 1st level Toc items.

[toc-sidebar]: toc-sidebar.html
