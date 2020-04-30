package com.cab.booking.store;

import com.cab.booking.ride.Ride;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public enum RideStore {
    INSTANCE;
    ConcurrentHashMap<String, List<Ride>> rideData = new ConcurrentHashMap<>();
    public void addRide(Ride r) throws Exception {
        if(r==null){
            throw new Exception("null Ride cannot be added");
        }
        List<Ride> list = rideData.getOrDefault(r.getRider().getId(),new LinkedList<>());
        list.add(r);
        rideData.putIfAbsent(r.getRider().getId(),list);
        System.out.println("successfully added ride for rider "+r.getRider().getId());
    }

    public List<Ride> getByRiderId(String id) throws Exception {
        if(!rideData.containsKey(id)){
            throw new Exception("no ride for rider "+id);
        }
        return rideData.get(id);

    }
}
