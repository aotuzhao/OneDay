package zzu.zhaoxuezhao.com.oneday.ui.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.suggestion.LifeSuggestionData;
import zzu.zhaoxuezhao.com.oneday.bean.suggestion.Suggestions;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherData;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherInfo;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherNow;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherThreeData;
import zzu.zhaoxuezhao.com.oneday.mvp.base.BaseFragment;
import zzu.zhaoxuezhao.com.oneday.mvp.contract.WeatherContract;
import zzu.zhaoxuezhao.com.oneday.mvp.model.WeatherDataModel;
import zzu.zhaoxuezhao.com.oneday.mvp.presenter.WeatherPresenter;
import zzu.zhaoxuezhao.com.oneday.ui.adapter.WeatherAdapter;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

/**
 * Created by aotu on 2018/3/20.
 */

public class WeatherFragment extends BaseFragment<WeatherPresenter, WeatherDataModel> implements WeatherContract.View {


    @BindView(R.id.location_city)
    TextView mLocationCity;
    @BindView(R.id.weather_icon)
    ImageView mWeatherIcon;
    @BindView(R.id.weather_text)
    TextView mWeatherText;
    @BindView(R.id.weather_temperature)
    TextView mWeatherTemperature;
    @BindView(R.id.weather_wend)
    TextView mWeatherWend;
    @BindView(R.id.weather_two)
    RecyclerView mWeatherTwo;
    @BindView(R.id.dress)
    TextView mDress;
    @BindView(R.id.sport)
    TextView mSport;
    @BindView(R.id.car)
    TextView mCar;
    @BindView(R.id.flu)
    TextView mFlu;
    @BindView(R.id.uv)
    TextView mUv;
    @BindView(R.id.travel)
    TextView mTravel;
    @BindView(R.id.weather_refresh)
    SmartRefreshLayout mWeatherRefresh;
    Unbinder unbinder;

    private List<WeatherInfo> mWeatherInfos;
    private WeatherAdapter mWeatherAdapter;

    public static WeatherFragment getInstance() {
        return new WeatherFragment();
    }


    @Override
    protected void fragmentLogic() {
        mWeatherAdapter.setItemClickListener(new WeatherAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                WeatherInfo weatherInfo=mWeatherInfos.get(position);
                Toast.makeText(getContext(),weatherInfo.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        mWeatherRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPresenter.getNowWeather();
                mPresenter.getThreeWeather();
                mWeatherRefresh.finishRefresh(2000);
            }
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void initChildView(View mView, Bundle b) {
        mLocationCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mPresenter.getLocation();
            }
        });
        mWeatherInfos = new ArrayList<WeatherInfo>();
        mWeatherAdapter = new WeatherAdapter(getContext(), mWeatherInfos);
        mWeatherTwo.setLayoutManager(new LinearLayoutManager(getContext()));
        mWeatherTwo.setAdapter(mWeatherAdapter);
        mWeatherRefresh.getRefreshHeader().setPrimaryColors(Color.WHITE);
        mWeatherRefresh.autoRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void showLocation(String location) {
        mLocationCity.setText(location);
    }

    @Override
    public void showNowWeather(WeatherData weatherData) {
        if (weatherData!=null){
            WeatherNow weatherNow=weatherData.getResults().get(0).getNow();
            GlideApp.with(this)
                    .load(getResources().getIntArray(R.array.weather_icon)[Integer.parseInt(weatherNow.getCode())])
                    .placeholder(R.drawable.w_0)
                    .error(R.drawable.w_99)
                    .fitCenter()
                    .into(mWeatherIcon);
            mWeatherText.setText(weatherNow.getText());
            mWeatherTemperature.setText(weatherNow.getTemperature()+R.string.weather_temperature);

        }

    }

    @Override
    public void showMoreWeather(WeatherThreeData weatherThreeData) {
        List<WeatherInfo> weathers=weatherThreeData.getResults().get(0).getDaily();
        if (weathers!=null){
            mWeatherInfos.addAll(weathers);
        }
        mWeatherAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSugWeather(LifeSuggestionData lifeSuggestionData) {
        Suggestions suggestions=lifeSuggestionData.getResults().get(0).getSuggestion();
        if (suggestions!=null){
            mDress.setText(suggestions.getDressing().getBrief());
            mCar.setText(suggestions.getCar_washing().getBrief());
            mFlu.setText(suggestions.getFlu().getBrief());
            mSport.setText(suggestions.getSport().getBrief());
            mUv.setText(suggestions.getUv().getBrief());
            mTravel.setText(suggestions.getTravel().getBrief());
        }
    }

    @Override
    public void showErr(String error) {
        Toast.makeText(getContext(),error,Toast.LENGTH_SHORT).show();
    }
}
