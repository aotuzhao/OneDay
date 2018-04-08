package zzu.zhaoxuezhao.com.oneday.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;

public class ZhihuApiMethods {
    /**
     * 封装线程管理和订阅的过程
     */
    public static void ApiSubscribe(Observable observable, Observer observer){
        observable.subscribe(observer);
    }

    public static Observable<ZhihuNewsData> getZhihuList(){
        return ZhihuApiService.getZhihuApiService()
                .getLatestNews()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
    public static Observable<ZhihuNewsData> getZhihuBeforeList(String time){
        return ZhihuApiService.getZhihuApiService()
                .getBeforetNews(time)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
    public static Observable<ZhihuaNews> getZhihuData(String id){
        return ZhihuApiService.getZhihuApiService()
                .getDetailNews(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


    }
}
