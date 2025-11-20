# Badge

{{< badge color="primary" text="New in v2.4" />}} {{< badge color="info" text="SHORTCODE" class="ml-1" />}}

[Based on Bootstrap Badge page](https://getbootstrap.com/docs/4.6/components/badge/)

Documentation and examples for badges, our small count and labeling component.

## Example

Badges scale to match the size of the immediate parent element by using relative font sizing and `em` units.

{{< example >}}

<!--
<h1 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h1>
<h2 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h2>
<h3 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h3>
<h4 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h4>
<h5 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h5>
<h6 class="no-anchor">Example heading <badge color="secondary" text="NEW" /></h6>
-->

{{< /example >}}

```markdown
# Example heading {{< badge color="secondary" text="NEW" />}}
## Example heading {{< badge color="secondary" text="NEW" />}}
### Example heading {{< badge color="secondary" text="NEW" />}}
#### Example heading {{< badge color="secondary" text="NEW" />}}
##### Example heading {{< badge color="secondary" text="NEW" />}}
###### Example heading {{< badge color="secondary" text="NEW" />}}
```

Badges can be used as part of links or buttons to provide a counter.

{{% example %}}

{{< bs-button color="primary" >}}Notifications {{< badge color="light" text="1" />}}{{< /bs-button >}}

```html
{{< bs-button color="primary" >}}Notifications {{< badge color="light" text="1" />}}{{< /bs-button >}}
```

{{% /example %}}

Note that depending on how they are used, badges may be confusing for users of screen readers and similar assistive technologies. While the styling of badges provides a visual cue as to their purpose, these users will simply be presented with the content of the badge. Depending on the specific situation, these badges may seem like random additional words or numbers at the end of a sentence, link, or button.

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

{{< /example >}}

{{< callout color="warning" level="5" title="Conveying meaning to assistive technologies" >}}

Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that information denoted by the color is either obvious from the content itself (e.g. the visible text), or is included through alternative means, such as additional text hidden with the `.sr-only` class.

{{< /callout >}}

## Pill badges

Use the `pill` attribute to make badges more rounded.

{{< example >}}

{{< badge color="primary" pill="true" text="Primary" />}}
{{< badge color="secondary" pill="true" text="Secondary" />}}
{{< badge color="success" pill="true" text="Success" />}}
{{< badge color="danger" pill="true" text="Danger" />}}
{{< badge color="warning" pill="true" text="warning" />}}
{{< badge color="info" pill="true" text="Info" />}}
{{< badge color="light" pill="true" text="Light" />}}
{{< badge color="dark" pill="true" text="Dark" />}}

```html
{{< badge color="primary" pill="true" text="Primary" />}}
{{< badge color="secondary" pill="true"  text="Secondary" />}}
{{< badge color="success" pill="true" text="Success" />}}
{{< badge color="danger" pill="true" text="Danger" />}}
{{< badge color="warning" pill="true" text="warning" />}}
{{< badge color="info" pill="true" text="Info" />}}
{{< badge color="light" pill="true" text="Light" />}}
{{< badge color="dark" pill="true" text="Dark" />}}
```

{{< /example >}}

## Links

Using the contextual `.badge-*` classes on an `<a>` element quickly provide actionable badges with hover and focus states.

{{< example >}}

{{< badge href="#" color="primary" text="Primary" />}}
{{< badge href="#" color="secondary" text="Secondary" />}}
{{< badge href="#" color="success" text="Success" />}}
{{< badge href="#" color="danger" text="Danger" />}}
{{< badge href="#" color="warning" text="warning" />}}
{{< badge href="#" color="info" text="Info" />}}
{{< badge href="#" color="light" text="Light" />}}
{{< badge href="#" color="dark" text="Dark" />}}

```html
{{< badge href="#" color="primary" text="Primary" />}}
{{< badge href="#" color="secondary" text="Secondary" />}}
{{< badge href="#" color="success" text="Success" />}}
{{< badge href="#" color="danger" text="Danger" />}}
{{< badge href="#" color="warning" text="warning" />}}
{{< badge href="#" color="info" text="Info" />}}
{{< badge href="#" color="light" text="Light" />}}
{{< badge href="#" color="dark" text="Dark" />}}
```

{{< /example >}}
