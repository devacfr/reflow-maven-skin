# Working with Snippet

A shortcode or web component are a simple snippet inside a page that Reflow will render using a predefined template. This feature is specific at Markdown for the preview version.

## Usage

There are 2 types of snippet managed by Reflow:

- the **web component** - for the moment (in preview version), it is a monolithic/autonomous block. it can't include other snippets (web component or shortcode). The web component is perfect to create a generic component.
- the **shortcode** - as indicated by his name, for short stuff as create an unified layout, include a specific information, modify a rendering part by Doxia.

### $snippet Variable

- `$snippet.name` -
- `$snippet.parent` -
- `$snippet.html` -
- `$snippet.[attr]` -
- `$snippet.attr[]` -
- `$snippet.[data]` -


## Template

The template uses [Velocity Template](https://velocity.apache.org/engine/1.7/developer-guide.html) to generate html content. the file have to be located in path `src/site/snippets`.

### Web component

The web component is composed by tag element with attributes, an associated xml data structure and a  velocity template file. The data part is enclosed in comment html element ( `<!-- -->`) and enclose in start tag `{{% component %}}` and tag `{{% /component %}}`. the template file name should be have same name as web compenent. For the following example, the template file name should be `src/site/snippets/component.vm`.

  ⚠️ the syntax of tag is important. Whitespaces are required after `{{%` and before `%}}` and the empty line after the snippet.

```html
{{% component attribute="value" %}}

<!--
<data>
  <item>Header Section</item>
  <content>
    <div>html used in template</div>
  </content>
</data>
-->

{{% /component%}}
```

The template use `$snippet` variable to render the component.

```html
#if( $snippet.attribute == 'value' )
  <div class="component">
    <h2>$snippet.item.body</h2>
   <div #if( $snippet.content.attr['class'] )class="$snippet.content.attr['class']"#end>
   $snippet.content.html
   </div>
  </div>
#end
```

### Shortcode

The Shortcode can be construct as empty element tag `{{< component attribute="value"/ >}}` or with start tag  `{{< component attribute="value" >}}` and end tag  `{{< /component >}}`.

  ⚠️ the syntax of tag is important. Whitespaces are required after `{{<` and before `>}}` and the empty line after the snippet.

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
---
It uses utility classes for typography and spacing to space content out within the larger container.

{{< /jumbotron >}}
```

The associated template use `$snippet` variable in velocity context to render the component.

```html
<div class="jumbotron #if( $snippet.attr['class'] )class=" $snippet.attr['class']"#end">
   $snippet.html
</div>
```

