package com.cab.booking.instruction.handler;

import com.cab.booking.ride.Ride;
import com.cab.booking.io.Writer;
import com.cab.booking.store.RideStore;

import java.util.List;


public class PrintAllRidesHandler extends BaseHandlerPrototype{
    public PrintAllRidesHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    public void printAllRides(String id) throws Exception {
        List<Ride> rides = RideStore.INSTANCE.getByRiderId(id);
        if(rides!=null){
            for(Ride r:rides){
                System.out.println("this ride was taken by cab "+r.toString());
            }
        }
    }

    @Override
    public void execute() throws Exception {
        if(instructions.length==2) {
            printAllRides(instructions[1]);
        }else{
            throw new NotMatchingInstructionArgumentException("please retry with 2 parameters");
        }
    }
}
