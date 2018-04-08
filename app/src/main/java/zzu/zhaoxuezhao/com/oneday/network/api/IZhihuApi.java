package zzu.zhaoxuezhao.com.oneday.network.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;

public interface IZhihuApi {

    @GET("news/latest")
    Observable<ZhihuNewsData> getLatestNews();

    @GET("news/before/{time}")
    Observable<ZhihuNewsData> getBeforetNews(@Path("time") String time);

    @GET("news/{id}")
    Observable<ZhihuaNews> getDetailNews(@Path("id") String id);
}
