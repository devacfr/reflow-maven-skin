# Buttons

{{< badge color="primary" text="New in v2.4" />}} {{< badge color="info" text="SHORTCODE" class="ms-1" />}}

[Based on Bootstrap Buttons page](https://getbootstrap.com/docs/5.3/components/buttons/)

Use Bootstrap’s custom button styles for actions in forms, dialogs, and more with support for multiple sizes, states, and more.

## Examples

Bootstrap includes several predefined button styles, each serving its own semantic purpose, with a few extras thrown in for more control.

{{% example %}}
{{< preview-section >}}
{{< bs-button color="primary" >}}Primary{{< /bs-button >}}
{{< bs-button color="secondary" >}}Secondary{{< /bs-button >}}
{{< bs-button color="success" >}}Success{{< /bs-button >}}
{{< bs-button color="danger" >}}Danger{{< /bs-button >}}
{{< bs-button color="warning" >}}Warning{{< /bs-button >}}
{{< bs-button color="info" >}}Info{{< /bs-button >}}
{{< bs-button color="light" >}}Light{{< /bs-button >}}
{{< bs-button color="dark" >}}Dark{{< /bs-button >}}
{{< bs-button color="link" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" >}}Primary{{< /bs-button >}}
{{< bs-button color="secondary" >}}Secondary{{< /bs-button >}}
{{< bs-button color="success" >}}Success{{< /bs-button >}}
{{< bs-button color="danger" >}}Danger{{< /bs-button >}}
{{< bs-button color="warning" >}}Warning{{< /bs-button >}}
{{< bs-button color="info" >}}Info{{< /bs-button >}}
{{< bs-button color="light" >}}Light{{< /bs-button >}}
{{< bs-button color="dark" >}}Dark{{< /bs-button >}}
{{< bs-button color="link" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

{{< callout color="warning" level="5" title="Conveying meaning to assistive technologies" >}}
Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that information denoted by the color is either obvious from the content itself (e.g. the visible text), or is included through alternative means, such as additional text hidden with the `.sr-only` class.
{{< /callout >}}

## Disable text wrapping

If you don’t want the button text to wrap, you can add the `.text-nowrap` class to the button. In Sass, you can set `$btn-white-space: nowrap` to disable text wrapping for each button.

## Button tags

The .btn classes are designed to be used with the `<button>` element. However, you can also use these classes on `<a>` elements (though some browsers may apply a slightly different rendering).

When using button classes on `<a>` elements that are used to trigger in-page functionality (like collapsing content), rather than linking to new pages or sections within the current page, these links should be given a `role="button"` to appropriately convey their purpose to assistive technologies such as screen readers.

{{% example %}}
{{< preview-section >}}
{{< bs-button color="primary" href="#" >}}Link{{< /bs-button >}}
{{< bs-button color="primary" type="submit" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" href="#" >}}Link{{< /bs-button >}}
{{< bs-button color="primary" type="submit" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Outline buttons

In need of a button, but not the hefty background colors they bring? Replace the default modifier classes with the `.btn-outline-*` ones to remove all background images and colors on any button.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="outline-primary" >}}Primary{{< /bs-button >}}
{{< bs-button color="outline-secondary" >}}Secondary{{< /bs-button >}}
{{< bs-button color="outline-success" >}}Success{{< /bs-button >}}
{{< bs-button color="outline-danger" >}}Danger{{< /bs-button >}}
{{< bs-button color="outline-warning" >}}Warning{{< /bs-button >}}
{{< bs-button color="outline-info" >}}Info{{< /bs-button >}}
{{< bs-button color="outline-light" >}}Light{{< /bs-button >}}
{{< bs-button color="outline-dark" >}}Dark{{< /bs-button >}}
{{< bs-button color="outline-link" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="outline-primary" >}}Primary{{< /bs-button >}}
{{< bs-button color="outline-secondary" >}}Secondary{{< /bs-button >}}
{{< bs-button color="outline-success" >}}Success{{< /bs-button >}}
{{< bs-button color="outline-danger" >}}Danger{{< /bs-button >}}
{{< bs-button color="outline-warning" >}}Warning{{< /bs-button >}}
{{< bs-button color="outline-info" >}}Info{{< /bs-button >}}
{{< bs-button color="outline-light" >}}Light{{< /bs-button >}}
{{< bs-button color="outline-dark" >}}Dark{{< /bs-button >}}
{{< bs-button color="outline-link" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

{{< callout color="info" >}}
Some of the button styles use a relatively light foreground color, and should only be used on a dark background in order to have sufficient contrast.
{{< /callout >}}

## Sizes

Fancy larger or smaller buttons? Add `.btn-lg` or `.btn-sm` for additional sizes.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" class="btn-lg" >}}Large button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg" >}}Large button{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" class="btn-lg" >}}Large button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg" >}}Large button{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" class="btn-sm" >}}Small button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-sm" >}}Small button{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" class="btn-sm" >}}Small button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-sm" >}}Small button{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

Create block level buttons—those that span the full width of a parent—by adding `.btn-block`.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" class="btn-lg btn-block" >}}Block level button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg btn-block" >}}Block level button{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" class="btn-lg btn-block" >}}Block level button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg btn-block" >}}Block level button{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Active state

Buttons will appear pressed when active with a darker background, darker border, and, when shadows are enabled, an inset shadow. **There’s no need to add a class to `<button>`s as they use a pseudo-class**. However, you can still force the same active appearance with `.active` (and include the `aria-pressed=“true”` attribute) should you need to replicate the state programmatically.

{{% example %}}
{{< preview-section >}}

{{< bs-button href="#" color="primary" class="btn-lg active" aria-pressed="true" >}}Primary link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg active" aria-pressed="true" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button href="#" color="primary" class="btn-lg active" aria-pressed="true" >}}Primary link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg active" aria-pressed="true" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Disabled state

Make buttons look inactive by adding the `disabled` boolean attribute to any `<button>` element.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" class="btn-lg" disabled >}}Primary button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg" disabled >}}Button{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" class="btn-lg" disabled >}}Primary button{{< /bs-button >}}
{{< bs-button color="secondary" class="btn-lg" disabled >}}Button{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

Disabled buttons using the `<a>` element behave a bit different:

* `<a>`s don’t support the `disabled` attribute, so you must add the `.disabled` class to make it visually appear disabled.
* Some future-friendly styles are included to disable all `pointer-events` on anchor buttons. In browsers which support that property, you won’t see the disabled cursor at all.
* Disabled buttons using `<a>` should include the `aria-disabled="true"` attribute to indicate the state of the element to assistive technologies.
* Disabled buttons using `<a>` should not include the `href` attribute.

{{% example %}}
{{< preview-section >}}

{{< bs-button href="#" color="primary" class="btn-lg disabled" >}}Primary Link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg disabled" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button href="#" color="primary" class="btn-lg disabled" >}}Primary Link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg disabled" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Link functionality caveat

To cover cases where you have to keep the `href` attribute on a disabled link, the `.disabled` class uses `pointer-events: none` to try to disable the link functionality of `<a>`s. Note that this CSS property is not yet standardized for HTML, but all modern browsers support it. In addition, even in browsers that do support `pointer-events: none`, keyboard navigation remains unaffected, meaning that sighted keyboard users and users of assistive technologies will still be able to activate these links. So to be safe, in addition to `aria-disabled="true"`, also include a `tabindex="-1`" attribute on these links to prevent them from receiving keyboard focus, and use custom JavaScript to disable their functionality altogether.

{{% example %}}
{{< preview-section >}}

{{< bs-button href="#" color="primary" class="btn-lg disabled" >}}Primary Link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg disabled" >}}Link{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button href="#" color="primary" class="btn-lg disabled" >}}Primary Link{{< /bs-button >}}
{{< bs-button href="#" color="secondary" class="btn-lg disabled" >}}Link{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Button plugin

Do more with buttons. Control button states or create groups of buttons for more components like toolbars.

### Toggle states

Add `data-bs-toggle="button"` to toggle a button’s `active` state. If you’re pre-toggling a button, you must manually add the `.active` class and `aria-pressed="true"` to the `<button>`.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" data-bs-toggle="button" aria-pressed="false" >}}Single toggle{{< /bs-button >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" data-bs-toggle="button" aria-pressed="false" >}}Single toggle{{< /bs-button >}}
```

{{< /code-section >}}
{{% /example %}}

## Checkbox and radio buttons

Bootstrap’s `.button` styles can be applied to other elements, such as `<label>`s, to provide checkbox or radio style button toggling. Add `data-bs-toggle="buttons"` to a `.btn-group` containing those modified buttons to enable their toggling behavior via JavaScript and add `.btn-group-toggle` to style the `<input>`s within your buttons. **Note that you can create single input-powered buttons or groups of them**.

The checked state for these buttons is **only updated via `click` event** on the button. If you use another method to update the input—e.g., with `<input type="reset">` or by manually applying the input’s `checked` property—you’ll need to toggle `.active` on the `<label>` manually.

Note that pre-checked buttons require you to manually add the `.active` class to the input’s `<label>`.

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group-toggle" data-bs-toggle="buttons" >}}
<!--
<label class="btn btn-secondary active">
  <input type="checkbox" checked> Checked
</label>
-->
{{< /layout >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< layout class="btn-group-toggle" data-bs-toggle="buttons" >}}
<!--
<label class="btn btn-secondary active">
  <input type="checkbox" checked> Checked
</label>
-->
{{< /layout >}}
```

{{< /code-section >}}
{{% /example %}}

{{% example %}}
{{< preview-section >}}

{{< layout class="btn-group btn-group-toggle" data-bs-toggle="buttons" >}}
<!--
<label class="btn btn-secondary active">
  <input type="radio" name="options" id="option1" checked> Active
</label>
<label class="btn btn-secondary">
  <input type="radio" name="options" id="option2"> Radio
</label>
<label class="btn btn-secondary">
  <input type="radio" name="options" id="option3"> Radio
</label>
-->
{{< /layout >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< layout class="btn-group btn-group-toggle" data-bs-toggle="buttons" >}}
<!--
<label class="btn btn-secondary active">
  <input type="radio" name="options" id="option1" checked> Active
</label>
<label class="btn btn-secondary">
  <input type="radio" name="options" id="option2"> Radio
</label>
<label class="btn btn-secondary">
  <input type="radio" name="options" id="option3"> Radio
</label>
-->
{{< /layout >}}
```

{{< /code-section >}}
{{% /example %}}
