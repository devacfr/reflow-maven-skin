# Bootswatch Flatly theme

This page is using a free [Flatly theme][bootswatch-theme], courtesy of
[Bootswatch][bootswatch].

To use this theme with Reflow Maven skin, use the following `<theme>` configuration
in the [`site.xml` site descriptor][site-xml] file:
  
```xml
<custom>
  <reflowSkin>
    ...
    <theme>bootswatch-flatly</theme>
    ...
  </reflowSkin>
</custom>
```

Find other theme options for Reflow Maven skin [here][reflow-themes].

[bootswatch-theme]: http://bootswatch.com/flatly/
[bootswatch]: http://bootswatch.com
[site-xml]: http://maven.apache.org/doxia/doxia-sitetools/doxia-decoration-model/decoration.html
[reflow-themes]: ../config.html#Themes
