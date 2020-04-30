package com.cab.booking.instruction;


import com.cab.booking.instruction.handler.*;
import com.cab.booking.io.Reader;
import com.cab.booking.io.Writer;

public class InstructionHandler {
    Reader reader;
    Writer writer;
    public InstructionHandler(Reader reader, Writer writer){
        this.reader = reader;
        this.writer = writer;
    }
    public void readInstructions() {
        try {
            while (true){
                String line = reader.read();
                //System.out.println("reading instr "+line);
                if(line==null){
                    break;
                }
                String[]instr = getInstructions(line);
                if(instr.length<1){
                    continue;
                }
                try {
                    String command = instr[0];
                    if (command.equals(Command.EXIT.toString())) {
                        break;
                    }
                    if (command.equals(Command.REGISTER_DRIVER.toString())) {
                        CabRegisterHandler handler = new CabRegisterHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                    if (command.equals(Command.REGISTER_USER.toString())) {
                        RiderRegisterHandler handler = new RiderRegisterHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                    if (command.equals(Command.SWITCH_ON_CAB.toString())) {
                        CabSwitchOnHandler handler = new CabSwitchOnHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                    if (command.equals(Command.SWITCH_OFF_CAB.toString())) {
                        CabSwitchOffHandler handler = new CabSwitchOffHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                    if (command.equals(Command.BOOK_CAB.toString())) {
                        BookCabHandler handler = new BookCabHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                    if (command.equals(Command.PRINT_ALL_RIDES.toString())) {
                        PrintAllRidesHandler handler = new PrintAllRidesHandler(instr, writer);
                        handler.execute();
                        continue;
                    }
                }catch (Exception e){
                    writer.write(" exception e "+e);
                    continue;
                }
            }
        }catch (Exception e){
            System.out.println("some exception "+e);
        }
    }

    private String[] getInstructions(String s){
        if(s == null){
            return null;
        }
        return s.split(" ");
    }
}
