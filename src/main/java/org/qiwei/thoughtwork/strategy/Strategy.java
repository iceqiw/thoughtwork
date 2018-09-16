package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.Route;
import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author qiwei
 * @description Strategy
 * @date 2018/9/15 20:41
 */
public abstract class Strategy<T extends StrategyParams> extends AbstractStrategy implements TripStrategyProgramming<T> {

    public Strategy(Map<Route, Integer> railRoadMap) {
        super(railRoadMap);
    }

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:27 2018/9/16
     * @param strategyParams
     * @return java.util.Set<org.qiwei.thoughtwork.domain.Trip>
     */
    @Override
    public Set<Trip> getAllTrips(T strategyParams) {
        programming(strategyParams);
        return strategyParams.getTrips();
    }

    /**
     * @description
     *
     *
     * @author qiwei
     * @date 22:27 2018/9/16
     * @param strategyParams
     * @return void
     */
    @Override
    public void programming(T strategyParams) {

        List<Route> newRoutes = this.getAllRoutes(strategyParams.getCurrentStationName());
        Trip currentTrip = strategyParams.getCurrentTrip();
        for (Route newRoute : newRoutes) {
            Trip newTrip = currentTrip.genNewTrip(newRoute);
            if (!doCondition(strategyParams, newTrip)) {
                continue;
            }
            if (newRoute.getEndStationName().equals(strategyParams.getEndStationName())) {
                strategyParams.addTrip(newTrip);
            }
            strategyParams.setCurrentTrip(newTrip);
            strategyParams.setCurrentStationName(newRoute.getEndStationName());
            programming(strategyParams);
        }
    }

    protected abstract boolean doCondition(T strategyParams,Trip newTrip);

}
