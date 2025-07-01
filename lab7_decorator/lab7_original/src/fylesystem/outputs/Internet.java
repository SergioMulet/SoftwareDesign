package fylesystem.outputs;

import fylesystem.Output;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;


public class Internet implements Output {
    
    String url;
    private Writer output;

    public Internet(String url) {
        this.url = url;
    }

    @Override
    public void open() throws IOException {
        output = new StringWriter();
        System.out.println("\n--- START Internet [" + url + "]");
    }

    @Override
    public void write(char c) throws IOException {
        output.append(c);
    }

    @Override
    public void close() {
        System.out.println(output.toString());
        System.out.println("--- END   Internet");
    }
}
