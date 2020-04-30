package com.cab.booking.store;

import com.cab.booking.rider.Rider;

import java.util.concurrent.ConcurrentHashMap;

public enum RiderStore {
    INSTANCE;
    ConcurrentHashMap<String, Rider> riderData = new ConcurrentHashMap<>();

    public void addRider(Rider r) throws Exception {
        if(r==null){
            throw new Exception("null Rider cannot be added");
        }
        if(riderData.containsKey(r.getId())){
            throw new Exception("duplicate Rider cannot be added");
        }
        riderData.put(r.getId(),r);
        System.out.println("successfully added rider "+r.getId());
    }

    public Rider getRiderById(String id) throws Exception {
        if(!riderData.containsKey(id)){
            throw new Exception("cab is not switchedon");
        }
        return riderData.get(id);

    }
}
