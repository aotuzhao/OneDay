package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.mvp.model.ZhihuDataModel;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IZhiHuListView;
import zzu.zhaoxuezhao.com.oneday.network.ZhihuApiMethods;

public class ZhihuListPresenter  {

    private IZhiHuListView mZhiHuListView;
    private ZhihuDataModel mZhihuDataModel;


    public ZhihuListPresenter(IZhiHuListView iZhiHuListView){
        mZhiHuListView=iZhiHuListView;
        mZhihuDataModel=new ZhihuDataModel();
    }

    public void getLatestNews(){
        Observer<ZhihuNewsData> observer=new Observer<ZhihuNewsData>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(ZhihuNewsData zhihuNewsData) {
                if (!zhihuNewsData.getStories().isEmpty()&&!zhihuNewsData.getTop_stories().isEmpty()){
                    mZhiHuListView.showZhihuList(zhihuNewsData);
                    mZhiHuListView.finishRefresh(true);
                }else {
                    mZhiHuListView.finishRefresh(false);
                }

            }

            @Override
            public void onError(Throwable throwable) {
                mZhiHuListView.showError(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ZhihuApiMethods.ApiSubscribe(mZhihuDataModel.getLatestNews(),observer);

    }
    public void getBeforeNews(String time){
        Observer<ZhihuNewsData> observer=new Observer<ZhihuNewsData>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(ZhihuNewsData zhihuNewsData) {
                if (zhihuNewsData==null){
                    mZhiHuListView.showError("请求为空");
                    mZhiHuListView.finshLoadMore();
                }else {
                    if (!zhihuNewsData.getStories().isEmpty()||!zhihuNewsData.getTop_stories().isEmpty()){
                        mZhiHuListView.showZhihuList(zhihuNewsData);
                        mZhiHuListView.finshLoadMore();
                    }

                }

            }

            @Override
            public void onError(Throwable throwable) {
                mZhiHuListView.showError(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ZhihuApiMethods.ApiSubscribe(mZhihuDataModel.getBeforeNews(time),observer);
    }



    public void distoryView(){
        if (mZhiHuListView!=null){
            mZhiHuListView=null;
        }
    }

}

