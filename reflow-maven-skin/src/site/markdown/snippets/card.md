# Card Snippet

Bootstrap’s cards provide a flexible and extensible content container with multiple variants and options.

## About

A card is a flexible and extensible content container. It includes options for headers and footers, a wide variety of content, contextual background colors, and powerful display options. If you’re familiar with Bootstrap 3, cards replace our old panels, wells, and thumbnails. Similar functionality to those components is available as modifier classes for cards.

## Example

Cards are built with as little markup and styles as possible, but still manage to deliver a ton of control and customization. Built with flexbox, they offer easy alignment and mix well with other Bootstrap components. They have no `margin` by default, so use [spacing utilities](https://getbootstrap.com/docs/4.4/utilities/spacing/) as needed.

Below is an example of a basic card with mixed content and a fixed width. Cards have no fixed width to start, so they’ll naturally fill the full width of its parent element. This is easily customized with our various [sizing options](https://getbootstrap.com/docs/4.4/components/card/#sizing).

{{< example >}}

{{% card style="width: 18rem;" %}}

<!--
  <card-image>
    <svg class="bd-placeholder-img card-img-top" width="100%" height="180" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image cap">
      <title>Placeholder</title>
      <rect width="100%" height="100%" fill="#868e96"></rect>
      <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
    </svg>
  </card-image>
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card style="width: 18rem;" %}}

<!--
  <card-image src="..." alt="..." />
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}
```

## Content types

Cards support a wide variety of content, including images, text, list groups, links, and more. Below are examples of what’s supported.

### Body

The building block of a card is the `<card-body>` element. Use it whenever you need a padded section within a card.

{{< example >}}

{{% card %}}

<!--
  <card-body>
    This is some text within a card body.
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card %}}

<!--
  <card-body>
    This is some text within a card body.
  </card-body>
-->

{{% /card %}}
```

### Titles, text, and links

Card titles are used by adding `.card-title` to a `<h*>` tag. In the same way, links are added and placed next to each other by adding `.card-link` to an `<a>` tag.

Subtitles are used by adding a `.card-subtitle` to a `<h*>` tag. If the `.card-title` and the `.card-subtitle` items are placed in a `<card-body>` element, the card title and subtitle are aligned nicely.

{{< example >}}

{{% card style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <h6 class="card-subtitle no-anchor mb-2 text-muted">Card subtitle</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <h6 class="card-subtitle no-anchor mb-2 text-muted">Card subtitle</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="card-link">Card link</a>
    <a href="#" class="card-link">Another link</a>
  </card-body>
-->

{{% /card %}}
```

### Images

`.card-img-top` places an image to the top of the card. With `.card-text`, text can be added to the card. Text within `.card-text` can also be styled with the standard HTML tags.

{{< example >}}

{{% card style="width: 18rem;" %}}

<!--
  <card-image>
    <svg class="bd-placeholder-img card-img-top" width="100%" height="180" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image cap">
      <title>Placeholder</title>
      <rect width="100%" height="100%" fill="#868e96"></rect>
      <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
    </svg>
  </card-image>
  <card-body>
    This is some text within a card body.
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card style="width: 18rem;" %}}

<!--
  <card-image src="..." alt="..." />
  <card-body>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
  </card-body>
-->

{{% /card %}}
```

### Header and footer

Add an optional header and/or footer within a card.

{{< example >}}

{{% card %}}

<!--
  <card-header>Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card %}}

<!--
  <card-header>Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}
```

Card headers can be styled by adding `card-header` to <h*> elements.

{{< example >}}

{{% card %}}

<!--
  <card-header level="5" class="no-anchor">Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card %}}

<!--
  <card-header level="5">Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}
```

## Sizing

Cards assume no specific `width` to start, so they’ll be 100% wide unless otherwise stated. You can change this as needed with custom CSS, grid classes, grid Sass mixins, or utilities.

### Using grid markup

Using the grid, wrap cards in columns and rows as needed.

{{< example >}}

{{< row >}}

{{< column >}}

{{% card %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
  <card-footer class="text-muted">
    2 days ago
  </card-footer>
-->

{{% /card %}}

{{< /column >}}

{{< column >%}}

{{% card %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
  <card-footer class="text-muted">
    2 days ago
  </card-footer>
-->

{{% /card %}}

{{< /column >}}

{{< /row >}}

{{< /example >}}

```xml
{{< row >}}

{{< column >}}

{{% card %}}

<!--
  <card-header class="text-center">Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
  <card-footer class="text-muted">
    2 days ago
  </card-footer>
-->

{{% /card %}}

{{< /column >}}

{{< column >}}

{{% card %}}

<!--
  <card-header class="text-center">Featured</card-header>
  <card-body>
    <h5 class="card-title no-anchor">Special title treatment</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
  <card-footer class="text-muted">
    2 days ago
  </card-footer>
-->

{{% /card %}}

{{< /column >}}

{{< /row >}}
```

### Using utilities

Use our handful of [available sizing utilities](https://getbootstrap.com/docs/4.4/utilities/sizing/) to quickly set a card’s width.

{{< example >}}

{{% card class="w-75" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Button</a>
  </card-body>
-->

{{% /card %}}

{{% card class="w-50" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Button</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card class="w-75" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Button</a>
  </card-body>
-->

{{% /card %}}

{{% card class="w-50" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
    <a href="#" class="btn btn-primary">Button</a>
  </card-body>
-->

{{% /card %}}
```

## Text alignment

You can quickly change the text alignment of any card—in its entirety or specific parts—with our [text align classes](https://getbootstrap.com/docs/4.4/utilities/text/#text-alignment).

{{< example >}}

{{% card style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{% card class="text-center" style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{% card class="text-right" style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{% card class="text-center" style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}

{{% card class="text-right" style="width: 18rem;" %}}

<!--
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </card-body>
-->

{{% /card %}}
```

## Images

Cards include a few options for working with images. Choose from appending “image caps” at either end of a card, overlaying images with card content, or simply embedding the image in a card.

### Image caps

Similar to headers and footers, cards can include top and bottom “image caps”—images at the top or bottom of a card.

### Image overlays

Turn an image into a card background and overlay your card’s text. Depending on the image, you may or may not need additional styles or utilities.

## Horizontal

Using a combination of grid and utility classes, cards can be made horizontal in a mobile-friendly and responsive way. In the example below, we remove the grid gutters with `.no-gutters` and use `.col-md-*` classes to make the card horizontal at the md breakpoint. Further adjustments may be needed depending on your card content.

{{< example >}}

{{% card horizontal="true" class="mb-3" style="max-width: 540px;" %}}

<!--
  <card-image>
    <svg class="bd-placeholder-img" width="100%" height="250" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image">
      <title>Placeholder</title>
      <rect width="100%" height="100%" fill="#868e96"></rect>
      <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image</text>
    </svg>
  </card-image>
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  </card-body>
-->

{{% /card %}}

{{< /example >}}

```xml
{{% card horizontal="true" class="mb-3" style="max-width: 540px;" %}}

<!--
  <card-image src="..." alt="..." />
  <card-body>
    <h5 class="card-title no-anchor">Card title</h5>
    <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
  </card-body>
-->

{{% /card %}}
```
