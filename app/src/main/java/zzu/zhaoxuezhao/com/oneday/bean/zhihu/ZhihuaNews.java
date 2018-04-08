package zzu.zhaoxuezhao.com.oneday.bean.zhihu;

import java.util.List;

public class ZhihuaNews {
    /**
     * body : <div class="main-wrap content-wrap">
     <div class="headline">

     <div class="img-place-holder"></div>



     </div>

     <div class="content-inner">




     <div class="question">
     <h2 class="question-title">网上说的「电梯关门键和楼层键一起按能直达楼层」是真的吗？</h2>

     <div class="answer">

     <div class="meta">
     <img class="avatar" src="http://pic3.zhimg.com/v2-8d162b17e7e0c310ce609e30077a70e6_is.jpg">
     <span class="author">江晟枫，</span><span class="bio">随意随意~</span>
     </div>

     <div class="content">
     <p>首先先简要介绍一下两个电梯常见的部件。</p>
     <p>召唤盒：如下图，也就是在厅内乘客需要乘坐电梯要将电梯召下来时所需要用到的部件。</p>
     <p><img class="content-image" src="http://pic4.zhimg.com/70/v2-400af7e004fd8fdad90d167288ba4aab_b.jpg" alt=""></p>
     <p>操纵箱：如下图，操纵箱位于轿厢内，用于登记乘客所需去的楼层。</p>
     <p><img class="content-image" src="http://pic1.zhimg.com/70/v2-63fb9aba44e5c28a7d136050d20e24cc_b.jpg" alt=""></p>
     <p>一台升降梯，一般情况下可以在不同模式下运行，如有司机模式（顺带补充一个冷知识，在有司机模式下开电梯是需要驾照的）、独立模式、检修模式等。</p>
     <p>题主所说的情况应该是独立模式。如果一台电梯开了独立模式，那么这台电梯就不会再响应召唤盒的指令，只会服从轿厢内操纵箱的指令，也就是说，电梯一旦进去了独立运行模式，乘客在外面召唤了电梯，哪怕电梯空载，也不会响应，乘客只能乘坐其他电梯上下楼。</p>
     <p>那么要开启或关闭这些模式，一般情况下是由专业人员打开操纵箱下面的检修盒（我在下图中圈出来的部分），拨动里面的开关进行操作的，普通乘客无法进行操作。</p>
     <p><img class="content-image" src="http://pic4.zhimg.com/70/v2-2c6db5635348363e53308b4f2b43e31b_b.jpg" alt=""></p>
     <p>而独立模式，很多厂家把独立模式的开关设置成了操纵箱上的组合键，（如题主所说的开关门键 + 楼层按键）当然，每家单位的各个电梯各个型号都是不一样的，具体操作也只有自己单位的员工才知道，原因如下。</p>
     <p>随着电梯行业不断的发展更新，出现了两点情况。</p>
     <p>1、电梯行业随整个制造业的大趋势，竞争日益激烈，所有单位都在思考一件事情：降本。（以下为我瞎写的故事）有一天，某个电梯厂商发现这个独立模式的开关按键使用频率相对较低，没必要单独当一个按键，于是想到了一个很聪明的方法，利用操纵箱上的按键，组合起来按代替一个单独的开关，久而久之，大家发现这家厂商卖的电梯由于没有这个按键总是比其他的便宜一块钱，很多客户都去买他们家的电梯了，于是大家纷纷效仿，都用组合键代替了这个开关。</p>
     <p>2、在某些特定的场合，需要快速地将电梯切换至独立模式，用组合键的开关比找出钥匙再到检修盒内去开速度快出不少，同时也显得优雅不少。那么具体场合请大家自行脑补，此处不便过多叙述，相信大家肯定能想到。</p>
     <p>所以基于以上两点，很多电梯用操纵箱的组合按键代替了独立模式的开关。当然，也有更多的电梯没有这样做，每家厂商的组合键也不一样，而且，这项功能本身也不是给乘客使用的，所以，大家还是出于科普的目的，听过就好，<strong>不要出于任何目的去尝试开启独立模式</strong>，如果打开了独立模式又关不掉要麻烦维保人员跑现场去关就是一件很麻烦的事了，而且，电梯本身就是一个公共设备，不能为了让自己快速上下楼而浪费其他乘客等待的时间。</p>
     </div>
     </div>


     <div class="view-more"><a href="http://www.zhihu.com/question/23575548">查看知乎讨论<span class="js-question-holder"></span></a></div>

     </div>


     </div>
     </div><script type=“text/javascript”>window.daily=true</script>
     * image_source : Yestone 邑石网正版图库
     * title : 「同时按下电梯关门键和楼层键就能直达楼层」是真的吗？
     * image : https://pic1.zhimg.com/v2-580b8fd45bf898445f234de166356664.jpg
     * share_url : http://daily.zhihu.com/story/9676568
     * js : []
     * ga_prefix : 040318
     * images : ["https://pic3.zhimg.com/v2-563eed826b7e12c0dd7ec5611aa9ef82.jpg"]
     * type : 0
     * id : 9676568
     * css : ["http://news-at.zhihu.com/css/news_qa.auto.css?v=4b3e3"]
     */

    private String body;
    private String image_source;
    private String title;
    private String image;
    private String share_url;
    private String ga_prefix;
    private int type;
    private int id;
    private List<String> js;
    private List<String> images;
    private List<String> css;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
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

    public List<String> getJs() {
        return js;
    }

    public void setJs(List<String> js) {
        this.js = js;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }
}
