package com.cab.booking.instruction.handler;

import com.cab.booking.io.Writer;
import com.cab.booking.rider.NormalRider;
import com.cab.booking.rider.Rider;
import com.cab.booking.store.RiderStore;

import java.io.IOException;

public class RiderRegisterHandler extends BaseHandlerPrototype {

    public RiderRegisterHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        if(instructions.length==2){
            String id = instructions[1];
            Rider r = new NormalRider(id);
            RiderStore.INSTANCE.addRider(r);
            writer.write("registered a rider with id "+instructions[1]+"");
        }
    }
}
