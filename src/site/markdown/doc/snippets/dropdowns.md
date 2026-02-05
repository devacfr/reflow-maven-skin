# Dropdowns

{{< badge color="primary" text="New in v2.4" />}}{{< badge color="info" text="SHORTCODE" class="ms-1" />}}

[Based on Bootstrap Dropdowns page](https://getbootstrap.com/docs/5.3/components/dropdowns/)

Toggle contextual overlays for displaying lists of links and more with the Bootstrap dropdown plugin.

## Overview

Dropdowns are toggleable, contextual overlays for displaying lists of links and more. They’re made interactive with the included Bootstrap dropdown JavaScript plugin. They’re toggled by clicking, not by hovering; this is [an intentional design decision](https://markdotto.com/2012/02/27/bootstrap-explained-dropdowns/).

Dropdowns are built on a third party library, [Popper](https://popper.js.org/), which provides dynamic positioning and viewport detection. Be sure to include [popper.min.js](https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js) before Bootstrap’s JavaScript or use `bootstrap.bundle.min.js` / `bootstrap.bundle`.js which contains Popper. Popper isn’t used to position dropdowns in navbars though as dynamic positioning isn’t required.

If you’re building our JavaScript from source, it [requires util.js](https://getbootstrap.com/docs/5.3/getting-started/javascript/#util).

## Accessibility

The [WAI ARIA](https://www.w3.org/TR/wai-aria/) standard defines an actual [role="menu" widget](https://www.w3.org/TR/wai-aria/#menu), but this is specific to application-like menus which trigger actions or functions. ARIA menus can only contain menu items, checkbox menu items, radio button menu items, radio button groups, and sub-menus.

Bootstrap’s dropdowns, on the other hand, are designed to be generic and applicable to a variety of situations and markup structures. For instance, it is possible to create dropdowns that contain additional inputs and form controls, such as search fields or login forms. For this reason, Bootstrap does not expect (nor automatically add) any of the role and `aria-` attributes required for true ARIA menus. Authors will have to include these more specific attributes themselves.

However, Bootstrap does add built-in support for most standard keyboard menu interactions, such as the ability to move through individual `.dropdown-item` elements using the cursor keys and close the menu with the <kbd>ESC</kbd> key.

## Examples

Wrap the dropdown’s toggle (your button or link) and the dropdown menu within `.dropdown`, or another element that declares `position: relative;`. Dropdowns can be triggered from `<a>` or `<button>` elements to better fit your potential needs.

### Single button

Any single `.btn` can be turned into a dropdown toggle with some markup changes. Here’s how you can put them to work with either `<button>` elements:

{{% example %}}
{{< preview-section >}}

{{% dropdown title="Dropdown button" color="secondary" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown title="Dropdown button" color="secondary" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

<!-- or, using commented tag -->

{{% dropdown title="Dropdown button" color="secondary" %}}
<!--
<dropdown-item title="Action" href="#" />
<dropdown-item title="Another action" href="#" />
<dropdown-item title="Something else here" href="#" />
-->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

The best part is you can do this with any button variant, too:

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown color="primary" title="Primary" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
{{< layout class="btn-group" >}}
{{% dropdown color="secondary" title="Secondary" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
{{< layout class="btn-group" >}}
{{% dropdown color="success" title="Success" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
{{< layout class="btn-group" >}}
{{% dropdown color="info" title="Info" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
{{< layout class="btn-group" >}}
{{% dropdown color="warning" title="Warning" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
{{< layout class="btn-group" >}}
{{% dropdown color="danger" title="Danger" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}

{{< /preview-section >}}
{{< code-section >}}

```html
<!-- Example single danger button -->
{{< layout class="btn-group" >}}
{{% dropdown color="danger" title="Danger" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /layout >}}
```

{{< /code-section >}}
{{% /example %}}

### Split button

Similarly, create split button dropdowns with virtually the same markup as single button dropdowns, but with the addition of `.dropdown-toggle-split` for proper spacing around the dropdown caret.

We use this extra class to reduce the horizontal `padding` on either side of the caret by 25% and remove the `margin-left` that’s added for regular button dropdowns. Those extra changes keep the caret centered in the split button and provide a more appropriately sized hit area next to the main button.

{{% example %}}
{{< preview-section >}}

{{% dropdown type="split" color="primary" title="Primary" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}

{{% dropdown type="split" color="secondary" title="Secondary" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}

{{% dropdown type="split" color="success" title="Success" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}

{{% dropdown type="split" color="info" title="Info" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}

{{% dropdown type="split" color="warning" title="Warning" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}

{{% dropdown type="split" color="danger" title="Danger" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
{{< /preview-section >}}
{{< code-section >}}

```html
<!-- Example single danger button -->
{{% dropdown type="split" color="danger" title="Danger" %}}
{{< dropdown-item title="Action" href="#" />}}
{{< dropdown-item title="Another action" href="#" />}}
{{< dropdown-item title="Something else here" href="#" />}}
{{< dropdown-item type="divider" />}}
{{< dropdown-item title="Separated link" href="#" />}}
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

## Sizing

Button dropdowns work with buttons of all sizes, including default and split dropdown buttons.

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown title="Large button" color="secondary" size="lg" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Large split button" color="secondary" type="split" size="lg" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
<!-- Large button groups (default and split) -->
{{< layout class="btn-group" >}}
{{% dropdown title="Large button" color="secondary" size="lg" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Large split button" color="secondary" type="split" size="lg" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown title="Small button" color="secondary" size="sm" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Small split button" color="secondary" type="split" size="sm" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
<!-- Small button groups (default and split) -->
{{< layout class="btn-group" >}}
{{% dropdown title="Small button" color="secondary" size="sm" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Small split button" color="secondary" type="split" size="sm" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

## Directions

### Dropup

Trigger dropdown menus above elements by adding `.dropup` to the parent element.

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown title="Dropup" color="secondary" direction="up" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split dropup" color="secondary" type="split" direction="up" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{< layout class="btn-group" >}}
{{% dropdown title="Dropup" color="secondary" direction="up" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split dropup" color="secondary" type="split" direction="up" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

### Dropright

Trigger dropdown menus at the right of the elements by adding `.dropright` to the parent element.

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown title="Dropright" color="secondary" direction="right" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split Dropright" color="secondary" type="split" direction="right" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{< layout class="btn-group" >}}
{{% dropdown title="Dropright" color="secondary" direction="right" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split Dropright" color="secondary" type="split" direction="right" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

### Dropleft

Trigger dropdown menus at the left of the elements by adding `.dropleft` to the parent element.

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group" >}}
{{% dropdown title="Dropleft" color="secondary" direction="left" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split Dropleft" color="secondary" type="split" direction="left" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{< layout class="btn-group" >}}
{{% dropdown title="Dropleft" color="secondary" direction="left" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
{{< /layout >}}

{{% dropdown title="Split Dropleft" color="secondary" type="split" direction="left" %}}
<!-- Dropdown menu links -->
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

## Menu items

Historically dropdown menu contents had to be links, but that’s no longer the case with v4. Now you can optionally use `<button>` elements in your dropdowns instead of just `<a>`s.

{{% example %}}
{{< preview-section >}}

{{% dropdown title="Dropdown" color="secondary" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown title="Dropdown" color="secondary" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

You can also create non-interactive dropdown items with `.dropdown-item-text`. Feel free to style further with custom CSS or text utilities.

{{% example %}}
{{< preview-section >}}

{{% dropdown title="Dropdown" color="secondary" %}}
{{< dropdown-item title="Dropdown item text" type="text" />}}>
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown title="Dropdown" color="secondary" %}}
{{< dropdown-item title="Dropdown item text" type="text" />}}>
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

### Active

Add `.active` to items in the dropdown to **style them as active**.

{{% example %}}
{{< preview-section >}}

{{% dropdown %}}
{{< dropdown-item title="Regular link" href="#" />}}>
{{< dropdown-item title="Active link" active href="#" />}}>
{{< dropdown-item title="Another link" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown %}}
{{< dropdown-item title="Regular link" href="#" />}}>
{{< dropdown-item title="Active link" active href="#" />}}>
{{< dropdown-item title="Another link" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

### Disabled

Add `.disabled` to items in the dropdown to style them as disabled.

{{% example %}}
{{< preview-section >}}

{{% dropdown %}}
{{< dropdown-item title="Regular link" href="#" />}}>
{{< dropdown-item title="Disabled link" disabled href="#" />}}>
{{< dropdown-item title="Another link" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown %}}
{{< dropdown-item title="Regular link" href="#" />}}>
{{< dropdown-item title="Disabled link" disabled href="#" />}}>
{{< dropdown-item title="Another link" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

## Menu alignment

By default, a dropdown menu is automatically positioned 100% from the top and along the left side of its parent. Add `.dropdown-menu-right` to a `.dropdown-menu` to right align the dropdown menu.

{{< callout color="info" >}}
**Heads up!** Dropdowns are positioned thanks to Popper (except when they are contained in a navbar).
{{< /callout >}}

{{% example %}}
{{< preview-section >}}

{{% dropdown title="Right-aligned menu" color="secondary" align="right" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown title="Right-aligned menu" color="secondary" align="right" %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

## Menu content

### Headers

Add a header to label sections of actions in any dropdown menu.

{{% example %}}
{{< preview-section >}}

{{% dropdown %}}
{{< dropdown-item title="Dropdown header" type="header" />}}>
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown %}}
{{< dropdown-item title="Dropdown header" type="header" />}}>
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}

### Dividers

Separate groups of related menu items with a divider.

{{% example %}}
{{< preview-section >}}

{{% dropdown %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item type="divider" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}

{{< /preview-section >}}
{{< code-section >}}

```html
{{% dropdown %}}
{{< dropdown-item title="Action" href="#" />}}>
{{< dropdown-item title="Another action" href="#" />}}>
{{< dropdown-item type="divider" />}}>
{{< dropdown-item title="Something else here" href="#" />}}>
{{% /dropdown %}}
```

{{< /code-section >}}
{{% /example %}}
