package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.Strategy;

import java.util.Map;

/**
 * @author qiwei
 * @description TripShortestDistanceStrategyImpl
 * @date 2018/9/16 18:27
 */
public class TripShortestDistanceStrategyImpl extends Strategy<StrategyParams> {

    public TripShortestDistanceStrategyImpl(Map<Route, Integer> railRoadMap) {
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
    protected boolean doCondition(StrategyParams strategyParams, Trip newTrip) {
        return !newTrip.getHasSameRoute();
    }


}
