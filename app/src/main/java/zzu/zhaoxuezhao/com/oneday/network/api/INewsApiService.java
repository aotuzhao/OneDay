package zzu.zhaoxuezhao.com.oneday.network.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zzu.zhaoxuezhao.com.oneday.entity.news.NewsData;

/**
 * Created by aotu on 2018/3/24.
 */

public interface INewsApiService {

    @GET("index")
    Observable<NewsData> getNews(@Query("key") String key,@Query("type") String type);
}
