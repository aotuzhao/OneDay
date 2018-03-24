package zzu.zhaoxuezhao.com.oneday.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by aotu on 2018/3/24.
 */

public class NetWorkUtils {
    /**
     * 判断网络是否连接
     *
     *
     * @param context 上下文
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isNetConnected(Context context) {
        NetworkInfo info = getActiveNetworkInfo(context);
        return info != null && info.isConnected();
    }
    /**
     * 获取活动网络信息
     *
     * @param context 上下文
     * @return NetworkInfo
     */
    private static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }


}
