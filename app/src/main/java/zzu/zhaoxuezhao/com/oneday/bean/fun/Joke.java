package zzu.zhaoxuezhao.com.oneday.bean.fun;

import com.google.gson.annotations.SerializedName;

public class Joke {
    /**
     * title : 放弃
     * thumburl : http://ww3.sinaimg.cn/large/bd759d6djw1er64gqwe0rj20at0y6wg6.jpg
     * sourceurl : http://down.laifudao.com/images/tupian/201541217943.jpg
     * height : 1230
     * width : 389
     * class : 2
     * url : http://www.laifudao.com/tupian/43201.htm
     */

    private String title;
    private String thumburl;
    private String sourceurl;
    private String height;
    private String width;
    @SerializedName("class")
    private String classX;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getClassX() {
        return classX;
    }

    public void setClassX(String classX) {
        this.classX = classX;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
