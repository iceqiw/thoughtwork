package org.qiwei.thoughtwork.service;

/**
 * @author qiwei
 * @description TripCountByMaxDistanceService
 * @date 2018/9/16 18:21
 */
public interface TripCountByMaxDistanceService {

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:25 2018/9/16
     * @param startStationName
     * @param endStationName
     * @param maxDistance
     * @return java.lang.Integer
     */
    Integer showTripsCountByMaxDistance(String startStationName, String endStationName, Integer maxDistance);
}
