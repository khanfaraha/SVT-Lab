package org.example;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    public int[] getArray() {
        return new int[]{1, 2, 3};
    }

    public String generateRandomNumber() {
        int random = (int) (Math.random() * 100); // Random number between 0 and 99
        return String.valueOf(random);
    }
}

