# Themes

element {{< badge color="secondary" text="reflow" />}}

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
[bootswatch]: http://bootswatch.com
[bootswatch-gallery]: http://bootswatch.com/#gallery

{{< grid-layout number-columns="3" >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-brite.html" class="stretched-link"><img src="../images/doc/bootswatch-brite.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-brite.html">Brite</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-brite&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-cerulean.html" class="stretched-link"><img src="../images/doc/bootswatch-cerulean.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-cerulean.html">Cerulean</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-cerulean&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-cosmo.html" class="stretched-link"><img src="../images/doc/bootswatch-cosmo.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-cosmo.html">Cosmo</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-cosmo&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-cyborg.html" class="stretched-link"><img src="../images/doc/bootswatch-cyborg.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-cyborg.html">Cyborg</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-cyborg&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-darkly.html" class="stretched-link"><img src="../images/doc/bootswatch-darkly.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-darkly.html">Darkly</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-darkly&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-flatly.html" class="stretched-link"><img src="../images/doc/bootswatch-flatly.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-flatly.html">Flatly</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-flatly&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-journal.html" class="stretched-link"><img src="../images/doc/bootswatch-journal.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-journal.html">Journal</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-journal&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-litera.html" class="stretched-link"><img src="../images/doc/bootswatch-litera.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-litera.html">Litera</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-litera&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-lumen.html" class="stretched-link"><img src="../images/doc/bootswatch-lumen.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-lumen.html">Lumen</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-lumen&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-lux.html" class="stretched-link"><img src="../images/doc/bootswatch-lux.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-lux.html">Lux</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-lux&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-materia.html" class="stretched-link"><img src="../images/doc/bootswatch-materia.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-materia.html">Materia</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-materia&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-minty.html" class="stretched-link"><img src="../images/doc/bootswatch-minty.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-minty.html">Minty</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-minty&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-morph.html" class="stretched-link"><img src="../images/doc/bootswatch-morph.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-morph.html">Morph</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-morph&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-pulse.html" class="stretched-link"><img src="../images/doc/bootswatch-pulse.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-pulse.html">Pulse</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-pulse&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-quartz.html" class="stretched-link"><img src="../images/doc/bootswatch-quartz.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-quartz.html">Quartz</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-quartz&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-sandstone.html" class="stretched-link"><img src="../images/doc/bootswatch-sandstone.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-sandstone.html">Sandstone</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-sandstone&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-simplex.html" class="stretched-link"><img src="../images/doc/bootswatch-simplex.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-simplex.html">Simplex</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-simplex&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-sketchy.html" class="stretched-link"><img src="../images/doc/bootswatch-sketchy.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-sketchy.html">Sketchy</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-sketchy&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-slate.html" class="stretched-link"><img src="../images/doc/bootswatch-slate.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-slate.html">Slate</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-slate&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-solar.html" class="stretched-link"><img src="../images/doc/bootswatch-solar.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-solar.html">Solar</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-solar&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-spacelab.html" class="stretched-link"><img src="../images/doc/bootswatch-spacelab.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-spacelab.html">Spacelab</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-spacelab&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-superhero.html" class="stretched-link"><img src="../images/doc/bootswatch-superhero.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-superhero.html">Superhero</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-superhero&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-united.html" class="stretched-link"><img src="../images/doc/bootswatch-united.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-united.html">United</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-united&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-vapor.html" class="stretched-link"><img src="../images/doc/bootswatch-vapor.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-vapor.html">Vapor</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-vapor&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-yeti.html" class="stretched-link"><img src="../images/doc/bootswatch-yeti.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-yeti.html">Yeti</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-yeti&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <a href="themes/bootswatch-zephyr.html" class="stretched-link"><img src="../images/doc/bootswatch-zephyr.png" class="img-fluid" /></a>
        <h5 class="card-title no-anchor"><a href="themes/bootswatch-zephyr.html">Zephyr</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-zephyr&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< column class="mb-4" >}}
{{% card class="h-100" %}}
<!--
    <card-body>
        <h5 class="card-title no-anchor"><a href="http://bootswatch.com/#gallery" target="_blank" rel="noopener">And more..</a></h5>
        <pre><code>&lt;theme&gt;bootswatch-*&lt;/theme&gt;</code></pre>
    </card-body>
-->
{{% /card  %}}
{{< /column >}}

{{< /grid-layout >}}

All theme images above are from the [Bootswatch gallery][bootswatch-gallery].
