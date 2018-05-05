package zzu.zhaoxuezhao.com.oneday.ui.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.fun.Joke;
import zzu.zhaoxuezhao.com.oneday.network.JokeApiMothods;
import zzu.zhaoxuezhao.com.oneday.ui.adapter.JokeAdapter;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

public class JokeActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private JokeAdapter mJokeAdapter;
    private List<Joke> mJokes = new ArrayList<Joke>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        mRecyclerView = findViewById(R.id.recycler_joke);
        getJoke();
        iniiView();

    }

    private void iniiView() {

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mJokeAdapter = new JokeAdapter(R.layout.item_joke, mJokes);
        mJokeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Joke joke = (Joke) adapter.getItem(position);
                showImage(joke.getThumburl());

            }
        });
        mJokeAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Joke joke = (Joke) adapter.getItem(position);
                shareJoke(joke.getUrl(), joke.getTitle());
                return false;
            }
        });
        mRecyclerView.setAdapter(mJokeAdapter);
    }

    public void shareJoke(String url, String title) {
        Intent textIntent = new Intent(Intent.ACTION_SEND);
        textIntent.setType("text/plain");
        textIntent.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(Intent.createChooser(textIntent, title));
    }

    private void showImage(String thumburl) {

        final Dialog dialog = new Dialog(this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        ImageView imgView = getView(thumburl);
        dialog.setContentView(imgView);
        dialog.show();

        // 点击图片消失
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
    }

    private ImageView getView(String url) {
        ImageView imgView = new ImageView(this);
        imgView.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));


        GlideApp.with(this)
                .load(url)
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into(imgView);

        return imgView;
    }

    private void getJoke() {
        Observer<List<Joke>> observer = new Observer<List<Joke>>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(List<Joke> jokes) {
                Log.e("--zhao--", jokes.size() + "--" + jokes.toString());
                if (jokes != null && jokes.size() > 0) {
                    mJokes.addAll(jokes);
                }
                mJokeAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(Throwable throwable) {
                Log.e("--zhao--", throwable.getMessage());
            }

            @Override
            public void onComplete() {

            }
        };

        JokeApiMothods.getInstance().getJoke(observer);
    }
}
