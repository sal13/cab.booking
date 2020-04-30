package com.cab.booking.io.console;

import com.cab.booking.io.Writer;

import java.io.IOException;

public class ConsoleWriter  implements Writer {
    public ConsoleWriter(){
    }
    public void write(String s) throws IOException{
        System.out.println(s);
    }
    public void close() throws IOException{

    }
}
