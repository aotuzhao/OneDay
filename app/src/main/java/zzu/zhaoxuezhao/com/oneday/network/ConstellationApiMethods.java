package zzu.zhaoxuezhao.com.oneday.network;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;

public class ConstellationApiMethods {
    public static void ApiSubscribe(Observable observable, Observer observer) {
        observable.subscribe(observer);
    }

    public static Observable<Constellation> getConstellationInfo(String star) {
        return ConstellationApiService.getIConstellationApi()
                .getConstellation(ApiConstants.CONSTELLATION_APPID, ApiConstants.CONSTELLATION_KEY, star, "1", "1", "1")
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
