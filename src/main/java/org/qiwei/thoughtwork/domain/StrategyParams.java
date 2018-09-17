package org.qiwei.thoughtwork.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qiwei
 * @description StrategyParams 基础策略参数类
 * @date 2018/9/16 17:52
 */
public class StrategyParams {

    /**
     * 起始站名称
     */
    private String startStationName;

    /**
     * 终点站名称
     */
    private String endStationName;

    /**
     * 当前站名称
     */
    private String currentStationName;
    /**
     * 当前路途
     */
    private Trip currentTrip;
    /**
     * 所有可选路途
     */
    private Set<Trip> trips;

    public StrategyParams(String startStationName, String endStationName) {
        this.startStationName = startStationName;
        this.endStationName = endStationName;
        this.currentStationName = startStationName;
        this.currentTrip = new Trip(startStationName, endStationName);
        this.trips = new HashSet<>();
    }

    public String getStartStationName() {
        return startStationName;
    }

    public void setStartStationName(String startStationName) {
        this.startStationName = startStationName;
    }

    public String getEndStationName() {
        return endStationName;
    }

    public void setEndStationName(String endStationName) {
        this.endStationName = endStationName;
    }

    public String getCurrentStationName() {
        return currentStationName;
    }

    public void setCurrentStationName(String currentStationName) {
        this.currentStationName = currentStationName;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

}
