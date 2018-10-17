# Thumbnails

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">layout</span>

_Thumbnails_ layout is best suited to produce a gallery of images. Each subsection constitutes a
thumbnail block, with its first image followed by the subsection heading and text. The [themes
page][themes-reflow] uses thumbnails to showcase examples of Bootswatch themes.

Thumbnails are placed in columns, so the same requirements as in _columns_ layout apply. To set
the layout with the number of columns, use `<thumbs>num</thumbs>` element:

```xml
...
<sections>
  ...
  <thumbs>3</thumbs>
  ...
</sections>
...
```
