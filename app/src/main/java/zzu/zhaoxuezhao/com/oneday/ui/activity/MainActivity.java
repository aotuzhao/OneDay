package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.MoreFragment;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.NewsFragment;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    public static final int WRITE_LOCATION_PHONE = 0252;


    MoreFragment mMoreFragment;
    WeatherFragment mWeatherFragment;
    NewsFragment mNewsFragment;

    public static MainActivity sMainActivity;
    @BindView(R.id.fragment)
    FrameLayout mFragment;
    @BindView(R.id.menu_weather)
    ImageView mMenuWeather;
    @BindView(R.id.menu_news)
    ImageView mMenuNews;
    @BindView(R.id.menu_more)
    ImageView mMenuMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sMainActivity = this;
        checkPerms();

        if (savedInstanceState == null) {
            mWeatherFragment = WeatherFragment.getInstance();
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
                if (mWeatherFragment == null) {
                    mWeatherFragment = WeatherFragment.getInstance();
                }
                replaceFragment(mWeatherFragment);
                break;
            case R.id.menu_news:
                mMenuWeather.setImageResource(R.drawable.weather_unselected);
                mMenuMore.setImageResource(R.drawable.more_unselected);
                mMenuNews.setImageResource(R.drawable.news_selected);
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                }
                replaceFragment(mNewsFragment);
                break;
            case R.id.menu_more:
                mMenuWeather.setImageResource(R.drawable.weather_unselected);
                mMenuMore.setImageResource(R.drawable.more_selected);
                mMenuNews.setImageResource(R.drawable.news_unselected);
                if (mMoreFragment == null) {
                    mMoreFragment = new MoreFragment();
                }
                replaceFragment(mMoreFragment);
                break;
        }
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @AfterPermissionGranted(WRITE_LOCATION_PHONE)
    private void checkPerms() {
        String[] permissions = {
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
        };
        if (!EasyPermissions.hasPermissions(MainActivity.sMainActivity, permissions)) {
            EasyPermissions.requestPermissions(this, getString(R.string.write_location_phone),
                    WRITE_LOCATION_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        StringBuffer sb = new StringBuffer();
        for (String str : perms) {
            sb.append(str);
            sb.append("\n");
        }
        sb.replace(sb.length() - 2, sb.length(), "");

        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog
                    .Builder(this)
                    .setRationale("需要" + sb + "权限，此应用程序可能无法正常工作。是否打开设置")
                    .setPositiveButton("去设置")
                    .setNegativeButton("取消")
                    .build()
                    .show();

        }
    }
}
