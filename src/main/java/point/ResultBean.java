package point;

import javax.faces.bean.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для организации хранения точек в коллекции
 * @author maria
 */

@ApplicationScoped
public class ResultBean implements Serializable {
    private List<PointBean> pointBeans;

    public ResultBean() {
        pointBeans = new ArrayList<>();
    }

    public List<PointBean> getPointBeans() {
        return pointBeans;
    }

    public void setPointBeans(List<PointBean> pointBeans) {
        this.pointBeans = pointBeans;
    }

    public void addPointCreation(PointBean pointBean) {
        pointBeans.add(pointBean);
    }
}
