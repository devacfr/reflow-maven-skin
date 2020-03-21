# Breadcrumb

element <span class="badge badge-secondary">site.xml</span>

![breadcrumb scheme](../images/doc/breadcrumb-scheme.png)

Breadcrumbs are defined using standard Maven site element
[`<body><breadcrumbs>`][mvn-site-breadcrumbs] in `site.xml`.
Reflow skin provides a `<breadcrumbs>` flag to enable/disable them:

```xml
<breadcrumbs>true|false</breadcrumbs>
```

- **true (default)** - Breadcrumb trail is displayed below the banner
- **false** - Do not display breadcrumbs

<div class="bd-callout bd-callout-info">
    <h4 class="no-anchor">Note</h4>
    <p>The breadcrumbs bar must be enabled if Maven site date or version are set to position <b>left</b> or <b>right</b>.</p>
</div>


[mvn-site-breadcrumbs]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Breadcrumbs
