package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    @ParameterizedTest
    @CsvSource({
            "0, 32",
            "25, 77",
            "-40, -40"
    })
    void testCelsiusToFahrenheit(double celsius, double expectedFahrenheit) {
        // Act
        double result = TemperatureConverter.celsiusToFahrenheit(celsius);

        // Assert
        assertEquals(expectedFahrenheit, result, 0.001); // Verify the result
    }

    @Test
    void testCelsiusToFahrenheitThrowsExceptionForInvalidTemperature() {
        // Assert exception is thrown for invalid temperature
        assertThrows(IllegalArgumentException.class, () ->
                TemperatureConverter.celsiusToFahrenheit(-274));
    }
}
