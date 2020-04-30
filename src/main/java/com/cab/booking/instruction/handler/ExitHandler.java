package com.cab.booking.instruction.handler;

import com.cab.booking.io.Writer;

public class ExitHandler extends BaseHandlerPrototype {
    public ExitHandler(String[] instructions, Writer writer) {
        super(instructions, writer);
    }

    @Override
    public void execute() throws Exception {
        writer.close();
    }
}
