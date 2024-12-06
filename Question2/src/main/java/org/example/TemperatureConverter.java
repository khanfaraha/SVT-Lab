package org.example;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        if (celsius < -273.15) { // Check if temperature is below absolute zero
            throw new IllegalArgumentException("Temperature below absolute zero");
        }
        return (celsius * 9 / 5) + 32; // Convert Celsius to Fahrenheit
    }
}
