package zzu.zhaoxuezhao.com.oneday.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.network.api.IConstellationApi;

public class ConstellationApiService {
    private static IConstellationApi mIConstellationApi;

    public static IConstellationApi getIConstellationApi(){
        if (mIConstellationApi==null){
            synchronized (IConstellationApi.class){
                if (mIConstellationApi==null){
                    new ConstellationApiService();
                }
            }
        }
        return mIConstellationApi;
    }

    private ConstellationApiService(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)

                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApiConstants.CONSTELLATION_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mIConstellationApi=retrofit.create(IConstellationApi.class);
    }
}
