package forms.validators;

import forms.Validator;

import java.util.List;

public class CheckAll implements Validator {
    Validator[] validators;

    public CheckAll(Validator... validators) {
        this.validators = validators;
    }

    @Override
    public boolean validate(String value) {
        for(Validator validator : validators) {
            if(!validator.validate(value)) {
                return false;
            }
        }
        return true;
    }
}
