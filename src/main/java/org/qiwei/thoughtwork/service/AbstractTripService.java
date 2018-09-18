package org.qiwei.thoughtwork.service;

import org.qiwei.thoughtwork.domain.StrategyParams;
import org.qiwei.thoughtwork.strategy.TripStrategy;

/**
 * @author qiwei
 * @description TripService
 * @date 2018/9/18 17:54
 */
public abstract class AbstractTripService<T extends StrategyParams> {

    protected TripStrategy<T> tripStrategy;

    public AbstractTripService(TripStrategy<T> tripStrategy) {
        this.tripStrategy = tripStrategy;
    }
}
