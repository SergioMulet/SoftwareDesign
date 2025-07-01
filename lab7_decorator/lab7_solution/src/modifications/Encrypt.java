package modifications;

import fylesystem.Output;

import java.io.IOException;

public class Encrypt implements Output {

    private Output output;

    public Encrypt(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        output.write((char)(c+1));
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
