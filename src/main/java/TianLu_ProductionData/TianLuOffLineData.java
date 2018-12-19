package TianLu_ProductionData;

import com.alibaba.fastjson.JSON;

/**
 * 程序入口
 */
public class TianLuOffLineData {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String jsonData = JSON.toJSONString(DataBag.getData());
            System.out.println(jsonData);
            StreamForTxt.writeToFile(jsonData);
        }
    }
}