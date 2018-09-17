package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.BaseStrategy;

import java.util.Map;

/**
 * 获取最短旅途策略实现
 *
 * @author qiwei
 * @description TripShortestDistanceStrategyImpl
 * @date 2018/9/16 18:27
 */
public class TripShortestDistanceStrategyImpl extends BaseStrategy<StrategyParams> {

    public TripShortestDistanceStrategyImpl(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * 最短旅途条件判断
     *
     * @param strategyParams 基础策略参数类
     * @param newTrip        新的路途
     * @return boolean 是否符合条件
     * @description
     * @author qiwei
     * @date 22:28 2018/9/16
     */
    @Override
    protected boolean doCondition(StrategyParams strategyParams, Trip newTrip) {
        return !newTrip.getHasSameRoute();
    }


}
