package TianLu_ProductionData;

import com.alibaba.fastjson.JSON;

public class TianLuOffLineData {
    public static void main(String[] args) {
        String jsonData = JSON.toJSONString(DataBag.getData());
        System.out.println(jsonData);
        }
        }
