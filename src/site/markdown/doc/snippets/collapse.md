# Collapse

{{< badge color="primary" text="New in v2.4" />}}{{< badge color="info" text="WEB COMPONENT" class="ml-1" />}}

[Based on Bootstrap Collapse page](https://getbootstrap.com/docs/4.6/components/collapse/)

Toggle the visibility of content across your project with a few classes and our JavaScript plugins.

## How is works

The collapse JavaScript plugin is used to show and hide content. Buttons or anchors are used as triggers that are mapped to specific elements you toggle. Collapsing an element will animate the `height` from its current value to 0. Given how CSS handles animations, you cannot use `padding` on a `.collapse` element. Instead, use the class as an independent wrapping element.

{{< callout color="info" >}}
The animation effect of this component is dependent on the `prefers-reduced-motion` media query. See the [reduced motion section of our accessibility documentation](https://getbootstrap.com/docs/4.6/getting-started/accessibility/#reduced-motion).
{{< /callout >}}

## Exemple

Click the buttons below to show and hide another element via class changes:

* `.collapse` hides content
* `.collapsing` is applied during transitions
* `.collapse.show` shows content

Generally, we recommend using a button with the `data-target` attribute. While not recommended from a semantic point of view, you can also use a link with the href attribute (and a `role="button"`). In both cases, the `data-toggle="collapse"` is required.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample" >}}Link with href{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" >}}Button with data-target{{< /bs-button >}}

{{< collapse id="collapseExample" >}}
<!--
<div class="card card-body">
  Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" data-toggle="collapse" href="#collapseExample"
    aria-expanded="false" aria-controls="collapseExample" >}}
Link with href
{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target="#collapseExample"
    aria-expanded="false" aria-controls="collapseExample" >}}
  Button with data-target
{{< /bs-button >}}

{{< collapse id="collapseExample" >}}
<!--
<div class="card card-body">
  Some placeholder content for the collapse component. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
```

{{< /code-section >}}
{{% /example %}}

## Horizontal

The collapse plugin also supports horizontal collapsing. Add the `.width` modifier class to transition the `width` instead of `height` and set a `width` on the immediate child element. Feel free to write your own custom Sass, use inline styles, or use our [width utilities](https://getbootstrap.com/docs/4.6/utilities/sizing/).

{{< callout color="info" >}}
Please note that while the example below has a `min-height` set to avoid excessive repaints in our docs, this is not explicitly required. **Only the `width` on the child element is required.**
{{< /callout >}}

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" data-toggle="collapse" data-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample" >}}
    Toggle width collapse
{{< /bs-button >}}

{{< layout style="min-height: 120px;" >}}
{{< collapse id="collapseWidthExample" class="width" >}}
<!--
  <div class="card card-body" style="width: 320px;">
    This is some placeholder content for a horizontal collapse. It's hidden by default and shown when triggered.
  </div>
-->
{{< /collapse >}}
{{< /layout >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" data-toggle="collapse" data-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample" >}}
    Toggle width collapse
{{< /bs-button >}}

{{< layout style="min-height: 120px;" >}}
{{< collapse id="collapseWidthExample" class="width" >}}
<!--
  <div class="card card-body" style="width: 320px;">
    This is some placeholder content for a horizontal collapse. It's hidden by default and shown when triggered.
  </div>
-->
{{< /collapse >}}
{{< /layout >}}
```

{{< /code-section >}}
{{% /example %}}

## Multiple targets

A `<button>` or `<a>` can show and hide multiple elements by referencing them with a JQuery selector in its `href` or `data-target` attribute. Multiple `<button>` or `<a>` can show and hide an element if they each reference it with their `href` or `data-target` attribute.

{{% example %}}
{{< preview-section >}}

{{< bs-button color="primary" data-toggle="collapse" href="#multiCollapseExample1" aria-expanded="false" aria-controls="multiCollapseExample1" >}}
  Toggle first element
{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2" >}}
  Toggle second element
{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2" >}}
  Toggle both elements
{{< /bs-button >}}

{{< row >}}
{{< column >}}
{{< collapse class="multi-collapse" id="multiCollapseExample1" >}}
<!--
<div class="card card-body">
  Some placeholder content for the first collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
{{< /column >}}
{{< column >}}
{{< collapse class="multi-collapse" id="multiCollapseExample2" >}}
<!--    
<div class="card card-body">
  Some placeholder content for the second collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
{{< /column >}}
{{< /row >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< bs-button color="primary" data-toggle="collapse" href="#multiCollapseExample1" aria-expanded="false" aria-controls="multiCollapseExample1" >}}
  Toggle first element
{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2" >}}
  Toggle second element
{{< /bs-button >}}
{{< bs-button color="primary" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2" >}}
  Toggle both elements
{{< /bs-button >}}

{{< row >}}
{{< column >}}
{{< collapse class="multi-collapse" id="multiCollapseExample1" >}}
<!--
<div class="card card-body">
  Some placeholder content for the first collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
{{< /column >}}

{{< column >}}
{{< collapse class="multi-collapse" id="multiCollapseExample2" >}}
<!--    
<div class="card card-body">
  Some placeholder content for the second collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
</div>
-->
{{< /collapse >}}
{{< /column >}}
{{< /row >}}
```

{{< /code-section >}}
{{% /example %}}

## Accordion example

Using the [card](https://getbootstrap.com/docs/4.6/components/card/) component, you can extend the default collapse behavior to create an accordion. To properly achieve the accordion style, be sure to use `.accordion` as a wrapper.

{{% example %}}
{{< preview-section >}}

{{% accordion id="accordionExample" %}}
<!--
<accordion-item title="Collapsible Group Item #1">
Some placeholder content for the first accordion panel. This panel is shown by default, thanks to the <code>.show</code> class.
</accordion-item>
<accordion-item title="Collapsible Group Item #2">
Some placeholder content for the second accordion panel. This panel is hidden by default.
</accordion-item>
<accordion-item title="Collapsible Group Item #3">
And lastly, the placeholder content for the third and final accordion panel. This panel is hidden by default.
</accordion-item>
-->
{{% /accordion %}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{% accordion id="accordionExample" %}}
<!--
<accordion-item title="Collapsible Group Item #1">
Some placeholder content for the first accordion panel. This panel is shown by default, thanks to the <code>.show</code> class.
</accordion-item>
<accordion-item title="Collapsible Group Item #2">
Some placeholder content for the second accordion panel. This panel is hidden by default.
</accordion-item>
<accordion-item title="Collapsible Group Item #3">
And lastly, the placeholder content for the third and final accordion panel. This panel is hidden by default.
</accordion-item>
-->
{{% /accordion %}}
```

{{< /code-section >}}
{{% /example %}}
