# Page section layouts

When writing Maven site pages using most of the available file formats, such as
[APT, XDoc or Markdown][doxia-formats], it is difficult to write anything more but a
straightforward linear page with headings to split the content. Reflow skin allows customizing
the page layout and reflowing the page using columns, thumbnails, or with the _carousel_ component.

The page is divided into _sections_ and each section can be assigned a special layout for its
contents. The different layouts are discussed in more detail below. The sections are specified
using `<sections>` element in the per-page (or global) configuration:

```xml
<custom>
  <reflowSkin>
    ...
    <pages>
      <index>
        <!-- index.html sections (examples of all available sections) -->
        <sections>
          <carousel />
          <thumbs>2</thumbs>
          <body />
          <sidebar />
          <columns>3</columns>
        </sections>
        ...
      </index>
      ...
    </pages>
    ...
  </reflowSkin>
</custom>
```

[doxia-formats]: http://maven.apache.org/doxia/references/index.html

## Defining sections

Page sections are indicated using _horizontal rule_ (`<hr/>`) elements in the generated page.
Check your file format reference on how to write them, e.g. `"==="` for [APT][apt-ref] or `"---"`
for [Markdown][markdown-hr-ref].

If sections are configured for a page, its contents are split on the `<hr/>` element
and indicated section layout is used sequentially. For all sections that have undefined
layout, `<body/>` is used (just plain body text). So for the example configuration above, the index
page is expected to have at least 5 sections, separated by _horizontal rules_. Then the first
one will be formatted as _carousel_, followed by a 2-column _thumbnails_ section, followed by
a _body_ text with _sidebar_ (2 sections here), then with 3-_column_ section. If there are more
sections after this in the text, they will have usual _body_ text layout.

Note that the layout actually defines how the _subsections_ of each section are laid out.
_Subsections_ currently are produced by splitting the section at the inner headings.

## Responsive design

Reflow skin is built on [Bootstrap][bootstrap] and provides responsive design features out of the
box. The page layouts are rearranged for smaller screens to provide a good viewing experience.

[apt-ref]: http://maven.apache.org/doxia/references/apt-format.html
[markdown-hr-ref]: http://daringfireball.net/projects/markdown/syntax#hr
[themes-reflow]: themes/#theme-bootswatch
[bootstrap]: http://getbootstrap.com
