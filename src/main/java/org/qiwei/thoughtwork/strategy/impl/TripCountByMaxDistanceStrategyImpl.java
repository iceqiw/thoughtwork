package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.Strategy;

import java.util.List;
import java.util.Map;

/**
 * @author qiwei
 * @description TripCountByMaxDistanceStrategyImpl
 * @date 2018/9/16 18:29
 */
public class TripCountByMaxDistanceStrategyImpl extends Strategy<StrategyParamsByDis> {

    public TripCountByMaxDistanceStrategyImpl(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:28 2018/9/16
     * @param strategyParams
     * @param newTrip
     * @return boolean
     */
    @Override
    protected boolean doCondition(StrategyParamsByDis strategyParams, Trip newTrip) {
        return newTrip.getDistance().compareTo(strategyParams.getDisLimit())<0;
    }


}
