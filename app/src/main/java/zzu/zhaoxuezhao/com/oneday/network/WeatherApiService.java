package zzu.zhaoxuezhao.com.oneday.network;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.network.api.IWeatherApi;
import zzu.zhaoxuezhao.com.oneday.utils.MyApplication;
import zzu.zhaoxuezhao.com.oneday.utils.XInterceptor;

/**
 * Created by aotu on 2018/3/24.
 */

public class WeatherApiService {

    private static IWeatherApi mWeatherApiService;


    public static IWeatherApi getWeatherApiService() {
        if (mWeatherApiService == null) {
            synchronized (IWeatherApi.class) {
                if (mWeatherApiService == null) {
                    new WeatherApiService();
                }
            }
        }
        return mWeatherApiService;
    }

    private WeatherApiService() {
        File cacheFile = new File(MyApplication.getContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(new XInterceptor.CommonNetCache(20))
                .addInterceptor(new XInterceptor.CommonNoNetCache(ApiConstants.CACHE_STALE_SEC, MyApplication.getContext()))
                .addInterceptor(new XInterceptor.Retry(3))
                .addInterceptor(new XInterceptor.CommonLog(true,"WeatherApiService Http :"))
                .cache(cache)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiConstants.WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mWeatherApiService = retrofit.create(IWeatherApi.class);
    }


}
