"use strict";

/*!
 * Affix jQuery Plugin
 * @version 2.0.0
 * @author  Jason Alvis
 * @url     https://github.com/jasonalvis/affix
 */
;(function( $, window, document, undefined ){
  "use strict";

  /**
   * Affix constructor
   * @param {HTMLElement|jQuery} element - The element to create the affix for
   * @param {Object} options             - The options
   */
  var Affix = function( element, options ){
    /**
     * DOM affix element
     * @type {Object}
     */
    this.element = element;

    /**
     * DOM affix element wrapped in jQuery
     * @type {Object}
     */
    this.$element = $(element);

    /**
     * Scroll position
     * @type {Number}
     */
    this.scrollPosition = 0;

    /**
     * Locked to
     * @type {Object}
     */
    this.lockedTo = null;

    /**
     * Current options
     * @type {Object}
     */
    this.options = options;

    /**
     * Init
     */
    this.init();
  };

  /**
   * Default options
   * @type {Object}
   */
  Affix.prototype.defaults = {
    offset: 0,
    target: window
  };

  /**
   * Init the affix
   * @return {Object}
   */
  Affix.prototype.init = function() {
    this.config = $.extend({}, this.defaults, this.options);

    // Target
    this.$target = $(this.config.target);

    // Bind checkPosition on scroll
    this.$target.on("scroll", $.proxy(this.checkPosition, this));

    // Bind checkPosition without scrolling on initial page load
    this.checkPosition();

    return this;
  };

  /**
   * Detect scroll direction
   * @return {String} - The direction of the window scrolling
   */
  Affix.prototype.detectDirection = function() {
    var start = this.$target.scrollTop(),
        direction;

    if (start > this.scrollPosition) {
      direction = "down";
    } else {
      direction = "up";
    }

    this.scrollPosition = start;

    return direction;
  };

  /**
   * Get state
   * @param  {Number} scrollHeight  - The height of the document
   * @param  {Number} elementHeight - The height of the affix element
   * @param  {Number} offsetTop     - The options offset top
   * @param  {Number} offsetBottom  - The options offset bottom
   * @return {String}               - The state of the affix element
   */
  Affix.prototype.getState = function(scrollHeight, elementHeight, offsetTop, offsetBottom) {
    var elOffset     = this.$element.offset(),
        direction    = this.detectDirection(),
        scrollTop    = this.$target.scrollTop(),
        windowHeight = this.$target.height(),
        windowDiff   = windowHeight - elementHeight;

    windowDiff = windowDiff < 0 ? 0 : windowDiff;

    // Top of the context reached
    if(scrollTop <= offsetTop){
      return "default";
    }

    // Bottom of the context reached
    if (scrollTop + windowHeight >= scrollHeight - offsetBottom + windowDiff){
      return "bottom-absolute";
    }

    // If the sidebar is tall enough
    if(windowHeight < elementHeight){
      // Bottom of sidebar reached
      if(direction === "down" && this.lockedTo === null && windowHeight + scrollTop > elOffset.top + elementHeight){
        return "bottom-fixed";
      // If sidebar is fixed to top and we scroll down absolute the sidebar so they don't move
      } else if(direction === "down" && this.lockedTo === "top"){
        return "absolute";
      // Top of sidebar reached
      } else if(direction === "up" && this.lockedTo === null && elOffset.top >= scrollTop){
        return "top-fixed";
      // If sidebar is fixed to bottom and we scroll up absolute the sidebar so they don't move
      } else if(direction === "up" && this.lockedTo === "bottom"){
        return "absolute";
      }
    } else {
      if(this.lockedTo === null){
        return "top-fixed";
      }
    }

    return false;
  };

  /**
   * Set position
   * @param {String} position - Set the position of the affix element
   */
  Affix.prototype.setPosition = function(position) {
    if(position === "bottom-fixed"){
      this.$element.css({
        position: "fixed",
        top:      "auto",
        bottom:   "0px"
      });

      this.lockedTo = "bottom";
    } else if(position === "bottom-absolute"){
      this.$element.css({
        position: "absolute",
        top:      "auto",
        bottom:   "0px"
      });

      this.lockedTo = null;
    } else if(position === "top-fixed"){
      this.$element.css({
        position: "fixed",
        top:      "0px",
        bottom:   "auto"
      });

      this.lockedTo = "top";
    } else if(position === "default"){
      this.$element.css({
        position: "relative",
        top:      "auto",
        bottom:   "auto"
      });

      this.lockedTo = null;
    } else if(position === "absolute"){
      this.$element.css({
        position: "absolute",
        top:      (this.$element.offset().top - this.$element.parent().offset().top) + "px",
        bottom:   "auto"
      });

      this.lockedTo = null;
    }
  };

  /**
   * Check position
   * @return {String} - Get the position of the affix element
   */
  Affix.prototype.checkPosition = function() {
    // Return if the element is hidden
    if (!this.$element.is(":visible")){
        return;
    }

    var offset        = this.config.offset,
        offsetTop     = offset.top,
        offsetBottom  = offset.bottom,
        elementHeight = this.$element.height(),
        scrollHeight  = Math.max( $(document).height(), $(document.body).height() ),
        position;

    // If offset is not an object a single number has been provided
    // set the offset to be applied to both top and bottom.
    if (typeof offset != "object") {
      offsetBottom = offsetTop = offset;
    }

    // Function provided
    if (typeof offsetTop == "function") {
      offsetTop = offset.top(this.$element);
    }

    // Function provided
    if (typeof offsetBottom == "function") {
      offsetBottom = offset.bottom(this.$element);
    }

    // Set position
    position = this.getState(scrollHeight, elementHeight, offsetTop, offsetBottom);

    // Only run if it doesn't return false
    if(position){
      this.setPosition(position);
    }
  };

  /**
   * Create a shorthand reference point for our defaults
   * @type {Object}
   */
  Affix.defaults = Affix.prototype.defaults;

  /**
   * jQuery Affix interface
   * @param  {Object} options - The options
   * @return {Object}         - The affix object
   */
  $.fn.affix = function(options) {
    var args = Array.prototype.slice.call(arguments, 1);

    return this.each(function() {
      var item = $(this),
          data = item.data('affix');

      if(!data) {
        // Create affix data if not created
        item.data('affix', new Affix(this, options));
      } else {
        // Otherwise check arguments for method call
        if(typeof options === 'string') {
          data[options].apply(data, args);
        }
      }
    });
  };

})( jQuery, window, document );

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
  var TOC_SEPARATOR = '_toc_';

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
    var tocTop = $('#m-toc-topbar');
    if (!tocTop.length) {
      return;
    }

    if (tocTop.length) {
      tocTop.affix({
        offset: {
          top: tocTop.offset().top,
          bottom: ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 70)
          // padding of footer.
        }
      });
    }

    $body.scrollspy({
      target: '#m-toc-topbar'
    });
  }

  function initTocSidebar() {
    var tocSidebar = $('#m-toc-sidebar');
    if (!tocSidebar.length) {
      return;
    }

    /*
    tocSidebar.mCustomScrollbar({
      theme: "inset", axis: "y", setHeight:
        getViewPort().height - getTocSidebarContainerOffset(tocSidebar)
    });
    */

    /*
    $window.resize(function () {
      tocSidebar.css('height',
        (getViewPort().height - getTocSidebarContainerOffset(tocSidebar)) +
        'px');
    });
    */



    // collapse all
    if (!tocSidebar.hasClass('m-toc-sidebar-expanded')) {
      tocSidebar.find('.nav-collapsible').addClass('collapse').attr('aria-expanded', 'false');
    }

    // add auto collapse on scrollspy
    if (tocSidebar.hasClass('m-toc-sidebar-autoexpandable')) {

      tocSidebar.on('activate.bs.scrollspy', function () {
        var active = $('#m-toc-sidebar li.active');
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


    // apply affix to #m-toc-sidebar
    if (tocSidebar.length) {
      tocSidebar.affix({
        offset: {
          top: tocSidebar.offset().top,
          bottom: ($('footer').outerHeight(true) + $('.subfooter').outerHeight(true) - 70)
          // padding of footer.
        }
      });
      // apply scrollspy to #m-toc-sidebar
      $body.scrollspy({
        target: '#m-toc-sidebar'
      });

      /*
      tocSidebar.on('activate.bs.scrollspy', function (evt) {
        var el = $(evt.target);
        if (timestampSideBar > 0 && evt.timeStamp < timestampSideBar + 100) {
          return false;
        }
        timestampSideBar = evt.timeStamp;
        var container = tocSidebar.find('.mCSB_container');
        var offsetHeight = 0;
        var elHeight = container.height();

        var parent = $(el.offsetParent());
        offsetHeight = el.position().top;
        while (!parent.hasClass('mCSB_container')) {
          offsetHeight +=
            parent.position().top; parent = $(parent.offsetParent());
        }
        var offset = offsetHeight; // - (elHeight / 2); //
        tocSidebar.mCustomScrollbar("scrollTo", el);
        tocSidebar.mCustomScrollbar("scrollTo", offset);
        evt.stopImmediatePropagation();
        return false;
      });
      */

    }


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

    // auto adjust placement of sub dropdown menu when out of window.
    $('.dropdown-submenu').on('mouseenter', function (event) {
      var ww = $(window).width();
      var menu = $(this);
      var $menuItem = menu.find('.dropdown-menu');
      var width = $menuItem.width();
      var mw = width + (menu.offset().left + menu.width());
      if (ww < mw) {
        $menuItem.css('left', -1 * (width), 'important');
      } else {
        $menuItem.css('left', '100%');
      }
    });

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
    if (anchors && $body.hasClass('m-toc-sidebar-enabled') || $body.hasClass('m-toc-top-enabled')
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

    /**
     * Gets the slug name of first &lt;a&gt; element in nav sidebar.
     */
    function findFirstMenu() {
      var href = $('.nav-side-menu a').first();
      return href.attr('slug-name');
    }

    /**
     * create a link
     * @param {*} slugName
     * @param {*} chapter
     */
    function hashes(slugName, chapter) {
      var hash = '#' + slugName;
      if (chapter) {
        hash += TOC_SEPARATOR + chapter;
      }
      return hash;
    }
    function resizeNavSidebar() {
      navSidebar.width(navSidebar.parent().width());
    }

    /**
     * Split the fragement of url and returns an array containing following info:
     * - the slugname of section
     * - the chapter in the section
     * @param {*} url the url the split
     */
    function splitUrl(url) {
      var index = url.indexOf(TOC_SEPARATOR, url.indexOf('#'));
      if (index >= 0) {
        return [url.substring(0, index), url.substring(index + TOC_SEPARATOR.length)];
      }
      return [url];
    }

    $window.bind('hashchange', function (evt) {

      var originalEvt = evt.originalEvent;
      var identicalPage = false;
      if (originalEvt) {
        var oldURL = splitUrl(originalEvt.oldURL);
        var newURL = splitUrl(originalEvt.newURL);
        identicalPage = oldURL[0] === newURL[0];
      }

      if (identicalPage) {
        return;
      }

      var item = null;
      var hash = window.location.hash;
      // set the first page in nav sidebar
      if (window.location.hash == '') {
        hash = hashes(findFirstMenu());
      }

      var chapter = '';
      var splittedUrl = splitUrl(hash);
      var section = splittedUrl[0].substring(1);
      if (splittedUrl.length > 1) {
        chapter = splittedUrl[1];
      } else {
        chapter = null;
      }

      // search the item in nav sidebar corresponding to section
      if (section.endsWith('html')) {
        item = $('.nav-side-menu a[href$="' + section + '"]');
      } else {
        item = $('.nav-side-menu a[slug-name$="' + section + '"]');
      }
      // expand the parent of item if it is sub-section menu.
      var collapsible = item.parents('ul.collapse');
      if (collapsible.length > 0) {
        collapsible.collapse('show');
      }
      var slugName = item.attr('slug-name');
      window.location.hash = hashes(slugName, chapter);
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

    // select first menu item on expand
    if ($body.hasClass('m-sidenav-select-onexpand')) {
      navSidebar.on('shown.bs.collapse', function (ev) {
        var el = $(ev.target);
        // break if have already active item
        if (el.find('li.active').length > 0) {
          return;
        }

        var href = el.find('li a').first();
        window.location.hash = hashes(href.attr('slug-name'));
      });
    }

    // prevent event on collapse clik.
    navSidebar.find("a[href=\\#]").click(function (event) {
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
