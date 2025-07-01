package fylesystem.outputs;

import fylesystem.Output;

import java.io.FileWriter;
import java.io.IOException;


public class FileOutput implements Output {

    String filename;
    FileWriter output;

    public FileOutput(String filename) {
        this.filename = filename;
    }

    @Override
    public void open() throws IOException {
        output = new FileWriter(filename);
    }

    @Override
    public void write(char c) throws IOException {
        output.append(c);
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
