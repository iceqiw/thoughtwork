package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiwei
 * @description RailRoadServiceFactory
 * @date 2018/9/15 22:13
 */
public abstract class AbstractRailRoadServiceFactory {

    protected Map<Route, Integer> railRoadMap;


    public AbstractRailRoadServiceFactory(Map<Route, Integer> railRoadMap) {
        this.railRoadMap = railRoadMap;
    }

    public AbstractRailRoadServiceFactory(String railRoadMapStr) {
        Map<Route, Integer> railRoadMap = new HashMap<>();
        String splitChar = ",";
        String[] items = railRoadMapStr.split(splitChar);
        for (String item : items) {
            String startStationName = Character.toString(item.charAt(0));
            String endStationName = Character.toString(item.charAt(1));
            Integer distance = Integer.parseInt(Character.toString(item.charAt(2)));
            railRoadMap.put(new Route(startStationName, endStationName, distance), distance);
        }
        this.railRoadMap = railRoadMap;
    }


    /**
     * 获取旅途停靠站服务
     *
     * @param
     * @return org.qiwei.thoughtwork.service.TripCountByStopService
     * @description 获取旅途停靠站服务
     * @author qiwei
     * @date 10:34 2018/9/17
     */
    public abstract TripCountByStopService applyTripCountByStopService();

    /**
     * 获取旅途距离计算服务
     *
     * @param
     * @return org.qiwei.thoughtwork.service.TripDistanceService
     * @description 获取旅途距离计算服务
     * @author qiwei
     * @date 17:43 2018/9/16
     */
    public abstract TripDistanceService applyTripDistanceService();

    /**
     * 获取最短路径服务
     *
     * @param
     * @return org.qiwei.thoughtwork.service.TripShortestDistanceService
     * @description 获取最短路径服务
     * @author qiwei
     * @date 18:24 2018/9/16
     */
    public abstract TripShortestDistanceService applyTripShortestDistance();

    /**
     * 获取最大距离现在旅途数量
     *
     * @param
     * @return org.qiwei.thoughtwork.service.TripCountByMaxDistanceService
     * @description 获取最大距离现在旅途数量
     * @author qiwei
     * @date 18:25 2018/9/16
     */
    public abstract TripCountByMaxDistanceService applyTripCountByMaxDistanceService();

    /**
     *
     * 向地图添加路径
     * @author qiwei
     * @date 10:39 2018/9/17
     * @param route 路线
     * @param dis 距离
     * @return void
     */
    public void addRoute(Route route, Integer dis) {
        railRoadMap.put(route, dis);
    }


}
