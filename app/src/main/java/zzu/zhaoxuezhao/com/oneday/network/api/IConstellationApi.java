package zzu.zhaoxuezhao.com.oneday.network.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;

public interface IConstellationApi {
    @GET("872-1")
    Observable<Constellation> getConstellation(@Query("showapi_appid") String showapi_appid,
                                               @Query("showapi_sign") String showapi_sign,
                                               @Query("star") String star,
                                               @Query("needTomorrow") String needTomorrow,
                                               @Query("needWeek") String needWeek,
                                               @Query("needMonth") String needMonth
    );
}
