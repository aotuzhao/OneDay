package zzu.zhaoxuezhao.com.oneday.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsData;

public class NewsApiMethods {
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribe(observer);
    }

    public static Observable<NewsData> getNowWeather(String key, String type){
        return NewsApiService.getNewsApiService()
                .getNews(key,type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
