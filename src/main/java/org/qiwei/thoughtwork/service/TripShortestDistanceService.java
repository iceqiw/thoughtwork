package org.qiwei.thoughtwork.service;

/**
 * 获取路途最短流程距离服务
 *
 * @author qiwei
 * @description TripShortestDistanceService
 * @date 2018/9/16 18:18
 */
public interface TripShortestDistanceService {

    /**
     * 获取最短流程距离
     *
     * @param startStationName 起始站
     * @param endStationName   终点站
     * @return java.lang.Integer 路途最短距离
     * @author qiwei
     * @date 22:23 2018/9/16
     */
    Integer showShortestTrips(String startStationName, String endStationName);
}
