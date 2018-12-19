package TianLu_ProductionData;

import com.cloudwise.sdg.dic.DicInitializer;
import com.cloudwise.sdg.template.TemplateAnalyzer;

import static TianLu_ProductionData.TimeFormat.nowTime;

public class DataBag {
    public static AllDataForJson getData() {
        String nowTime = nowTime();
        //数据词典生成
        try {
            DicInitializer.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        TemplateAnalyzer pointPowerd = ;
        String pointPower = new TemplateAnalyzer("TianLu", "$Dic{pointPower}").analyse();
        String electricity = new TemplateAnalyzer("TianLu", "$Dic{electricity}").analyse();
        String sample = new TemplateAnalyzer("TianLu", "$Dic{sample}").analyse();
        String detector_adr = new TemplateAnalyzer("TianLu", "$Dic{coordinate}").analyse();
        String point_adr = new TemplateAnalyzer("TianLu", "$Dic{coordinate}").analyse();
        String electrode_adr = new TemplateAnalyzer("TianLu","$Dic{coordinate}" ).analyse();
        String s_wave_velocity = new TemplateAnalyzer("TianLu","$Dic{s_wave_velocity}" ).analyse();
        String p_wave_velocity = new TemplateAnalyzer("TianLu", "$Dic{p_wave_velocity}").analyse();
        AllDataForJson dataJson = new AllDataForJson(nowTime(),
                InstrumentID.getTsp_id(),
                InstrumentID.getDetector_id(),
                InstrumentID.getShotPoint_id(),
                pointPower,
                sample,
                InstrumentID.getNum(1000,3000),
                InstrumentID.getNum(1000,5000),
                electricity,
                detector_adr,
                detector_adr,
                detector_adr,
                point_adr,
                point_adr,
                point_adr,
                electrode_adr,
                electrode_adr,
                electrode_adr,
                s_wave_velocity,
                p_wave_velocity);

        return dataJson;
    }
}
