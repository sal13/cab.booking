package com.cab.booking.instruction.handler;
import com.cab.booking.cab.Cab;
import com.cab.booking.cab.CabStatus;
import com.cab.booking.io.Writer;
import com.cab.booking.store.CabStore;

public class CabSwitchOffHandler extends BaseHandlerPrototype {
    public CabSwitchOffHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        if(instructions.length==4) {
            String cabId = instructions[1];
            Cab cab = CabStore.INSTANCE.getCabById(cabId);
            cab.turnCabUnavailable();
        }else{
            throw new NotMatchingInstructionArgumentException(" please retry with 4 parameters");
        }

    }
}
