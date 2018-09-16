package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;
import org.qiwei.thoughtwork.strategy.TripStrategyProgramming;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author qiwei
 * @description TripShortestDistanceServiceImpl
 * @date 2018/9/16 18:26
 */
public class TripShortestDistanceServiceImpl  implements TripShortestDistanceService {


    private TripStrategyProgramming<StrategyParams> tripShortestDistanceStrategy;


    public TripShortestDistanceServiceImpl(TripStrategyProgramming<StrategyParams> tripShortestDistanceStrategy) {
        this.tripShortestDistanceStrategy = tripShortestDistanceStrategy;
    }

    @Override
    public Integer showShortestTrips(String startStationName, String endStationName) {
        Set<Trip> trips = tripShortestDistanceStrategy.getAllTrips(new StrategyParams(startStationName, endStationName));
        TreeSet<Trip> minTrip = new TreeSet<>(trips);
        return minTrip.first().getDistance();
    }
}
