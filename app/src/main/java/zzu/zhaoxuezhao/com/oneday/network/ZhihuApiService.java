package zzu.zhaoxuezhao.com.oneday.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.network.api.IZhihuApi;
import zzu.zhaoxuezhao.com.oneday.utils.XInterceptor;

public class ZhihuApiService {
    public static IZhihuApi sZhihuNewsApiService;

    public static IZhihuApi getZhihuApiService() {
        if (sZhihuNewsApiService == null) {
            synchronized (IZhihuApi.class) {
                if (sZhihuNewsApiService == null) {
                    new ZhihuApiService();
                }
            }
        }
        return sZhihuNewsApiService;
    }

    private ZhihuApiService(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .addNetworkInterceptor(new XInterceptor.CommonNetCache(20))
                .addInterceptor(new XInterceptor.Retry(3))
                .addInterceptor(new XInterceptor.CommonLog("ZhihuApiService Http :"))

                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiConstants.ZHIHU_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        sZhihuNewsApiService=retrofit.create(IZhihuApi.class);
    }
}
