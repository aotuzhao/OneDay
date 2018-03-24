package zzu.zhaoxuezhao.com.oneday.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zzu.zhaoxuezhao.com.oneday.entity.news.NewsData;
import zzu.zhaoxuezhao.com.oneday.network.api.NewsApi;

/**
 * Created by aotu on 2018/3/24.
 */

public class NewsApiMethods {

    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public static void getNews(Observer<NewsData> observer,String key,String type){
        ApiSubscribe(NewsApi.getNewsApiService().getNews(key, type),observer);

    }
}
