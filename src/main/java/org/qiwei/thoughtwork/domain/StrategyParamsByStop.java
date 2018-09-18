package org.qiwei.thoughtwork.domain;


/**
 * @author qiwei
 * @description StrategyParamsByStop 根据停靠站规划旅途参数
 * @date 2018/9/16 17:52
 */
public class StrategyParamsByStop extends StrategyParams {

    /**
     * 停靠站数量
     */
    private Integer stopNum;

    /**
     * 沿途车站名称
     */
    private String stationNames;


    public StrategyParamsByStop(String startStationName, String endStationName, Integer stopNum) {
        super(startStationName, endStationName);
        this.stopNum = stopNum;
    }

    public StrategyParamsByStop(String[] stationNames) {
        super(stationNames[0], stationNames[stationNames.length - 1]);
        StringBuilder stationNamesStr = new StringBuilder();
        for (String stationName : stationNames) {
            stationNamesStr.append(stationName);
        }
        this.stationNames = stationNamesStr.toString();
        this.stopNum = stationNames.length;
    }

    public Integer getStopNum() {
        return stopNum;
    }

    public void setStopNum(Integer stopNum) {
        this.stopNum = stopNum;
    }

    public String getStationNames() {
        return stationNames;
    }

    public void setStationNames(String stationNames) {
        this.stationNames = stationNames;
    }
}
