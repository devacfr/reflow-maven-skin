# Page Body layout

Body layout is composed only header (navbar), body and footer. You can play only with the body content. The content is put as is, Reflow maven skin should not modify this content. Let's be free in your inspiration to create a attractive home page.

![body layout](images/body-layout-scheme.png)

## Usage

support <span class="badge badge-primary">v2.3</span> <span class="badge badge-success">new</span><br/>
element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">element</span>

To declare a page as body layout, create an page (`index.html` in example below) and set `type` attribute with value `body`.

```xml
<pages>
    ...
    <index type="body" project="project-id">
    </index>
    ...
</pages>
```

- **project** <span class="badge badge-light">v1.0</span> - `project` attribute associates the page to specific Maven artifactId declaring in the project. This can be useful to exclude all inherit configuration on same page name localized in other module in project. **Be careful** that `name` attribute in root `<project>` element in site.xml is used to set the site title.
