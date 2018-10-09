# Body

_Body_ layout just outputs the page contents as they are. The subsections are output sequentially.
If no _sidebar_ (or sidebar ToC) is indicated, the _body_ text occupies full page width. Otherwise
it accommodates the sidebar and takes 3/4 of the page.

Body section is indicated using `<body />` element without any attributes. The layout is also used
as default for sections without explicit layout.

```xml
...
<sections>
  ...
  <body />
  ...
</sections>
...
```
