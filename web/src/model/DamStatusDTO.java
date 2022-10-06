package src.model;

public class DamStatusDTO {
    public DamStatusDTO() {

    }

    public void setS_time(String s_time) {
        S_time = s_time;
    }

    public void setS_lowLevelWater(String s_lowLevelWater) {
        S_lowLevelWater = s_lowLevelWater;
    }

    public void setS_waterStorage(String s_waterStorage) {
        S_waterStorage = s_waterStorage;
    }

    public void setS_POW(String s_POW) {
        S_POW = s_POW;
    }

    public void setS_rainfall(String s_rainfall) {
        S_rainfall = s_rainfall;
    }

    public void setS_inflow(String s_inflow) {
        S_inflow = s_inflow;
    }

    public void setS_tOutflow(String s_tOutflow) {
        S_tOutflow = s_tOutflow;
    }

    private String S_time;
    private String S_lowLevelWater;
    private String S_waterStorage;
    private String S_POW;
    private String S_rainfall;
    private String S_inflow;
    private String S_tOutflow;


    private String S_ESR;

    public DamStatusDTO(String s_time, String s_lowLevelWater, String s_waterStorage, String s_POW, String s_rainfall, String s_inflow, String s_tOutflow, String s_ESR) {
        S_time = s_time;
        S_lowLevelWater = s_lowLevelWater;
        S_waterStorage = s_waterStorage;
        S_POW = s_POW;
        S_rainfall = s_rainfall;
        S_inflow = s_inflow;
        S_tOutflow = s_tOutflow;
        S_ESR = s_ESR;
    }


    public String getS_time() {
        return S_time;
    }

    public String getS_lowLevelWater() {
        return S_lowLevelWater;
    }

    public String getS_waterStorage() {
        return S_waterStorage;
    }

    public String getS_POW() {
        return S_POW;
    }

    public String getS_rainfall() {
        return S_rainfall;
    }

    public String getS_inflow() {
        return S_inflow;
    }

    public String getS_tOutflow() {
        return S_tOutflow;
    }

    public String getS_ESR() {
        return S_ESR;
    }

    public void setS_ESR(String s_ESR) {
        S_ESR = s_ESR;
    }
}
