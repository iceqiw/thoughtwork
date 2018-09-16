package org.qiwei.thoughtwork;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.service.TripCountByMaxDistanceService;
import org.qiwei.thoughtwork.service.TripCountByStopService;
import org.qiwei.thoughtwork.service.TripDistanceService;
import org.qiwei.thoughtwork.service.TripShortestDistanceService;
import org.qiwei.thoughtwork.service.impl.TripCountByMaxDistanceServiceImpl;
import org.qiwei.thoughtwork.service.impl.TripCountByStopServiceImpl;
import org.qiwei.thoughtwork.service.impl.TripDistanceServiceImpl;
import org.qiwei.thoughtwork.service.impl.TripShortestDistanceServiceImpl;
import org.qiwei.thoughtwork.strategy.TripDistanceStrategy;
import org.qiwei.thoughtwork.strategy.TripStrategyProgramming;
import org.qiwei.thoughtwork.strategy.impl.TripCountByMaxDistanceStrategyImpl;
import org.qiwei.thoughtwork.strategy.impl.TripCountByStopStrategyImpl;
import org.qiwei.thoughtwork.strategy.impl.TripDistanceStrategyImpl;
import org.qiwei.thoughtwork.strategy.impl.TripShortestDistanceStrategyImpl;

import java.util.Map;

/**
 * @author qiwei
 * @description RailRoadServiceFactory
 * @date 2018/9/15 22:26
 */
public class RailRoadServiceFactory extends AbstRailRoadServiceFactory {


    public RailRoadServiceFactory(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    public RailRoadServiceFactory(String railRoadMapStr) {
        super(railRoadMapStr);
    }

    public Map<Route, Integer> parseRoad(String road) {

        return railRoadMap;
    }

    /**
     * @param
     * @return org.qiwei.thoughtwork.service.TripDistanceService
     * @description 获取旅途停靠站服务
     * @author qiwei
     * @date 17:43 2018/9/16
     */
    @Override
    public TripCountByStopService applyTripCountByStopService() {
        TripStrategyProgramming strategy = new TripCountByStopStrategyImpl(this.railRoadMap);
        return new TripCountByStopServiceImpl(strategy);
    }

    /**
     * @param
     * @return org.qiwei.thoughtwork.service.TripDistanceService
     * @description 获取旅途距离计算服务
     * @author qiwei
     * @date 17:43 2018/9/16
     */
    @Override
    public TripDistanceService applyTripDistanceService() {
        TripDistanceStrategy strategy = new TripDistanceStrategyImpl(this.railRoadMap);
        return new TripDistanceServiceImpl(strategy);
    }

    /**
     * @param
     * @return org.qiwei.thoughtwork.service.TripShortestDistanceService
     * @description 获取最短路径服务
     * @author qiwei
     * @date 18:24 2018/9/16
     */
    @Override
    public TripShortestDistanceService applyTripShortestDistance() {
        TripStrategyProgramming strategy = new TripShortestDistanceStrategyImpl(this.railRoadMap);
        return new TripShortestDistanceServiceImpl(strategy);
    }


    /**
     * @param
     * @return org.qiwei.thoughtwork.service.TripCountByMaxDistanceService
     * @description 获取最大距离现在旅途数量
     * @author qiwei
     * @date 18:25 2018/9/16
     */
    @Override
    public TripCountByMaxDistanceService applyTripCountByMaxDistanceService() {
        TripStrategyProgramming strategy = new TripCountByMaxDistanceStrategyImpl(this.railRoadMap);
        return new TripCountByMaxDistanceServiceImpl(strategy);
    }


}
