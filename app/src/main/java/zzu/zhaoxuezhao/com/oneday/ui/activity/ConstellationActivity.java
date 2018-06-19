package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import zzu.zhaoxuezhao.com.oneday.R;

public class ConstellationActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constellation);
    }

    public void getBaiyang(View view) {
        getInfo("baiyang", 1);
        Toast.makeText(this,"白羊座",Toast.LENGTH_SHORT).show();
    }

    public void getJinniu(View view) {
        getInfo("jinniu", 2);
        Toast.makeText(this,"金牛座",Toast.LENGTH_SHORT).show();
    }

    public void getShuangzi(View view) {
        getInfo("shuangzi", 3);
        Toast.makeText(this,"双子座",Toast.LENGTH_SHORT).show();
    }

    public void getJuxie(View view) {
        getInfo("juxie", 4);
        Toast.makeText(this,"巨蟹座",Toast.LENGTH_SHORT).show();
    }

    public void getShizi(View view) {
        getInfo("shizi", 5);
        Toast.makeText(this,"狮子座",Toast.LENGTH_SHORT).show();
    }

    public void getChunv(View view) {
        getInfo("chunv", 6);
        Toast.makeText(this,"处女座",Toast.LENGTH_SHORT).show();
    }

    public void getTiancheng(View view) {
        getInfo("tiancheng", 7);
        Toast.makeText(this,"天秤座",Toast.LENGTH_SHORT).show();
    }

    public void getTianxie(View view) {
        getInfo("tianxie", 8);
        Toast.makeText(this,"天蝎座",Toast.LENGTH_SHORT).show();
    }

    public void getSheshou(View view) {
        getInfo("sheshou", 9);
        Toast.makeText(this,"射手座",Toast.LENGTH_SHORT).show();
    }

    public void getMojie(View view) {
        getInfo("mojie", 10);
        Toast.makeText(this,"摩羯座",Toast.LENGTH_SHORT).show();
    }

    public void getShuiping(View view) {
        getInfo("shuiping", 11);
        Toast.makeText(this,"水瓶座",Toast.LENGTH_SHORT).show();
    }

    public void getShuangyu(View view) {
        getInfo("shuangyu", 12);
        Toast.makeText(this,"双鱼座",Toast.LENGTH_SHORT).show();
    }

    public void getInfo(String star, int image) {
        Intent intent = new Intent(this, ConstellationInfoActivity.class);
        intent.putExtra("star", star);
        intent.putExtra("image", image);
        startActivity(intent);
    }
}
