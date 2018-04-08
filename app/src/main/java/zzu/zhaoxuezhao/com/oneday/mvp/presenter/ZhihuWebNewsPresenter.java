package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import android.content.Context;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;
import zzu.zhaoxuezhao.com.oneday.mvp.model.ZhihuDataModel;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IZhiHuWebView;
import zzu.zhaoxuezhao.com.oneday.network.ZhihuApiMethods;

public class ZhihuWebNewsPresenter {

    private Context context;
    private IZhiHuWebView mIZhiHuWebView;
    private ZhihuDataModel mZhihuDataModel;
    public ZhihuWebNewsPresenter(Context context, IZhiHuWebView iZhiHuWebView) {
        this.context = context;
        mIZhiHuWebView = iZhiHuWebView;
        mZhihuDataModel=new ZhihuDataModel();
    }

    public void getDetailNews(String id) {
        Observer<ZhihuaNews> observer=new Observer<ZhihuaNews>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(ZhihuaNews zhihuaNews) {
                if (zhihuaNews!=null){
                    mIZhiHuWebView.showWebView(zhihuaNews);
                    mIZhiHuWebView.showImgTitle(zhihuaNews.getTitle());
                    mIZhiHuWebView.showImgSource(zhihuaNews.getImage_source());
                    mIZhiHuWebView.showWebImg(zhihuaNews.getImage());
                }else {
                    mIZhiHuWebView.showError("新闻为空");
                }
            }

            @Override
            public void onError(Throwable throwable) {
                mIZhiHuWebView.showError(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ZhihuApiMethods.ApiSubscribe(mZhihuDataModel.getNewsDeta(id),observer);
    }

    public void destroyImg() {
        if (mIZhiHuWebView != null) {
            mIZhiHuWebView = null;
        }
    }




}
