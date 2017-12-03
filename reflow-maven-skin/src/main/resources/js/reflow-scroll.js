
$(window).load(function(){
  $('a[href^="#"]:not([href^="#carousel"]):not([data-toggle="dropdown"])').on('click', function(e) {

    function scrollTo(el, offset, clbck) {
      var pos = (el && el.length > 0) ? el.offset().top : 0;
      pos = pos + (offset ? offset : 0);

      $('html,body').animate({
          scrollTop: pos
      }, 300, clbck);
    };

     // prevent default anchor click behavior
     e.preventDefault();

     // store hash
     var hash = this.hash;

    if (hash === "") {
      // other
      scrollTo();
    } else {
      var body  = $(this).closest( "[data-psy='scroll']");
      var offset = $(body).attr('data-offset') |  10 ;
      // heading click
      scrollTo(
        $(this.hash),
        offset,
        function(){
          // when done, add hash to url
          // (default click behaviour)
          window.location.hash = hash;
        }
      );
    }

  });
});

