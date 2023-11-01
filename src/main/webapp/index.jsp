<%@ page import="point.PointBean" %>
<%@ page import="java.util.List" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Web Progrmming 2</title>
    <link rel="stylesheet" href="style/style.css" />
    <link rel="icon" href="favicon/favicon.jpg" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<jsp:useBean id="resultBean" class="point.ResultBean" scope="session"/>
<script>
    var points = <%= new Gson().toJson(resultBean.getPointBeans()) %>;
    window.onload = function () {
        draw(undefined, points);
    };
</script>
<header>
    <section class="header">
        <div id="name">Чмурова Мария Владиславовна</div>
        <div id="group">P3232</div>
        <div id="variant">v:992929</div>
    </section>
</header>
<div style="float: left">
    <div class="image">
        <canvas id="canvas" width="480" height="320"></canvas>
        <script src="js/draw.js"></script>
    </div>
    <div class="coordinates">
        Выберите значение X:<br />
        <div class="buttonX">
            <button class="btnX" value="-2">-2</button>
            <button class="btnX" value="-1.5">-1.5</button>
            <button class="btnX" value="-1">-1</button>
            <button class="btnX" value="-0.5">-0.5</button>
            <button class="btnX" value="0">0</button>
            <button class="btnX" value="0.5">0.5</button>
            <button class="btnX" value="1">1</button>
            <button class="btnX" value="1.5">1.5</button>
            <button class="btnX" value="2">2</button>
        </div>
        <form>
            <label>Введите Y в диапозоне (-3; 3):<br /></label>
            <input
                    type="text"
                    class="textbox"
                    name="Y_coordinate"
                    placeholder="0"
                    maxlength="10"
            />
        </form>
        Выберите значение R:<br />
        <div class="buttonR">
            <button class="btnR" value="1" onclick="draw(1, points)">1</button>
            <button class="btnR" value="2" onclick="draw(2, points)">2</button>
            <button class="btnR" value="3" onclick="draw(3, points)">3</button>
            <button class="btnR" value="4" onclick="draw(4, points)">4</button>
            <button class="btnR" value="5" onclick="draw(5, points)">5</button>
        </div>
        <p id="error_message"></p>
    </div>
    <form id="checkButton">
        <input
                class="pointer"
                id="checking"
                name="check"
                type="submit"
                value="Проверить"
        />
        <input type="hidden" name="XX" id="hiddenX" />
        <input type="hidden" name="YY" id="hiddenY" />
        <input type="hidden" name="RR" id="hiddenR" />
    </form>
    <form id="clearButton">
        <input
                class="pointer"
                id="clearing"
                type="button"
                value="Очистить таблицу"
                onclick="clear_table()"
        />
    </form>
</div>
<div style="float: right">
    <div id="table-container">
    <table id="resultTable" class="table">
        <thead>
        <tr id="heads">
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Текущее время</th>
            <th>Время работы</th>
            <th>Результат</th>
        </tr>
        </thead>
        <%
            List<PointBean> list = resultBean.getPointBeans();

            for (PointBean pointBean : list) {
        %>
        <tr>
            <td><%=pointBean.getX() %></td>
            <td><%=pointBean.getY() %></td>
            <td><%=pointBean.getR() %></td>
            <td><%=pointBean.getTime() %></td>
            <td><%=pointBean.getScriptTime() %></td>
            <td><%=pointBean.getStatus() %></td>
        </tr>
        <% } %>
    </table>
    </div>
</div>
</body>
<script src="js/button.js"></script>
<script src="js/validate.js"></script>
<script src="js/data_handler.js"></script>
<script src="js/clear_table.js"></script>
</html>

