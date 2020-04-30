package com.cab.booking.io;

import java.io.IOException;

public interface Reader {
    String read() throws IOException;
    void close()  throws IOException;

}
