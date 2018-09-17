package org.qiwei.thoughtwork.domain;

import java.util.LinkedList;

/**
 * @author qiwei
 * @description Trip
 * @date 2018/9/15 20:44
 */
public class Trip implements Comparable<Trip> {

    /**
     * 起始站名称
     */
    private String startStationName;
    /**
     * 终点站名称
     */
    private String endStationName;
    /**
     * 是否有同样路线
     */
    private Boolean hasSameRoute;

    /**
     * 路途路线
     */
    private LinkedList<Route> routes;

    public Trip(String startStationName, String endStationName) {
        this.startStationName = startStationName;
        this.endStationName = endStationName;
        this.routes = new LinkedList<>();
        this.hasSameRoute = false;
    }

    public Trip(String startStationName, String endStationName, LinkedList<Route> routes, Boolean hasSameRoute) {
        this.startStationName = startStationName;
        this.endStationName = endStationName;
        this.routes = routes;
        this.hasSameRoute = hasSameRoute;
    }


    public LinkedList<Route> getRoutes() {
        return routes;
    }

    /**
     *获取路线距离
     *
     * @author qiwei
     * @date 10:44 2018/9/17
     * @param
     * @return java.lang.Integer
     */
    public Integer getDistance() {
        Integer distance = 0;
        for (Route route : routes) {
            distance += route.getDistance();
        }
        return distance;
    }

    /**
    * 获取旅途路径
    *
    * @author qiwei
    * @date 10:46 2018/9/17
    * @param
    * @return
    */
    public String getPath() {
        StringBuilder path = new StringBuilder(this.startStationName);
        for (Route route : routes) {
            path.append(route.getEndStationName());
        }
        return path.toString();
    }


    /**
     *根据新路线生成新路途
     *
     * @author qiwei
     * @date 10:46 2018/9/17
     * @param newRoute 新路线
     * @return org.qiwei.thoughtwork.domain.Trip
     */
    public Trip genNewTrip(Route newRoute) {
        LinkedList<Route> newRoutes = new LinkedList<>(routes);
        newRoutes.add(newRoute);
        if (routes.contains(newRoute)) {
            return new Trip(startStationName, endStationName, newRoutes, true);
        }
        return new Trip(startStationName, endStationName, newRoutes, false);
    }

    public Boolean getHasSameRoute() {
        return hasSameRoute;
    }

    public void setHasSameRoute(Boolean hasSameRoute) {
        this.hasSameRoute = hasSameRoute;
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

    public void setRoutes(LinkedList<Route> routes) {
        this.routes = routes;
    }

    public Integer getStopStationCount() {
        return routes.size();
    }



    @Override
    public String toString() {
        return getPath();
    }


    @Override
    public boolean equals(Object o) {
        Trip trip = (Trip) o;
        return trip.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return this.getPath().hashCode() * 31;
    }

    @Override
    public int compareTo(Trip o) {
        return this.getDistance().compareTo(o.getDistance());
    }

}
