package org.qiwei.thoughtwork.domain;

/**
 * @author qiwei
 * @description StrategyParamsByDis
 * @date 2018/9/16 18:46
 */
public class StrategyParamsByDis extends StrategyParams {

    private Integer disLimit;

    public StrategyParamsByDis(String startStationName, String endStationName) {
        super(startStationName, endStationName);
    }

    public StrategyParamsByDis(String startStationName, String endStationName, Integer disLimit) {
        super(startStationName, endStationName);
        this.disLimit = disLimit;
    }

    public Integer getDisLimit() {
        return disLimit;
    }

    public void setDisLimit(Integer disLimit) {
        this.disLimit = disLimit;
    }

    public boolean doCondition(Integer distance) {
        return distance.compareTo(disLimit) >= 0;
    }
}
