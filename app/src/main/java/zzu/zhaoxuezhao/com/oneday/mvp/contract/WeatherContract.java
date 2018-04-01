package zzu.zhaoxuezhao.com.oneday.mvp.contract;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.suggestion.LifeSuggestionData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherThreeData;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseModel;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BasePresenter;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseView;

/**
 * Created by aotu on 2018/3/27.
 */

public interface WeatherContract {
    interface View extends BaseView{
        void showLocation(String location);
        void showNowWeather(WeatherData weatherData);
        void showMoreWeather(WeatherThreeData weatherThreeData);
        void showSugWeather(LifeSuggestionData lifeSuggestionData);

    }

    interface Model extends BaseModel{
        Observable<WeatherData> getNowWeather();
        Observable<WeatherThreeData> getMoreWeather();
        Observable<LifeSuggestionData> getSugWeather();
        String getLocation();
    }
    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getNowWeather();
        public abstract void  getThreeWeather();
        public abstract void getSugWeather();
        public abstract void getLocation();
    }
}
