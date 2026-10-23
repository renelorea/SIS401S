package com.poo.sis401s;

public class Calculator {
    public double calculate(int operation, double firstNumber, double secondNumber) {
        return switch (operation) {
            case 1 -> firstNumber + secondNumber;
            case 2 -> firstNumber - secondNumber;
            case 3 -> firstNumber * secondNumber;
            case 4 -> divide(firstNumber, secondNumber);
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    private double divide(double dividend, double divisor) {
        if (divisor == 0.0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return dividend / divisor;
    }
}