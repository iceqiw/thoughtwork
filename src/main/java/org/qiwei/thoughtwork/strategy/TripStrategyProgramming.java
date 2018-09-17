package org.qiwei.thoughtwork.strategy;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.domain.Trip;

import java.util.Set;

/**
 * 旅行策略规划与获取接口
 *
 * @author qiwei
 * @description ProgrammingTrip
 * @date 2018/9/16 20:06
 */
public interface TripStrategyProgramming<T extends StrategyParams> {

    /**
     * 获取规划后的旅行集合
     *
     * @param strategyParams 旅行策略
     * @return java.util.Set<org.qiwei.thoughtwork.domain.Trip> 路途路线集合
     * @description
     * @author qiwei
     * @date 22:27 2018/9/16
     */
    Set<Trip> getAllTrips(T strategyParams);

    /**
     * 根据不同策略，规划路线
     *
     * @param strategyParams 策略参数
     * @return void
     * @description
     * @author qiwei
     * @date 22:27 2018/9/16
     */
    void programming(T strategyParams);
}
