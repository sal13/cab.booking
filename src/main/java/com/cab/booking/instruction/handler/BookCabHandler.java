package com.cab.booking.instruction.handler;

import com.cab.booking.*;
import com.cab.booking.cab.Cab;
import com.cab.booking.cab.PossibleCab;
import com.cab.booking.io.Writer;
import com.cab.booking.ride.PossibleCabComaprator;
import com.cab.booking.ride.PossibleRides;
import com.cab.booking.ride.Ride;
import com.cab.booking.ride.RideStatus;
import com.cab.booking.rider.Rider;
import com.cab.booking.store.CabStore;
import com.cab.booking.store.RideStore;
import com.cab.booking.store.RiderStore;

import java.util.PriorityQueue;
import java.util.Set;

public class BookCabHandler extends BaseHandlerPrototype {
    public BookCabHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        if(instructions.length==6) {
            String riderId = instructions[1];
            Rider rider = RiderStore.INSTANCE.getRiderById(riderId);
            double x1 = Double.parseDouble(instructions[2]);
            double y1 = Double.parseDouble(instructions[3]);
            Location start  = new Location(x1,y1);
            double x2 = Double.parseDouble(instructions[4]);
            double y2 = Double.parseDouble(instructions[5]);
            Location end  = new Location(x2,y2);
            Ride r = new Ride(rider,start,end);
            PriorityQueue<PossibleCab> possibleCabs = bookCabForRide(r,5.0, 10);
            if(possibleCabs!=null && possibleCabs.size()>0) {
                PossibleCab possibleCab = possibleCabs.poll();
                if (possibleCab != null) {
                   possibleCab.getC().turnCabUnavailable();
                   r.setStatus(RideStatus.STARTED);
                    writer.write("ride started for "+possibleCab.getC().getCabId()+" for ride id "+ r.getId()+" at (timemillis) "+System.currentTimeMillis());
                    Thread.sleep(10000);
                    writer.write("ride stopped for "+possibleCab.getC().getCabId()+" for ride id "+ r.getId()+" at (timemillis) "+System.currentTimeMillis());
                    possibleCab.getC().turnAvailable(end);
                    r.setStatus(RideStatus.COMPLTED);
                    RideStore.INSTANCE.addRide(r);
                }
            }
        }else{
            throw new NotMatchingInstructionArgumentException(" please retry with 6 parameters");
        }
    }

    public PriorityQueue<PossibleCab> bookCabForRide(Ride r, double maxDistance, int maxNoResult) throws Exception {
        if(r.getStart()==null|| r.getEnd()==null){
            throw  new Exception("null start or end not allowed");
        }
        Set<Cab> cabs = CabStore.INSTANCE.getAllAvailableCabs();
        PossibleRides ps = new PossibleRides(maxNoResult, new PossibleCabComaprator());
        for(Cab cab: cabs){
            if(cab.getLocation()!=null){
                double dist = r.getStart().getDistance(cab.getLocation());
                if(dist<maxDistance) {
                    PossibleCab possibleCab = new PossibleCab(cab, dist);
                    ps.addItem(possibleCab);
                }
            }
        }
        return ps.getItems();
    }
}
