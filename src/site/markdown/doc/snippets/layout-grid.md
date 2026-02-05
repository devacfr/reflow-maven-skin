# Layout Grid system

{{< badge color="primary" text="New in v2.4" />}}

Bootstrap’s grid system uses a series of containers, rows, and columns to layout and align content. Below is an example and an in-depth look at how the grid comes together.

{{< example  type="row" >}}

{{< layout class="container" >}}

{{< row >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
{{< /column >}}
{{< /row >}}

{{< /layout >}}

```xml
{{< layout class="container" >}}

{{< row >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
One of three columns
{{< /column >}}
{{< column class="col-sm" >}}
<!-- Accept empty column -->
{{< /column >}}
{{< /row >}}

{{< /layout >}}
```

{{< /example >}}

The above example creates three equal-width columns on small, medium, large, and extra large devices using our predefined grid classes. Those columns are centered in the page with the parent `.container`.

Breaking it down, here’s how it works:

* Containers provide a means to center and horizontally pad your site’s contents. Use `.container` for a responsive pixel width or `.container-fluid` for `width: 100%` across all viewport and device sizes.
* Rows are wrappers for columns. Each column has horizontal `padding` (called a gutter) for controlling the space between them. This `padding` is then counteracted on the rows with negative margins. This way, all the content in your columns is visually aligned down the left side.
* In a grid layout, content must be placed within columns and only columns may be immediate children of rows.
* Thanks to flexbox, grid columns without a specified `width` will automatically layout as equal width columns. For example, four instances of `.col-sm` will each automatically be 25% wide from the small breakpoint and up. See the [auto-layout columns](https://getbootstrap.com/docs/5.3/layout/grid/#auto-layout-columns) section for more examples.
* Column classes indicate the number of columns you’d like to use out of the possible 12 per row. So, if you want three equal-width columns across, you can use `.col-4`.
* Column `width`s are set in percentages, so they’re always fluid and sized relative to their parent element.
* Columns have horizontal `padding` to create the gutters between individual columns, however, you can remove the `margin` from rows and `padding` from columns with `.no-gutters` on the `.row`.
* To make the grid responsive, there are five grid breakpoints, one for each [responsive breakpoint](https://getbootstrap.com/docs/5.3/layout/overview/#responsive-breakpoints): all breakpoints (extra small), small, medium, large, and extra large.
* Grid breakpoints are based on minimum width media queries, meaning **they apply to that one breakpoint and all those above it** (e.g., `.col-sm-4` applies to small, medium, large, and extra large devices, but not the first `xs` breakpoint).
* You can use predefined grid classes (like `.col-4`) or [Sass mixins](https://getbootstrap.com/docs/5.3/layout/grid/#sass-mixins) for more semantic markup.

Be aware of the limitations and [bugs around flexbox](https://github.com/philipwalton/flexbugs), like the [inability to use some HTML elements as flex containers](https://github.com/philipwalton/flexbugs#flexbug-9).

## Auto-layout columns

Utilize breakpoint-specific column classes for easy column sizing without an explicit numbered class like `.col-sm-6`.

### Equal-width

For example, here are two grid layouts that apply to every device and viewport, from `xs` to `xl`. Add any number of unit-less classes for each breakpoint you need and every column will be the same width.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}
      1 of 2
    {{< /column >}}
    {{< column >}}
      2 of 2
    {{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}
      1 of 3
    {{< /column >}}
    {{< column >}}
      2 of 3
    {{< /column >}}
    {{< column >}}
      3 of 3
    {{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}
      1 of 2
    {{< /column >}}
    {{< column >}}
      2 of 2
    {{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}
      1 of 3
    {{< /column >}}
    {{< column >}}
      2 of 3
    {{< /column >}}
    {{< column >}}
      3 of 3
    {{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Equal-width multi-line

Create equal-width columns that span multiple lines by inserting a `.w-100` where you want the columns to break to a new line. Make the breaks responsive by mixing `.w-100` with some [responsive display utilities](https://getbootstrap.com/docs/5.3/utilities/display/).

There was a [Safari flexbox bug](https://github.com/philipwalton/flexbugs#flexbug-11) that prevented this from working without an explicit `flex-basis` or `border`. There are workarounds for older browser versions, but they shouldn’t be necessary if your target browsers don’t fall into the buggy versions.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< layout class="w-100" >}}{{< /layout >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< layout class="w-100" >}}{{< /layout >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Setting one column width

Auto-layout for flexbox grid columns also means you can set the width of one column and have the sibling columns automatically resize around it. You may use predefined grid classes (as shown below), grid mixins, or inline widths. Note that the other columns will resize no matter the width of the center column.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-6" >}}2 of 3 (wider){{< /column >}}
    {{< column >}}3 of 3{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-5" >}}2 of 3 (wider){{< /column >}}
    {{< column >}}3 of 3{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-6" >}}2 of 3 (wider){{< /column >}}
    {{< column >}}3 of 3{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-5" >}}2 of 3 (wider){{< /column >}}
    {{< column >}}3 of 3{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Variable width content

Use `col-{breakpoint}-auto` classes to size columns based on the natural width of their content.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="justify-content-md-center" >}}
    {{< column class="col-lg-2" >}}1 of 3{{< /column >}}
    {{< column class="col-md-auto" >}}2 of 3 (wider){{< /column >}}
    {{< column class="col-lg-2" >}}3 of 3{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-md-auto" >}}Variable width content{{< /column >}}
    {{< column class="col-lg-2" >}}3 of 3{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="justify-content-md-center" >}}
    {{< column class="col-lg-2" >}}1 of 3{{< /column >}}
    {{< column class="col-md-auto" >}}2 of 3 (wider){{< /column >}}
    {{< column class="col-lg-2" >}}3 of 3{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column >}}1 of 3{{< /column >}}
    {{< column class="col-md-auto" >}}Variable width content{{< /column >}}
    {{< column class="col-lg-2" >}}3 of 3{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

## Responsive classes

Bootstrap’s grid includes five tiers of predefined classes for building complex responsive layouts. Customize the size of your columns on extra small, small, medium, large, or extra large devices however you see fit.

### All breakpoints

For grids that are the same from the smallest of devices to the largest, use the `.col` and `.col-*` classes. Specify a numbered class when you need a particularly sized column; otherwise, feel free to stick to `.col`.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-8" >}}.col-8{{< /column >}}
    {{< column class="col-4" >}}.col-4{{< /column >}}  
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-8" >}}.col-8{{< /column >}}
    {{< column class="col-4" >}}.col-4{{< /column >}}  
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Stacked to horizontal

Using a single set of `.col-sm-*` classes, you can create a basic grid system that starts out stacked and becomes horizontal at the small breakpoint (`sm`).

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-sm-8" >}}.col-sm-8{{< /column >}}
    {{< column class="col-sm-4" >}}.col-sm-4{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-sm-8" >}}.col-sm-8{{< /column >}}
    {{< column class="col-sm-4" >}}.col-sm-4{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
    {{< column class="col-sm" >}}.col-sm{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Mix and match

Don’t want your columns to simply stack in some grid tiers? Use a combination of different classes for each tier as needed. See the example below for a better idea of how it all works.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-md-8" >}}.col-md-8{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
  {{< row >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  <!-- Stack the columns on mobile by making one full-width and the other half-width -->
  {{< row >}}
    {{< column class="col-md-8" >}}.col-md-8{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
  <!-- Columns start at 50% wide on mobile and bump up to 33.3% wide on desktop -->
  {{< row >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
  <!-- Columns are always 50% wide, on mobile and desktop -->
  {{< row >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Gutters

Gutters can be responsively adjusted by breakpoint-specific padding and negative margin utility classes. To change the gutters in a given row, pair a negative margin utility on the `.row` and matching padding utilities on the `.col`s. The `.container` or `.container-fluid` parent may need to be adjusted too to avoid unwanted overflow, using again matching padding utility.

Here’s an example of customizing the Bootstrap grid at the large (`lg`) breakpoint and above. We’ve increased the `.col` padding with `.px-lg-5`, counteracted that with `.mx-lg-n5` on the parent `.row` and then adjusted the `.container` wrapper with `.px-lg-5`.

{{< example type="row" >}}

{{< layout class="container px-lg-5" >}}
  {{< row class="mx-lg-n5" >}}
    {{< column class="py-3 px-lg-5 border bg-light" >}}Custom column padding{{< /column >}}
    {{< column class="py-3 px-lg-5 border bg-light" >}}Custom column padding{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container px-lg-5" >}}
  {{< row class="mx-lg-n5" >}}
    {{< column class="py-3 px-lg-5 border bg-light" >}}Custom column padding{{< /column >}}
    {{< column class="py-3 px-lg-5 border bg-light" >}}Custom column padding{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Row columns

Use the responsive `.row-cols-*` classes to quickly set the number of columns that best render your content and layout. Whereas normal `.col-*` classes apply to the individual columns (e.g., `.col-md-4`), the row columns classes are set on the parent `.row` as a shortcut.

Use these row columns classes to quickly create basic grid layouts or to control your card layouts.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="row-cols-2" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="row-cols-2" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="row-cols-3" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="row-cols-3" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="row-cols-4" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="row-cols-4" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column class="col-6" >}}.col-6{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="row-cols-1 row-cols-sm-2 row-cols-md-4" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="row-cols-1 row-cols-sm-2 row-cols-md-4" >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
    {{< column >}}col{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

You can also use the accompanying Sass mixin, `row-cols()`:

```scss
.element {
  // Three columns to start
  @include row-cols(3);

  // Five columns from medium breakpoint up
  @include media-breakpoint-up(md) {
    @include row-cols(5);
  }
}
```

## Alignment

Use flexbox alignment utilities to vertically and horizontally align columns. **Internet Explorer 10-11 do not support vertical alignment of flex items when the flex container has a `min-height` as shown below**. See [Flexbugs #3 for more details](https://github.com/philipwalton/flexbugs#flexbug-3).

### Vertical alignment

{{< example type="row-flex-cols" >}}

{{< layout class="container" >}}
  {{< row class="align-items-start" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}

  {{< row class="align-items-center" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}

  {{< row class="align-items-end" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="align-items-start" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}

  {{< row class="align-items-center" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}

  {{< row class="align-items-end" >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
    {{< column >}}One of three columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

{{< example type="row-flex-cols" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="align-self-start" >}}One of three columns{{< /column >}}
    {{< column class="align-self-center" >}}One of three columns{{< /column >}}
    {{< column class="align-self-end" >}}One of three columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="align-self-start" >}}One of three columns{{< /column >}}
    {{< column class="align-self-center" >}}One of three columns{{< /column >}}
    {{< column class="align-self-end" >}}One of three columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Horizontal alignment

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="justify-content-start" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-center" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-end" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-around" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-between" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="justify-content-start" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-center" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-end" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-around" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
  {{< row class="justify-content-between" >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
    {{< column class="col-4" >}}One of two columns{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### No gutters

The gutters between columns in our predefined grid classes can be removed with `.no-gutters`. This removes the negative `margins` from `.row` and the horizontal `padding` from all immediate children columns.

Here’s the source code for creating these styles. Note that column overrides are scoped to only the first children columns and are targeted via [attribute selector](https://developer.mozilla.org/en-US/docs/Web/CSS/Attribute_selectors). While this generates a more specific selector, column padding can still be further customized with [spacing utilities](https://getbootstrap.com/docs/5.3/utilities/spacing/).

**Need an edge-to-edge design?** Drop the parent `.container` or `.container-fluid`.

```css
.no-gutters {
  margin-right: 0;
  margin-left: 0;

  > .col,
  > [class*="col-"] {
    padding-right: 0;
    padding-left: 0;
  }
}
```

In practice, here’s how it looks. Note you can continue to use this with all other predefined grid classes (including column widths, responsive tiers, reorders, and more).

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row class="no-gutters" >}}
    {{< column class="col-sm-6 col-md-8" >}}.col-sm-6 .col-md-8{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row class="no-gutters" >}}
    {{< column class="col-sm-6 col-md-8" >}}.col-sm-6 .col-md-8{{< /column >}}
    {{< column class="col-6 col-md-4" >}}.col-6 .col-md-4{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Column wrapping

If more than 12 columns are placed within a single row, each group of extra columns will, as one unit, wrap onto a new line.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-4" >}}
    <!--
    .col-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.
    -->
    {{< /column >}}
    {{< column class="col-6" >}}
    <!--
    .col-6<br>Subsequent columns continue along the new line.
    -->
    {{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-4" >}}
    <!--
    .col-4<br>Since 9 + 4 = 13 &gt; 12, this 4-column-wide div gets wrapped onto a new line as one contiguous unit.
    -->
    {{< /column >}}
    {{< column class="col-6" >}}
    <!--
    .col-6<br>Subsequent columns continue along the new line.
    -->
    {{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Column breaks

Breaking columns to a new line in flexbox requires a small hack: add an element with `width: 100%` wherever you want to wrap your columns to a new line. Normally this is accomplished with multiple `.row`s, but not every implementation method can account for this.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    {{< layout class="w-100" />}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    <!-- Force next columns to break to new line -->
    {{< layout class="w-100" />}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
    {{< column class="col-6 col-sm-3" >}}.col-6 .col-sm-3{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

You may also apply this break at specific breakpoints with our [responsive display utilities](https://getbootstrap.com/docs/5.3/utilities/display/).

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    {{< layout class="w-100 d-none d-md-block" />}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    <!-- Force next columns to break to new line at md breakpoint and up -->
    {{< layout class="w-100 d-none d-md-block" />}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
    {{< column class="col-6 col-sm-4" >}}.col-6 .col-sm-4{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

## Reordering

### Order classes

Use `.order-` classes for controlling the **visual order** of your content. These classes are responsive, so you can set the `order` by breakpoint (e.g., `.order-1.order-md-2`). Includes support for `1` through `12` across all five grid tiers.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}First in DOM, no order applied{{< /column >}}
    {{< column class="order-12" >}}Second in DOM, with a larger order{{< /column >}}
    {{< column class="order-1" >}}Third in DOM, with an order of 1{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column >}}First in DOM, no order applied{{< /column >}}
    {{< column class="order-12" >}}Second in DOM, with a larger order{{< /column >}}
    {{< column class="order-1" >}}Third in DOM, with an order of 1{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

There are also responsive `.order-first` and `.order-last` classes that change the `order` of an element by applying `order: -1` and `order: 13` (`order: $columns + 1`), respectively. These classes can also be intermixed with the numbered `.order-*` classes as needed.

{{< example type="row" >}}

{{< layout class="container" >}}
  {{< row >}}
    {{< column class="order-last" >}}First in DOM, ordered last{{< /column >}}
    {{< column >}}Second in DOM, with a larger order{{< /column >}}
    {{< column class="order-first" >}}Third in DOM, ordered first{{< /column >}}
  {{< /row >}}
{{< /layout >}}

```html
{{< layout class="container" >}}
  {{< row >}}
    {{< column class="order-last" >}}First in DOM, ordered last{{< /column >}}
    {{< column >}}Second in DOM, with a larger order{{< /column >}}
    {{< column class="order-first" >}}Third in DOM, ordered first{{< /column >}}
  {{< /row >}}
{{< /layout >}}
```

{{< /example >}}

### Offsetting columns

You can offset grid columns in two ways: our responsive `.offset-` grid classes and our [margin utilities](https://getbootstrap.com/docs/5.3/utilities/spacing/). Grid classes are sized to match columns while margins are more useful for quick layouts where the width of the offset is variable.

#### Offset classes

Move columns to the right using `.offset-md-*` classes. These classes increase the left margin of a column by `*` columns. For example, ?  moves `.col-md-4` over four columns.

