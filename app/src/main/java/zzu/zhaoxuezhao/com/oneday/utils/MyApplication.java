package zzu.zhaoxuezhao.com.oneday.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by aotu on 2018/3/24.
 */

public class MyApplication extends Application {
    private static Context application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }


    public static Context getContext() {
        return  application;
    }
}
