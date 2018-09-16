package org.qiwei.thoughtwork.service.impl;

import org.qiwei.thoughtwork.exception.NoSuchRouteException;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.strategy.TripDistanceStrategy;

/**
 * @author qiwei
 * @description SimpleDistanceRailRoadService
 * @date 2018/9/15 23:02
 */
public class TripDistanceServiceImpl implements TripDistanceService {

    private TripDistanceStrategy tripDistanceStrategy;

    public TripDistanceServiceImpl(TripDistanceStrategy tripDistanceStrategy) {
        this.tripDistanceStrategy = tripDistanceStrategy;
    }

    @Override
    public String showDistance(String... stations) {
        String disStr;
        try {
            Integer dis = tripDistanceStrategy.getDistance(stations);
            disStr = dis.toString();
        } catch (NoSuchRouteException e) {
            disStr = e.getMessage();
        }
        return disStr;
    }
}
