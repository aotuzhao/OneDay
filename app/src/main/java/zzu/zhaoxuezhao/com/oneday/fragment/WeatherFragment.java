package zzu.zhaoxuezhao.com.oneday.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import zzu.zhaoxuezhao.com.oneday.MainActivity;
import zzu.zhaoxuezhao.com.oneday.R;

/**
 * Created by aotu on 2018/3/20.
 */

public class WeatherFragment extends Fragment implements EasyPermissions.PermissionCallbacks{
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

    public static final int WRITE_LOCATION_PHONE=0252;

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
        checkPerms();
    }

    @AfterPermissionGranted(WRITE_LOCATION_PHONE)
    private void checkPerms(){
        String[] permissions={
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
        };
        if (!EasyPermissions.hasPermissions(MainActivity.sMainActivity,permissions)){
            EasyPermissions.requestPermissions(this,getString(R.string.write_location_phone),
                    WRITE_LOCATION_PHONE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        StringBuffer sb = new StringBuffer();
        for (String str : perms){
            sb.append(str);
            sb.append("\n");
        }
        sb.replace(sb.length() - 2,sb.length(),"");

        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog
                    .Builder(this)
                    .setRationale("需要"+sb+"权限，此应用程序可能无法正常工作。是否打开设置")
                    .setPositiveButton("去设置")
                    .setNegativeButton("取消")
                    .build()
                    .show();

        }
    }


}
