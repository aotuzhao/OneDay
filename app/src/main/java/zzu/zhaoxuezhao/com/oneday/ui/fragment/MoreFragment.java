package zzu.zhaoxuezhao.com.oneday.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.thefinestartist.finestwebview.FinestWebView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.ui.activity.MainActivity;
import zzu.zhaoxuezhao.com.oneday.ui.activity.ZhihuListActivity;
import zzu.zhaoxuezhao.com.oneday.ui.adapter.ImageViewHolder;


/**
 * Created by aotu on 2018/3/20.
 */

public class MoreFragment extends Fragment {
    @BindView(R.id.more_flush)
    ConvenientBanner mMoreFlush;
    @BindView(R.id.more_blog)
    ImageView mMoreBlog;
    @BindView(R.id.more_joke)
    ImageView mMoreJoke;
    @BindView(R.id.more_constellation)
    ImageView mMoreConstellation;
    @BindView(R.id.more_welfare)
    ImageView mMoreWelfare;
    @BindView(R.id.zhihu)
    ImageView mZhihu;
    Unbinder unbinder;
    private List<String> mStrings=new ArrayList<String>();
    private List<String> urls=new ArrayList<String>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.more_blog, R.id.more_joke, R.id.more_constellation, R.id.more_welfare, R.id.zhihu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_blog:
                break;
            case R.id.more_joke:
                break;
            case R.id.more_constellation:
                break;
            case R.id.more_welfare:
                break;
            case R.id.zhihu:
                Intent intent=new Intent(getContext(), ZhihuListActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }

    private void initView(){
        mMoreFlush.setPages(new CBViewHolderCreator() {
            @Override
            public Object createHolder() {
                return new ImageViewHolder();
            }
        },mStrings).setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        mMoreFlush.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                webView(urls.get(position));
            }
        });

    }

    private void webView(String url){
        new  FinestWebView.Builder(MainActivity.sMainActivity)
                .webViewSupportZoom(true)
                .webViewBuiltInZoomControls(true)
                .show(url);
    }

    private void initData(){
        if (mStrings.isEmpty()){
            mStrings.add("http://www.freezxz.com/wp-content/uploads/2018/04/top.jpg");
            mStrings.add("https://imgsa.baidu.com/forum/w%3D580/sign=77991c307b8da9774e2f86238051f872/492ad3f9d72a605918243e192034349b033bbaa6.jpg");
            mStrings.add("http://imgsrc.baidu.com/forum/pic/item/b341094f78f0f73675718d020255b319eac413cf.jpg");

            urls.add("https://github.com/aotuzhao");
            urls.add("http://www.freezxz.com/");
            urls.add("http://www.jikedaohang.com/");

        }


    }

    @Override
    public void onResume() {
        super.onResume();
        mMoreFlush.startTurning(3000);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMoreFlush.stopTurning();
    }
}
