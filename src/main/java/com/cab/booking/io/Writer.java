package com.cab.booking.io;

import java.io.IOException;

public interface Writer {
    void write(String s) throws IOException;
    void close() throws IOException;
}
