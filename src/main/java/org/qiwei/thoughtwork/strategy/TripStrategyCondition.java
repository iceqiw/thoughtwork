package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;

/**
 * 旅行策略规划与获取接口
 *
 * @author qiwei
 * @description ProgrammingTrip
 * @date 2018/9/16 20:06
 */
public interface TripStrategyCondition<T extends StrategyParams> {

    boolean doCondition(T strategyParams, Trip newTrip);
}
