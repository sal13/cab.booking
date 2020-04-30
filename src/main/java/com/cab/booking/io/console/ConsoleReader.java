package com.cab.booking.io.console;

import com.cab.booking.io.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader {
    BufferedReader br;
    public ConsoleReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String read() throws IOException{
        return br.readLine();
    }

    public void close()throws IOException{
        br.close();
    }
}
