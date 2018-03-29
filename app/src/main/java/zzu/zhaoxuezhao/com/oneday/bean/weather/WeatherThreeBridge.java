package zzu.zhaoxuezhao.com.oneday.bean.weather;

import java.util.List;

/**
 * Created by aotu on 2018/3/15.
 * 三天天气
 */

public class WeatherThreeBridge{
    private List<WeatherInfo> daily;
    private String last_update;

    public List<WeatherInfo> getDaily() {
        return daily;
    }

    public void setDaily(List<WeatherInfo> daily) {
        this.daily = daily;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }
}
