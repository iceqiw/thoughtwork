package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
*@description  AbstractStrategy
*  路线规划策略抽象类
* @author   qiwei
* @date     2018/9/16 20:50
*/
public abstract class AbstractStrategy  {
    protected Map<Route, Integer> railRoadMap;

    public AbstractStrategy(Map<Route, Integer> railRoadMap) {
        this.railRoadMap = railRoadMap;
    }

    /**
     * @param stationName
     * @return java.util.List<org.qiwei.thoughtwork.domain.Route>
     * @description 获取车站临近路线
     * @author qiwei
     * @date 17:39 2018/9/16
     */
    protected List<Route> getAllRoutes(String stationName) {
        List<Route> allRoutes = new ArrayList<>();
        for (Route r : this.railRoadMap.keySet()) {
            if (r.getStartStationName().equals(stationName)) {
                allRoutes.add(r);
            }
        }
        return allRoutes;
    }

    /**
     * @param route
     * @return java.lang.Integer
     * @description 获取路段距离
     * @author qiwei
     * @date 17:40 2018/9/16
     */
    protected Integer getRouteDistance(Route route) {
        Integer distance = this.railRoadMap.get(route);
        return distance;
    }
}
