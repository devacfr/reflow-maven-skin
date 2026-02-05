# Accordion

{{< badge color="primary" text="New in v3.0" />}}{{< badge color="info" text="WEB COMPONENT" class="ms-1" />}}

[Based on Bootstrap Accordion page](https://getbootstrap.com/docs/5.3/components/accordion/)

{{< layout class="bd-subtitle" >}}Build vertically collapsing accordions in combination with our Collapse JavaScript plugin.{{< /layout >}}

## How it works

The accordion uses [collapse](https://getbootstrap.com/docs/5.3/components/collapse) internally to make it collapsible.

{{< callout color="info" >}}
The animation effect of this component is dependent on the `prefers-reduced-motion` media query. See the [reduced motion section of our accessibility documentation](https://getbootstrap.com/docs/5.3/getting-started/accessibility/#reduced-motion).
{{< /callout >}}

## Example

Click the accordions below to expand/collapse the accordion content.

{{% example %}}
{{< preview-section >}}

{{% accordion id="accordionExample" %}}
<!--
<accordion-item title="Accordion Item #1">
<strong>This is the first item’s accordion body.</strong> It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
</accordion-item>
<accordion-item title="Accordion Item #2">
<strong>This is the second item’s accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
</accordion-item>
<accordion-item title="Accordion Item #3">
<strong>This is the third item’s accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
</accordion-item>
-->
{{% /accordion %}}

{{< /preview-section >}}
{{< code-section >}}

```xml
{{% accordion id="accordionExample" %}}
<!--
<accordion-item title="Accordion Item #1">
...
</accordion-item>
<accordion-item title="Accordion Item #2">
...
</accordion-item>
<accordion-item title="Accordion Item #3">
...
</accordion-item>
-->
{{% /accordion %}}
```

{{< /code-section >}}
{{% /example %}}

## Flush

Add `flush` to remove some borders and rounded corners to render accordions edge-to-edge with their parent container.

{{% example %}}
{{< preview-section >}}

{{% accordion id="accordionFlushExample" flush %}}
{{< accordion-item title="Accordion Item #1" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the first item’s accordion body.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #2" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the second item’s accordion body. Let’s imagine this being filled with some actual content.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #3" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the third item’s accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.
{{< /accordion-item >}}
{{% /accordion %}}

{{< /preview-section >}}
{{< code-section >}}

```xml
{{% accordion id="accordionFlushExample" flush %}}
{{< accordion-item title="Accordion Item #1" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the first item’s accordion body.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #2" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the second item’s accordion body. Let’s imagine this being filled with some actual content.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #3" >}}
Placeholder content for this accordion, which is intended to demonstrate the `.accordion-flush` class. This is the third item’s accordion body. Nothing more exciting happening here in terms of content, but just filling up the space to make it look, at least at first glance, a bit more representative of how this would look in a real-world application.
{{< /accordion-item >}}
{{% /accordion %}}
```

{{< /code-section >}}
{{% /example %}}

## Always open

Add `alwaysOpen` attribute to make accordion items stay open when another item is opened.

{{% example %}}
{{< preview-section >}}

{{% accordion id="accordionPanelsStayOpenExample" alwaysOpen %}}
{{< accordion-item title="Accordion Item #1" >}}
**This is the first item’s accordion body.** It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #2" >}}
**This is the second item’s accordion body.** It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #3" >}}
**This is the third item’s accordion body.** It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{% /accordion %}}

{{< /preview-section >}}
{{< code-section >}}

```xml
{{% accordion id="accordionPanelsStayOpenExample" alwaysOpen %}}
{{< accordion-item title="Accordion Item #1" >}}
**This is the first item’s accordion body.** It is shown by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #2" >}}
**This is the second item’s accordion body.** It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{< accordion-item title="Accordion Item #3" >}}
**This is the third item’s accordion body.** It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It’s also worth noting that just about any HTML can go within the `.accordion-body`, though the transition does limit overflow.
{{< /accordion-item >}}
{{% /accordion %}}
```

{{< /code-section >}}
{{% /example %}}
