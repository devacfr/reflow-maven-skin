# Badge

Documentation and examples for badges, our small count and labeling component.

{{< badge color="primary" text="New in v2.4" />}}

{{< badge color="info" text="SHORTCODE" />}}

[Based on Bootstrap Badge page](https://getbootstrap.com/docs/4.4/components/badge/)

## Example

Badges scale to match the size of the immediate parent element by using relative font sizing and `em` units.

{{% example %}}

<!--
<h1 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h1>
<h2 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h2>
<h3 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h3>
<h4 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h4>
<h5 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h5>
<h6 class="no-anchor">Example heading <badge shortcode color="secondary" text="NEW" /></h6>
-->

{{% /example %}}

```markdown
# Example heading {{< badge color="secondary" text="NEW" />}}
## Example heading {{< badge color="secondary" text="NEW" />}}
### Example heading {{< badge color="secondary" text="NEW" />}}
#### Example heading {{< badge color="secondary" text="NEW" />}}
##### Example heading {{< badge color="secondary" text="NEW" />}}
###### Example heading {{< badge color="secondary" text="NEW" />}}
```

## Contextual variations

Add any of the below mentioned modifier classes to change the appearance of a badge.

{{< example >}}

{{< badge color="primary" text="Primary" />}}
{{< badge color="secondary" text="Secondary" />}}
{{< badge color="success" text="Success" />}}
{{< badge color="danger" text="Danger" />}}
{{< badge color="warning" text="warning" />}}
{{< badge color="info" text="Info" />}}
{{< badge color="light" text="Light" />}}
{{< badge color="dark" text="Dark" />}}

{{< /example >}}

```html
{{< badge color="primary" text="Primary" />}}
{{< badge color="secondary" text="Secondary" />}}
{{< badge color="success" text="Success" />}}
{{< badge color="danger" text="Danger" />}}
{{< badge color="warning" text="warning" />}}
{{< badge color="info" text="Info" />}}
{{< badge color="light" text="Light" />}}
{{< badge color="dark" text="Dark" />}}
```

{{< callout color="warning" level="5" title="Conveying meaning to assistive technologies" >}}

Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that information denoted by the color is either obvious from the content itself (e.g. the visible text), or is included through alternative means, such as additional text hidden with the `.sr-only` class.

{{< /callout >}}

## Pill badges

Use the `pill` attribute to make badges more rounded.

{{< example >}}

{{< badge color="primary" pill text="Primary" />}}
{{< badge color="secondary" pill text="Secondary" />}}
{{< badge color="success" pill text="Success" />}}
{{< badge color="danger" pill text="Danger" />}}
{{< badge color="warning" pill text="warning" />}}
{{< badge color="info" pill text="Info" />}}
{{< badge color="light" pill text="Light" />}}
{{< badge color="dark" pill text="Dark" />}}

{{< /example >}}

```html
{{< badge color="primary" pill text="Primary" />}}
{{< badge color="secondary" pill  text="Secondary" />}}
{{< badge color="success" pill text="Success" />}}
{{< badge color="danger" pill text="Danger" />}}
{{< badge color="warning" pill text="warning" />}}
{{< badge color="info" pill text="Info" />}}
{{< badge color="light" pill text="Light" />}}
{{< badge color="dark" pill text="Dark" />}}
```
