package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.service.AbstractTripService;
import org.qiwei.thoughtwork.service.TripService;
import org.qiwei.thoughtwork.strategy.TripStrategy;

import java.util.Set;

/**
 * @author qiwei
 * @description TripCountByStopServiceImpl
 * @date 2018/9/16 18:08
 */
public class TripCountByStopServiceImpl extends AbstractTripService<StrategyParamsByStop> implements TripService<StrategyParamsByStop> {

    public TripCountByStopServiceImpl(TripStrategy<StrategyParamsByStop> tripStrategy) {
        super(tripStrategy);
    }

    @Override
    public String doService(StrategyParamsByStop strategyParams) {
        Set<Trip> trips = tripStrategy.getTrips(strategyParams);
        Integer result = 0;
        for (Trip trip : trips) {
            if (trip.getStopStationCount().compareTo(strategyParams.getStopNum()) == 0) {
                result++;
            }
        }
        return String.valueOf(result);
    }
}
