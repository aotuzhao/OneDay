package zzu.zhaoxuezhao.com.oneday.mvp.model;


import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.suggestion.LifeSuggestionData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherThreeData;
import zzu.zhaoxuezhao.com.oneday.common.ApiConstants;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.WeatherContract;
import zzu.zhaoxuezhao.com.oneday.network.WeatherApiMethods;
import zzu.zhaoxuezhao.com.oneday.utils.MyApplication;
import zzu.zhaoxuezhao.com.oneday.utils.PreferenceHelper;

/**
 * Created by aotu on 2018/3/26.
 */

public class WeatherDataModel implements WeatherContract.Model{
    private AMapLocationClient locationClientSingle = null;

    @Override
    public Observable<WeatherData> getNowWeather() {

        return WeatherApiMethods.getNowWeather(ApiConstants.WEATHER_KEY,getLocation());
    }

    @Override
    public Observable<WeatherThreeData> getMoreWeather() {
        return null;
    }

    @Override
    public Observable<LifeSuggestionData> getSugWeather() {

        return null;
    }

    @Override
    public String getLocation() {
        final PreferenceHelper preferenceHelper=new PreferenceHelper();

        if (null == locationClientSingle) {
            locationClientSingle = new AMapLocationClient(MyApplication.getContext());
        }
        AMapLocationClientOption locationClientOption = new AMapLocationClientOption();
        locationClientOption.setOnceLocation(true);
        // 地址信息
        locationClientOption.setNeedAddress(true);
        locationClientOption.setLocationCacheEnable(false);
        locationClientSingle.setLocationOption(locationClientOption);
        locationClientSingle.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation location) {

                Log.e("Zhao-LocationDataModel:",location.getCity().toString());
                preferenceHelper.setLocation(location.getCity().toString());

            }
        });
        locationClientSingle.startLocation();
        return   preferenceHelper.getLocation();
    }

}
