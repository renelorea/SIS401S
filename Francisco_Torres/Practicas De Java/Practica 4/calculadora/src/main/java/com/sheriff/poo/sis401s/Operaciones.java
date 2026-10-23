package com.sheriff.poo.sis401s;

public class Operaciones {
    public double calculate(int operacion, double PrimerNumero, double SegundoNumero) {
        return switch (operacion) {
            case 1 -> PrimerNumero + SegundoNumero;
            case 2 -> PrimerNumero - SegundoNumero;
            case 3 -> PrimerNumero * SegundoNumero;
            case 4 -> divide(PrimerNumero, SegundoNumero);
            default -> throw new IllegalArgumentException("Unknown operation: " + operacion);
        };
    }

    private double divide(double dividend, double divisor) {
        if (divisor == 0.0) {
            throw new ArithmeticException("Resultado Invalido, no es posible dividir entre cero.");
        }
        return dividend / divisor;
    }
}