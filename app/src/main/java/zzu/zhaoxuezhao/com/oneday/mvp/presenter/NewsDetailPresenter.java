package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsData;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.NewsDetailContract;
import zzu.zhaoxuezhao.com.oneday.network.NewsApiMethods;

public class NewsDetailPresenter extends NewsDetailContract.Presenter {

    @Override
    public void getNewsDate(String type) {
        Log.e("Presenter:--",type);
        Observer<NewsData> observer=new Observer<NewsData>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                addSubscribe(disposable);
            }

            @Override
            public void onNext(NewsData newsData) {
                if (newsData.getError_code()==10012){
                    mView.showErr("新闻请求次数达到上限");

                }else {
                    if (newsData.getResult().getData()!=null){
                        mView.showNews(newsData.getResult().getData());
                        mView.finshRefresh(true);
                    }else {
                        mView.finshRefresh(false);
                    }
                }


            }

            @Override
            public void onError(Throwable throwable) {
                    mView.showErr("新闻:"+throwable.getMessage());
            }

            @Override
            public void onComplete() {
                mView.finshRefresh(true);
            }
        };
        NewsApiMethods.ApiSubscribe(mModel.getNewsDate(type),observer);
    }
}
