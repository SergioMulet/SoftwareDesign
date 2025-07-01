package forms.validators;

import forms.Validator;

public class TextValidator implements Validator {

    @Override
    public boolean validate(String value) {
        for (char ch : value.toCharArray()) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }
}
