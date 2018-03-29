package zzu.zhaoxuezhao.com.oneday.network;


import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by aotu on 2018/3/24.
 */

public class WeatherApiMethods {

    /**
     * 封装线程管理和订阅的过程
     */



    public static Observable getNowWeather(String key,String location){
       return WeatherApiService.getWeatherApiService()
               .getNowWeather(key,location)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
    public static Observable getMoreWeather( String key, String location){
        return WeatherApiService.getWeatherApiService()
                .getMoreWeather(key,location)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable getSuggestions(String key, String location){
        return WeatherApiService.getWeatherApiService()
                .getSuggestions(key,location)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
