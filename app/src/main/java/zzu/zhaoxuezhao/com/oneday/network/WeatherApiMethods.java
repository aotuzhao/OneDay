package zzu.zhaoxuezhao.com.oneday.network;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zzu.zhaoxuezhao.com.oneday.entity.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.network.api.WeatherApi;

/**
 * Created by aotu on 2018/3/24.
 */

public class WeatherApiMethods {

    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


    public static void getNowWeather(Observer<WeatherData> observer,String key,String location){
        ApiSubscribe(WeatherApi.getWeatherApiService().getNowWeather(key,location),
                observer);
    }

}
