package main;

import forms.*;
import forms.validators.CheckAll;
import forms.validators.NumericValidator;
import forms.validators.PredefinedValidator;
import forms.validators.TextValidator;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();
		TextValidator textValidator = new TextValidator();
		PredefinedValidator predefinedValidator = new PredefinedValidator("Santander", "Oviedo", "Cádiz");
		NumericValidator numericValidator = new NumericValidator();

		form.addField(new Field("Nombre", textValidator));
		form.addField(new Field("Apellido", new TextValidator()));
		form.addField(new Field("Telefónico", numericValidator));
		form.addField(new Field("Ciudad", predefinedValidator));

		form.addField(new Field("Texto, numero, ciudad", new CheckAll(textValidator, numericValidator, predefinedValidator))); // dosn't make sense for this implementation, just too see the composite

		form.askUser();
	}
}
