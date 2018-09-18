package org.qiwei.thoughtwork.strategy.impl;

import org.qiwei.thoughtwork.domain.StrategyParamsByStop;
import org.qiwei.thoughtwork.domain.Trip;
import org.qiwei.thoughtwork.strategy.TripStrategyCondition;

/**
 * 根据停靠站规划旅途
 *
 * @author qiwei
 * @description TripCountByStopStrategyImpl
 * @date 2018/9/16 11:22
 */
public class TripCountByStopStrategyImpl implements TripStrategyCondition<StrategyParamsByStop> {

    /**
     * 停靠站条件判断
     *
     * @param strategyParams 根据停靠站规划旅途参数
     * @param newTrip        新的路途
     * @return boolean 是否符合条件
     * @description
     * @author qiwei
     * @date 22:28 2018/9/16
     */
    @Override
    public boolean doCondition(StrategyParamsByStop strategyParams, Trip newTrip) {
        return strategyParams.getStopNum().compareTo(newTrip.getStopStationCount()) >= 0;
    }


}
