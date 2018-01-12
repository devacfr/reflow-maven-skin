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
          timeStamp = e.timeStamp;
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

function getViewPort() {
  var e = window, a = 'inner';
  if (!('innerWidth' in window)) {
    a = 'client';
    e = document.documentElement || document.body;
  }

  return {
    width : e[a + 'Width'],
    height : e[a + 'Height']
  };
}

var timestampSideBar = 0;

// Additional skin Javascript
// ++++++++++++++++++++++++++++++++++++++++++
!function($) {

  $(function() {

    var $window = $(window);
    var $body   = $(document.body);
    var sidebar = $('.m-toc-sidebar-container');
    
    function getSidebarContainerOffset() {
      if (sidebar.hasClass('affix')) {
        // size header
        return 70
      } else {
        return sidebar.offset().top;
      }
    }

    sidebar.mCustomScrollbar({
      theme : "inset",
      axis : "y",
      setHeight : getViewPort().height - getSidebarContainerOffset()
    });

    $window.resize(function() {
      sidebar.css('height', (getViewPort().height - getSidebarContainerOffset()) + 'px');
    });

    
    $body.scrollspy({
      target: '.m-toc-sidebar'
    });
    
    /*
    sidebar.on('activate.bs.scrollspy', function(evt) {
      var el = $(evt.target);
      if (timestampSideBar > 0 && evt.timeStamp < timestampSideBar + 100)
        return false;
      timestampSideBar = evt.timeStamp;
      var container = sidebar.find('.mCSB_container');
      var offsetHeight = 0;
      var elHeight = container.height()

      var parent = $(el.offsetParent())
      offsetHeight = el.position().top;
      while (!parent.hasClass('mCSB_container')) {
        offsetHeight += parent.position().top;
        parent = $(parent.offsetParent());
      }
      var offset = offsetHeight; // - (elHeight / 2);
      // sidebar.mCustomScrollbar("scrollTo",el);
      sidebar.mCustomScrollbar("scrollTo", offset);
      evt.stopImmediatePropagation();
      return false;
    });
    
    */

    // toc aside bar
    if ($('.m-toc-sidebar-container[data-spy=affix]').length) {
      sidebar.affix({
        offset : {
          top : sidebar.offset().top,
          bottom : ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 40)
        // padding of footer.
        }
      });
    }

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
