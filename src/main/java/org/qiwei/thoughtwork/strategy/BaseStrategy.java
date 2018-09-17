package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 路线规划策略基础类
 * @author qiwei
 * @description BaseStrategy
 * @date 2018/9/15 20:41
 */
public abstract class BaseStrategy<T extends StrategyParams> extends AbstractStrategy implements TripStrategyProgramming<T> {

    public BaseStrategy(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * 获取规划后的旅行集合
     *
     * @param strategyParams 旅行策略
     * @return java.util.Set<org.qiwei.thoughtwork.domain.Trip>
     * @description
     * @author qiwei
     * @date 22:27 2018/9/16
     */
    @Override
    public Set<Trip> getAllTrips(T strategyParams) {
        programming(strategyParams);
        return strategyParams.getTrips();
    }

    /**
     * 根据不同策略，规划路线
     *
     * @param strategyParams 策略参数
     * @return void
     * @description
     * @author qiwei
     * @date 22:27 2018/9/16
     */
    @Override
    public void programming(T strategyParams) {

        List<Route> newRoutes = this.getAllRoutes(strategyParams.getCurrentStationName());
        Trip currentTrip = strategyParams.getCurrentTrip();
        for (Route newRoute : newRoutes) {
            Trip newTrip = currentTrip.genNewTrip(newRoute);
            if (doCondition(strategyParams, newTrip)) {
                if (newRoute.getEndStationName().equals(strategyParams.getEndStationName())) {
                    strategyParams.addTrip(newTrip);
                }
                strategyParams.setCurrentTrip(newTrip);
                strategyParams.setCurrentStationName(newRoute.getEndStationName());
                programming(strategyParams);
            }
        }
    }

    /**
     * 判断是否需要继续探索新的路线
     *
     * @param strategyParams 策略参数
     * @param newTrip        新的旅途
     * @return boolean
     * @author qiwei
     * @date 10:51 2018/9/17
     */
    protected abstract boolean doCondition(T strategyParams, Trip newTrip);

}
