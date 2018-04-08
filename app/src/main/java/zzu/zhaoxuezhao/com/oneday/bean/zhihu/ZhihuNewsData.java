package zzu.zhaoxuezhao.com.oneday.bean.zhihu;

import java.util.List;

public class ZhihuNewsData {

    /**
     * date : 20180403
     * stories : [{"title":"有哪些被低估的电影和电视剧？","ga_prefix":"040321","images":["https://pic4.zhimg.com/v2-60c124ec242123ad2f460263052e5feb.jpg"],"multipic":true,"type":0,"id":9677334},{"images":["https://pic2.zhimg.com/v2-04f07c460873947baca37a2be1b9e3f5.jpg"],"type":0,"id":9677255,"ga_prefix":"040319","title":"我离职了，无关薪酬福利、同事关系，只是不想每天「自愿」加班"},{"title":"把代表春天的果子吃进肚子里","ga_prefix":"040318","images":["https://pic4.zhimg.com/v2-7381f17cd8da9179a0a268ae3a01de03.jpg"],"multipic":true,"type":0,"id":9677331},{"images":["https://pic3.zhimg.com/v2-563eed826b7e12c0dd7ec5611aa9ef82.jpg"],"type":0,"id":9676568,"ga_prefix":"040318","title":"「同时按下电梯关门键和楼层键就能直达楼层」是真的吗？"},{"images":["https://pic3.zhimg.com/v2-252b13d387d1516132e1a83049610b7e.jpg"],"type":0,"id":9677259,"ga_prefix":"040317","title":"高铁设茶吧卖高价茶，乘客喝茶才能入座，合理吗？"},{"images":["https://pic3.zhimg.com/v2-b092de5d6657ab87914febf1b62447e2.jpg"],"type":0,"id":9677248,"ga_prefix":"040316","title":"都说是「95 亿」收购饿了么，不过，阿里这次可没出那么多"},{"images":["https://pic3.zhimg.com/v2-b2d8efa97811f51b6bf808545fb04c12.jpg"],"type":0,"id":9676858,"ga_prefix":"040315","title":"算不上游戏迷，我也觉得电影《头号玩家》还不错"},{"images":["https://pic1.zhimg.com/v2-bb23542fdf5645229a42d5bf1028e214.jpg"],"type":0,"id":9677138,"ga_prefix":"040313","title":"比起星巴克致癌，更可怕的是活跃在朋友圈里谣言号"},{"images":["https://pic1.zhimg.com/v2-0aec038b6c1076e06af8d35af8408d98.jpg"],"type":0,"id":9676927,"ga_prefix":"040312","title":"大误 · 《头号玩家》里的隐藏细节"},{"images":["https://pic2.zhimg.com/v2-f4334b59b0922bfb4c9f6a93faa0c4ed.jpg"],"type":0,"id":9677020,"ga_prefix":"040310","title":"为什么人到中年，很少有身材苗条的？"},{"images":["https://pic3.zhimg.com/v2-fa6123c0c3e2f261a99e8367e7681182.jpg"],"type":0,"id":9674718,"ga_prefix":"040309","title":"春天一到，怎么有的树先开花再长叶，而有的却先长叶再开花？"},{"images":["https://pic4.zhimg.com/v2-f1c084ca341d396f69cb0c31535332bb.jpg"],"type":0,"id":9675761,"ga_prefix":"040308","title":"用数据告诉你，什么样的数据分析师才是企业需要的"},{"images":["https://pic4.zhimg.com/v2-db46ed6ffca222f8cea56d9681aceb8f.jpg"],"type":0,"id":9676962,"ga_prefix":"040307","title":"明明在国内，为什么 B 站、爱奇艺这些公司还要赴美 IPO？"},{"images":["https://pic2.zhimg.com/v2-53cab5878c3c23fcc1c169c2743a3695.jpg"],"type":0,"id":9677039,"ga_prefix":"040307","title":"「白银案」凶手和他的同学们"},{"images":["https://pic3.zhimg.com/v2-40b35835a2780eb2291d2fb79d6a4f76.jpg"],"type":0,"id":9676818,"ga_prefix":"040306","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"https://pic1.zhimg.com/v2-6fc29d5a0e64a19919139d5151d6b698.jpg","type":0,"id":9677255,"ga_prefix":"040319","title":"我离职了，无关薪酬福利、同事关系，只是不想每天「自愿」加班"},{"image":"https://pic1.zhimg.com/v2-cec020a14a164ef1657afc259328ecf4.jpg","type":0,"id":9677259,"ga_prefix":"040317","title":"高铁设茶吧卖高价茶，乘客喝茶才能入座，合理吗？"},{"image":"https://pic1.zhimg.com/v2-60df6e8163f77f91022b9accbd0ea2f0.jpg","type":0,"id":9677248,"ga_prefix":"040316","title":"都说是「95 亿」收购饿了么，不过，阿里这次可没出那么多"},{"image":"https://pic4.zhimg.com/v2-498ce8f4b9ce9886cc0066abcaf44687.jpg","type":0,"id":9676858,"ga_prefix":"040315","title":"算不上游戏迷，我也觉得电影《头号玩家》还不错"},{"image":"https://pic2.zhimg.com/v2-0d9f5f97429089f20ee1ce224cd79c1d.jpg","type":0,"id":9677138,"ga_prefix":"040313","title":"比起星巴克致癌，更可怕的是活跃在朋友圈里谣言号"}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * title : 有哪些被低估的电影和电视剧？
         * ga_prefix : 040321
         * images : ["https://pic4.zhimg.com/v2-60c124ec242123ad2f460263052e5feb.jpg"]
         * multipic : true
         * type : 0
         * id : 9677334
         */

        private String title;
        private String ga_prefix;
        private boolean multipic;
        private int type;
        private int id;
        private List<String> images;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * image : https://pic1.zhimg.com/v2-6fc29d5a0e64a19919139d5151d6b698.jpg
         * type : 0
         * id : 9677255
         * ga_prefix : 040319
         * title : 我离职了，无关薪酬福利、同事关系，只是不想每天「自愿」加班
         */

        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
