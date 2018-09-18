package org.qiwei.thoughtwork.service;

import org.qiwei.thoughtwork.domain.StrategyParams;

/**
 * @author qiwei
 * @description TripService
 * @date 2018/9/18 17:54
 */
public interface TripService<T extends StrategyParams> {

    String doService(T strategyParams);
}
