# Carousel Snippet

A slideshow component for cycling through elements—images or slides of text—like a carousel.

## How it works

The carousel is a slideshow for cycling through a series of content, built with CSS 3D transforms and a bit of JavaScript. It works with a series of images, text, or custom markup. It also includes support for previous/next controls and indicators.

## Example

Carousels don’t automatically normalize slide dimensions. As such, you may need to use additional utilities or custom styles to appropriately size content. While carousels support previous/next controls and indicators, they’re not explicitly required. Add and customize as you see fit.

### Slides only

Here’s a carousel with slides only. Note the presence of the `.d-block` and `.w-100` on carousel images to prevent browser default image alignment.

{{% carousel id="carousel1" withControls="false" withIndicators="false" %}}

```
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
```

{{% /carousel %}}

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

### With controls

Adding in the previous and next controls:

{{% carousel id="carousel2" withControls="true" withIndicators="false" %}}

```
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
```

{{% /carousel %}}

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

### With indicators

You can also add the indicators to the carousel, alongside the controls, too.

{{% carousel id="carousel3" withControls="true" withIndicators="true" %}}

```
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
```

{{% /carousel %}}

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

### With captions

Add captions to your slides easily with the `<slide-caption>` element within any `<slide>` element. They can be easily hidden on smaller viewports, as shown below, with optional Bootstrap display utilities. We hide them initially with `.d-none` and bring them back on medium-sized devices with `.d-md-block`.

{{% carousel id="carousel4" withControls="true" withIndicators="true" %}}

```
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
```

{{% /carousel %}}

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

### Crossfade

set `crossfade="true"` attribute to your carousel to animate slides with a fade transition instead of a slide.

{{% carousel id="carousel5" withControls="true" withIndicators="false" crossfade="true" %}}

```
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
```

{{% /carousel %}}

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

### Individual interval

Add `interval=""` attribute to a `<slide>` element to change the amount of time to delay between automatically cycling to the next item.

{{% carousel id="carousel5" withControls="true" withIndicators="false" %}}

```
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
```

{{% /carousel %}}

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
