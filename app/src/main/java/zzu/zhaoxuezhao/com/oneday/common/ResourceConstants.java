package zzu.zhaoxuezhao.com.oneday.common;

import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.utils.MyApplication;

/**
 * Created by aotu on 2018/3/27.
 */

public class ResourceConstants {
    public static final int[] WEATHER_ICON= MyApplication.getContext()
            .getResources().getIntArray(R.array.weather_icon);
    /**
     * Shared Preference key
     */
    public static final String LOCATION = "location";
}
