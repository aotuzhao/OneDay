package zzu.zhaoxuezhao.com.oneday.mvp.view;

import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;

public interface IZhiHuListView {
    void showZhihuList(ZhihuNewsData zhihuNewsData);
    void showNewsData(String  id);
    void showError(String error);
    void finishRefresh(Boolean b);
    void finshLoadMore();

}
