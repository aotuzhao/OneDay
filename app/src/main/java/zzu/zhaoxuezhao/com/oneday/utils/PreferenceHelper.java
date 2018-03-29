package zzu.zhaoxuezhao.com.oneday.utils;

import android.content.Context;
import android.content.SharedPreferences;

import zzu.zhaoxuezhao.com.oneday.common.ResourceConstants;

public class PreferenceHelper {
    private static final String MY_SHARED_PREFERENCE="my_shared_preference";
    private static final SharedPreferences mSharedPreferences=MyApplication.getContext().getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);;



    public static void setLocation(String location){
        mSharedPreferences.edit().putString(ResourceConstants.LOCATION, location).apply();
    }
    public static String getLocation(){
        return mSharedPreferences.getString(ResourceConstants.LOCATION,"郑州");
    }


}
