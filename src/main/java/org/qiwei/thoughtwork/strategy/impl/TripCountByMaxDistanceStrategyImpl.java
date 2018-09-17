package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.BaseStrategy;

import java.util.Map;

/**
 * 最远距离为限制条件策略实现
 * @author qiwei
 * @description TripCountByMaxDistanceStrategyImpl
 * @date 2018/9/16 18:29
 */
public class TripCountByMaxDistanceStrategyImpl extends BaseStrategy<StrategyParamsByDis> {

    public TripCountByMaxDistanceStrategyImpl(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * 最远距离条件判断
     *
     * @param strategyParams 根据距离规划旅途策略参数
     * @param newTrip 新的路途
     * @return boolean 是否符合条件
     * @description
     * @author qiwei
     * @date 22:28 2018/9/16
     */
    @Override
    protected boolean doCondition(StrategyParamsByDis strategyParams, Trip newTrip) {
        return newTrip.getDistance().compareTo(strategyParams.getDisLimit()) < 0;
    }


}
