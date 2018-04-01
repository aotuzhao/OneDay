package zzu.zhaoxuezhao.com.oneday.ui.fragment;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
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

    private SwipeRefreshLayout mWeatherRefresh;
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
                WeatherInfo weatherInfo = mWeatherInfos.get(position);
                Toast.makeText(getContext(), weatherInfo.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mLocationCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getLocation();
            }
        });
    }


    @SuppressLint("RestrictedApi")
    @Override
    protected void initChildView(View mView, Bundle b) {

        mWeatherInfos = new ArrayList<WeatherInfo>();
        mWeatherAdapter = new WeatherAdapter(getContext(), mWeatherInfos);
        mWeatherTwo.setLayoutManager(new LinearLayoutManager(getContext()));
        mWeatherTwo.setAdapter(mWeatherAdapter);
        mWeatherRefresh = mView.findViewById(R.id.weather_refresh);
        mWeatherRefresh.setColorSchemeColors(Color.BLUE);
        mWeatherRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getLocation();
                mPresenter.getNowWeather();
                mPresenter.getThreeWeather();
                mPresenter.getSugWeather();
                stopRefresh();
            }
        });
        mPresenter.getLocation();
        mPresenter.getNowWeather();
        mPresenter.getThreeWeather();
        mPresenter.getSugWeather();
        // mWeatherRefresh.autoRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    protected WeatherPresenter createPresenter() {
        return new WeatherPresenter();
    }

    @Override
    protected WeatherDataModel createModel() {
        return new WeatherDataModel();
    }

    @Override
    public void showLocation(String location) {
        mLocationCity.setText(location);
    }

    @Override
    public void showNowWeather(WeatherData weatherData) {
        if (weatherData != null) {
            WeatherNow weatherNow = weatherData.getResults().get(0).getNow();
            //Log.e("zhao-weathernow:",weatherNow.getTemperature()+weatherNow.getCode()+weatherNow.getText());

            TypedArray mTypedArray = getResources().obtainTypedArray(R.array.weather_icon);

            int imageId = mTypedArray.getResourceId(Integer.parseInt(weatherNow.getCode()), 39);

            mTypedArray.recycle();
            Log.e("zhao-imageId", imageId + "");
            GlideApp.with(this)
                    .load(imageId)
                    .placeholder(R.drawable.w_0)
                    .error(R.drawable.w_99)
                    .fitCenter()
                    .into(mWeatherIcon);
            mWeatherText.setText(weatherNow.getText());
            mWeatherTemperature.setText(weatherNow.getTemperature() + getString(R.string.weather_temperature));
            stopRefresh();
        }


    }

    @Override
    public void showMoreWeather(WeatherThreeData weatherThreeData) {
        List<WeatherInfo> weathers = weatherThreeData.getResults().get(0).getDaily();
        mWeatherInfos.clear();
        if (weathers != null) {
            WeatherInfo weatherInfo = weathers.get(0);
            mWeatherWend.setText(weatherInfo.getWind_direction() + " 风" + "\n" + weatherInfo.getWind_scale() + " 级");
            mWeatherInfos.addAll(weathers);
        }
        stopRefresh();
        mWeatherAdapter.notifyDataSetChanged();

    }

    @Override
    public void showSugWeather(LifeSuggestionData lifeSuggestionData) {
        Suggestions suggestions = lifeSuggestionData.getResults().get(0).getSuggestion();
        if (suggestions != null) {
            mDress.setText(suggestions.getDressing().getBrief());
            mCar.setText(suggestions.getCar_washing().getBrief());
            mFlu.setText(suggestions.getFlu().getBrief());
            mSport.setText(suggestions.getSport().getBrief());
            mUv.setText(suggestions.getUv().getBrief());
            mTravel.setText(suggestions.getTravel().getBrief());
            stopRefresh();
        }

    }

    @Override
    public void showErr(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    public void stopRefresh() {
        if (mWeatherRefresh.isRefreshing()) {
            mWeatherRefresh.setRefreshing(false);

        }
    }


}
