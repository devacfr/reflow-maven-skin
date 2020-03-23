# Working with Snippets {{< badge color="warning" text="DRAFT" />}}

{{< badge color="primary" text="New in v2.4" />}}

{{< callout color="warning" title="Warning" >}}

Snippet feature is in preview version. The specification can change in the future.

All recommendation and improvement are appreciated.

{{< /callout >}}

Markdown is simple content format, but there are times when Markdown falls short. Often, authors are forced to add raw HTML to Markdown content. Reflow created snippets to get around these limitations.
A `shortcode` and `web component` are a simple snippet inside a page that Reflow will render using a predefined template. This feature is specific at Markdown (not test with other format for the moment).

{{< grid-layout number-columns="2" >}}

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

{{< /grid-layout >}}


## Shortcodes

The shortcode can be construct as a empty element tag `{{< shortcode attribute="value" />}}` or with a start tag  `{{< shortcode attribute="value" >}}` with attributes and a end tag  `{{< /shortcode >}}`.
One of these peculiarities is that it can mutate to web component. This particularity allows to resolve certain conflict with the Doxia renderer.

One good shortcode sample is the Bootstrap badge. You want include a badge inline the text.

```
Lorem ipsum dolor sit amet {{< badge color="info" text="NEW" />}}, consectetur
adipiscing elit. Quare ad ea primum, si videtur; Hunc vos beatum; Nam ista vestra:
Si gravis, brevis; Sed haec in pueris
```

Now, you are just to create a template file with the same name of shortcode `badge.vm` in folder `src/site/layouts/snippets` and add following lines:

```html
<!-- src/site/layouts/snippets/badge.vm -->
<span class="badge ${snippet.color}">${snippet.text}</span>
```

That's it! It's short, quick and stylishness.

Here is another example always so easy, I want generalise the component callout that use everywhere in content page.

```html
{{< callout color="warning" level="5" title="Warning" >}}

Why does the cry assume the dapper sugar?

{{< /callout >}}
```

The associated template,

```html
<!-- src/site/layouts/snippets/callout.vm -->
<div class="bd-callout bd-callout-${snippet.color} $snippet.attr['class']">
 #if( ${snippet.title} )##
    <h${snippet.level} class="no-anchor">${snippet.title}</h${snippet.level}>
 #end##
  #render_html( ${snippet} )##
</div>
```

The facility macro `#render_html` renders the content html of snippet and execute included Velocity Template Language (VTL) macro.

### Tag Syntax

The shortcode must respect a strict shorthand notation so as not to be in conflict with the Doxia renderer.

- whitespaces are required after `{{<` and before `>}}`
- the empty line is required before and after each start and end tag.
- start and end tags must be placed at the start of a line.
- the empty tag `{{< shortcode />}}` or start and end tags can be used inline in same paragraph.

### Nested Shortcodes

You can include shortcodes within other shortcodes by creating your own templates that leverage the `$snippet.parent` property. `$snippet.parent` allows you to check the context in which the shortcode is being called.

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

To be recognized by reflow, a data element **should** be a xhtml element with a tag name differents of existing html tags.
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
    #include( 'src/site/svg/pretty.svg' )
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
    #render_html( $snippet.data-content )
   </div>
  </div>
#end
```

This example above uses the Velocity macro `#render_html( $snippet )` allowing execute `#include` Velocity Template Language (VTL) directive declared inside `web component` snippet.

### Debug Mode

Reflow provides the possibility to help the developement your new snippet displaying its structure in adding the attribute `debug=true`. In this example, card web component will be used.

{{< example >}}

{{% card debug="true" style="width: 18rem;" %}}

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
{{% card debug="true" style="width: 18rem;" %}}

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

## $snippet Variable

The `$snippet` variable is a instance of java class [Component](../reflow-velocity-tools/apidocs/org/devacfr/maven/skins/reflow/snippet/Component.html).

Take the first example, `$snippet.color`. It can have two meanings. It can mean, Look in the hashtable identified as snippet and return the attribute associated with the key `color`. But `$snippet.color` can also be referring to a `<color>` data element. `$snippet.color` could be an abbreviated way of writing `$snippet.attr['color]` or `$snippet.getAttribute('color')` for an attribute, or `$snippet.getChildren('color')` for an data element.

<!-- MACRO{partial|file=src/site/layouts/partials/snippets/snippet-property-table.html} -->

### Lookup Rules

As was mentioned earlier, properties refer to attribute or data element of the parent object. Reflow uses the following lookup sequence. For names, such as `$snippet.class`, the sequence is:

- `getclass()`
- `getClass()`
- `get("class")`
  - Returns `getAttrs()["class"]` attibute if exists
  - if the property name has suffix "s" `getChildren("class")`, try returns a list .
  - `getChildren("class")` Returns the first element if exists.
- isClass()

{{< callout color="warning" level="5" title="Of course" >}}

In this example, `\$snippet.class` will returns a string representing the class name `"org.devacfr.maven.skins.reflow.snippet.SnippetComponent"`. It's not what you want.
You shouldn't use the `class` attribute directly like this `$snippet.data-content.class`, but instead `$snippet.data-content.attr['class']`.

{{< /callout >}}

## Template

The template uses [Velocity Template](https://velocity.apache.org/engine/1.7/developer-guide.html) to generate html content. the file have to be located in path `src/site/layouts/snippets`.

### Override Template

Template can override existing template.
