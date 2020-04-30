package com.cab.booking.ride;

import com.cab.booking.Location;
import com.cab.booking.cab.Cab;
import com.cab.booking.rider.Rider;

import java.util.Date;

public class Ride {
    int id;
    Rider rider;
    Cab cab;
    Location start;
    Location end;
    RideStatus status;

    public Ride(Rider r, Location start, Location end) {
        id = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
        this.rider = r;
        this.start = start;
        this.end = end;
        this.status = RideStatus.SEARCHING;
        cab=null;
    }

    public Rider getRider() {
        return rider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Cab getCab() {
        return cab;
    }

    public void setCab(Cab cab) {
        this.cab = cab;
    }

    public Location getStart() {
        return start;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public Location getEnd() {
        return end;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rider=" + rider +
                ", cab=" + cab +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
                '}';
    }
}
