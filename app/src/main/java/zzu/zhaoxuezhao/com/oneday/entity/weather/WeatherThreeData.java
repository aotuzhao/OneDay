package zzu.zhaoxuezhao.com.oneday.entity.weather;

import java.util.List;

/**
 * Created by aotu on 2018/3/15.
 * 三天天气
 */

public class WeatherThreeData {
    private List<WeatherThreeBridge> results;

    public List<WeatherThreeBridge> getResults() {
        return results;
    }

    public void setResults(List<WeatherThreeBridge> results) {
        this.results = results;
    }
}
