package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;

import java.util.Set;

/**
 * @author qiwei
 * @description ProgrammingTrip
 * @date 2018/9/16 20:06
 */
public interface TripStrategyProgramming<T extends StrategyParams> {

    Set<Trip> getAllTrips(T strategyParams);

    void programming(T strategyParams);
}
