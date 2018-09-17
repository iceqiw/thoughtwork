package org.qiwei.thoughtwork.service;

/**
 * 根据最远距离获取路途线路信息服务
 *
 * @author qiwei
 * @description TripCountByMaxDistanceService
 * @date 2018/9/16 18:21
 */
public interface TripCountByMaxDistanceService {

    /**
     * 根据最大停靠站数量获取路线数量
     *
     * @param startStationName 起始站
     * @param endStationName   终点站
     * @param maxDistance      最远路途距离
     * @return java.lang.Integer 路线数量
     * @description
     * @author qiwei
     * @date 22:25 2018/9/16
     */
    Integer showTripsCountByMaxDistance(String startStationName, String endStationName, Integer maxDistance);
}
