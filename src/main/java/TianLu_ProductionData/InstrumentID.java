package TianLu_ProductionData;

/**
 * 这里是设备ID工具
 *
 */

public class InstrumentID {
    //设置起止随机数
    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
    //弹性波设备ID   tsp_id
    public static String getTsp_id(){
        String Tsp_id = "tsp-"+String.valueOf(getNum(1, 20)).substring(1);
        return Tsp_id;
    }
    //检波器ID
    public static String getDetector_id(){
        String detector_id = "det-"+String.valueOf(getNum(1, 2000)).substring(1);
        return detector_id;
    }
    //激发炮点ID       shotPoint_id
    public static String getShotPoint_id(){
        String shotPoint_id = "det-"+String.valueOf(getNum(1, 1000)).substring(1);
        return shotPoint_id;
    }
    //高频接收天线ID   receiving_antenna_id
    public static String getReceiving_antenna_id(){
        String receiving_antenna_id = "ant-"+String.valueOf(getNum(1, 1000)).substring(1);
        return receiving_antenna_id;
    }
    //电极ID    electrode_id
    public static String getElectrode_id(){
        String getElectrode_id = "ele-"+String.valueOf(getNum(1, 1000)).substring(1);
        return getElectrode_id;
    }
    //应力传感器ID   Stress_id
    public static String getStress_id(){
        String getStress_id = "stre-"+String.valueOf(getNum(1, 1000)).substring(1);
        return getStress_id;
    }



}
