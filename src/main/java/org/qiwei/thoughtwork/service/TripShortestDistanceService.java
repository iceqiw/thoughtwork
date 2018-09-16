package org.qiwei.thoughtwork.service;

/**
 * @author qiwei
 * @description TripShortestDistanceService
 * @date 2018/9/16 18:18
 */
public interface TripShortestDistanceService {

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:23 2018/9/16
     * @param startStationName
     * @param endStationName
     * @return java.lang.Integer
     */
    Integer showShortestTrips(String startStationName, String endStationName);
}
