package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author qiwei
 * @description TripStrategy
 * @date 2018/9/18 18:05
 */
public class TripStrategy<T extends StrategyParams> {

    private TripStrategyCondition<T> tripStrategyCondition;

    protected Map<Route, Integer> railRoadMap;


    public TripStrategy(TripStrategyCondition<T> tripStrategyCondition, Map<Route, Integer> railRoadMap) {
        this.tripStrategyCondition = tripStrategyCondition;
        this.railRoadMap = railRoadMap;
    }

    public void programming(T strategyParams) {

        List<Route> newRoutes = this.getAllRoutes(strategyParams.getCurrentStationName());
        Trip currentTrip = strategyParams.getCurrentTrip();
        for (Route newRoute : newRoutes) {
            Trip newTrip = currentTrip.genNewTrip(newRoute);
            if (tripStrategyCondition.doCondition(strategyParams, newTrip)) {
                if (newRoute.getEndStationName().equals(strategyParams.getEndStationName())) {
                    strategyParams.addTrip(newTrip);
                }
                strategyParams.setCurrentTrip(newTrip);
                strategyParams.setCurrentStationName(newRoute.getEndStationName());
                programming(strategyParams);
            }
        }
    }

    public Set<Trip> getTrips(T strategyParams) {
        programming(strategyParams);
        return strategyParams.getTrips();
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


}

