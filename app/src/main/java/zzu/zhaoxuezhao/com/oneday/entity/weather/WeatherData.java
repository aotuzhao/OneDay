package zzu.zhaoxuezhao.com.oneday.entity.weather;

import java.util.List;

/**
 * Created by aotu on 2018/3/14.
 *天气时况
 *
 */

public class WeatherData {
    private List<WeatherResultBridge> results;

    public List<WeatherResultBridge> getResults() {
        return results;
    }

    public void setResults(List<WeatherResultBridge> results) {
        this.results = results;
    }
}
