package zzu.zhaoxuezhao.com.oneday.utils;

import java.util.Calendar;

public class DateUtil {
    static Calendar calendar = Calendar.getInstance();

    public static String getDate(int date){

        if (date== Calendar.MONTH){
            return (calendar.get(Calendar.MONTH)+1)+"";
        }else{
            return calendar.get(date)+"";
        }

    }

    public static String getWeek(){
       String today="";
        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case 1:
                today="星期日";
                break;
            case 2:
                today="星期一";
                break;
            case 3:
                today="星期二";
                break;
            case 4:
                today="星期三";
                break;
            case 5:
                today="星期五";
                break;
            case 6:
                today="星期六";
                break;
            default:
                break;
        }
        return today;

    }
}
