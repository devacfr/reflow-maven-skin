"use strict";

/*
 * By Osvaldas Valutis, www.osvaldas.info Available for use under the MIT
 * License
 */
(function ($, window, document, undefined) {
  $.fn.doubleTapToGo = function (params) {
    if (!('ontouchstart' in window) && !navigator.msMaxTouchPoints
      && !navigator.userAgent.toLowerCase().match(/windows phone os 7/i))
      return false;

    this.each(function () {
      var curItem = false;

      $(this).on('click', function (e) {
        var item = $(this);
        if (item[0] != curItem[0]) {
          e.stopPropagation();
          e.preventDefault();
          curItem = item;
        }
      });

      $(document).on('click touchstart MSPointerDown', function (e) {
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
    width: e[a + 'Width'],
    height: e[a + 'Height']
  };
}

var timestampSideBar = 0;

var mReflow = function () {
  var $window = $(window);
  var $body = $(document.body);

  function getTocSidebarContainerOffset(tocSidebar) {
    if (tocSidebar.hasClass('affix')) {
      // size header
      return 70;
    } else {
      return tocSidebar.offset().top;
    }
  }

  function initCarousel() {
    $('.carousel').carousel();
  }

  function initTocTop() {
    var tocTop = $('#toc-bar');
    if (!tocTop.length) {
      return;
    }

    if ($('#toc-bar[data-spy=affix]').length) {
      tocTop.affix({
        offset: {
          top: tocTop.offset().top,
          bottom: ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 70)
          // padding of footer.
        }
      });
    }

    $body.scrollspy({
      target: '#toc-bar'
    });
  }

  function initTocSidebar() {
    var tocSidebar = $('.m-toc-sidebar-container');
    if (!tocSidebar.length) {
      return;
    }
    // TODO
    /*
     * tocSidebar.mCustomScrollbar({ theme: "inset", axis: "y", setHeight:
     * getViewPort().height - getTocSidebarContainerOffset(tocSidebar) });
     * 
     * 
     * $window.resize(function () { tocSidebar.css('height',
     * (getViewPort().height - getTocSidebarContainerOffset(tocSidebar)) +
     * 'px'); });
     */

    /*
     * tocSidebar.on('activate.bs.scrollspy', function(evt) { var el =
     * $(evt.target); if (timestampSideBar > 0 && evt.timeStamp <
     * timestampSideBar + 100) return false; timestampSideBar = evt.timeStamp;
     * var container = tocSidebar.find('.mCSB_container'); var offsetHeight = 0;
     * var elHeight = container.height()
     * 
     * var parent = $(el.offsetParent()) offsetHeight = el.position().top; while
     * (!parent.hasClass('mCSB_container')) { offsetHeight +=
     * parent.position().top; parent = $(parent.offsetParent()); } var offset =
     * offsetHeight; // - (elHeight / 2); //
     * tocSidebar.mCustomScrollbar("scrollTo",el);
     * tocSidebar.mCustomScrollbar("scrollTo", offset);
     * evt.stopImmediatePropagation(); return false; });
     * 
     */

    // add auto collapase
    if ($body.hasClass('m-tocsidebar-collapsible') || tocSidebar.hasClass('nav-collapsible')) {

      tocSidebar.find('.nav-collapsible').addClass('collapse').attr('aria-expanded', 'false');

      tocSidebar.on('activate.bs.scrollspy', function () {
        var active = $('.m-toc-sidebar li.active');
        var collapsePanel = active.next('ul.nav.nav-collapsible');
        tocSidebar.find('ul.nav.nav-collapsible').each(function (index, element) {
          var el = $(element);
          if (el.is(collapsePanel))
            return;
          var children = el.find('li.active');
          if (children.length == 0) {
            el.collapse('hide');
          }
        });
        collapsePanel.collapse('show');
        active.parent('ul.nav.nav-collapsible').collapse('show');
      });
    }
    // toc sidebar
    if ($('.m-toc-sidebar-container[data-spy=affix]').length) {
      tocSidebar.affix({
        offset: {
          top: tocSidebar.offset().top,
          bottom: ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 70)
          // padding of footer.
        }
      });
    }

    $body.scrollspy({
      target: '.m-toc-sidebar'
    });
  }

  function initHighlight() {
    // activate syntax higlighting with highlight.js
    // Note: only run if `hljs` exists
    if (typeof hljs !== 'undefined') {
      // classic encoding with <div class="source"><pre></pre></div>
      // and HTML5 version with <pre><code></code></pre>
      $('div.source pre, pre code').each(function (i, e) {
        hljs.highlightBlock(e);
      });
    }
  }

  function initTopNavBar() {
    function resizeTopNavBar() {
      var navbar = $('#m-top-navbar');
      var size = 0;
      if (navbar.length) {
        size = navbar.height() + 20; // normally 70
      }
      $('body').css('padding-top', size);
    }
    $window.resize(resizeTopNavBar);
    // initialize size on start up
    resizeTopNavBar();
    // prevents the browser from opening a URL but allows that if tapped once
    // again in succession
    $('.dropdown-submenu').doubleTapToGo();
  }

  function scrollTo(el, offset, clbck) {
    var pos = (el && el.length > 0) ? el.offset().top : 0;
    pos = pos + (offset ? offset : 0);

    $('html,body').animate({
      scrollTop: pos
    }, 300, clbck);
  }

  function initScrollTop() {
    var el = $("#m-scroll-top");
    $window.scroll(function () {
      if ($(window).scrollTop() > 100) {
        el.fadeIn(500);
      } else {
        el.fadeOut(500);
      }
    });
    el.click(function () {
      window.scrollTo(0, 0);
    });
  }

  function loadFrame(href, slugName) {
    $('#m-doc-frame').load(href, function () {
      // find li parent of 'href'
      href = href.replace(/\./g, "\\.");
      var item = $('.nav-side-menu a[slug-name$="' + slugName + '"]').parent();
      // remove all active item
      $('.nav-side-menu li').removeClass('active');
      // activate current item
      item.addClass('active');

      scrollTo();
      initCarousel();
      initTocTop();
      initTocSidebar();
      initHighlight();
      initAnchorJs();
      refreshScrollSpy();

      var hash = window.location.hash;
      scrollTo($(hash));
    });
  }

  function initAnchorJs() {
    if (anchors && $body.hasClass('m-tocsidebar-enabled') || $body.hasClass('m-toctop-enabled')
      || $body.hasClass('m-sidenav-enabled')) {
      anchors.options = {
        placement: 'left',
      };
      anchors.add('h1,h2, h3, h4, h5, h6');
    }
  }

  function initNavSidebar() {
    var navSidebar = $('.nav-side-menu');
    if (navSidebar.length == 0) {
      return;
    }

    function findFirstMenu(navSidebar) {
      var href = $('.nav-side-menu a').first();
      return href.attr('slug-name');
    }
    function hashes(fragment, link) {
      var hash = '#' + fragment;
      if (link) {
        hash += '_toc_' + link;
      }
      return hash;
    }
    function resizeNavSidebar() {
      navSidebar.width(navSidebar.parent().width());
    }

    $window.bind('hashchange', function (evt) {

      var originalEvt = evt.originalEvent;
      var identicalPage = false;
      if (originalEvt) {
        var oldURL = originalEvt.oldURL.split('_toc_');
        var newURL = originalEvt.newURL.split('_toc_');
        identicalPage = oldURL[0] === newURL[0];
      }

      if (identicalPage) {
        return;
      }

      var item = null;
      if (window.location.hash == '') {
        window.location.hash = hashes(findFirstMenu());
      }
      var hash = window.location.hash;
      var link = hash.split('_toc_');
      var page = link[0].substring(1);
      if (link.length > 1) {
        link = link[1];
      } else {
        link = null;
      }

      if (page.endsWith('html')) {
        item = $('.nav-side-menu a[href$="' + page + '"]');
      } else {
        item = $('.nav-side-menu a[slug-name$="' + page + '"]');
      }
      // item in collapsible element
      var collapsible = item.parents('ul.collapse');
      if (collapsible.length > 0) {
        collapsible.collapse('show');
      }
      var slugName = item.attr('slug-name');
      window.location.hash = hashes(slugName, link);
      var href = item.attr('href').substring(1);
      loadFrame(href, slugName);

    });

    $window.resize(resizeNavSidebar);

    navSidebar.on('affixed.bs.affix', resizeNavSidebar);

    navSidebar.affix({
      offset: {
        top: navSidebar.offset().top,
        bottom: ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 70)
        // padding of footer.
      }
    });

    // init fragment url part
    var fragment = window.location.hash;
    if (!fragment) {
      var href = findFirstMenu();
      window.location.hash = hashes(href);
    } else {
      // enforce load frame
      $window.trigger('hashchange');
    }

    // select first menu item on show collapse
    navSidebar.on('shown.bs.collapse', function (ev) {
      var el = $(ev.target);
      // break if have already active item
      if (el.find('li.active').length > 0) {
        return;
      }

      var href = el.find('li a').first();
      window.location.hash = hashes(href.attr('slug-name'));
    });

    // prevent event on collapse clik.
    navSidebar.find("a[href=#]").click(function (event) {
      event.preventDefault();
    });
  }


  function refreshScrollSpy() {
    $body.scrollspy('refresh');
  }

  return {
    init: function () {
      initCarousel();
      initTocSidebar();
      initTocTop();
      initNavSidebar();
      initScrollTop();
      initTopNavBar();
      initHighlight();
      initAnchorJs();
      refreshScrollSpy();
    }
  };

}();

$(document).ready(function () {
  mReflow.init();
});
