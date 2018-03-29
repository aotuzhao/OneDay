package zzu.zhaoxuezhao.com.oneday.bean.weather;

/**
 * Created by aotu on 2018/3/15.
 * 天气时况
 */

public class WeatherResultBridge {
    private WeatherNow now;
    private String last_update;

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public WeatherNow getNow() {
        return now;
    }

    public void setNow(WeatherNow now) {
        this.now = now;
    }
}
