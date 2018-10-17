# Sidebar

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">layout</span>

_Sidebar_ layout places the section contents into a sidebar with shaded background. If the sidebar
follows _body_ section, it is placed side-by-side with the body text. Otherwise it occupies a whole
row.

If sidebar ToC is used, it is placed within the first sidebar in the page.

Sidebar section is indicated using `<sidebar />` element without any attributes.

```xml
...
<sections>
  ...
  <body />
  <sidebar />
  ...
</sections>
...
```
