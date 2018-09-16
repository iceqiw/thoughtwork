package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.exception.NoSuchRouteException;
import org.qiwei.thoughtwork.strategy.AbstractStrategy;
import org.qiwei.thoughtwork.strategy.TripDistanceStrategy;

import java.util.Map;

/**
 * @author qiwei
 * @description TripDistanceStrategyImpl  实现旅行路线距离计算策略接口
 * @date 2018/9/15 22:38
 */
public class TripDistanceStrategyImpl extends AbstractStrategy implements TripDistanceStrategy {

    public TripDistanceStrategyImpl(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:29 2018/9/16
     * @param stationNames
     * @return java.lang.Integer
     */

    @Override
    public Integer getDistance(String... stationNames) throws NoSuchRouteException {
        Integer distanceSum = 0;
        for (int i = 1; i < stationNames.length; i++) {
            Integer dis = this.getRouteDistance(new Route(stationNames[i - 1], stationNames[i]));
            if (null == dis) {
                throw new NoSuchRouteException();
            }
            distanceSum += dis;
        }
        return distanceSum;
    }

}
