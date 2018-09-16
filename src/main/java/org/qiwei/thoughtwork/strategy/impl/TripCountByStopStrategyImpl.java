package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.Strategy;

import java.util.Map;

/**
 * @author qiwei
 * @description TripsCountByMaxStopsStrategy
 * @date 2018/9/16 11:22
 */
public class TripCountByStopStrategyImpl extends Strategy<StrategyParamsByStop> {

    public TripCountByStopStrategyImpl(Map<Route, Integer> railRoadMap) {
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
    protected boolean doCondition(StrategyParamsByStop strategyParams, Trip newTrip) {
        return strategyParams.getStopNum().compareTo(newTrip.getStopStationCount()) >= 0;
    }


}
