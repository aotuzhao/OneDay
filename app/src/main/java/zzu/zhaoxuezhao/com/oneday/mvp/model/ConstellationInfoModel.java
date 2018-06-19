package zzu.zhaoxuezhao.com.oneday.mvp.model;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;
import zzu.zhaoxuezhao.com.oneday.network.ConstellationApiMethods;

public class ConstellationInfoModel {
    public Observable<Constellation> getConstellationInfo(String star) {
        return ConstellationApiMethods.getConstellationInfo(star);
    }
}
