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

support {{< badge color="primary" >}}v1.0{{< /badge >}} <br/>
element {{< badge color="secondary" >}}reflow{{< /badge >}} {{< badge color="info" >}}component{{< /badge >}}

Top ToC displays the table of contents as a horizontal menu just below the site header. Top items provide drop-down menus for subsections. Such menu s used throughout the whole site here.

The ToC snaps to the top of the screen to allow easy navigation in long pages.

```xml
<toc numberItems="number|-1"
     flatten="true|false"
     cssClass="css classes"
     theme="light|dark"
     background="bootstrap colour theme">top</toc>
```

- **numberItems** {{< badge color="light" >}}v2.0{{< /badge >}} -  Sets a integer greater than 0 to limit the number of top ToC items. All menu entries exceeding that number are grouped under the last dropdown menu. `-1` or no attribute (default) displays all items.
- **flatten** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets to `true` flatten first 2 levels of ToC. Top ToC for pages that have only a single top heading (e.g. h1) also includes the 2nd level headings as top menu items. This is to avoid having a single item in the whole menu. Otherwise only the top level headings are included. This option can be overridden to force always or disable altogether, otherwise `false` to always just use 1st level ToC items. this attribute replace `<tocTopFlatten>` element.
- **cssClass** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets the css class with built-in Bootstrap support. The default value is `null`.
- **theme** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

## ToC Sidebar

support {{< badge color="primary" >}}v1.0{{< /badge >}} <br/>
element {{< badge color="secondary" >}}reflow{{< /badge >}} {{< badge color="info" >}}component{{< /badge >}}

```xml
<toc position="fixed|relative"
     autoExpandable="true|false"
     expanded="true|false"
     level="number">sidebar</toc>
```

- **position** {{< badge color="light" >}}v2.0{{< /badge >}} - The ToC can be displayed as a tree in the sidebar. This style `relative` does not snap to the page when scrolling, but scrolls with the whole page. The default position `fixed` allow to fix the position of ToC depending on where the user has scrolled. See it in action in the [sample page][toc-sidebar].
- **level** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets the number of heading level to display. `0` allows to display all heading level (**default value**).
- **autoExpandable** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets to `true` (**default value**) to automatically expand and collapse sub-menu on select or during scroll whenever a new item becomes activated by the scrollspy, otherwise `false`.
- **expanded** {{< badge color="light" >}}v2.0{{< /badge >}} - Sets to `true` (**default value**) to expand all menus in tree, otherwise `false` to show only 1st level Toc items.

[toc-sidebar]: test/toc-sidebar.html
