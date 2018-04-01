package zzu.zhaoxuezhao.com.oneday.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.news.NewsResult;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

/**
 * Created by aotu on 2018/3/26.
 */

public class NewsDateAdapter extends BaseQuickAdapter<NewsResult,BaseViewHolder>{


    public NewsDateAdapter(int layoutResId, @Nullable List<NewsResult> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsResult item) {
        helper.setText(R.id.news_title,item.getTitle());
        helper.setText(R.id.news_author,item.getAuthor_name());
        helper.setText(R.id.news_time,item.getDate());
        GlideApp.with(mContext)
                .load(item.getThumbnail_pic_s())
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into((ImageView) helper.getView(R.id.news_image));

    }


}
