package zzu.zhaoxuezhao.com.oneday.mvp.presenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;
import zzu.zhaoxuezhao.com.oneday.mvp.model.ConstellationInfoModel;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IConstellationInfoView;
import zzu.zhaoxuezhao.com.oneday.network.ConstellationApiMethods;

public class ConstellationInfoPresenter {

    private IConstellationInfoView mIConstellationInfoView;
    private ConstellationInfoModel mConstellationInfoModel;

    public ConstellationInfoPresenter(IConstellationInfoView IConstellationInfoView) {
        mIConstellationInfoView = IConstellationInfoView;
        mConstellationInfoModel = new ConstellationInfoModel();
    }

    public void getConstellationInfo(String star) {
        Observer<Constellation> observer = new Observer<Constellation>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Constellation constellation) {
                if (constellation!=null){
                    mIConstellationInfoView.showConstellation(constellation);
                }else {
                    mIConstellationInfoView.showError("暂无资源！");
                }
            }

            @Override
            public void onError(Throwable throwable) {
                mIConstellationInfoView.showError(throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };
        ConstellationApiMethods.ApiSubscribe(mConstellationInfoModel.getConstellationInfo(star), observer);
    }
}
