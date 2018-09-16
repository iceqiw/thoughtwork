package org.qiwei.thoughtwork.domain;

import java.util.LinkedList;

/**
 * @author qiwei
 * @description Trip
 * @date 2018/9/15 20:44
 */
public class Trip implements Comparable<Trip> {

    private String startStationName;
    private String endStationName;
    private Boolean hasSameRoute;

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

    public Integer getDistance() {
        Integer distance = 0;
        for (Route route : routes) {
            distance += route.getDistance();
        }
        return distance;
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

    public String getPath() {
        StringBuilder path = new StringBuilder(this.startStationName);
        for (Route route : routes) {
            path.append(route.getEndStationName());
        }
        return path.toString();
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

    public Trip genNewTrip(Route newRoute) {
        LinkedList<Route> newRoutes = new LinkedList<>(routes);
        newRoutes.add(newRoute);
        if (routes.contains(newRoute)) {
            return new Trip(startStationName, endStationName, newRoutes, true);
        }
        return new Trip(startStationName, endStationName, newRoutes, false);
    }
}
