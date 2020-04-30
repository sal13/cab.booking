package com.cab.booking.instruction.handler;

import com.cab.booking.instruction.handler.Handler;
import com.cab.booking.io.Writer;

public abstract class BaseHandlerPrototype implements Handler {
    String[] instructions;
    Writer writer;

    public BaseHandlerPrototype(String[] instructions, Writer writer) {
        this.instructions = instructions;
        this.writer = writer;
    }
}
