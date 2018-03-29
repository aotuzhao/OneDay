package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.WeatherContract;

/**
 * Created by aotu on 2018/3/26.
 */

public class WeatherPresenter  extends WeatherContract.Presenter{


    @Override
    public void getNowWeather() {
        Observer<WeatherData> observer=new Observer<WeatherData>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                
            }

            @Override
            public void onNext(WeatherData weatherData) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        };

    }

    @Override
    public void getThreeWeather() {

    }

    @Override
    public void getSugWeather() {

    }

    @Override
    public void getLocation() {

    }
}
