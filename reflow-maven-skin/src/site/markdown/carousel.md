# Carousel

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

[carousel-reflow]: ../
[carousel-bootstrap]: http://twitter.github.com/bootstrap/javascript.html#carousel
