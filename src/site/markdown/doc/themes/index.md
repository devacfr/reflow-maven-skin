# Themes

support {{< bagde color="primary" text="v1.0" />}} <br/>
element {{< bagde color="secondary" text="reflow" />}}

Reflow skin builds on [Twitter Bootstrap][bootstrap] and supports predefined and custom
Bootstrap themes. They are set using the `<theme>` element in the customization:

[bootstrap]: http://getbootstrap.com/

```xml
<custom>
  <reflowSkin>
    ...
    <theme>default|bootswatch-*</theme>
    ...
  </reflowSkin>
</custom>
```

There are several options for the `<theme>` value:

- **`default`**

    (**Default**: will be used if `<theme>` is not set).

    Default Bootstrap theme (version ${bootstrapVersion}). The default theme (with minor customizations)
    is used for this website.

    The default Bootstrap theme is loaded from the
    [BootstrapCDN Content Delivery Network][bootstrapcdn], which improves website loading
    by hosting the Bootstrap CSS and JavaScript files.

- **`bootswatch-*`**

    One of free Bootstrap themes from [Bootswatch][bootswatch]. Append the lowercase theme name
    in the [Bootswatch gallery][bootswatch-gallery], e.g. `bootswatch-readable`.

    Bootswatch themes (default version ${bootstrapVersion}) are loaded from the
    [BootstrapCDN Content Delivery Network][bootstrapcdn].

    Preview full themes at the [Bootswatch gallery][bootswatch-gallery],
    or check out several examples of Reflow skin using Bootswatch themes below.

[bootstrapcdn]: http://bootstrapcdn.com
[bootstrap-custom]: http://twitter.github.com/bootstrap/customize.html
[bootswatch]: http://bootswatch.com
[bootswatch-gallery]: http://bootswatch.com/#gallery

{{< row class="row-cols-1 row-cols-md-3" >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-cerulean.html"><img src="../images/doc/bootswatch-cerulean.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-cerulean.html">Cerulean</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-cerulean&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-cosmo.html"><img src="../images/doc/bootswatch-cosmo.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-cosmo.html">Cosmo</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-cosmo&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-darkly.html"><img src="../images/doc/bootswatch-darkly.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-darkly.html">Darkly</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-darkly&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-flatly.html"><img src="../images/doc/bootswatch-flatly.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Flatly</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-flatly&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-journal.html"><img src="../images/doc/bootswatch-journal.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Journal</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-journal&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-litera.html"><img src="../images/doc/bootswatch-litera.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Litera</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-litera&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-lumen.html"><img src="../images/doc/bootswatch-lumen.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Lumen</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-lumen&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-lux.html"><img src="../images/doc/bootswatch-lux.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Lux</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-lux&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-materia.html"><img src="../images/doc/bootswatch-materia.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Materia</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-materia&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-minty.html"><img src="../images/doc/bootswatch-minty.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Minty</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-minty&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-pulse.html"><img src="../images/doc/bootswatch-pulse.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Pulse</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-pulse&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-sandstone.html"><img src="../images/doc/bootswatch-sandstone.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Sandstone</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-sandstone&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-simplex.html"><img src="../images/doc/bootswatch-simplex.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Simplex</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-simplex&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-sketchy.html"><img src="../images/doc/bootswatch-sketchy.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Sketchy</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-sketchy&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-slate.html"><img src="../images/doc/bootswatch-slate.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Slate</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-slate&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-solar.html"><img src="../images/doc/bootswatch-solar.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Solar</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-solar&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-spacelab.html"><img src="../images/doc/bootswatch-spacelab.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Spacelab</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-spacelab&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-superhero.html"><img src="../images/doc/bootswatch-superhero.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Superhero</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-superhero&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-united.html"><img src="../images/doc/bootswatch-united.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">United</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-united&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <a href="themes/bootswatch-yeti.html"><img src="../images/doc/bootswatch-yeti.png" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Yeti</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-yeti&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< column class="mb-4" >}}

{{% card class="h-100" %}}

```
    <card-body>
        <h5 class="card-title no-anchor"><a href="http://bootswatch.com/#gallery" target="_blank" rel="noopener">And more..</a></h5>
        <pre>
        <code>
&lt;theme&gt;bootswatch-*&lt;/theme&gt;
        </code>
        </pre>
    </card-body>
```

{{% /card  %}}

{{< /column >}}

{{< /row >}}

All theme images above are from the [Bootswatch gallery][bootswatch-gallery].
