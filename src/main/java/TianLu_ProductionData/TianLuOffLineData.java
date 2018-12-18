package TianLu_ProductionData;

import com.alibaba.fastjson.JSON;

public class TianLuOffLineData {
    public static void main(String[] args) {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String jsonData = JSON.toJSONString(DataBag.getData());
            System.out.println(jsonData);
        }

        }
}
