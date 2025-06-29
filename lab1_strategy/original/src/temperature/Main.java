package temperature;

public class Main {

	public static void main(String[] args) {

		double[] temperatures = new double[100];

		// Data acquisition
		for (int i = 0; i < temperatures.length; i++)
			temperatures[i] = readTemperatureSensor();

		// Calculate the average temperature in Celsius
		double averageCelsius = 0;
		for (int i = 0; i < temperatures.length; i++) {
			averageCelsius += temperatures[i];
		}
		averageCelsius = averageCelsius / temperatures.length;
		System.out.printf("The average temperature in Celsius is: %.1f ºC\n", averageCelsius);

		// Calculate the average temperature in Fahrenheit
		double averageFahrenheit = 0;
		for (int i = 0; i < temperatures.length; i++) {
			averageFahrenheit += temperatures[i] * 9 / 5 + 32;
		}
		averageFahrenheit = averageFahrenheit / temperatures.length;
		System.out.printf("The average temperature in Fahrenheit is: %.1f ºF\n", averageFahrenheit);

		// Calculate the variance in Fahrenheit
		double varianceFahrenheit = 0;
		for (int i = 0; i < temperatures.length; i++) {
			varianceFahrenheit += Math.pow(temperatures[i] * 9 / 5 + 32 - averageFahrenheit, 2);
		}
		varianceFahrenheit = varianceFahrenheit / temperatures.length;
		System.out.printf("The variance in Fahrenheit is: %.1f\n", varianceFahrenheit);
	}

	// Simulates the reading of a temperature sensor in Celsius
	public static double readTemperatureSensor() {
		return Math.random() * 30;
	}
}