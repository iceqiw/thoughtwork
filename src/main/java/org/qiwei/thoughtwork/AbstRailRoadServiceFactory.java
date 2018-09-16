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
public abstract class AbstRailRoadServiceFactory {

    protected Map<Route, Integer> railRoadMap;


    public AbstRailRoadServiceFactory(Map<Route, Integer> railRoadMap) {
        this.railRoadMap = railRoadMap;
    }

    public AbstRailRoadServiceFactory(String railRoadMapStr) {
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

    public abstract TripCountByStopService applyTripCountByStopService();

    public abstract TripDistanceService applyTripDistanceService();

    public abstract TripShortestDistanceService applyTripShortestDistance();

    public abstract TripCountByMaxDistanceService applyTripCountByMaxDistanceService();

    public void addRoute(Route route, Integer dis) {
        railRoadMap.put(route, dis);
    }


}
