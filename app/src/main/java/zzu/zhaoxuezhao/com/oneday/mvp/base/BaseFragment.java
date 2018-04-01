package zzu.zhaoxuezhao.com.oneday.mvp.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by aotu on 2018/3/26.
 */

public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment implements BaseView{
    protected P mPresenter;

    private M mModel;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter=createPresenter();
        mModel=createModel();
        mPresenter.attachView(this,mModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(getLayoutId(),container,false);
        unbinder = ButterKnife.bind(this, view);
        initChildView(view,savedInstanceState );
        fragmentLogic();
        return view;
    }


    //逻辑处理
    protected abstract void fragmentLogic();

    //初始化View
    protected abstract void initChildView(View mView,Bundle b);

    //获取布局
    protected abstract int getLayoutId();

    //初始化Presenter
    protected abstract P createPresenter();
    //初始化Model
    protected abstract M createModel();

    @Override
    public void onResume() {
        super.onResume();
        if (mPresenter == null) {
            mPresenter.attachView(this,mModel);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
