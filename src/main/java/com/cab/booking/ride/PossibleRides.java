package com.cab.booking.ride;

import com.cab.booking.cab.PossibleCab;

import java.util.PriorityQueue;

public class PossibleRides {
    int maxSize = 100;

    PriorityQueue<PossibleCab> items;
    public PossibleRides(int maxSize, PossibleCabComaprator pc) {
        this.maxSize = maxSize;
        items = new PriorityQueue<>(pc);
    }

    public void addItem(PossibleCab newItem) {
        if (items.size() > maxSize) {
            items.poll();
        }
        items.add(newItem);
    }

    public PriorityQueue<PossibleCab> getItems() {
        return items;
    }

}
