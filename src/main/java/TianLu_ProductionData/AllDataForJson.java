package TianLu_ProductionData;

/**
 * 这里
 */

public class AllDataForJson {
    private String dSampleDate;//当前时间
    private String tsp_id;//弹性波设备ID
    private String detector_id;//检波器ID
    private String shotPoint_id;//激发炮点ID
    private String pointPower;//炮能量
    private String sample_rate;//采样率
    private int sample_num;//采样点数
    private int dielectric_constant;//介电常数
    private String electrode_current;//电极电流
    private double detector_x;//检波器x坐标
    private double detector_y;
    private double detector_z;
    private double point_x;//炮点x坐标
    private double point_y;
    private double point_z;
    private double electrode_x;//电极坐标
    private double electrode_y;
    private double electrode_z;
    private double S_wave_velocity;//s波速度
    private double P_wave_velocity;//p波速度

    public AllDataForJson(String dSampleDate, String tsp_id, String detector_id, String shotPoint_id, String pointPower, String sample_rate, int sample_num, int dielectric_constant, String electrode_current, double detector_x, double detector_y, double detector_z, double point_x, double point_y, double point_z, double electrode_x, double electrode_y, double electrode_z, double s_wave_velocity, double p_wave_velocity) {
        this.dSampleDate = dSampleDate;
        this.tsp_id = tsp_id;
        this.detector_id = detector_id;
        this.shotPoint_id = shotPoint_id;
        this.pointPower = pointPower;
        this.sample_rate = sample_rate;
        this.sample_num = sample_num;
        this.dielectric_constant = dielectric_constant;
        this.electrode_current = electrode_current;
        this.detector_x = detector_x;
        this.detector_y = detector_y;
        this.detector_z = detector_z;
        this.point_x = point_x;
        this.point_y = point_y;
        this.point_z = point_z;
        this.electrode_x = electrode_x;
        this.electrode_y = electrode_y;
        this.electrode_z = electrode_z;
        S_wave_velocity = s_wave_velocity;
        P_wave_velocity = p_wave_velocity;
    }


    public String getdSampleDate() {
        return dSampleDate;
    }

    public void setdSampleDate(String dSampleDate) {
        this.dSampleDate = dSampleDate;
    }

    public String getTsp_id() {
        return tsp_id;
    }

    public void setTsp_id(String tsp_id) {
        this.tsp_id = tsp_id;
    }

    public String getDetector_id() {
        return detector_id;
    }

    public void setDetector_id(String detector_id) {
        this.detector_id = detector_id;
    }

    public String getShotPoint_id() {
        return shotPoint_id;
    }

    public void setShotPoint_id(String shotPoint_id) {
        this.shotPoint_id = shotPoint_id;
    }

    public String getPointPower() {
        return pointPower;
    }

    public void setPointPower(String pointPower) {
        this.pointPower = pointPower;
    }

    public String getSample_rate() {
        return sample_rate;
    }

    public void setSample_rate(String sample_rate) {
        this.sample_rate = sample_rate;
    }

    public int getSample_num() {
        return sample_num;
    }

    public void setSample_num(int sample_num) {
        this.sample_num = sample_num;
    }

    public int getDielectric_constant() {
        return dielectric_constant;
    }

    public void setDielectric_constant(int dielectric_constant) {
        this.dielectric_constant = dielectric_constant;
    }

    public String getElectrode_current() {
        return electrode_current;
    }

    public void setElectrode_current(String electrode_current) {
        this.electrode_current = electrode_current;
    }

    public double getDetector_x() {
        return detector_x;
    }

    public void setDetector_x(double detector_x) {
        this.detector_x = detector_x;
    }

    public double getDetector_y() {
        return detector_y;
    }

    public void setDetector_y(double detector_y) {
        this.detector_y = detector_y;
    }

    public double getDetector_z() {
        return detector_z;
    }

    public void setDetector_z(double detector_z) {
        this.detector_z = detector_z;
    }

    public double getPoint_x() {
        return point_x;
    }

    public void setPoint_x(double point_x) {
        this.point_x = point_x;
    }

    public double getPoint_y() {
        return point_y;
    }

    public void setPoint_y(double point_y) {
        this.point_y = point_y;
    }

    public double getPoint_z() {
        return point_z;
    }

    public void setPoint_z(double point_z) {
        this.point_z = point_z;
    }

    public double getElectrode_x() {
        return electrode_x;
    }

    public void setElectrode_x(double electrode_x) {
        this.electrode_x = electrode_x;
    }

    public double getElectrode_y() {
        return electrode_y;
    }

    public void setElectrode_y(double electrode_y) {
        this.electrode_y = electrode_y;
    }

    public double getElectrode_z() {
        return electrode_z;
    }

    public void setElectrode_z(double electrode_z) {
        this.electrode_z = electrode_z;
    }

    public double getS_wave_velocity() {
        return S_wave_velocity;
    }

    public void setS_wave_velocity(double s_wave_velocity) {
        S_wave_velocity = s_wave_velocity;
    }

    public double getP_wave_velocity() {
        return P_wave_velocity;
    }

    public void setP_wave_velocity(double p_wave_velocity) {
        P_wave_velocity = p_wave_velocity;
    }

    @Override
    public String toString() {
        return "AllDataForJson{" +
                "dSampleDate='" + dSampleDate + '\'' +
                ", tsp_id='" + tsp_id + '\'' +
                ", detector_id='" + detector_id + '\'' +
                ", shotPoint_id='" + shotPoint_id + '\'' +
                ", pointPower='" + pointPower + '\'' +
                ", sample_rate='" + sample_rate + '\'' +
                ", sample_num=" + sample_num +
                ", dielectric_constant=" + dielectric_constant +
                ", electrode_current=" + electrode_current +
                ", detector_x=" + detector_x +
                ", detector_y=" + detector_y +
                ", detector_z=" + detector_z +
                ", point_x=" + point_x +
                ", point_y=" + point_y +
                ", point_z=" + point_z +
                ", electrode_x=" + electrode_x +
                ", electrode_y=" + electrode_y +
                ", electrode_z=" + electrode_z +
                ", S_wave_velocity=" + S_wave_velocity +
                ", P_wave_velocity=" + P_wave_velocity +
                '}';
    }
}
