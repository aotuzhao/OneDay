package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.AppSettingsDialog;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.MoreFragment;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.NewsFragment;
import zzu.zhaoxuezhao.com.oneday.ui.fragment.WeatherFragment;

public class MainActivity extends AppCompatActivity {




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

    private static final int LOCATION_PERMISSION_CODE = 100;
    private static final int STORAGE_PERMISSION_CODE = 101;
    public static final int PHONE_PERMISSION_CODE = 102;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sMainActivity = this;


        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }

        checkLocationPermission();
        checkStoragePermission();
        checkPhonePermission();
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
                    mNewsFragment = NewsFragment.getInstance();
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





    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        switch (requestCode){
            case LOCATION_PERMISSION_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"定位权限已获取",Toast.LENGTH_SHORT).show();
                    Log.i("MY","定位权限已获取");

                } else {
                    Toast.makeText(MainActivity.this,"定位权限被拒绝",Toast.LENGTH_SHORT).show();
                    Log.i("MY","定位权限被拒绝");
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){

                        Log.i("MY","false 勾选了不再询问，并引导用户去设置中手动设置");
                        onPermissionsDenied("定位权限");
                        return;
                    }
                }
                break;
            case STORAGE_PERMISSION_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"存储权限已获取",Toast.LENGTH_SHORT).show();
                    Log.i("MY","存储权限已获取");

                } else {
                    Toast.makeText(MainActivity.this,"存储权限被拒绝",Toast.LENGTH_SHORT).show();
                    Log.i("MY","存储权限被拒绝");
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){

                        Log.i("MY","false 勾选了不再询问，并引导用户去设置中手动设置");
                        onPermissionsDenied("存储权限");
                        return;
                    }
                }
                break;
            case PHONE_PERMISSION_CODE:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this,"手机状态权限已获取",Toast.LENGTH_SHORT).show();
                    Log.i("MY","手机状态权限已获取");

                } else {
                    Toast.makeText(MainActivity.this,"手机状态权限被拒绝",Toast.LENGTH_SHORT).show();
                    Log.i("MY","手机状态权限被拒绝");
                    if(!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE)){

                        Log.i("MY","false 勾选了不再询问，并引导用户去设置中手动设置");
                        onPermissionsDenied("手机状态权限");
                        return;
                    }
                }
                break;

        }
    }

    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("MY","没有权限");
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
        } else {
            Toast.makeText(MainActivity.this, "已获取定位权限", Toast.LENGTH_SHORT).show();


        }
    }

    private void checkStoragePermission() {

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("MY","没有权限");
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},101);
        } else {
            Toast.makeText(MainActivity.this, "已获取存储的读写权限",Toast.LENGTH_SHORT).show();
        }
    }

    private void checkPhonePermission() {

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            Log.i("MY","没有权限");
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},102);
        } else {
            Toast.makeText(MainActivity.this, "已获取手机状态权限",Toast.LENGTH_SHORT).show();
        }
    }

    public void onPermissionsDenied(String perms) {

            new AppSettingsDialog
                    .Builder(this)
                    .setRationale("需要" + perms+ "权限，此应用程序可能无法正常工作。是否打开设置")
                    .setPositiveButton("去设置")
                    .setNegativeButton("取消")
                    .build()
                    .show();


    }



}
