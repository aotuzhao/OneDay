package zzu.zhaoxuezhao.com.oneday.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zzu.zhaoxuezhao.com.oneday.R;

/**
 * Created by aotu on 2018/3/20.
 */

public class WeatherFragment extends Fragment {
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
    ListView mWeatherTwo;
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
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.location_city)
    public void onViewClicked() {

    }
}
