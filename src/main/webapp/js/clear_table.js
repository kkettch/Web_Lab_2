//clear_table.js отправляет на сервер запрос для очищения коллекции точек
function clear_table() {
  $.ajax({
    type: "DELETE",
    url: "controller-servlet",
    async: false,
    success: function () {
      window.location.replace('index.jsp');
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
