package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.mvp.presenter.ZhihuListPresenter;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IZhiHuListView;
import zzu.zhaoxuezhao.com.oneday.ui.adapter.ZhihuDataAdapter;

public class ZhihuListActivity extends AppCompatActivity implements IZhiHuListView {

    @BindView(R.id.zhihu_list)
    RecyclerView mZhihuList;
    @BindView(R.id.zhihu_list_fresh)
    SmartRefreshLayout mZhihuListFresh;
    private ZhihuListPresenter mZhihuListPresenter = new ZhihuListPresenter(this);
    private ZhihuDataAdapter mZhihuDataAdapter;
    private List<ZhihuNewsData.StoriesBean> mStoriesBeanList = new ArrayList<>();
    private String time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhihu_list);
        ButterKnife.bind(this);

        mZhihuListPresenter.getLatestNews();
        initView();
    }

    private void initView() {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mZhihuDataAdapter = new ZhihuDataAdapter(R.layout.item_zhihu_stories, mStoriesBeanList);
        mZhihuDataAdapter.openLoadAnimation();
        mZhihuDataAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ZhihuNewsData.StoriesBean storiesBean = (ZhihuNewsData.StoriesBean) adapter.getItem(position);
                showNewsData(storiesBean.getId() + "");
            }
        });

        mZhihuDataAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mZhihuList.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mZhihuListPresenter.getBeforeNews(time);
                    }
                }, 2000);
            }
        }, mZhihuList);
        mZhihuListFresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mStoriesBeanList.clear();
                mZhihuListPresenter.getLatestNews();
            }
        });
        mZhihuList.setLayoutManager(staggeredGridLayoutManager);
        mZhihuList.setAdapter(mZhihuDataAdapter);
    }

    @Override
    public void showZhihuList(ZhihuNewsData zhihuNewsData) {
        if (zhihuNewsData.getStories().isEmpty()) {
            showError("返回为空");
        } else {
            time = zhihuNewsData.getDate();
            mStoriesBeanList.addAll(zhihuNewsData.getStories());
            mZhihuDataAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void showNewsData(String id) {
        Intent intent = new Intent(this, ZhihuWebActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }


    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void finishRefresh(Boolean b) {
        if (mZhihuListFresh.isRefreshing()) {
            mZhihuListFresh.finishRefresh(b);
        }
    }

    @Override
    public void finshLoadMore() {
        mZhihuDataAdapter.loadMoreComplete();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStoriesBeanList.clear();
        if (mZhihuListPresenter != null) {
            mZhihuListPresenter.distoryView();
        }
    }
}
