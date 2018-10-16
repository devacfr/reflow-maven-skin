# Table of contents

The skin supports automatic generation of table of contents (ToC) for any page based on the headings
appearing in the page. Clicking on the ToC item jumps to the corresponding heading in the page.

The ToC style can be chosen with `<toc>` element:

```xml
<custom>
  <reflowSkin>
    ...
    <toc>top|sidebar</theme>
    ...
  </reflowSkin>
</custom>
```

- **top** - top ToC bar (subnav)
- **sidebar** - sidebar ToC tree
- **any other value or no `<toc>` element (default)** - do not create ToC

Both styles are exclusive: either the top or the sidebar can be used in a single page. The
different styles and their further options are explained below.

## Top ToC

Top ToC displays the table of contents as a horizontal menu just below the site header. Top items
provide drop-down menus for subsections. Such menu is used throughout the whole site here.

The ToC snaps to the top of the screen to allow easy navigation in long pages.

```xml
<toc>top</toc>
```

### Limit the number of top ToC items

Top ToC can be limited to a certain number of items in configuration. All menu entries exceeding
that number are grouped under the last dropdown menu. Exclude the option if unlimited.

```xml
<tocTopMax>6</tocTopMax>
```

- **number** - limit to this number of items
- **-1 or no `<tocTopMax>` element (default)** - unlimited

### Flatten first 2 levels of ToC

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

## Sidebar ToC

The ToC can be displayed as a tree in the sidebar. This default style `static` does not snap to the page when scrolling, but scrolls with the whole page. The type `fixed` allow to fix the position of ToC depending on where the user has scrolled. See it in action in the [sample page][toc-sidebar].

```xml
<toc type="fixed|static">sidebar</toc>
```

[toc-sidebar]: toc-sidebar.html
