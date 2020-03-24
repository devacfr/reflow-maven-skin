# Page Body layout

Body layout is composed only header (navbar), body and footer. You can play only with the body content. The content is put as is, Reflow maven skin should not modify this content. Let's be free in your inspiration to create a attractive home page.

![body layout](../images/doc/body-layout-scheme.png)

## Usage

support {{< badge color="primary" text="New in v2.3" />}} <br/>
element {{< badge color="secondary" text="reflow" />}} {{< badge color="info" text="element" />}}

To declare a page as body layout, create an page (`index.html` in example below) and set `type` attribute with value `body`.

```xml
<pages>
    ...
    <index type="body" project="project-id">
    </index>
    ...
</pages>
```

- **project** {{< badge color="light" text="v1.0" />}} - `project` attribute associates the page to specific Maven artifactId declaring in the project. This can be useful to exclude all inherit configuration on same page name localized in other module in project. **Be careful** that `name` attribute in root `<project>` element in site.xml is used to set the site title.
