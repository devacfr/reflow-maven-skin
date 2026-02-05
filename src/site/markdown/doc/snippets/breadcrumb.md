# Breadcrumb

{{< badge color="primary" text="New in v2.4" />}} {{< badge color="info" text="SHORTCODE" class="ms-1" />}}

[Based on Bootstrap Breadcrumb page](https://getbootstrap.com/docs/5.3/components/breadcrumb/)

Indicate the current page’s location within a navigational hierarchy that automatically adds separators via CSS.

## Example

{{% example %}}
{{< preview-section >}}
{{< breadcrumb />}}
{{< /preview-section >}}
{{< code-section >}}

```html
{{< breadcrumb />}}
```

{{< /code-section >}}
{{% /example %}}

## Changing the separator

Separators are automatically added in CSS through [::before](https://developer.mozilla.org/en-US/docs/Web/CSS/::before) and [content](https://developer.mozilla.org/en-US/docs/Web/CSS/content). They can be changed by changing `$breadcrumb-divider`. The [quote](https://sass-lang.com/documentation/modules/string#quote) function is needed to generate the quotes around a string, so if you want `>` as separator, you can use this:

```css
$breadcrumb-divider: quote(">");
```

It’s also possible to use a **base64 embedded SVG icon**:

```css
$breadcrumb-divider: url(data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI4IiBoZWlnaHQ9IjgiPjxwYXRoIGQ9Ik0yLjUgMEwxIDEuNSAzLjUgNCAxIDYuNSAyLjUgOGw0LTQtNC00eiIgZmlsbD0iY3VycmVudENvbG9yIi8+PC9zdmc+);
```

The separator can be removed by setting `$breadcrumb-divider` to `none`:

```css
$breadcrumb-divider: none;
```
