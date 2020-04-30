package com.cab.booking.ride;

import com.cab.booking.cab.PossibleCab;

import java.util.Comparator;


public class PossibleCabComaprator implements Comparator<PossibleCab> {
    @Override
    public int compare(PossibleCab o1, PossibleCab o2) {
        return (int)(o1.getDistance() - o2.getDistance());
    }
}
