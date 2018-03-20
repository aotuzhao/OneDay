package zzu.zhaoxuezhao.com.oneday.entity.weather;

/**
 * Created by aotu on 2018/3/15.
 * 天气详情
 * date 日期
 * text_day 天气
 * code_day 天气代码
 * high 最高气温
 * low 最低气温
 * wind_direction 风向
 * wind_scale 风力
 */

public class WeatherInfo {
    private String date;
    private String text_day;
    private String code_day;
    private String high;
    private String low;
    private String wind_direction;
    private String wind_scale;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getCode_day() {
        return code_day;
    }

    public void setCode_day(String code_day) {
        this.code_day = code_day;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_scale() {
        return wind_scale;
    }

    public void setWind_scale(String wind_scale) {
        this.wind_scale = wind_scale;
    }
}
