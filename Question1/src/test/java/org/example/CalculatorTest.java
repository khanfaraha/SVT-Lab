package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    static void setupAll() {
        System.out.println("Run before all tests.");
    }

    @BeforeEach
    void setup() {
        System.out.println("Run before each test.");
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Run after each test.");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Run after all tests.");
    }

    @Test
    void testBasicAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testNullChecks() {
        assertNotNull(calculator);
        String nullString = null;
        assertNull(nullString);
    }

    @Test
    void testAssertions() {
        assertEquals(6, calculator.add(3, 3));
        assertNotEquals(5, calculator.add(2, 2));
        assertTrue(calculator.add(2, 2) == 4);
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(4, 0));
        assertDoesNotThrow(() -> calculator.divide(4, 2));
    }

    @Test
    void testArrayAndObjects() {
        assertArrayEquals(new int[]{1, 2, 3}, calculator.getArray());

        Calculator sameCalculator = calculator;
        assertSame(calculator, sameCalculator);

        List<String> expectedLines = List.of("Hello", "World");
        List<String> actualLines = List.of("Hello", "World");
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(50); // Simulate some processing
            calculator.add(1, 1);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "4, 5, 9"
    })
    void testParameterizedAddition(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @RepeatedTest(5)
    void testRandomNumberInRange() {
        int number = Integer.parseInt(calculator.generateRandomNumber());
        assertTrue(number >= 0 && number < 100, "Number is out of range");
    }
}
