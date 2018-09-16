package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.strategy.TripStrategyProgramming;

import java.util.Set;

/**
 * @author qiwei
 * @description TripCountByMaxDistanceServiceImpl
 * @date 2018/9/16 18:29
 */
public class TripCountByMaxDistanceServiceImpl implements TripCountByMaxDistanceService {

    private TripStrategyProgramming<StrategyParamsByDis> tripCountByMaxDistanceStrategy;

    public TripCountByMaxDistanceServiceImpl(TripStrategyProgramming<StrategyParamsByDis>  tripCountByMaxDistanceStrategy) {
        this.tripCountByMaxDistanceStrategy = tripCountByMaxDistanceStrategy;
    }

    @Override
    public Integer showTripsCountByMaxDistance(String startStationName, String endStationName, Integer maxDistance) {
        Set<Trip> trips = tripCountByMaxDistanceStrategy.getAllTrips(new StrategyParamsByDis(startStationName, endStationName, maxDistance));
        return trips.size();
    }
}
