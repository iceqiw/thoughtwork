package org.qiwei.thoughtwork.service;

/**
 * @author qiwei
 * @description TripCountByStopService
 * @date 2018/9/16 18:05
 */
public interface TripCountByStopService {
    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:25 2018/9/16
     * @param startStationName
     * @param endStationName
     * @param maxStation
     * @return java.lang.Integer
     */
    Integer showMaxStopTripsCount(String startStationName, String endStationName, Integer maxStation);

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:25 2018/9/16
     * @param startStationName
     * @param endStationName
     * @param exactlyStation
     * @return java.lang.Integer
     */
    Integer showExactlyStopTripsCount(String startStationName, String endStationName, Integer exactlyStation);

}
