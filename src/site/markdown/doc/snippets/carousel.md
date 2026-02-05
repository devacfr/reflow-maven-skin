# Carousel

{{< badge color="info" text="WEB COMPONENT" class="ms-1" />}}

[Based on Bootstrap Carousel page](https://getbootstrap.com/docs/5.3/components/carousel/)

{{< layout class="bd-subtitle" >}}A slideshow component for cycling through elements—images or slides of text—like a carousel.{{< /layout >}}

## How it works

* The carousel is a slideshow for cycling through a series of content, built with CSS 3D transforms and a bit of JavaScript. It works with a series of images, text, or custom markup. It also includes support for previous/next controls and indicators.
* For performance reasons, `carousels must be manually initialized` using the [carousel constructor method](https://getbootstrap.com/docs/5.3/components/carousel/#methods). Without initialization, some of the event listeners (specifically, the events needed touch/swipe support) will not be registered until a user has explicitly activated a control or indicator.
The only exception are [autoplaying carousels](https://getbootstrap.com/docs/5.3/components/carousel/#autoplaying-carousels) with the `data-bs-ride="carousel"` attribute as these are initialized automatically on page load. If you’re using autoplaying carousels with the data attribute, `don’t explicitly initialize the same carousels with the constructor method`.
* Nested carousels are not supported. You should also be aware that carousels in general can often cause usability and accessibility challenges.

{{< callout color="info" >}}
The animation effect of this component is dependent on the `prefers-reduced-motion` media query. See the [reduced motion section of our accessibility documentation](https://getbootstrap.com/docs/5.3/getting-started/accessibility/#reduced-motion).
{{< /callout >}}

## Basic examples

Here is a basic example of a carousel with three slides. Note the previous/next controls.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel1" withControls="true" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### Slides only

Here’s a carousel with slides only. Note the presence of the `.d-block` and `.w-100` on carousel images to prevent browser default image alignment.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel1" withControls="false" withIndicators="false" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="false" withIndicators="false" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### With controls

Adding in the previous and next controls:

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel2" withControls="true" withIndicators="false" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" withIndicators="false" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### With indicators

You can also add the indicators to the carousel, alongside the controls, too.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel3" withControls="true" withIndicators="true" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" withIndicators="true" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### With captions

Add captions to your slides easily with the `<slide-caption>` element within any `<slide>` element. They can be easily hidden on smaller viewports, as shown below, with optional Bootstrap display utilities. We hide them initially with `.d-none` and bring them back on medium-sized devices with `.d-md-block`.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel4" withControls="true" withIndicators="true" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
        <slide-caption class="d-none d-md-block" >
          <h5>First slide label</h5>
          <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
        </slide-caption>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
        <slide-caption class="d-none d-md-block" >
          <h5>Second slide label</h5>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
        </slide-caption>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
        <slide-caption class="d-none d-md-block" >
          <h5>Third slide label</h5>
          <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
        </slide-caption>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" withIndicators="true" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
    <slide-caption class="d-none d-md-block" >
      <h5>First slide label</h5>
      <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
    </slide-caption>  
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
    <slide-caption class="d-none d-md-block" >
      <h5>Second slide label</h5>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </slide-caption>
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
    <slide-caption class="d-none d-md-block" >
      <h5>Third slide label</h5>
      <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
    </slide-caption>
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### Crossfade

set `crossfade="true"` attribute to your carousel to animate slides with a fade transition instead of a slide.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel5" withControls="true" withIndicators="false" crossfade="true" %}}
<!--
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" withIndicators="false" crossfade="true" %}}
<!--
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
  <slide>
    <slide-image src="..." class="d-block w-100" />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}

### Individual interval

Add `interval=""` attribute to a `<slide>` element to change the amount of time to delay between automatically cycling to the next item.

{{% example %}}
{{< preview-section >}}

{{% carousel id="carousel5" withControls="true" withIndicators="false" %}}
<!--
    <slide interval="10000">
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: First slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">First slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide interval="2000">
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Second slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Second slide</text>
            </svg>
        </slide-image>
    </slide>
    <slide>
        <slide-image>
            <svg class="bd-placeholder-img bd-placeholder-img-lg d-block w-100" width="800" height="400" xmlns="http://www.w3.org/2000/svg" 
            preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Third slide">
                <title>Placeholder</title>
                <rect width="100%" height="100%" fill="#666"></rect>
                <text x="50%" y="50%" fill="#444" dy=".3em">Third slide</text>
            </svg>
        </slide-image>
    </slide>
-->
{{% /carousel %}}
{{< /preview-section >}}
{{< code-section >}}

```xml
{{% carousel id="carousel" withControls="true" withIndicators="false" crossfade="true" %}}
<!--
  <slide interval="10000">
    <slide-image src="..." />
  </slide>
  <slide interval="2000">
    <slide-image src="..." />
  </slide>
  <slide>
    <slide-image src="..." />
  </slide>
-->
{{% /carousel %}}
```

{{< /code-section >}}
{{% /example %}}
