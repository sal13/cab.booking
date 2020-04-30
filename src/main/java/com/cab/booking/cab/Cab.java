package com.cab.booking.cab;

import com.cab.booking.Location;
import com.cab.booking.store.CabStore;

public abstract class Cab {
    String cabId;
    CabStatus status;
    Location location;

    public Cab(String cabId, Location location) {
        this.cabId = cabId;
        status = CabStatus.AVALAIBLE;
        this.location = location;
    }

    public String getCabId() {
        return cabId;
    }

    public Location getLocation() {
        return location;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public CabStatus getStatus() {
        return status;
    }

    public void setStatus(CabStatus status) {
        this.status = status;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void turnAvailable(Location location) throws Exception {
        setStatus(CabStatus.AVALAIBLE);
        CabStore.INSTANCE.addAvailableDriver(this);
        setLocation(location);
    }
    public void turnCabUnavailable() throws Exception {
        setStatus(CabStatus.SWITCH_OFF);
        CabStore.INSTANCE.removeAvailableCabById(cabId);
    }
}
