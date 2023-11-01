package point;

import java.io.Serializable;
import java.util.Locale;

/**
 * Класс для хранения информации о точке: координаты, время, время выполнения скрипта, результат попадания
 * @author maria
 */
public class PointBean implements Serializable {
    private float x;
    private float y;
    private float r;
    private String time;
    private long scriptTime;
    private String status;
    public PointBean() {}

    public PointBean(float x, float y, float r, String time, long scriptTime, String status) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.time = time;
        this.scriptTime = scriptTime;
        this.status = status;
    }
    public String toJSON() {
        return String.format(Locale.US, """
                {
                "x": %.3f,
                "y": %.3f,
                "r": %.3f,
                "status": "%s",
                "time": "%s",
                "scriptTime": %d
                }
                """, x, y, r, status, time, scriptTime);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR() {
        return r;
    }

    public String getTime() {
        return time;
    }

    public long getScriptTime() {
        return scriptTime;
    }

    public String getStatus() {
        return status;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setScriptTime(long scriptTime) {
        this.scriptTime = scriptTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
