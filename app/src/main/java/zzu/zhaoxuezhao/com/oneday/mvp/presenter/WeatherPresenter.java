package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.suggestion.LifeSuggestionData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherThreeData;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.WeatherContract;
import zzu.zhaoxuezhao.com.oneday.network.WeatherApiMethods;

/**
 * Created by aotu on 2018/3/26.
 */

public class WeatherPresenter extends WeatherContract.Presenter {


    @Override
    public void getNowWeather() {
        Observer<WeatherData> observer=new Observer<WeatherData>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                addSubscribe(disposable);
            }

            @Override
            public void onNext(WeatherData weatherData) {

                mView.showNowWeather(weatherData);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.showErr("天气时况"+throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        WeatherApiMethods.ApiSubscribe(mModel.getNowWeather(),observer);
    }

    @Override
    public void getThreeWeather() {
        Observer<WeatherThreeData> observer=new Observer<WeatherThreeData>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                addSubscribe(disposable);
            }

            @Override
            public void onNext(WeatherThreeData weatherThreeData) {
                mView.showMoreWeather(weatherThreeData);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.showErr("天气预报"+throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        WeatherApiMethods.ApiSubscribe(mModel.getMoreWeather(),observer);
    }

    @Override
    public void getSugWeather() {
        Observer<LifeSuggestionData> observer=new Observer<LifeSuggestionData>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                addSubscribe(disposable);
            }

            @Override
            public void onNext(LifeSuggestionData lifeSuggestionData) {
                mView.showSugWeather(lifeSuggestionData);
            }

            @Override
            public void onError(Throwable throwable) {
                mView.showErr("生活建议"+throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        WeatherApiMethods.ApiSubscribe(mModel.getSugWeather(),observer);
    }

    @Override
    public void getLocation() {
        mView.showLocation(mModel.getLocation());
    }
}
