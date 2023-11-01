package servlet;

import point.ResultBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс организует очищение коллекции, хранящей информацию о точках
 * @author maria
 */

@WebServlet(name = "servlet.clear-table-servlet", value = "/clear-table-servlet")
public class ClearTableServlet extends HttpServlet {
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultBean resultBean = (ResultBean) req.getSession().getAttribute("resultBean");
        if (resultBean != null) {
            resultBean.getPointBeans().clear();
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // Коллекция не найдена
        }
    }
}
