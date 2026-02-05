# Bootswatch Morph theme

This page is using a free [Morph theme][bootswatch-theme], courtesy of
[Bootswatch][bootswatch].

To use this theme with Reflow Maven skin, use the following `<theme>` configuration
in the [`site.xml` site descriptor][site-xml] file:
  
```xml
<custom>
  <reflowSkin>
    ...
    <theme>bootswatch-morph</theme>
    ...
  </reflowSkin>
</custom>
```

## Overview

### Buttons

{{< bs-button color="outline-primary" >}}Primary{{< /bs-button >}}
{{< bs-button color="outline-secondary" >}}Secondary{{< /bs-button >}}
{{< bs-button color="outline-success" >}}Success{{< /bs-button >}}
{{< bs-button color="outline-danger" >}}Danger{{< /bs-button >}}
{{< bs-button color="outline-warning" >}}Warning{{< /bs-button >}}
{{< bs-button color="outline-info" >}}Info{{< /bs-button >}}
{{< bs-button color="outline-light" >}}Light{{< /bs-button >}}
{{< bs-button color="outline-dark" >}}Dark{{< /bs-button >}}
{{< bs-button color="outline-link" >}}Link{{< /bs-button >}}

{{< layout class="my-4" >}}
{{< layout class="btn-group" role="group" aria-label="Basic example" >}}
{{< bs-button color="secondary" >}}Left{{< /bs-button >}}
{{< bs-button color="secondary" >}}Middle{{< /bs-button >}}
{{< bs-button color="secondary" >}}Right{{< /bs-button >}}
{{< /layout >}}
{{< /layout >}}

{{< layout class="btn-toolbar d-block my-4" role="toolbar" aria-label="Toolbar with button groups" >}}
{{< layout class="btn-group mr-2" role="group" aria-label="First group" >}}
{{< bs-button color="primary" >}}1{{< /bs-button >}}
{{< bs-button color="primary" >}}2{{< /bs-button >}}
{{< bs-button color="primary" >}}3{{< /bs-button >}}
{{< bs-button color="primary" >}}4{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Second group" >}}
{{< bs-button color="secondary" >}}5{{< /bs-button >}}
{{< bs-button color="secondary" >}}6{{< /bs-button >}}
{{< bs-button color="secondary" >}}7{{< /bs-button >}}
{{< /layout >}}
{{< layout class="btn-group mr-2" role="group" aria-label="Third group" >}}
{{< bs-button color="success" >}}8{{< /bs-button >}}
{{< /layout >}}
{{< /layout >}}

### Typography

{{< row >}}
{{< column >}}
<!--
<div class="bs-component">
  <h1 class="no-anchor">Heading 1</h1>
  <h2 class="no-anchor">Heading 2</h2>
  <h3 class="no-anchor">Heading 3</h3>
  <h4 class="no-anchor">Heading 4</h4>
  <h5 class="no-anchor">Heading 5</h5>
  <h6 class="no-anchor">Heading 6</h6>
  <h3 class="no-anchor">
    Heading
    <small class="text-body-secondary">with faded secondary text</small>
  </h3>
  <p class="lead">Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor.</p>
</div>
-->
{{< /column >}}
{{< column >}}
<!--
<div class="bs-component">
  <h2 class="no-anchor">Example body text</h2>
  <p>Nullam quis risus eget <a href="#">urna mollis ornare</a> vel eu leo. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nullam id dolor id nibh ultricies vehicula.</p>
  <p><small>This line of text is meant to be treated as fine print.</small></p>
  <p>The following is <strong>rendered as bold text</strong>.</p>
  <p>The following is <em>rendered as italicized text</em>.</p>
  <p>An abbreviation of the word attribute is <abbr title="attribute">attr</abbr>.</p>
</div>
-->
{{< /column >}}
{{< column >}}
<!--
<div class="bs-component">
  <h2 class="no-anchor">Emphasis classes</h2>
  <p class="text-primary">.text-primary</p>
  <p class="text-primary-emphasis">.text-primary-emphasis</p>
  <p class="text-secondary">.text-secondary</p>
  <p class="text-secondary-emphasis">.text-secondary-emphasis</p>
  <p class="text-success">.text-success</p>
  <p class="text-success-emphasis">.text-success-emphasis</p>
  <p class="text-danger">.text-danger</p>
  <p class="text-danger-emphasis">.text-danger-emphasis</p>
  <p class="text-warning">.text-warning</p>
  <p class="text-warning-emphasis">.text-warning-emphasis</p>
  <p class="text-info">.text-info</p>
  <p class="text-info-emphasis">.text-info-emphasis</p>
  <p class="text-light">.text-light</p>
  <p class="text-light">.text-light-emphasis</p>
  <p class="text-dark">.text-dark</p>
  <p class="text-dark">.text-dark-emphasis</p>
  <p class="text-body">.text-body</p>
  <p class="text-body">.text-body-emphasis</p>
  <p class="text-body-secondary">.text-body-secondary</p>
  <p class="text-body-tertiary">.text-body-tertiary</p>
</div>
-->
{{< /column >}}
{{< /row >}}

{{< row >}}
{{< column >}}
<!--
<div class="bs-component">
  <figure>
    <blockquote class="blockquote">
      <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>

    </blockquote>
    <figcaption class="blockquote-footer">
      Someone famous in <cite title="Source Title">Source Title</cite>
    </figcaption>
  </figure> 
</div>   
-->
{{< /column >}}
{{< column >}}
<!--
<div class="bs-component">
  <figure class="text-center">
    <blockquote class="blockquote">
      <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>

    </blockquote>
    <figcaption class="blockquote-footer">
      Someone famous in <cite title="Source Title">Source Title</cite>
    </figcaption>
  </figure>  
</div>
  -->
{{< /column >}}
{{< column >}}
<!--
<div class="bs-component">
  <figure class="text-end">
    <blockquote class="blockquote">
      <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>

    </blockquote>
    <figcaption class="blockquote-footer">
      Someone famous in <cite title="Source Title">Source Title</cite>
    </figcaption>
  </figure>    
</div>
-->
{{< /column >}}
{{< /row >}}

Find other theme options for Reflow Maven skin [here][reflow-themes].

[bootswatch-theme]: http://bootswatch.com/morph/
[bootswatch]: http://bootswatch.com
[site-xml]: https://maven.apache.org/doxia/doxia-sitetools/doxia-site-model/site.html
[reflow-themes]: ../reflow-documentation.html#themes-index
