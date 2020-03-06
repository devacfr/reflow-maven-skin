# Header Jumbotron

This page displays the jumbotron header.

To use this type of header with Reflow Maven skin, use the following `<header>` configuration
in the [`site.xml` site descriptor][site-xml] file:
  
```xml
<custom>
  <reflowSkin>
    ...
    <page>
        <header type="jumbotron">
        </header>
    </page>
    ...
  </reflowSkin>
</custom>
```

Find other theme options for Reflow Maven skin [here][reflow-header].

[site-xml]: http://maven.apache.org/doxia/doxia-sitetools/doxia-decoration-model/decoration.html
[reflow-header]: ../reflow-documentation.html#components-header
