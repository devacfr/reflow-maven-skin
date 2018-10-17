# Menus

Menus in Reflow skin can be placed both at the top navigation bar and at the bottom navigation
columns. The menus themselves are defined as normally in Maven site, 
[using `<project><body><menu>` XML items][mvn-site-menus]. The skin allows customizing where which
menu items are placed in the website.

Both top and bottom navigation allows specifying regular expressions that filter the menus
to be displayed in the particular place. The regular expressions can match both the name of the
menu item and its `ref` value, e.g. to match `<menu ref="modules" inherit="bottom" />`.

[mvn-site-menus]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Including_Generated_Content

## Top navigation

Top navigation is right-aligned at the top of the screen. It sticks to the screen when scrolling.
The menu items can be filtered using regular expression to indicate which of the menu items
are displayed there:

```xml
<topNav>RegEx<topNav>
```

- **RegEx** - applies the regular expression to menu names and `ref` attributes. If the regular
    expression matches, adds the menu to the top navigation.
- **no `<topNav>` element (default)** - list all menus

## Links

element <span class="badge badge-primary">site.xml</span>

All links from defined in [`<body><links>` element][mvn-site-links] of `site.xml` site descriptor
are placed in the top navigation bar. This allows having top-level links in navigation (menus are
always drop-down).

[mvn-site-links]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Links

## Bottom navigation

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span>

The bottom navigation is placed in the footer, to the left of website description. It can feature
a number of columns with menu items. The columns are indicated using the `bottomNav` element.
If configuration is not available, lists all menus in a single column.

```xml
<bottomNav maxSpan="8">
  <column>RegEx</column>
  <column>RegEx</column>
  <column>RegEx</column>
</bottomNav>
```

The `maxSpan` attribute defines the total width that bottom navigation columns can take
(out of 12). By default, the **`maxSpan = 9`**. The columns are then placed equally within
this span.

Each column in the configuration defines a regular expression for menu items that will be listed
in said column. For example, to include only _Home_ and _Download_ items, use `Home|Download`
for the regular expression.
