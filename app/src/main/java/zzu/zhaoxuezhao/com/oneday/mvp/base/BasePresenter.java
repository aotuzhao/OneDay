package zzu.zhaoxuezhao.com.oneday.mvp.base;

import android.util.Log;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by aotu on 2018/3/26.
 */

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    private static final String TAG = "BasePresenter";

    protected V mView;
    protected M mModel;
    private CompositeDisposable compositeDisposable;

    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    protected void attachView(V mView, M mModel) {
        if (this.mView == null) {
            this.mView = mView;
        }
        if (this.mModel == null) {
            this.mModel = mModel;
        }
    }


    protected void detachView() {
        this.mView = null;
        Log.e(TAG, "unSubscribe: view null");

        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }

    }
}