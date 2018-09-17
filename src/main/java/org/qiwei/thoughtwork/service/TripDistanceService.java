package org.qiwei.thoughtwork.service;

/**
 * 根据制定停靠站获取旅行距离服务
 *
 * @author qiwei
 * @description RailRoadService
 * @date 2018/9/15 21:32
 */
public interface TripDistanceService {
    /**
     * 根据制定停靠站获取旅行距离
     *
     * @param stations 停靠站
     * @return java.lang.String  路途距离
     * @description
     * @author qiwei
     * @date 22:24 2018/9/16
     */
    String showDistance(String... stations);

}
