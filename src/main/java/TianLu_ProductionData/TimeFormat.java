package TianLu_ProductionData;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 这里是时间工具
 */

public class TimeFormat {
    //实时获取当前时间,并转为时间格式
    public static String nowTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = sdf.format(date);
        return nowTime;
    }
    //获取当前的时间戳
    public static long current(){
        long current = System.currentTimeMillis();
        return current;
    }
}
