package com.cab.booking.instruction.handler;

import com.cab.booking.Location;
import com.cab.booking.cab.Cab;
import com.cab.booking.io.Writer;
import com.cab.booking.store.CabStore;

public class CabSwitchOnHandler extends BaseHandlerPrototype {
    public CabSwitchOnHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        if(instructions.length==4) {
            String cabId = instructions[1];
            Cab c = CabStore.INSTANCE.getCabById(cabId);
            c.turnAvailable(new Location(Double.parseDouble(instructions[2]), Double.parseDouble(instructions[3])));
            writer.write("switched on cab");
        }else{
            throw new NotMatchingInstructionArgumentException(" please retry with 4 parameters");
        }
    }
}
