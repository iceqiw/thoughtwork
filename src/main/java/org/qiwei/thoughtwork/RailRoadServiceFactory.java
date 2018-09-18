package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.StrategyParamsByDis;
import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.service.TripService;
import org.qiwei.thoughtwork.service.impl.*;
import org.qiwei.thoughtwork.strategy.TripStrategy;
import org.qiwei.thoughtwork.strategy.impl.TripCountByMaxDistanceStrategyImpl;
import org.qiwei.thoughtwork.strategy.impl.TripCountByStopStrategyImpl;
import org.qiwei.thoughtwork.strategy.impl.TripShortestDistanceStrategyImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiwei
 * @description RailRoadServiceFactory
 * 工厂类，完成地图初始化，各种服务生成。
 * @date 2018/9/15 22:26
 */
public class RailRoadServiceFactory {


    protected Map<Route, Integer> railRoadMap;


    public RailRoadServiceFactory(Map<Route, Integer> railRoadMap) {
        this.railRoadMap = railRoadMap;
    }

    public RailRoadServiceFactory(String railRoadMapStr) {
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
     * 向地图添加路径
     *
     * @param route 路线
     * @param dis   距离
     * @return void
     * @author qiwei
     * @date 10:39 2018/9/17
     */
    public void addRoute(Route route, Integer dis) {
        railRoadMap.put(route, dis);
    }


    public TripService applyTripService(Integer type) {
        if (type == 0) {
            TripStrategy<StrategyParamsByStop> strategy = new TripStrategy<>(new TripCountByStopStrategyImpl(), this.railRoadMap);
            TripService<StrategyParamsByStop> service = new TripDistanceServiceImpl(strategy);
            return service;
        }
        if (type == 1) {
            TripStrategy<StrategyParamsByStop> strategy = new TripStrategy<>(new TripCountByStopStrategyImpl(), this.railRoadMap);
            TripService<StrategyParamsByStop> service = new TripCountByMaxStopServiceImpl(strategy);
            return service;
        }
        if (type == 2) {
            TripStrategy<StrategyParamsByStop> strategy = new TripStrategy<>(new TripCountByStopStrategyImpl(), this.railRoadMap);
            TripService<StrategyParamsByStop> service = new TripCountByStopServiceImpl(strategy);
            return service;
        }
        if (type == 3) {
            TripStrategy<StrategyParams> strategy = new TripStrategy<>(new TripShortestDistanceStrategyImpl(), this.railRoadMap);
            TripService<StrategyParams> service = new TripShortestDistanceServiceImpl(strategy);
            return service;
        }
        if (type == 4) {
            TripStrategy<StrategyParamsByDis> strategy = new TripStrategy<>(new TripCountByMaxDistanceStrategyImpl(), this.railRoadMap);
            TripService<StrategyParamsByDis> service = new TripCountByMaxDistanceServiceImpl(strategy);
            return service;
        }

        return null;
    }

}
