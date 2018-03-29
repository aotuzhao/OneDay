package zzu.zhaoxuezhao.com.oneday.utils;

import android.app.Application;
import android.content.Context;

import com.scwang.smartrefresh.header.waveswipe.DropBounceInterpolator;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Created by aotu on 2018/3/24.
 */

public class MyApplication extends Application {
    private static Context application;

    //static 代码段可以防止内存泄露, 全局设置刷新头部及尾部，优先级最低
    static {//使用static代码段可以防止内存泄漏
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                //开始设置全局的基本参数
                layout.setReboundDuration(1000);
                layout.setReboundInterpolator(new DropBounceInterpolator());
                layout.setFooterHeight(100);
                layout.setDisableContentWhenLoading(false);
                //更多的 set 方法
                return new ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }


    public static Context getContext() {
        return  application;
    }
}
