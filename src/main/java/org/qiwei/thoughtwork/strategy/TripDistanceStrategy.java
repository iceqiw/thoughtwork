package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.exception.NoSuchRouteException;

/**
 *
 * 根据站点计算旅行距离策略
 *
 * @author qiwei
 * @description TripDistanceStrategy
 * @date 2018/9/15 20:41
 */
public interface TripDistanceStrategy {


    /**
     * 根据站点计算旅行距离
     *
     * @param stationNames 沿途站点
     * @return java.lang.Integer 旅途距离
     * @throws NoSuchRouteException 未找到路线异常
     * @description 根据站点继续旅行距离
     * @author qiwei
     * @date 22:29 2018/9/16
     */
    Integer getDistance(String... stationNames) throws NoSuchRouteException;
}
