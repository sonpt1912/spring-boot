// Lắng nghe sự kiện khi tab được nhấp
var tabs = document.querySelectorAll(".md");
tabs.forEach(function (tab) {
  tab.addEventListener("click", function (event) {
    event.preventDefault();

    // Xóa lớp active từ tất cả các tab và các tab-pane tương ứng
    tabs.forEach(function (tab) {
      tab.classList.remove("active");
    });
    var tabPanes = document.querySelectorAll(".tab-pane");
    tabPanes.forEach(function (tabPane) {
      tabPane.classList.remove("show", "active");
    });

    // Thêm lớp active cho tab hiện tại và tab-pane tương ứng
    this.classList.add("active");
    var target = this.getAttribute("href");
    var targetPane = document.querySelector(target);
    targetPane.classList.add("show", "active");
  });
});
