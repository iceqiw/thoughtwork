package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.exception.NoSuchRouteException;

/**
 * @author qiwei
 * @description TripDistanceStrategy 旅行路线距离计算策略接口
 * @date 2018/9/15 20:41
 */
public interface TripDistanceStrategy {
    /**
     * @param stationNames 沿途车站名称
     * @return
     * @description 获取旅行路线距离
     * @author qiwei
     * @date 17:41 2018/9/16
     */
    Integer getDistance(String... stationNames) throws NoSuchRouteException;
}
