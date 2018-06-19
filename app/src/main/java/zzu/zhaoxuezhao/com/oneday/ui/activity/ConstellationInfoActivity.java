package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.constellation.Constellation;
import zzu.zhaoxuezhao.com.oneday.mvp.presenter.ConstellationInfoPresenter;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IConstellationInfoView;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

public class ConstellationInfoActivity extends AppCompatActivity implements IConstellationInfoView {

    @BindView(R.id.star_icon)
    ImageView mStarIcon;
    @BindView(R.id.day_notice)
    TextView mDayNotice;
    @BindView(R.id.day_general)
    TextView mDayGeneral;
    @BindView(R.id.day_love)
    TextView mDayLove;
    @BindView(R.id.day_work)
    TextView mDayWork;
    @BindView(R.id.day_money)
    TextView mDayMoney;
    @BindView(R.id.tomorrow_general)
    TextView mTomorrowGeneral;
    @BindView(R.id.tomorrow_love)
    TextView mTomorrowLove;
    @BindView(R.id.tomorrow_work)
    TextView mTomorrowWork;
    @BindView(R.id.tomorrow_money)
    TextView mTomorrowMoney;
    @BindView(R.id.week_general)
    TextView mWeekGeneral;
    @BindView(R.id.week_love)
    TextView mWeekLove;
    @BindView(R.id.week_work)
    TextView mWeekWork;
    @BindView(R.id.week_money)
    TextView mWeekMoney;
    @BindView(R.id.week_health)
    TextView mWeekHealth;
    @BindView(R.id.summary_star)
    RatingBar mSummaryStar;
    @BindView(R.id.work_star)
    RatingBar mWorkStar;
    @BindView(R.id.money_star)
    RatingBar mMoneyStar;
    @BindView(R.id.love_star)
    RatingBar mLoveStar;
    @BindView(R.id.grxz)
    TextView mGrxz;
    @BindView(R.id.lucky_num)
    TextView mLuckyNum;
    @BindView(R.id.lucky_direction)
    TextView mLuckyDirection;
    @BindView(R.id.lucky_color)
    TextView mLuckyColor;
    private String start;
    private int image;
    private ConstellationInfoPresenter mConstellationInfoPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation_info);
        ButterKnife.bind(this);
        start = getIntent().getStringExtra("star");
        image = getIntent().getIntExtra("image", 1);
        mConstellationInfoPresenter = new ConstellationInfoPresenter(this);
        mConstellationInfoPresenter.getConstellationInfo(start);

        switch (image) {
            case 1:
                showImage(R.drawable.constellation_01);
                break;
            case 2:
                showImage(R.drawable.constellation_02);
                break;
            case 3:
                showImage(R.drawable.constellation_03);
                break;
            case 4:
                showImage(R.drawable.constellation_04);
                break;
            case 5:
                showImage(R.drawable.constellation_05);
                break;
            case 6:
                showImage(R.drawable.constellation_06);
                break;
            case 7:
                showImage(R.drawable.constellation_07);
                break;
            case 8:
                showImage(R.drawable.constellation_08);
                break;
            case 9:
                showImage(R.drawable.constellation_09);
                break;
            case 10:
                showImage(R.drawable.constellation_10);
                break;
            case 11:
                showImage(R.drawable.constellation_11);
                break;
            case 12:
                showImage(R.drawable.constellation_12);
                break;


        }
    }


    @Override
    public void showConstellation(Constellation constellation) {
        Constellation.ShowapiResBodyBean.DayBean dayBean = constellation.getShowapi_res_body().getDay();
        Constellation.ShowapiResBodyBean.TomorrowBean tomorrowBean = constellation.getShowapi_res_body().getTomorrow();
        Constellation.ShowapiResBodyBean.WeekBean weekBean = constellation.getShowapi_res_body().getWeek();
        mSummaryStar.setRating(dayBean.getSummary_star());
        mWorkStar.setRating(dayBean.getWork_star());
        mMoneyStar.setRating(dayBean.getMoney_star());
        mLoveStar.setRating(dayBean.getLove_star());

        mGrxz.setText(dayBean.getGrxz());
        mLuckyNum.setText(dayBean.getLucky_num());
        mLuckyDirection.setText(dayBean.getLucky_direction());
        mLuckyColor.setText(dayBean.getLucky_color());

        mDayNotice.setText(dayBean.getDay_notice());
        mDayGeneral.setText(dayBean.getGeneral_txt());
        mDayLove.setText(dayBean.getLove_txt());
        mDayWork.setText(dayBean.getWork_txt());
        mDayMoney.setText(dayBean.getMoney_txt());

        mTomorrowGeneral.setText(tomorrowBean.getGeneral_txt());
        mTomorrowLove.setText(tomorrowBean.getLove_txt());
        mTomorrowMoney.setText(tomorrowBean.getMoney_txt());
        mTomorrowWork.setText(tomorrowBean.getWork_txt());

        mWeekGeneral.setText(weekBean.getGeneral_txt());
        mWeekWork.setText(weekBean.getWork_txt());
        mWeekMoney.setText(weekBean.getMoney_txt());
        mWeekHealth.setText(weekBean.getHealth_txt());
        mWeekLove.setText(weekBean.getLove_txt());

    }

    @Override
    public void showError(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void showImage(int im) {
        GlideApp.with(this)
                .load(im)
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into(mStarIcon);
    }

}
