package forms.validators;

import forms.Validator;

public class NumericValidator implements Validator {

	@Override
	public boolean validate(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}
}
