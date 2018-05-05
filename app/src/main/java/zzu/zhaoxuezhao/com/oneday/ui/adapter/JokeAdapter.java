package zzu.zhaoxuezhao.com.oneday.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.fun.Joke;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

public class JokeAdapter extends BaseQuickAdapter<Joke,BaseViewHolder> {

    public JokeAdapter(int layoutResId, @Nullable List<Joke> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Joke item) {
        helper.setText(R.id.tv_joke_title,item.getTitle());
        GlideApp.with(mContext)
                .load(item.getThumburl())
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into((ImageView) helper.getView(R.id.iv_joke_image));
    }
}
