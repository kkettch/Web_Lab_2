<%@ page import="point.PointBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="resultBean" class="point.ResultBean" scope="session"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Web Programming 2</title>
  <link rel="stylesheet" href="style/style.css" />
</head>
<body>
<div class="center">
  <table id="results" class="table">
    <tr>
      <th>X</th>
      <th>Y</th>
      <th>R</th>
      <th>Текущее время</th>
      <th>Время работы</th>
      <th>Результат</th>
    </tr>
    <%
      List<PointBean> list = resultBean.getPointBeans();
      PointBean pointBean = list.get(list.size()-1);
    %>
    <tr>
      <td><%=pointBean.getX() %></td>
      <td><%=pointBean.getY() %></td>
      <td><%=pointBean.getR() %></td>
      <td><%=pointBean.getTime() %></td>
      <td><%=pointBean.getScriptTime() %></td>
      <td><%=pointBean.getStatus() %></td>
    </tr>
  </table>
  <div>
    <button
            class="pointer"
            id="backBtn"
            onClick="window.location.replace('index.jsp');"
            type="reset"
            onclick=""
    >
      Назад
    </button>
  </div>
</div>
</body>
</html>
