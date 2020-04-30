package com.cab.booking.cab;

import com.cab.booking.cab.Cab;

public class PossibleCab {
    Cab c;
    double distance;

    public PossibleCab(Cab c, double distance) {
        this.c = c;
        this.distance = distance;
    }

    public Cab getC() {
        return c;
    }

    public void setC(Cab c) {
        this.c = c;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
