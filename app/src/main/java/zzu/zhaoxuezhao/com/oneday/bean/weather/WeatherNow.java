package zzu.zhaoxuezhao.com.oneday.bean.weather;

/**
 * Created by aotu on 2018/3/15.
 * 天气时况
 * text 天气现象文字
 * code 天气现象代码
 * temperature 温度，单位为c摄氏度或f华氏度
 */

public class WeatherNow {
    private String text;
    private String code;
    private String temperature;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
