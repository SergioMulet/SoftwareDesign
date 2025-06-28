package temperature;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Temperature> temperatures = new ArrayList<>();

		// Data acquisition
		for(int i=0; i< 100; i++){
			Temperature temp = new Temperature(readTemperatureSensor());
			System.out.println(temp.getCelsius());
			temperatures.add(temp);
		}

		// Calculate the average temperature in Celsius
		double averageCelsius = 0;
		for(Temperature temperature: temperatures){
			averageCelsius += temperature.getCelsius();
		}
		averageCelsius = averageCelsius / temperatures.size();
		System.out.printf("The average temperature in Celsius is: %.1f ºC\n", averageCelsius);

		// Calculate the average temperature in Fahrenheit
		double averageFahrenheit = 0;
		for(Temperature temperature: temperatures){
			averageFahrenheit += temperature.getFahrenheit();
		}
		averageFahrenheit = averageFahrenheit / temperatures.size();
		System.out.printf("The average temperature in Fahrenheit is: %.1f ºF\n", averageFahrenheit);

		// Calculate the variance in Fahrenheit
		double varianceFahrenheit = 0;
		for(Temperature temperature: temperatures){
			varianceFahrenheit += temperature.getVarianceFahrenheit(averageFahrenheit);
		}
		varianceFahrenheit = varianceFahrenheit / temperatures.size();
		System.out.printf("The variance in Fahrenheit is: %.1f\n", varianceFahrenheit);
	}

	// Simulates the reading of a temperature sensor in Celsius
	private static double readTemperatureSensor() {
		return Math.random() * 30;
	}


}