package zzu.zhaoxuezhao.com.oneday.network.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zzu.zhaoxuezhao.com.oneday.entity.suggestion.LifeSuggestionData;
import zzu.zhaoxuezhao.com.oneday.entity.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.entity.weather.WeatherThreeData;

/**
 * Created by aotu on 2018/3/24.
 */

public interface IWeatherApiService {

    @GET("weather/now.json")
    Observable<WeatherData> getNowWeather(@Query("key") String key,@Query("location") String location);

    @GET("weather/daily.json")
    Observable<WeatherThreeData> getMoreWeather(@Query("key") String key,@Query("location") String location);

    @GET("life/suggestion.json")
    Observable<LifeSuggestionData> getSuggestions(@Query("key") String key,@Query("location") String location);

}
