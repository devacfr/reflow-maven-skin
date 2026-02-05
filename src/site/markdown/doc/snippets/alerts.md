# Alerts

{{< badge color="info" text="SHORTCODE" class="ms-1" />}}

[Based on Bootstrap Alerts page](https://getbootstrap.com/docs/5.3/components/alerts/)

{{< layout class="bd-subtitle" >}}Provide contextual feedback messages for typical user actions with the handful of available and flexible alert messages.{{< /layout >}}

## Examples

Alerts are available for any length of text, as well as an optional close button. For proper styling, use one of the eight **required** contextual color (e.g., `success`). For inline dismissal, use the alerts [JavaScript plugin](https://getbootstrap.com/docs/5.3/components/alerts/#dismissing).

{{% example %}}
{{< preview-section >}}

{{< alert color="primary" >}}
A simple primary alert—check it out!
{{< /alert >}}

{{< alert color="secondary" >}}
A simple secondary alert—check it out!
{{< /alert >}}

{{< alert color="success" >}}
A simple success alert—check it out!
{{< /alert >}}

{{< alert color="danger" >}}
A simple danger alert—check it out!
{{< /alert >}}

{{< alert color="warning" >}}
A simple warning alert—check it out!
{{< /alert >}}

{{< alert color="info" >}}
A simple info alert—check it out!
{{< /alert >}}

{{< alert color="light" >}}
A simple light alert—check it out!
{{< /alert >}}

{{< alert color="dark" >}}
A simple dark alert—check it out!
{{< /alert >}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{< alert color="primary" >}}
A simple primary alert—check it out!
{{< /alert >}}

{{< alert color="secondary" >}}
A simple secondary alert—check it out!
{{< /alert >}}

{{< alert color="success" >}}
A simple success alert—check it out!
{{< /alert >}}

{{< alert color="danger" >}}
A simple danger alert—check it out!
{{< /alert >}}

{{< alert color="warning" >}}
A simple warning alert—check it out!
{{< /alert >}}

{{< alert color="info" >}}
A simple info alert—check it out!
{{< /alert >}}

{{< alert color="light" >}}
A simple light alert—check it out!
{{< /alert >}}

{{< alert color="dark" >}}
A simple dark alert—check it out!
{{< /alert >}}
```

{{< /code-section >}}
{{% /example %}}

{{< callout color="warning" >}}
**Accessibility tip**: Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies like screen readers. Please ensure the meaning is obvious from the content itself (e.g., the visible text with a [sufficient color contrast](https://getbootstrap.com/docs/5.3/getting-started/accessibility/#color-contrast)) or is included through alternative means, such as additional text hidden with the `.visually-hidden` class.
{{< /callout >}}

## Link color

Use the `.alert-link` utility class to quickly provide matching colored links within any alert.

{{% example %}}
{{< preview-section >}}

{{< alert color="primary" >}}
A simple primary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="secondary" >}}
A simple primary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="success" >}}
A simple success alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="danger" >}}
A simple danger alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="warning" >}}
A simple warning alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="info" >}}
A simple info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="light" >}}
A simple light alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="dark" >}}
A simple dark alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{< alert color="primary" >}}
A simple primary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="secondary" >}}
A simple primary alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="success" >}}
A simple success alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="danger" >}}
A simple danger alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="warning" >}}
A simple warning alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="info" >}}
A simple info alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="light" >}}
A simple light alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}

{{< alert color="dark" >}}
A simple dark alert with <a href="#" class="alert-link">an example link</a>. Give it a click if you like.
{{< /alert >}}
```

{{< /code-section >}}
{{% /example %}}

## Additional content

Alerts can also contain additional HTML elements like headings, paragraphs and dividers.

{{% example %}}
{{< preview-section >}}

{{< alert color="success" title="Well done!" level="4" >}}
<!--
<p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p>
<hr>
<p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
-->
{{< /alert >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< alert color="success" title="Well done!" level="4" >}}
<!--
<p>Aww yeah, you successfully read this important alert message. This example text is going to run a bit longer so that you can see how spacing within an alert works with this kind of content.</p>
<hr>
<p class="mb-0">Whenever you need to, be sure to use margin utilities to keep things nice and tidy.</p>
-->
{{< /alert >}}
```

{{< /code-section >}}
{{% /example %}}

## Dismissing

Using the alert JavaScript plugin, it’s possible to dismiss any alert inline. Here’s how:

* Be sure you’ve loaded the alert plugin, or the compiled Bootstrap JavaScript.
* If you’re building our JavaScript from source, it [requires util.js](https://getbootstrap.com/docs/5.3/getting-started/javascript/#util). The compiled version includes this.
* Add a dismiss button and the `.alert-dismissible` class, which adds extra padding to the right of the alert and positions the `.close` button.
* On the dismiss button, add the `data-dismiss="alert"` attribute, which triggers the JavaScript functionality. Be sure to use the `<button>` element with it for proper behavior across all devices.
* To animate alerts when dismissing them, be sure to add the .fade and .show classes.
You can see this in action with a live demo:

{{% example %}}
{{< preview-section >}}

{{< alert color="warning" dismissable >}}
**Holy guacamole!** You should check in on some of those fields below.
{{< /alert >}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< alert color="warning" dismissable >}}
**Holy guacamole!** You should check in on some of those fields below.
{{< /alert >}}
```

{{< /code-section >}}
{{% /example %}}
