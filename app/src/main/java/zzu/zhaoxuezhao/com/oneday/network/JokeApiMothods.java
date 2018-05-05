package zzu.zhaoxuezhao.com.oneday.network;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.network.api.IJokeApi;

public class JokeApiMothods {
    private Retrofit mRetrofit;
    private IJokeApi mIJokeApi;
    private static JokeApiMothods INSTANCE;

    private JokeApiMothods() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(5, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(ApiConstants.JOKE_BASE_URL)
                .build();
        mIJokeApi = mRetrofit.create(IJokeApi.class);
    }

    public static JokeApiMothods getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new JokeApiMothods();
        }
        return INSTANCE;
    }

    public void getJoke(Observer observer) {
        mIJokeApi.getJoke()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
