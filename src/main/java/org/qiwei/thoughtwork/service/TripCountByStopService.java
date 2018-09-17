package org.qiwei.thoughtwork.service;

/**
 * 根据停靠站获取获取路线信息服务
 *
 * @author qiwei
 * @description TripCountByStopService
 * @date 2018/9/16 18:05
 */
public interface TripCountByStopService {
    /**
     * 根据最大停靠站数量获取路线数量
     *
     * @param startStationName 起始站
     * @param endStationName   终点站
     * @param maxStation       最大停靠站数量
     * @return java.lang.Integer 路线数量
     * @description
     * @author qiwei
     * @date 22:25 2018/9/16
     */
    Integer showMaxStopTripsCount(String startStationName, String endStationName, Integer maxStation);

    /**
     * 根据准确停靠站数量获取路线数量
     *
     * @param startStationName 起始站
     * @param endStationName   终点站
     * @param exactlyStation   准确停靠站数量
     * @return java.lang.Integer 路线数量
     * @description
     * @author qiwei
     * @date 22:25 2018/9/16
     */
    Integer showExactlyStopTripsCount(String startStationName, String endStationName, Integer exactlyStation);

}
