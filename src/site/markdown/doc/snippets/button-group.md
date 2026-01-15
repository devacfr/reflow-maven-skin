# Button Group

{{< badge color="primary" text="New in v2.4" />}} {{< badge color="info" text="SHORTCODE" class="ml-1" />}}

[Based on Bootstrap Button Group page](https://getbootstrap.com/docs/4.6/components/button-group/)

Group a series of buttons together on a single line with the button group, and super-power them with JavaScript.

## Basic example

Wrap a series of buttons with `.btn` in `.btn-group`. Add on optional JavaScript radio and checkbox style behavior with [our buttons plugin](https://getbootstrap.com/docs/4.6/components/buttons/#button-plugin).

{{< example >}}

{{< layout class="btn-group" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}

```html
{{< layout class="btn-group" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}
```

{{< /example >}}

{{< callout color="warning" >}}

**Ensure correct `role` and provide a label**

In order for assistive technologies (such as screen readers) to convey that a series of buttons is grouped, an appropriate role attribute needs to be provided. For button groups, this would be `role="group"`, while toolbars should have a `role="toolbar"`.

In addition, groups and toolbars should be given an explicit label, as most assistive technologies will otherwise not announce them, despite the presence of the correct role attribute. In the examples provided here, we use aria-label, but alternatives such as aria-labelledby can also be used.

{{< /callout >}}

## Button toolbar

Combine sets of button groups into button toolbars for more complex components. Use utility classes as needed to space out groups, buttons, and more.

{{< example >}}

{{< layout class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups" >}}
{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Second group" >}}
{{< bs-button color="secondary" >}}5{{< /bs-button >}}
{{< bs-button color="secondary" >}}6{{< /bs-button >}}
{{< bs-button color="secondary" >}}7{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Third group" >}}
{{< bs-button color="secondary" >}}8{{< /bs-button >}}
{{< /layout >}}
{{< /layout >}}

```html
{{< layout class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups" >}}
{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Second group" >}}
{{< bs-button color="secondary" >}}5{{< /bs-button >}}
{{< bs-button color="secondary" >}}6{{< /bs-button >}}
{{< bs-button color="secondary" >}}7{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Third group" >}}
{{< bs-button color="secondary" >}}8{{< /bs-button >}}
{{< /layout >}}
{{< /layout >}}
```

{{< /example >}}

Feel free to mix input groups with button groups in your toolbars. Similar to the example above, you’ll likely need some utilities though to space things properly.

{{< example >}}

{{< layout class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups" >}}

{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}

{{< layout class="input-group" >}}
<!--
<div class="input-group-prepend">
  <div class="input-group-text" id="btnGroupAddon">@</div>
</div>
<input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon">
-->
{{< /layout >}}

{{< /layout >}}

{{< layout class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups" >}}

{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}

{{< layout class="input-group" >}}
<!--
<div class="input-group-prepend">
  <div class="input-group-text" id="btnGroupAddon2">@</div>
</div>
<input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon2">
-->
{{< /layout >}}

{{< /layout >}}

```html
{{< layout class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups" >}}

{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}

{{< layout class="input-group" >}}
<!--
<div class="input-group-prepend">
  <div class="input-group-text" id="btnGroupAddon">@</div>
</div>
<input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon">
-->
{{< /layout >}}

{{< /layout >}}

{{< layout class="btn-toolbar justify-content-between" role="toolbar" aria-label="Toolbar with button groups" >}}

{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< bs-button color="secondary" >}}3{{< /bs-button >}}
{{< bs-button color="secondary" >}}4{{< /bs-button >}}
{{< /layout >}}

{{< layout class="input-group" >}}
<!--
<div class="input-group-prepend">
  <div class="input-group-text" id="btnGroupAddon2">@</div>
</div>
<input type="text" class="form-control" placeholder="Input group example" aria-label="Input group example" aria-describedby="btnGroupAddon2">
-->
{{< /layout >}}

{{< /layout >}}
```

{{< /example >}}

## Sizing

Instead of applying button sizing classes to every button in a group, just add `.btn-group-*` to each `.btn-group`, including each one when nesting multiple groups.

{{< example >}}

{{< layout class="d-inline-flex flex-column" >}}

{{< layout class="btn-group btn-group-lg mb-2" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}

{{< layout class="btn-group mb-2" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}

{{< layout class="btn-group btn-group-sm" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}

{{< /layout >}}

```html
{{< layout class="btn-group btn-group-lg" role="group" aria-label="Basic example" >}}
...
{{< /layout >}}

{{< layout class="btn-group" role="group" aria-label="Basic example" >}}
...
{{< /layout >}}

{{< layout class="btn-group-sm" role="group" aria-label="Basic example" >}}
...
{{< /layout >}}
```

{{< /example >}}

## Nesting

Place a `.btn-group` within another `.btn-group` when you want dropdown menus mixed with a series of buttons.

{{< example >}}

{{< layout class="btn-group" role="group" aria-label="Button group with nested dropdown" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< layout class="btn-group" role="group" >}}
{{< bs-button color="secondary" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" >}}
Dropdown
{{< /bs-button >}}
{{% dropdown %}}
<!--
<item title="Dropdown link" href="#"></item>
<item title="Dropdown link" href="#"></item>
-->
{{% /dropdown %}}

{{< /layout >}}
{{< /layout >}}

```html
{{< layout class="btn-group" role="group" aria-label="Button group with nested dropdown" >}}
{{< bs-button color="secondary" >}}1{{< /bs-button >}}
{{< bs-button color="secondary" >}}2{{< /bs-button >}}
{{< layout class="btn-group" role="group" >}}
{{< bs-button color="secondary" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" >}}
Dropdown
{{< /bs-button >}}
{{% dropdown %}}
<!--
<item title="Dropdown link" href="#"></item>
<item title="Dropdown link" href="#"></item>
-->
{{% /dropdown %}}

{{< /layout >}}
{{< /layout >}}
```

{{< /example >}}

## Vertical variation

Make a set of buttons appear vertically stacked rather than horizontally. **Split button dropdowns are not supported here**.

{{< example >}}

{{< layout class="btn-group-vertical" role="group" aria-label="Button group with nested dropdown" >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< /layout >}}

{{< /example >}}

{{< example >}}

{{< layout class="btn-group-vertical" role="group" >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< layout class="btn-group" role="group" >}}
{{< bs-button color="secondary" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false" >}}
Dropdown
{{< /bs-button >}}
{{% dropdown %}}
<!--
<item title="Dropdown link" href="#"></item>
<item title="Dropdown link" href="#"></item>
-->
{{% /dropdown %}}
{{< /layout >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< bs-button color="secondary" >}}Button{{< /bs-button >}}
{{< /layout >}}

```html
{{< layout class="btn-group-vertical" >}}
...
{{< /layout >}}
```

{{< /example >}}
