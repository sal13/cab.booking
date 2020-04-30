package com.cab.booking.instruction.handler;

import com.cab.booking.cab.Cab;
import com.cab.booking.cab.MicroCab;
import com.cab.booking.io.Writer;
import com.cab.booking.store.CabStore;

public class CabRegisterHandler extends BaseHandlerPrototype {

    public CabRegisterHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        if (instructions.length == 2) {
            String id = instructions[1];
            Cab c = new MicroCab(id, null);
            CabStore.INSTANCE.registerDriver(c);
            writer.write("successfully registered driver " + c.getCabId());
        }else{
            throw new NotMatchingInstructionArgumentException("please retry with 2 parameters");
        }
    }
}
