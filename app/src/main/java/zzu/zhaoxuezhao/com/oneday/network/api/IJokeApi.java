package zzu.zhaoxuezhao.com.oneday.network.api;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import zzu.zhaoxuezhao.com.oneday.bean.fun.Joke;

public interface IJokeApi {
    @GET("tupian.json")
    Observable<List<Joke>> getJoke();
}
