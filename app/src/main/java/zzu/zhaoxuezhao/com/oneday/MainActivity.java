package zzu.zhaoxuezhao.com.oneday;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zzu.zhaoxuezhao.com.oneday.fragment.MoreFragment;
import zzu.zhaoxuezhao.com.oneday.fragment.NewsFragment;
import zzu.zhaoxuezhao.com.oneday.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.menu_weather)
    ImageView mMenuWeather;
    @BindView(R.id.menu_news)
    ImageView mMenuNews;
    @BindView(R.id.menu_more)
    ImageView mMenuMore;

    MoreFragment mMoreFragment;
    WeatherFragment mWeatherFragment;
    NewsFragment mNewsFragment;

    public static MainActivity sMainActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sMainActivity=this;
        ButterKnife.bind(this);

        if (savedInstanceState==null){
            mWeatherFragment=new WeatherFragment();
            mMenuWeather.setImageResource(R.drawable.weather_selected);
            mMenuMore.setImageResource(R.drawable.more_unselected);
            mMenuNews.setImageResource(R.drawable.news_unselected);
            replaceFragment(mWeatherFragment);
        }


    }


    @OnClick({R.id.menu_weather, R.id.menu_news, R.id.menu_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.menu_weather:
                mMenuWeather.setImageResource(R.drawable.weather_selected);
                mMenuMore.setImageResource(R.drawable.more_unselected);
                mMenuNews.setImageResource(R.drawable.news_unselected);
                if (mWeatherFragment==null){
                    mWeatherFragment=new WeatherFragment();
                }
                replaceFragment(mWeatherFragment);
                break;
            case R.id.menu_news:
                mMenuWeather.setImageResource(R.drawable.weather_unselected);
                mMenuMore.setImageResource(R.drawable.more_unselected);
                mMenuNews.setImageResource(R.drawable.news_selected);
                if (mNewsFragment==null){
                    mNewsFragment=new NewsFragment();
                }
                replaceFragment(mNewsFragment);
                break;
            case R.id.menu_more:
                mMenuWeather.setImageResource(R.drawable.weather_unselected);
                mMenuMore.setImageResource(R.drawable.more_selected);
                mMenuNews.setImageResource(R.drawable.news_unselected);
                if (mMoreFragment==null){
                    mMoreFragment=new MoreFragment();
                }
                replaceFragment(mMoreFragment);
                break;
        }
    }


    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment,fragment);
        fragmentTransaction.commit();
    }



}
