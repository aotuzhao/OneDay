package zzu.zhaoxuezhao.com.oneday.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import zzu.zhaoxuezhao.com.oneday.R;
import zzu.zhaoxuezhao.com.oneday.bean.weather.WeatherInfo;
import zzu.zhaoxuezhao.com.oneday.common.ResourceConstants;
import zzu.zhaoxuezhao.com.oneday.utils.GlideApp;

/**
 * Created by aotu on 2018/3/26.
 */

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> implements View.OnClickListener {

    List<WeatherInfo> mWeatherInfoList = new ArrayList<WeatherInfo>();
    Context mContext;
    private OnItemClickListener mItemClickListener;
    public WeatherAdapter(Context context, List<WeatherInfo> list) {
        mContext = context;
        mWeatherInfoList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weaher, parent, false);
        view.setOnClickListener(this);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WeatherInfo weatherInfo = mWeatherInfoList.get(position);
        holder.date.setText(weatherInfo.getDate());
        holder.temp.setText(weatherInfo.getLow() + "~" + weatherInfo.getHigh() + " °C");
        int code = Integer.parseInt(weatherInfo.getCode_day());
        /*Glide.with(mContext)
                .load(ResourceConstants.WEATHER_ICON[code])
                .into(holder.image);*/
        GlideApp.with(mContext)
                .load(ResourceConstants.WEATHER_ICON[code])
                .placeholder(R.drawable.w_0)
                .fitCenter()
                .into(holder.image);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mWeatherInfoList.size();
    }

    @Override
    public void onClick(View view) {
        if (mItemClickListener!=null){
            mItemClickListener.onItemClick((Integer) view.getTag());
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date;
        ImageView image;
        TextView temp;

        public ViewHolder(View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.item_date);
            image = itemView.findViewById(R.id.item_image);
            temp = itemView.findViewById(R.id.item_temperature);
        }


    }

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
