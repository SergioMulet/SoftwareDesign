package forms.validators;

import forms.Validator;

public class PredefinedValidator implements Validator {
	
	private final String[] predefinedValues;

	public PredefinedValidator(String... prefefinedValues) {
		this.predefinedValues = prefefinedValues;
	}

	@Override
	public boolean validate(String value) {
		for (String each : predefinedValues) {
			if (value.equalsIgnoreCase(each)) {
				return true;
			}
		}
		return false;
	}
}
