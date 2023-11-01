//button.js настраивает кнопки так, чтобы активной можно было выбрать только одну
document.addEventListener("DOMContentLoaded", function () {
  const btnXElements = document.querySelectorAll(".btnX");
  const btnRElements = document.querySelectorAll(".btnR");

  //настройка кнопок с координатой X
  btnXElements.forEach((btnX) => {
    btnX.addEventListener("click", function () {
      btnXElements.forEach((btn) => {
        btn.classList.remove("active");
      });
      this.classList.add("active");
    });
  });

  //настройка кнопок с радиусом R 
  btnRElements.forEach((btnR) => {
    btnR.addEventListener("click", function () {
      btnRElements.forEach((btn) => {
        btn.classList.remove("active");
      });
      this.classList.add("active");
    });
  });
});
