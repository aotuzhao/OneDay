package zzu.zhaoxuezhao.com.oneday.bean.constellation;

public class Constellation {


    /**
     * showapi_res_error :
     * showapi_res_code : 0
     * showapi_res_body : {"ret_code":0,"tomorrow":{"love_txt":"感情超级丰富的一天，很容易受感动！单身者稍微有异性对你好一点你就被电到啰！","work_txt":"作上有好消息降临，让你兴奋不已。正是发挥才能的时期，好好把握机会吧！","work_star":4,"money_star":3,"lucky_color":"宝石蓝","lucky_time":"上午11:00--12:00","lucky_direction":"西北方","love_star":5,"summary_star":4,"time":"20180507","money_txt":"花钱应量入为出。","general_txt":"大小桃花纷至沓来，让你有些应接不暇，可不要挑花眼哦！朋友们的投资日见成效，看得你相当眼红，投资热情不断高涨；浅尝辄止的学习作风今天会让你的收获同样微薄，转变想法才有望实现突破。","grxz":"双鱼座","lucky_num":"7","day_notice":"虚心学习朋友们的投资心得。"},"star":"shizi","day":{"love_txt":"夫妻之间应增进彼此的互动，以免感情变淡；单身者容易表错情会错意，理性一些才好。","work_txt":"处理事情单独作业会比较困难，倘若能与他人协调合作，则可顺利并超额完成。","work_star":3,"money_star":4,"lucky_color":"酸橙绿","lucky_time":"下午3:00--5:00","lucky_direction":"正南方","love_star":3,"summary_star":3,"time":"20180506","money_txt":"财运佳，有人施援手，在资金方面为你提供便利。","general_txt":"与恋人分隔两地的你对于两人的恋情产生了一些情绪上的波动，多与他联系沟通，多给自己也给他一些坚持的信念；朋友提供的一些情报对你的投资会有很大的帮助；与朋友的聚会中容易多喝，但要注意切莫发酒疯，不然影响友情。","grxz":"天秤座","lucky_num":"3","day_notice":"朋友也是一笔珍贵的财富。"},"week":{"love_txt":"爱情秘笈：别因一件小别扭的事纠缠太久。","health_txt":"身体抵抗力低下，出入公众场应采取防护措施、注意个人卫生，预防流感病毒。","work_txt":"焦躁不安，为学习、工作烦心。事务繁琐而杂乱，难以理清头绪，还得不到上司、同事的理解。情绪的失控，也让学习、工作失误倍增，急需贴心心安慰。","lucky_day":"星期二","work_star":3,"week_notice":"摆正心态，迎难而上。","money_star":2,"lucky_color":"羊毛白","lucky_direction":"西南方","love_star":2,"summary_star":2,"time":"20180507-20180513","money_txt":"手头拮据，需要把紧钱关。想要把有限的库存分配好，这周一开始可以先做好预算，购物前先列清单，勾选必买的物件，对收支记账，明确财务现状。","general_txt":"本周你会面临一些选择难题，并且一旦面对这些选择性的问题你就会感到有障碍，而且很容易做出选择。当自己拿不定主意时，让他人帮你做选择会更为妥当。","grxz":"天秤座","xrxz":"金牛座","lucky_num":"7"}}
     */

    private String showapi_res_error;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * ret_code : 0
         * tomorrow : {"love_txt":"感情超级丰富的一天，很容易受感动！单身者稍微有异性对你好一点你就被电到啰！","work_txt":"作上有好消息降临，让你兴奋不已。正是发挥才能的时期，好好把握机会吧！","work_star":4,"money_star":3,"lucky_color":"宝石蓝","lucky_time":"上午11:00--12:00","lucky_direction":"西北方","love_star":5,"summary_star":4,"time":"20180507","money_txt":"花钱应量入为出。","general_txt":"大小桃花纷至沓来，让你有些应接不暇，可不要挑花眼哦！朋友们的投资日见成效，看得你相当眼红，投资热情不断高涨；浅尝辄止的学习作风今天会让你的收获同样微薄，转变想法才有望实现突破。","grxz":"双鱼座","lucky_num":"7","day_notice":"虚心学习朋友们的投资心得。"}
         * star : shizi
         * day : {"love_txt":"夫妻之间应增进彼此的互动，以免感情变淡；单身者容易表错情会错意，理性一些才好。","work_txt":"处理事情单独作业会比较困难，倘若能与他人协调合作，则可顺利并超额完成。","work_star":3,"money_star":4,"lucky_color":"酸橙绿","lucky_time":"下午3:00--5:00","lucky_direction":"正南方","love_star":3,"summary_star":3,"time":"20180506","money_txt":"财运佳，有人施援手，在资金方面为你提供便利。","general_txt":"与恋人分隔两地的你对于两人的恋情产生了一些情绪上的波动，多与他联系沟通，多给自己也给他一些坚持的信念；朋友提供的一些情报对你的投资会有很大的帮助；与朋友的聚会中容易多喝，但要注意切莫发酒疯，不然影响友情。","grxz":"天秤座","lucky_num":"3","day_notice":"朋友也是一笔珍贵的财富。"}
         * week : {"love_txt":"爱情秘笈：别因一件小别扭的事纠缠太久。","health_txt":"身体抵抗力低下，出入公众场应采取防护措施、注意个人卫生，预防流感病毒。","work_txt":"焦躁不安，为学习、工作烦心。事务繁琐而杂乱，难以理清头绪，还得不到上司、同事的理解。情绪的失控，也让学习、工作失误倍增，急需贴心心安慰。","lucky_day":"星期二","work_star":3,"week_notice":"摆正心态，迎难而上。","money_star":2,"lucky_color":"羊毛白","lucky_direction":"西南方","love_star":2,"summary_star":2,"time":"20180507-20180513","money_txt":"手头拮据，需要把紧钱关。想要把有限的库存分配好，这周一开始可以先做好预算，购物前先列清单，勾选必买的物件，对收支记账，明确财务现状。","general_txt":"本周你会面临一些选择难题，并且一旦面对这些选择性的问题你就会感到有障碍，而且很容易做出选择。当自己拿不定主意时，让他人帮你做选择会更为妥当。","grxz":"天秤座","xrxz":"金牛座","lucky_num":"7"}
         */

        private int ret_code;
        private TomorrowBean tomorrow;
        private String star;
        private DayBean day;
        private WeekBean week;

        public int getRet_code() {
            return ret_code;
        }

        public void setRet_code(int ret_code) {
            this.ret_code = ret_code;
        }

        public TomorrowBean getTomorrow() {
            return tomorrow;
        }

        public void setTomorrow(TomorrowBean tomorrow) {
            this.tomorrow = tomorrow;
        }

        public String getStar() {
            return star;
        }

        public void setStar(String star) {
            this.star = star;
        }

        public DayBean getDay() {
            return day;
        }

        public void setDay(DayBean day) {
            this.day = day;
        }

        public WeekBean getWeek() {
            return week;
        }

        public void setWeek(WeekBean week) {
            this.week = week;
        }

        public static class TomorrowBean {
            /**
             * love_txt : 感情超级丰富的一天，很容易受感动！单身者稍微有异性对你好一点你就被电到啰！
             * work_txt : 作上有好消息降临，让你兴奋不已。正是发挥才能的时期，好好把握机会吧！
             * work_star : 4
             * money_star : 3
             * lucky_color : 宝石蓝
             * lucky_time : 上午11:00--12:00
             * lucky_direction : 西北方
             * love_star : 5
             * summary_star : 4
             * time : 20180507
             * money_txt : 花钱应量入为出。
             * general_txt : 大小桃花纷至沓来，让你有些应接不暇，可不要挑花眼哦！朋友们的投资日见成效，看得你相当眼红，投资热情不断高涨；浅尝辄止的学习作风今天会让你的收获同样微薄，转变想法才有望实现突破。
             * grxz : 双鱼座
             * lucky_num : 7
             * day_notice : 虚心学习朋友们的投资心得。
             */

            private String love_txt;
            private String work_txt;
            private int work_star;
            private int money_star;
            private String lucky_color;
            private String lucky_time;
            private String lucky_direction;
            private int love_star;
            private int summary_star;
            private String time;
            private String money_txt;
            private String general_txt;
            private String grxz;
            private String lucky_num;
            private String day_notice;

            public String getLove_txt() {
                return love_txt;
            }

            public void setLove_txt(String love_txt) {
                this.love_txt = love_txt;
            }

            public String getWork_txt() {
                return work_txt;
            }

            public void setWork_txt(String work_txt) {
                this.work_txt = work_txt;
            }

            public int getWork_star() {
                return work_star;
            }

            public void setWork_star(int work_star) {
                this.work_star = work_star;
            }

            public int getMoney_star() {
                return money_star;
            }

            public void setMoney_star(int money_star) {
                this.money_star = money_star;
            }

            public String getLucky_color() {
                return lucky_color;
            }

            public void setLucky_color(String lucky_color) {
                this.lucky_color = lucky_color;
            }

            public String getLucky_time() {
                return lucky_time;
            }

            public void setLucky_time(String lucky_time) {
                this.lucky_time = lucky_time;
            }

            public String getLucky_direction() {
                return lucky_direction;
            }

            public void setLucky_direction(String lucky_direction) {
                this.lucky_direction = lucky_direction;
            }

            public int getLove_star() {
                return love_star;
            }

            public void setLove_star(int love_star) {
                this.love_star = love_star;
            }

            public int getSummary_star() {
                return summary_star;
            }

            public void setSummary_star(int summary_star) {
                this.summary_star = summary_star;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getMoney_txt() {
                return money_txt;
            }

            public void setMoney_txt(String money_txt) {
                this.money_txt = money_txt;
            }

            public String getGeneral_txt() {
                return general_txt;
            }

            public void setGeneral_txt(String general_txt) {
                this.general_txt = general_txt;
            }

            public String getGrxz() {
                return grxz;
            }

            public void setGrxz(String grxz) {
                this.grxz = grxz;
            }

            public String getLucky_num() {
                return lucky_num;
            }

            public void setLucky_num(String lucky_num) {
                this.lucky_num = lucky_num;
            }

            public String getDay_notice() {
                return day_notice;
            }

            public void setDay_notice(String day_notice) {
                this.day_notice = day_notice;
            }
        }

        public static class DayBean {
            /**
             * love_txt : 夫妻之间应增进彼此的互动，以免感情变淡；单身者容易表错情会错意，理性一些才好。
             * work_txt : 处理事情单独作业会比较困难，倘若能与他人协调合作，则可顺利并超额完成。
             * work_star : 3
             * money_star : 4
             * lucky_color : 酸橙绿
             * lucky_time : 下午3:00--5:00
             * lucky_direction : 正南方
             * love_star : 3
             * summary_star : 3
             * time : 20180506
             * money_txt : 财运佳，有人施援手，在资金方面为你提供便利。
             * general_txt : 与恋人分隔两地的你对于两人的恋情产生了一些情绪上的波动，多与他联系沟通，多给自己也给他一些坚持的信念；朋友提供的一些情报对你的投资会有很大的帮助；与朋友的聚会中容易多喝，但要注意切莫发酒疯，不然影响友情。
             * grxz : 天秤座
             * lucky_num : 3
             * day_notice : 朋友也是一笔珍贵的财富。
             */

            private String love_txt;
            private String work_txt;
            private int work_star;
            private int money_star;
            private String lucky_color;
            private String lucky_time;
            private String lucky_direction;
            private int love_star;
            private int summary_star;
            private String time;
            private String money_txt;
            private String general_txt;
            private String grxz;
            private String lucky_num;
            private String day_notice;

            public String getLove_txt() {
                return love_txt;
            }

            public void setLove_txt(String love_txt) {
                this.love_txt = love_txt;
            }

            public String getWork_txt() {
                return work_txt;
            }

            public void setWork_txt(String work_txt) {
                this.work_txt = work_txt;
            }

            public int getWork_star() {
                return work_star;
            }

            public void setWork_star(int work_star) {
                this.work_star = work_star;
            }

            public int getMoney_star() {
                return money_star;
            }

            public void setMoney_star(int money_star) {
                this.money_star = money_star;
            }

            public String getLucky_color() {
                return lucky_color;
            }

            public void setLucky_color(String lucky_color) {
                this.lucky_color = lucky_color;
            }

            public String getLucky_time() {
                return lucky_time;
            }

            public void setLucky_time(String lucky_time) {
                this.lucky_time = lucky_time;
            }

            public String getLucky_direction() {
                return lucky_direction;
            }

            public void setLucky_direction(String lucky_direction) {
                this.lucky_direction = lucky_direction;
            }

            public int getLove_star() {
                return love_star;
            }

            public void setLove_star(int love_star) {
                this.love_star = love_star;
            }

            public int getSummary_star() {
                return summary_star;
            }

            public void setSummary_star(int summary_star) {
                this.summary_star = summary_star;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getMoney_txt() {
                return money_txt;
            }

            public void setMoney_txt(String money_txt) {
                this.money_txt = money_txt;
            }

            public String getGeneral_txt() {
                return general_txt;
            }

            public void setGeneral_txt(String general_txt) {
                this.general_txt = general_txt;
            }

            public String getGrxz() {
                return grxz;
            }

            public void setGrxz(String grxz) {
                this.grxz = grxz;
            }

            public String getLucky_num() {
                return lucky_num;
            }

            public void setLucky_num(String lucky_num) {
                this.lucky_num = lucky_num;
            }

            public String getDay_notice() {
                return day_notice;
            }

            public void setDay_notice(String day_notice) {
                this.day_notice = day_notice;
            }
        }

        public static class WeekBean {
            /**
             * love_txt : 爱情秘笈：别因一件小别扭的事纠缠太久。
             * health_txt : 身体抵抗力低下，出入公众场应采取防护措施、注意个人卫生，预防流感病毒。
             * work_txt : 焦躁不安，为学习、工作烦心。事务繁琐而杂乱，难以理清头绪，还得不到上司、同事的理解。情绪的失控，也让学习、工作失误倍增，急需贴心心安慰。
             * lucky_day : 星期二
             * work_star : 3
             * week_notice : 摆正心态，迎难而上。
             * money_star : 2
             * lucky_color : 羊毛白
             * lucky_direction : 西南方
             * love_star : 2
             * summary_star : 2
             * time : 20180507-20180513
             * money_txt : 手头拮据，需要把紧钱关。想要把有限的库存分配好，这周一开始可以先做好预算，购物前先列清单，勾选必买的物件，对收支记账，明确财务现状。
             * general_txt : 本周你会面临一些选择难题，并且一旦面对这些选择性的问题你就会感到有障碍，而且很容易做出选择。当自己拿不定主意时，让他人帮你做选择会更为妥当。
             * grxz : 天秤座
             * xrxz : 金牛座
             * lucky_num : 7
             */

            private String love_txt;
            private String health_txt;
            private String work_txt;
            private String lucky_day;
            private int work_star;
            private String week_notice;
            private int money_star;
            private String lucky_color;
            private String lucky_direction;
            private int love_star;
            private int summary_star;
            private String time;
            private String money_txt;
            private String general_txt;
            private String grxz;
            private String xrxz;
            private String lucky_num;

            public String getLove_txt() {
                return love_txt;
            }

            public void setLove_txt(String love_txt) {
                this.love_txt = love_txt;
            }

            public String getHealth_txt() {
                return health_txt;
            }

            public void setHealth_txt(String health_txt) {
                this.health_txt = health_txt;
            }

            public String getWork_txt() {
                return work_txt;
            }

            public void setWork_txt(String work_txt) {
                this.work_txt = work_txt;
            }

            public String getLucky_day() {
                return lucky_day;
            }

            public void setLucky_day(String lucky_day) {
                this.lucky_day = lucky_day;
            }

            public int getWork_star() {
                return work_star;
            }

            public void setWork_star(int work_star) {
                this.work_star = work_star;
            }

            public String getWeek_notice() {
                return week_notice;
            }

            public void setWeek_notice(String week_notice) {
                this.week_notice = week_notice;
            }

            public int getMoney_star() {
                return money_star;
            }

            public void setMoney_star(int money_star) {
                this.money_star = money_star;
            }

            public String getLucky_color() {
                return lucky_color;
            }

            public void setLucky_color(String lucky_color) {
                this.lucky_color = lucky_color;
            }

            public String getLucky_direction() {
                return lucky_direction;
            }

            public void setLucky_direction(String lucky_direction) {
                this.lucky_direction = lucky_direction;
            }

            public int getLove_star() {
                return love_star;
            }

            public void setLove_star(int love_star) {
                this.love_star = love_star;
            }

            public int getSummary_star() {
                return summary_star;
            }

            public void setSummary_star(int summary_star) {
                this.summary_star = summary_star;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getMoney_txt() {
                return money_txt;
            }

            public void setMoney_txt(String money_txt) {
                this.money_txt = money_txt;
            }

            public String getGeneral_txt() {
                return general_txt;
            }

            public void setGeneral_txt(String general_txt) {
                this.general_txt = general_txt;
            }

            public String getGrxz() {
                return grxz;
            }

            public void setGrxz(String grxz) {
                this.grxz = grxz;
            }

            public String getXrxz() {
                return xrxz;
            }

            public void setXrxz(String xrxz) {
                this.xrxz = xrxz;
            }

            public String getLucky_num() {
                return lucky_num;
            }

            public void setLucky_num(String lucky_num) {
                this.lucky_num = lucky_num;
            }
        }
    }
}
