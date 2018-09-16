package org.qiwei.thoughtwork.service;

/**
 * @author qiwei
 * @description RailRoadService 旅行服务接口
 * @date 2018/9/15 21:32
 */
public interface TripDistanceService {
    /**
     * @param stations
     * @return java.lang.String
     * @description
     * @author qiwei
     * @date 22:24 2018/9/16
     */
    String showDistance(String... stations);

}
