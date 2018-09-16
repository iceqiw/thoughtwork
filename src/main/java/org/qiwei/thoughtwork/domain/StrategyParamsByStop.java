package org.qiwei.thoughtwork.domain;


/**
 * @author qiwei
 * @description StrategyParams
 * @date 2018/9/16 17:52
 */
public class StrategyParamsByStop extends StrategyParams {

    private Integer stopNum;

    public StrategyParamsByStop(String startStationName, String endStationName) {
        super(startStationName, endStationName);
    }

    public StrategyParamsByStop(String startStationName, String endStationName, Integer stopNum) {
        super(startStationName, endStationName);
        this.stopNum = stopNum;
    }

    public Integer getStopNum() {
        return stopNum;
    }

    public void setStopNum(Integer stopNum) {
        this.stopNum = stopNum;
    }

    public boolean doCondition(Integer stops) {
        return stops.compareTo(stopNum) <= 0;
    }
}
