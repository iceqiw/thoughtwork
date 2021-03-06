package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.AbstractTripService;
import org.qiwei.thoughtwork.service.TripService;
import org.qiwei.thoughtwork.strategy.TripStrategy;

import java.util.Set;

/**
 * @author qiwei
 * @description TripCountByMaxDistanceServiceImpl
 * @date 2018/9/16 18:29
 */
public class TripCountByMaxDistanceServiceImpl extends AbstractTripService<StrategyParamsByDis> implements TripService<StrategyParamsByDis> {


    public TripCountByMaxDistanceServiceImpl(TripStrategy<StrategyParamsByDis> tripStrategy) {
        super(tripStrategy);
    }

    @Override
    public String doService(StrategyParamsByDis strategyParams) {
        Set<Trip> trips = tripStrategy.getTrips(strategyParams);
        return String.valueOf(trips.size());
    }

    
}
