package modifications;

import fylesystem.Output;

import java.io.IOException;

public class Normalize implements Output {

    Output output;

    public Normalize(Output output) {
        this.output = output;
    }

    @Override
    public void open() throws IOException {
        output.open();
    }

    @Override
    public void write(char c) throws IOException {
        if(c != '\r'){
            output.write(c);
        }
    }

    @Override
    public void close() throws IOException {
        output.close();
    }
}
