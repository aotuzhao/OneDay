package zzu.zhaoxuezhao.com.oneday.mvp.contract;

import java.util.List;

import io.reactivex.Observable;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsData;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsResult;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseModel;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BasePresenter;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseView;

/**
 * Created by aotu on 2018/3/28.
 */

public interface NewsDetailContract {
    interface View extends BaseView{
        void showNews(List<NewsResult> newsResults);
        void finshRefresh(Boolean b);
    }

    interface Model extends BaseModel{
        Observable<NewsData> getNewsDate(String type);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void getNewsDate(String type);

    }
}
