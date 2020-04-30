package com.cab.booking;

public class Location {
    double x;
    double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistance(Location end){
        return Math.sqrt(end.getX()-x)*(end.getX()-x) +(end.getY()-y)*(end.getY()-y);
    }
}
