package servlet;

import point.PointBean;
import point.ResultBean;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Класс организует проверку попадания точки в область на координатной плоскости
 * @author maria
 */

@WebServlet(name = "area-check-servlet", value = "/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {
    private ResultBean resultBean;


    /**
     * Получение координат точки и их валидация из HTTP-запроса POST
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException{
        log(req.getParameter("x-value")+ req.getParameter("y-value")+ req.getParameter("r-value"));
        long timer = System.nanoTime();
        try {
            float x = Float.parseFloat(req.getParameter("x-value"));
            float y = Float.parseFloat(req.getParameter("y-value"));
            float r = Float.parseFloat(req.getParameter("r-value"));

            log("X: " + x);
            log("Y: " + y);
            log("R: " + r);

            if(validationOnArea(x,y,r)){
                resultBean = (ResultBean) req.getSession().getAttribute("resultBean");
                if (resultBean == null) {
                    resultBean = new ResultBean();
                    req.getSession().setAttribute("resultBean", resultBean);
                }
                createResult(req,resp,timer,x,y,r);
            }else{
                log("data is incorrect");
            }
        } catch (NumberFormatException e) {
            log("NumberFormatException");
        }
    }

    /**
     * Формирование результата обработки сервером и сохранение полученной точки в коллекцию
     */
    private void createResult(HttpServletRequest req,HttpServletResponse resp,long timer,float x,float y,float r) throws IOException {

        PrintWriter printWriter = resp.getWriter();
        String status = isHit(x, y, r);

        int timeZone = Integer.parseInt(req.getParameter("timezone"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String currentTime = formatter.format(LocalDateTime.now().plus(timeZone, MINUTES));
        long scriptTime = (long) ((System.nanoTime() - timer) * 0.001);

        PointBean newPointBean = new PointBean(x, y, r, currentTime, scriptTime, status);
        resultBean.addPointCreation(newPointBean);
        String responseBody = newPointBean.toJSON();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.write(responseBody);
        printWriter.flush();
    }

    /**
     * Валидация значений точек x, y, r
     */
    private boolean validationOnArea(double x,double y,double r){
        return ((x>=-5 && x<=5) && (y>=-5 && y<=5) && (r>=1 && r<=5));
    }

    /**
     * Проверка попадания точки в область
     */
    private String isHit(double x, double y, double r) {
        if ((y >= x / 2 - r / 2 && y <= 0 && x >= 0) || // Проверка попадания точки в первую область (треугольник)
                (x * x + y * y <= (r / 2) * (r / 2) && x >= 0 && y >= 0) || // Проверка попадания точки во вторую область (окружность)
                (x >= -r && x <= 0 && y >= -r / 2 && y <= 0)) { // Проверка попадания точки в третью область (прямоугольник)
            return "Попадание!"; // Если точка попала в одну из областей, возвращаем true
        } else {
            return "Промах!"; // Если точка не попала ни в одну из областей, возвращаем false
        }
    }

}
