package com.cab.booking.store;

import com.cab.booking.cab.Cab;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum CabStore {
    INSTANCE;
    ConcurrentHashMap<String, Cab> driverStore = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Cab> availableDriver = new ConcurrentHashMap<>();

    public void registerDriver(Cab c) throws Exception {
        if(c==null){
            throw new Exception("null Driver cannot be switched on");
        }
        if(driverStore.containsKey(c.getCabId())){
            throw new Exception("duplicate Rider cannot be added");
        }
        driverStore.put(c.getCabId(),c);
    }

    public void addAvailableDriver(Cab c) throws Exception {
        if(c==null){
            throw new Exception("null Driver cannot be switched on");
        }
        if(availableDriver.containsKey(c.getCabId())){
            throw new Exception("duplicate Rider cannot be added");
        }
        availableDriver.put(c.getCabId(),c);
    }

    public Cab getAvailableCabById(String id) throws Exception {
        if(!availableDriver.containsKey(id)){
            throw new Exception("cab is not switched On");
        }
        return availableDriver.get(id);
    }
    public Cab removeAvailableCabById(String id) throws Exception {
        if(!availableDriver.containsKey(id)){
            throw new Exception("cab is not in available list");
        }
        return availableDriver.remove(id);
    }

    public Cab getCabById(String id) throws Exception {
        if(!driverStore.containsKey(id)){
            throw new Exception("cab is not present");
        }
        return driverStore.get(id);
    }

    public Set<Cab> getAllAvailableCabs() throws Exception {
        Set<Cab> cabs = new HashSet<>();
        for (String d: availableDriver.keySet()) {
            cabs.add(availableDriver.get(d));
        }
        return cabs;
    }
}
