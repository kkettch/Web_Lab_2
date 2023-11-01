//data_handler.js отправляет данные на сервер, где те валидируется и при успешной валидации добавляется строка таблицы
function getDataFromForm() {
  // Получение значений x, y и r из соответствующих элементов формы
  var x = parseFloat($("input[name='XX']").val());
  var y = parseFloat($("input[name='YY']").val());
  var r = parseInt($("input[name='RR']").val());

  sendData(x, y, r);
}
function sendData(x, y, r) {
  x = x.toFixed(2);
  y = y.toFixed(2);
  $.ajax({
    type: "POST",
    url: "controller-servlet",
    dataType: "json",
    async: false,
    data: {
      "x-value": x.toString().trim(), "y-value": y.toString().trim(), "r-value": r.toString().trim(),
      "timezone": new Date().getTimezoneOffset()
    },
    success: function () {
      window.location.replace('result.jsp');
    },
    error: function (xhr, textStatus, err) {
      alert("readyState: " + xhr.readyState + "\n" +
          "responseText: " + xhr.responseText + "\n" +
          "status: " + xhr.status + "\n" +
          "text status: " + textStatus + "\n" +
          "error: " + err);
    }
  });
}
