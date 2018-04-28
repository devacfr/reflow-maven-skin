"use strict";
/*
 * By Osvaldas Valutis, www.osvaldas.info Available for use under the MIT
 * License
 */
(function($, window, document, undefined) {
  $.fn.doubleTapToGo = function(params) {
    if (!('ontouchstart' in window) && !navigator.msMaxTouchPoints
        && !navigator.userAgent.toLowerCase().match(/windows phone os 7/i))
      return false;

    this.each(function() {
      var curItem = false;

      $(this).on('click', function(e) {
        var item = $(this);
        if (item[0] != curItem[0]) {
          e.stopPropagation();
          e.preventDefault();
          curItem = item;
        }
      });

      $(document).on('click touchstart MSPointerDown', function(e) {
        var resetItem = true, parents = $(e.target).parents();

        for (var i = 0; i < parents.length; i++)
          if (parents[i] == curItem[0]) {
            resetItem = false;
            break;
          }

        if (resetItem)
          curItem = false;
      });
    });
    return this;
  };
})(jQuery, window, document);

// Additional skin Javascript
// ++++++++++++++++++++++++++++++++++++++++++
!function($) {

  $(function() {

    var $window = $(window)

    // Start carousel
    $(function() {
      $('.carousel').carousel();
    });

    // activate syntax higlighting with highlight.js
    // Note: only run if `hljs` exists
    if (typeof hljs !== 'undefined') {
      // classic encoding with <div class="source"><pre></pre></div>
      // and HTML5 version with <pre><code></code></pre>
      $('div.source pre, pre code').each(function(i, e) {
        hljs.highlightBlock(e)
      });
    }

    // toc aside bar
    if ($('#toc-sidebar[data-spy=affix]').length) {
      $('#toc-sidebar').affix({
        offset : {
          top : $('#toc-sidebar').offset().top,
          bottom : ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 40)
        // padding of footer.
        }
      });
    }

    function resizeTopNavBar() {
      var navbar = $('#m-top-navbar');
      var size = 0;
      if (navbar.length) {
        size = navbar.height() + 20; // normally 70
      }
      $('body').css('padding-top', size);
    }

    $(window).resize(resizeTopNavBar);
    // initialize size on start up
    resizeTopNavBar();

    // prevents the browser from opening a URL but allows that if tapped once
    // again in succession
    $('.dropdown-submenu').doubleTapToGo();

  });

}(window.jQuery)
