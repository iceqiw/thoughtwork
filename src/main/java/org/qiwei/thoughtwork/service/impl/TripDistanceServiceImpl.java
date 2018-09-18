package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.exception.NoSuchRouteException;
import org.qiwei.thoughtwork.service.AbstractTripService;
import org.qiwei.thoughtwork.service.TripService;
import org.qiwei.thoughtwork.strategy.TripStrategy;

import java.util.Set;

/**
 * @author qiwei
 * @description SimpleDistanceRailRoadService
 * @date 2018/9/15 23:02
 */
public class TripDistanceServiceImpl extends AbstractTripService<StrategyParamsByStop> implements TripService<StrategyParamsByStop> {

    public TripDistanceServiceImpl(TripStrategy<StrategyParamsByStop> tripStrategy) {
        super(tripStrategy);
    }

    @Override
    public String doService(StrategyParamsByStop strategyParams) {
        Set<Trip> trips = tripStrategy.getTrips(strategyParams);
        for (Trip trip : trips) {
            if (trip.getPath().equals(strategyParams.getStationNames())) {
                return trip.getDistance().toString();
            }
        }
        throw new NoSuchRouteException();
    }
}
