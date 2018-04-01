package zzu.zhaoxuezhao.com.oneday.mvp.model;

import android.util.Log;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsData;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.NewsDetailContract;
import zzu.zhaoxuezhao.com.oneday.network.NewsApiMethods;

public class NewsDetailModel implements NewsDetailContract.Model {

    @Override
    public Observable<NewsData> getNewsDate(String type) {
        Log.e("model:--",type);
        return NewsApiMethods.getNowWeather(ApiConstants.NEWS_KEY,type);
    }
}
