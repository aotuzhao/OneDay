package zzu.zhaoxuezhao.com.oneday.mvp.model;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;
import zzu.zhaoxuezhao.com.oneday.network.ZhihuApiMethods;

public class ZhihuDataModel {

    public Observable<ZhihuNewsData> getLatestNews() {

        return ZhihuApiMethods.getZhihuList();
    }

    public Observable<ZhihuNewsData> getBeforeNews(String time) {

        return ZhihuApiMethods.getZhihuBeforeList(time);
    }

    public Observable<ZhihuaNews> getNewsDeta(String id) {

        return ZhihuApiMethods.getZhihuData(id);
    }


}
