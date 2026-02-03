# Breadcrumb

element {{< badge color="secondary" text="site.xml" />}}

{{< example class="mb-4" >}}

{{< breadcrumb />}}

{{< /example >}}

Breadcrumbs are defined using standard Maven site element
[`<body><breadcrumbs>`][mvn-site-breadcrumbs] in `site.xml`.
Reflow skin provides a `<breadcrumbs>` flag to enable/disable them:

```xml
<breadcrumbs>true|false</breadcrumbs>
```

- **true (default)** - Breadcrumb trail is displayed below the banner
- **false** - Do not display breadcrumbs

{{< callout title="Note" level="5" color="info" >}}

The breadcrumbs bar must be enabled if Maven site date or version are set to position **left** or **right**.

{{< /callout >}}


[mvn-site-breadcrumbs]: http://maven.apache.org/plugins/maven-site-plugin/examples/sitedescriptor.html#Breadcrumbs
