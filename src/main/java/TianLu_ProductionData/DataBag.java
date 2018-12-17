package TianLu_ProductionData;

import com.cloudwise.sdg.dic.DicInitializer;
import com.cloudwise.sdg.template.TemplateAnalyzer;

public class DataBag {


    public static AllDataForJson getData() {
        String nowTime = TimeFormat.nowTime();
        //数据词典生成
        try {
            DicInitializer.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        TemplateAnalyzer pointPowerd = ;
        String pointPower =new TemplateAnalyzer("TianLu", "$Dic{pointPower}").analyse();
        String electricity =new TemplateAnalyzer("TianLu", "$Dic{electricity}").analyse();
        String sample =new TemplateAnalyzer("TianLu", "$Dic{sample}").analyse();
        AllDataForJson dataJson = new AllDataForJson(nowTime,
                InstrumentID.getTsp_id(),
                InstrumentID.getDetector_id(),
                InstrumentID.getShotPoint_id(),
                pointPower,
                sample,
                InstrumentID.getNum(1000,3000),
                InstrumentID.getNum(1000,5000),
                electricity,123.456,123.456,123.456,123.456,123.456,123.456,
                123.456,123.456,123.456,200,300);

        return dataJson;
    }
}
