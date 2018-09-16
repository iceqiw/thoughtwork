package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.strategy.TripStrategyProgramming;

import java.util.Set;

/**
 * @author qiwei
 * @description TripCountByStopServiceImpl
 * @date 2018/9/16 18:08
 */
public class TripCountByStopServiceImpl implements TripCountByStopService {

    private TripStrategyProgramming<StrategyParamsByStop>  tripCountByStopStrategy;

    public TripCountByStopServiceImpl(TripStrategyProgramming<StrategyParamsByStop>  tripCountByStopStrategy) {
        this.tripCountByStopStrategy = tripCountByStopStrategy;
    }

    @Override
    public Integer showMaxStopTripsCount(String startStationName, String endStationName, Integer maxStation) {
        Set<Trip> trips = tripCountByStopStrategy.getAllTrips(new StrategyParamsByStop(startStationName, endStationName, maxStation));
        return trips.size();
    }

    @Override
    public Integer showExactlyStopTripsCount(String startStationName, String endStationName, Integer exactlyStation) {
        Set<Trip> trips = tripCountByStopStrategy.getAllTrips(new StrategyParamsByStop(startStationName, endStationName, exactlyStation));
        Integer result = 0;
        for (Trip trip : trips) {
            if (trip.getStopStationCount().compareTo(exactlyStation) == 0) {
                result++;
            }
        }
        return result;
    }


}
