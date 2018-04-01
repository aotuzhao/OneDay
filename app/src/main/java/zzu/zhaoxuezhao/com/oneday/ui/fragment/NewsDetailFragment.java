package zzu.zhaoxuezhao.com.oneday.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsResult;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseFragment;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.NewsDetailContract;
import zzu.zhaoxuezhao.com.oneday.mvp.model.NewsDetailModel;
import zzu.zhaoxuezhao.com.oneday.mvp.presenter.NewsDetailPresenter;
import zzu.zhaoxuezhao.com.oneday.ui.activity.MainActivity;
import zzu.zhaoxuezhao.com.oneday.ui.adapter.NewsDateAdapter;


public class NewsDetailFragment extends BaseFragment<NewsDetailPresenter, NewsDetailModel> implements NewsDetailContract.View {


    public static String newsType;
    @BindView(R.id.news_detail)
    RecyclerView mNewsDetail;
    @BindView(R.id.srl)
    SmartRefreshLayout mSrl;

    private List<NewsResult> mNewsResultList = new ArrayList<NewsResult>();
    private NewsDateAdapter mNewsDateAdapter;

    public static NewsDetailFragment getInstance(String d) {
        switch (d) {
            case "头条":
                newsType = "top";
                break;
            case "社会":
                newsType = "shehui";
                break;
            case "国内":
                newsType = "guonei";
                break;
            case "国际":
                newsType = "guoji";
                break;
            case "娱乐":
                newsType = "yule";
                break;
            case "体育":
                newsType = "tiyu";
                break;
            case "军事":
                newsType = "junshi";
                break;
            case "科技":
                newsType = "keji";
                break;
            case "财经":
                newsType = "caijing";
                break;
            case "时尚":
                newsType = "shishang";
                break;
            default:
                newsType = "top";
                break;
        }
        return new NewsDetailFragment();
    }

    @Override
    protected void fragmentLogic() {

    }

    @Override
    protected void initChildView(View mView, Bundle b) {
        mNewsResultList.clear();
        mNewsDetail.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsDateAdapter = new NewsDateAdapter(R.layout.item_news, mNewsResultList);
        mNewsDateAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                NewsResult newsResult= (NewsResult) adapter.getItem(position);
                Toast.makeText(getContext(),newsResult.getUrl() , Toast.LENGTH_SHORT).show();
                webView(newsResult.getUrl());
            }
        });
        mNewsDateAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        mNewsDateAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mNewsDetail.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                },3000);
            }
        },mNewsDetail);
        mNewsDetail.setAdapter(mNewsDateAdapter);

        mSrl.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mNewsResultList.clear();
                mPresenter.getNewsDate(newsType);
            }
        });
        Log.e("Detail--init", newsType + "--------");
        mPresenter.getNewsDate(newsType);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected NewsDetailPresenter createPresenter() {
        return new NewsDetailPresenter();
    }

    @Override
    protected NewsDetailModel createModel() {
        return new NewsDetailModel();
    }

    @Override
    public void showNews(List<NewsResult> newsResults) {
        if (newsResults != null) {
            mNewsResultList.clear();
            mNewsResultList.addAll(newsResults);
            mNewsDateAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void finshRefresh(Boolean b) {
        if (mSrl.isRefreshing()) {
            mSrl.finishRefresh(b);
        }
    }


    @Override
    public void showErr(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    private void webView(String url){
        new  FinestWebView.Builder(MainActivity.sMainActivity)
                .webViewSupportZoom(true)
                .webViewBuiltInZoomControls(true)
                .show(url);
    }
}
