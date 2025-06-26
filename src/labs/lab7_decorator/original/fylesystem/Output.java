package labs.lab7_decorator.original.fylesystem;

import java.io.IOException;

public interface Output {
    void open() throws IOException;
    void write(char c) throws IOException;
    void close() throws IOException;
}
