package com.cab.booking.rider;

public abstract class Rider {
    String id;

    public Rider(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
