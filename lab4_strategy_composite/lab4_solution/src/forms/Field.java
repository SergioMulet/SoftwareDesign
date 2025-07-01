package forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Field {

    private String label;
    private String value;
    private Validator validator;

    public Field(String label, Validator validator) {
        this.label = label;
        this.validator = validator;
    }

    public void askUser() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        boolean isValid;
        do {
            isValid = true;
            try {
                System.out.print(label + ": ");
                value = console.readLine();

                isValid = validator.validate(value);
            } catch (IOException ex) {
                System.out.println(ex);
            }
        } while (!isValid);
    }

    public String getValue() {
        return value;
    }

}
