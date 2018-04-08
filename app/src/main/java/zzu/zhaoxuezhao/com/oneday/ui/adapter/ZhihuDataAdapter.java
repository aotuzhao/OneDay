package zzu.zhaoxuezhao.com.oneday.ui.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.zhihu.ZhihuNewsData;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

public class ZhihuDataAdapter extends BaseQuickAdapter<ZhihuNewsData.StoriesBean,BaseViewHolder> {

    public ZhihuDataAdapter(int layoutResId, @Nullable List<ZhihuNewsData.StoriesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ZhihuNewsData.StoriesBean item) {
        helper.setText(R.id.tv_stories_title,item.getTitle());
        GlideApp.with(mContext)
                .load(item.getImages().get(0))
                .placeholder(R.drawable.cloud_ok)
                .error(R.drawable.cloud_error)
                .into((ImageView) helper.getView(R.id.iv_stories_img));
    }
}
