package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.AbstractTripService;
import org.qiwei.thoughtwork.service.TripService;
import org.qiwei.thoughtwork.strategy.TripStrategy;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author qiwei
 * @description TripShortestDistanceServiceImpl
 * @date 2018/9/16 18:26
 */
public class TripShortestDistanceServiceImpl extends AbstractTripService<StrategyParams> implements TripService<StrategyParams> {


    public TripShortestDistanceServiceImpl(TripStrategy<StrategyParams> tripStrategy) {
        super(tripStrategy);
    }

    @Override
    public String doService(StrategyParams strategyParams) {
        Set<Trip> trips = tripStrategy.getTrips(strategyParams);
        /**
         * 排序
         */
        TreeSet<Trip> minTrip = new TreeSet<>(trips);
        return String.valueOf(minTrip.first().getDistance());
    }
}
