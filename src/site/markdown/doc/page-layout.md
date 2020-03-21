# Page Layout

Page layout is the standard representation in Reflow skin.

![page layout](../images/doc/page-layout-scheme.png)

The content of page is put in `body` container. All components around the body are customized globally or locally to this page. To customized the `body` itself, see [Section Layout documention][section-layout] for more information

## Usage

support <span class="badge badge-primary">v1.0</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">element</span>

```xml
...
<custom>
    <reflowSkin>
        <pages>
            <page-id project="Maven artifactId" type="page">
            <!-- usage/basic.html in "my-project" project only: submodules will not inherit -->
            ...
            </page-id>
        <pages>
    </reflowSkin>
</custom>
...
```

- **project** <span class="badge badge-light">v1.0</span> - `project` attribute associates the page to specific Maven artifactId declaring in the project. This can be useful to exclude all inherit configuration on same page name localized in other module in project. **Be careful** that `name` attribute in root `<project>` element in site.xml is used to set the site title.
- **type** <span class="badge badge-light">v2.0</span> - the `page` layout is **default** represention in Reflow skin.

[section-layout]: #section-layout.html
