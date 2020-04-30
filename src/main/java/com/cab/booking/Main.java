package com.cab.booking;

import com.cab.booking.instruction.InstructionHandler;
import com.cab.booking.io.console.ConsoleReader;
import com.cab.booking.io.console.ConsoleWriter;

public class Main {
    public static void main(String args[]){
        try {
            InstructionHandler is = new InstructionHandler(new ConsoleReader(), new ConsoleWriter());
            is.readInstructions();
        }catch (Exception e){
            System.out.println("exception "+e);
        }
    }
}
