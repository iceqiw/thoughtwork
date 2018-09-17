package org.qiwei.thoughtwork.domain;

/**
 * @author qiwei
 * @description StrategyParamsByDis 根据距离规划旅途策略参数
 * @date 2018/9/16 18:46
 */
public class StrategyParamsByDis extends StrategyParams {

    /**
     * 距离限制
     */
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

}
