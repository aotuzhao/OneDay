package zzu.zhaoxuezhao.com.oneday.mvp.view;

import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;

public interface IZhiHuWebView {
    void showWebView(ZhihuaNews zhihuaNews);

    void showWebImg(String url);

    void showImgTitle(String title);

    void showImgSource(String source);

    void showError(String error);


}
