# Carousel

support <span class="badge badge-dark">v1.0+</span> element <span class="badge badge-secondary">reflow</span> <span class="badge badge-info">layout</span>

_Carousel_ component provides a slideshow of images with captions. It is normally used in front page
to advertise main features or showcase a portfolio, etc. See one in action at the top of the
[front page of this site][carousel-reflow], or as a [Bootstrap component][carousel-bootstrap].

Carousel section is indicated using `<carousel />` element without any attributes:

```xml
...
<sections>
  <carousel />
  ...
</sections>
...
```

Carousel is constructed by displaying each subsection in the text as a carousel slide. The first
image in the section becomes the carousel image. The subsection header and text consitute the slide
caption. For best results, aim for images of the same size, and use `h4` headings for the
subsections.

Here is a example with 3 carousel items write in markdown:

```markdown
#### [Title of 1 item](http://company.com/link1)

[![Image 1](images/image1.png)](http://company.com/link1)

Text Description of carousel item.

#### [Title of 2 item](http://company.com/link2)

[![Image 2](images/image2.jpg)](http://company.com/link2)

Text Description of carousel item.

#### [Title of 3 item](http://company.com/link2)

[![Modern skin](images/image3.jpg)](http://company.com/link2)

Text Description of carousel item.

---
```

[carousel-reflow]: ../
[carousel-bootstrap]: http://twitter.github.com/bootstrap/javascript.html#carousel
