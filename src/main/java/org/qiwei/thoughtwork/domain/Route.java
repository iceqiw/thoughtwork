package org.qiwei.thoughtwork.domain;


/**
 * @author qiwei
 * @description
 * @date 2018/9/15 20:10
 */
public class Route {

    private Station startStation;
    private Station endStation;
    private Integer distance;


    public Route(String startStationName, String endStationName) {
        this.startStation = new Station(startStationName);
        this.endStation = new Station(endStationName);
    }

    public Route(String startStationName, String endStationName, Integer distance) {
        this.startStation = new Station(startStationName);
        this.endStation = new Station(endStationName);
        this.distance = distance;
    }

    public Route(Station startStation, Station endStation, Integer distance) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.distance = distance;
    }

    public Station getStartStation() {
        return startStation;
    }

    public void setStartStation(Station startStation) {
        this.startStation = startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public void setEndStation(Station endStation) {
        this.endStation = endStation;
    }

    public String getStartStationName() {
        return startStation.getName();
    }

    public String getEndStationName() {
        return endStation.getName();
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        Route r = (Route) o;
        return (this.getStartStationName() + this.getEndStationName()).equals(r.getStartStationName() + r.getEndStationName());
    }

    @Override
    public int hashCode() {
        return (this.getStartStationName() + this.getEndStationName()).hashCode();
    }

    @Override
    public String toString() {
        return "Route{" + "from=" + this.getStartStationName() + "to=" + this.getEndStationName() + '}';
    }

}
