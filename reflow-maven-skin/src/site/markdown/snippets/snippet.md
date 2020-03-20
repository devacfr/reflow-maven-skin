# Working with Snippets {{< badge color="warning" text="DRAFT" />}}

{{< badge color="primary" text="New in v2.4" />}}

{{< callout color="warning" text="Need your Help" >}}

Please note that this feature is in development. All recommendation and improvement are appreciated.

{{< /callout >}}

Markdown is simple content format, but there are times when Markdown falls short. Often, authors are forced to add raw HTML to Markdown content. Reflow created snippets to get around these limitations.
A `shortcode` and `web component` are a simple snippet inside a page that Reflow will render using a predefined template. This feature is specific at Markdown (not test with other format for the moment).

{{< row class="row-cols-1 row-cols-md-2" >}}

{{< column class="mb-4" >}}

{{% card %}}

```
  <card-body>
    <h5 class="card-title no-anchor"><a href="#snippets-snippet_toc_web-component">Web Component</a></h5>
    <p class="card-text text-secondary">It is a autonomous block. it can't include other snippets (web component or shortcode). The web component is perfect to create a generic component.</p>
  </card-body>
```

{{% /card %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card %}}

```
  <card-body>
    <h5 class="card-title no-anchor"><a href="#snippets-snippet_toc_web-component">Shortcode</a></h5>
    <p class="card-text text-secondary">as indicated by his name, for short stuff to create an unified layout, include a specific information, etc.</p>
  </card-body>
```

{{% /card %}}

{{< /column >}}

{{< /row >}}

## Web Components

It is composed by start tag `{{% component attribute="value" %}}` with attributes and tag `{{% /component %}}`, an associated xhtml data structure and a velocity template file.
The xhtml data part is enclosed in comment html element ( `<!-- -->`) or in highlighting block `<pre>...</pre>`. This notation reduces the risk that Doxia Tools modify or delete certain xhtml elements (doxia deletes all non-standard elements, `<svg>` tag too :-1: ).
The template file name should have the same name as web compenent and located in `src/site/snippets/component.vm`.
In future, the web component will be managed directly by javascript using [web component APIs](https://www.webcomponents.org/).

### Tag Syntax

The `web component` must respect a strict shorthand notation so as not to be in conflict with the Doxia renderer.

- whitespaces are required after `{{%` and before `%}}` tags.
- the empty line is required before after each start and end tag.
- start and end tags must be placed at the start of a line.

### Data Element

To be recognized by reflow, a data element **should** be a xml element with a tag name differents of existing html tag.
the tag name must start with an alphabetic character (a .. z or A .. Z). The rest of the characters are limited to the following types of characters:

- alphabetic (a .. z, A .. Z)
- numeric (0 .. 9)
- hyphen ("-")
- underscore ("_")

```html
{{% component attribute="value" %}}

<!--
<data>
  <data-item class="text-muted" >Header Section</data-item>
  <data-content>
    <div>html used in template</div>
  </data-content>
</data>
-->

{{% /component%}}
```

### Web Component Template

The template use `$snippet` variable to render the web component.

```html
#if( $snippet.attribute == 'value' )
  <div class="component">
    <h2>$snippet.data-item.html</h2>
   <div #if( $snippet.data-content.attr['class'] )class="$snippet.data-content.attr['class']"#end>
   $snippet.data-content.html
   </div>
  </div>
#end
```

## Shortcodes

The shortcode .It can be construct as a empty element tag `{{< component attribute="value" />}}` or with a start tag  `{{< component attribute="value" >}}` with attributes and a end tag  `{{< /component >}}`.
One of these peculiarities is that it can mutate to web component. This particularity allows to resolve certain conflict with the Doxia renderer.

### Tag Syntax

The shortcode must respect a strict shorthand notation so as not to be in conflict with the Doxia renderer.

- whitespaces are required after `{{<` and before `>}}`
- the empty line is required before after each start and end tag.
- start and end tags must be placed at the start of a line.
- the empty tag `{{< shortcode />}}` or start and end tags can be used inline in same paragraph.

### Nested Shortcodes

You can include shortcodes within other shortcodes by creating your own templates that leverage the `$snippet.parent` property. `$snippet.parent` allows you to check the context in which the shortcode is being called.

```html
{{< jumbotron class="bg-primary" >}}

  <h1 class="display-4">Hello, world!</h1>
  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
  <hr class="my-4">
  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
  <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>

{{< /jumbotron >}}

or, with markdown text

{{< jumbotron class="bg-primary" >}}

## Hello, world!

This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.
It uses utility classes for typography and spacing to space content out within the larger container.

{{< /jumbotron >}}
```

The associated template use `$snippet` variable in velocity context to render the component.

```html
<div class="jumbotron #if( $snippet.attr['class'] )class=" $snippet.attr['class']"#end">
   $snippet.html
</div>
```

## $snippet Variable

Take the first example, `$snippet.color`. It can have two meanings. It can mean, Look in the hashtable identified as snippet and return the attribute associated with the key `color`. But `$snippet.color` can also be referring to a `<color>` data element. `$snippet.color` could be an abbreviated way of writing `$snippet.attr['color]` or `$snippet.getAttribute('color')` for an attribute, or `$snippet.getChildren('color')` for an data element.

{{< callout color="warning" >}}

You can not use the `class` attribute directly like this `$snippet.data-content.class`, but instead `$snippet.data-content.attr['class']`.

{{< /callout >}}

### Lookup Rules

As was mentioned earlier, properties refer to attribute or data element of the parent object. Reflow uses the following lookup sequence. For names, such as `$snippet.class`, the sequence is:

- `getclass()`
- `getClass()`
- `get("class")`
  - Returns `getAttribute("class")` attibute if exists
  - if the property name has suffix "s" `getAttribute("class")`, returns a list.
  - `getChildren("class")` Returns the first element if exists.
- isClass()

{{< callout color="warning" level="5" title="Of course" >}}

You can not use the `class` attribute directly like this `$snippet.data-content.class`, but instead `$snippet.data-content.attr['class']`.

{{< /callout >}}

### Property

- `$snippet.name` -
- `$snippet.parent` -
- `$snippet.html` -
- `$snippet.[attr]` -
- `$snippet.attr[]` -
- `$snippet.[data]` -

## Template

The template uses [Velocity Template](https://velocity.apache.org/engine/1.7/developer-guide.html) to generate html content. the file have to be located in path `src/site/snippets`.

### Override Template

Template can override existing template.
