# Footer Component

## Usage

```xml
<footer cssClass="css classes"
        theme="light|dark"
        background="bootstrap colour theme" />
```

- **cssClass** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap support. The default value is `null`.
- **theme** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap theme . `light` is the default value if value is empty or `null`.
- **background** <span class="badge badge-light">v2.0</span> - Sets the css class with built-in Bootstrap colour theme. `light` is the default value if value is empty or `null`.

### Bottom navigation

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span>

The bottom navigation is placed in the footer, to the left of website description. It can feature a number of columns with menu items. The columns are indicated using the `bottomNav` element. If configuration is not available, lists all menus in a single column.

```xml
<bottomNav maxSpan="8">
  <column>RegEx</column>
  <column>RegEx</column>
  <column>RegEx</column>
</bottomNav>
```

- **maxSpan** <span class="badge badge-light">v1.0</span> - defines the total width that bottom navigation columns can take (out of 12). By default, the **`maxSpan = 9`**. The columns are then placed equally within this span (removed in <span class="badge badge-danger">v2.0</span>).
- Each column in the configuration defines a regular expression for menu items that will be listed in said column. For example, to include only _Home_ and _Download_ items, use `Home|Download` for the regular expression.

## Bottom description

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">component</span>

It is placed on the right of the bottom navigation area. Site description takes up space remaining after the bottom navigation. The bottom description is set using `<bottomDescription>` element:

```xml
<bottomDescription quote="true|false">description</bottomDescription>
```

The `quote` attribute wraps the text into a `<blockquote>` element:

- **true (default)** - Text is wrapped into a `<blockquote>` element
- **false** - Text is printed as-is

The **description** can be plain text or a `CDATA` element and thus wrap the text with HTML formatting.

Alternatively, `<bottomDescription>` can contain HTML elements directly, which will be embedded in the bottom description area.

<div class="bd-callout bd-callout-info">
    <h4 class="no-anchor">Note</h4>
    <p>the bottom description must be enabled if Maven site date or version are set to position <b>navigation-bottom</b>.</p>
</div>
