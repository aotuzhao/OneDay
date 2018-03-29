package zzu.zhaoxuezhao.com.oneday.bean.news;

import java.util.List;

/**
 * Created by aotu on 2018/3/14.
 * stat 状态码
 * data 新闻详情
 */

public class NewResultBridge {
    private String  stat;
    private List<NewsResult> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<NewsResult> getData() {
        return data;
    }

    public void setData(List<NewsResult> data) {
        this.data = data;
    }
}
