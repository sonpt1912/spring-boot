$(document).ready(function () {
  $(".canvas__open").on("click", function () {
    $(".offcanvas-menu-overlay").addClass("active");
    $(".offcanvas-menu-wrapper").addClass("active");
  });

  $(".offcanvas-menu-overlay").on("click", function () {
    $(".offcanvas-menu-wrapper").removeClass("active");
    $(".offcanvas-menu-overlay").removeClass("active");
  });
});
