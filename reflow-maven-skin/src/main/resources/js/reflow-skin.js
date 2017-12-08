"use strict";
// Additional skin Javascript
// ++++++++++++++++++++++++++++++++++++++++++

!function ($) {

  $(function(){

    var $window = $(window)

    // Start carousel
    $(function() {
      $('.carousel').carousel();
    });

    // activate syntax higlighting with highlight.js
    // Note: only run if `hljs` exists
    if (typeof hljs !== 'undefined')
    {
      // classic encoding with <div class="source"><pre></pre></div>
      // and HTML5 version with <pre><code></code></pre>
      $('div.source pre, pre code').each(function(i, e) {hljs.highlightBlock(e)});
    }

    // toc aside bar
    if ($('#toc-sidebar[data-spy=affix]').length) {
    $('#toc-sidebar').affix({
      offset: {
      top: $('#toc-sidebar').offset().top,
      bottom: ($('footer').outerHeight(true) +
              $('.subfooter').outerHeight(true)-40) //padding of footer.
      }
      });
    }

    function resizeTopNavBar() {
      var navbar = $('#m-top-navbar');
      var size = 0;
      if (navbar.length) {
        size = navbar.height() + 20; // normally 70
      }
      $('body').css('padding-top',size);
    }

    $(window).resize(resizeTopNavBar);
    // initialize size on start up
    resizeTopNavBar();

  });

}(window.jQuery)
