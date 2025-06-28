package temperature;

public class Temperature {

    private final double temperature;

    public Temperature(double celcius){
        this.temperature = celcius;
    }

    public double getCelsius(){
        return temperature;
    }

    public double getFahrenheit(){
        return temperature * 9 / 5 + 32;
    }

    public double getVarianceFahrenheit(double averageFahrenheit){
        return Math.pow(getFahrenheit() - averageFahrenheit, 2);
    }
}
