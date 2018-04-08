package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuaNews;
import zzu.zhaoxuezhao.com.oneday.mvp.presenter.ZhihuWebNewsPresenter;
import zzu.zhaoxuezhao.com.oneday.mvp.view.IZhiHuWebView;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

public class ZhihuWebActivity extends AppCompatActivity implements IZhiHuWebView {
    @BindView(R.id.iv_web_img)
    ImageView mIvWebImg;
    @BindView(R.id.tv_img_title)
    TextView mTvImgTitle;
    @BindView(R.id.tv_img_source)
    TextView mTvImgSource;
    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.zhihu_share)
    FloatingActionButton mZhihuShare;
    private ZhihuWebNewsPresenter mZhihuWebNewsPresenter;
    private String id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }
        id = getIntent().getStringExtra("id");
        mZhihuWebNewsPresenter = new ZhihuWebNewsPresenter(this, this);
        mZhihuWebNewsPresenter.getDetailNews(id);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mZhihuWebNewsPresenter.destroyImg();
    }

    @Override
    public void showWebView(final ZhihuaNews zhihuaNews) {

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        String head = "<head>\n" +
                "\t<link rel=\"stylesheet\" href=\"" + zhihuaNews.getCss().get(0) + "\"/>\n" +
                "</head>";
        String img = "<div class=\"headline\">";
        String html = head + zhihuaNews.getBody().replace(img, " ");
        mWebView.loadDataWithBaseURL(null, html, "text/html", "utf-8", null);
        mZhihuShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareZhihu(zhihuaNews.getShare_url(), zhihuaNews.getTitle());
            }
        });
    }

    @Override
    public void showWebImg(String url) {
        GlideApp.with(this)
                .load(url)
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into(mIvWebImg);
    }

    @Override
    public void showImgTitle(String title) {
        mTvImgTitle.setText(title);
    }

    @Override
    public void showImgSource(String source) {
        mTvImgSource.setText(source);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    public void shareZhihu(String url, String title) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(textIntent, title));
    }


}
