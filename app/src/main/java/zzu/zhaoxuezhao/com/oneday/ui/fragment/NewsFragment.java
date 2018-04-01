package zzu.zhaoxuezhao.com.oneday.ui.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zzu.zhaoxuezhao.com.oneday.R;


/**
 * Created by aotu on 2018/3/20.
 */

public class NewsFragment extends Fragment {


    private static List<String> newstype = new ArrayList<String>();
    @BindView(R.id.news_indicator)
    MagicIndicator mNewsIndicator;
    @BindView(R.id.news_pager)
    ViewPager mNewsPager;
    Unbinder unbinder;
    private NewsAdapter mNewsAdapter;

    public static NewsFragment getInstance() {
        return new NewsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        unbinder = ButterKnife.bind(this, view);
        initChildView();
        return view;
    }



    protected void initChildView() {
        String[] newslkind = getResources().getStringArray(R.array.news_type);
        newstype.clear();
        for (String d : newslkind) {
            newstype.add(d);
        }
        mNewsAdapter = new NewsAdapter(getChildFragmentManager());
        mNewsPager.setAdapter(mNewsAdapter);
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setScrollPivotX(0.65f);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return newstype == null ? 0 : newstype.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int i) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#9e9e9e"));
                colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#00c853"));
                colorTransitionPagerTitleView.setText(newstype.get(i));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mNewsPager.setCurrentItem(i);
                        //mNewsAdapter.notifyDataSetChanged();
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                indicator.setLineHeight(UIUtil.dip2px(context, 6));
                indicator.setLineWidth(UIUtil.dip2px(context, 10));
                indicator.setRoundRadius(UIUtil.dip2px(context, 3));
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
                indicator.setColors(Color.parseColor("#00c853"));
                return indicator;
            }
        });
        mNewsIndicator.setBackgroundColor(Color.parseColor("#fafafa"));
        mNewsIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mNewsIndicator, mNewsPager);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private  class NewsAdapter extends FragmentStatePagerAdapter{

        public NewsAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Log.e("news_type",newstype.get(position)+"--------"+position);
            return NewsDetailFragment.getInstance(newstype.get(position));
        }

        @Override
        public int getCount() {
            return newstype.size();
        }

        @Override
        public void restoreState(Parcelable state, ClassLoader loader) {
        }
    }


}
