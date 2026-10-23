/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculadoraherencia;

/**
 *
 * @author yeyos
 */

import java.util.Scanner;

// Clase base
abstract class Operacion {
    protected double numero1;
    protected double numero2;
    protected double resultado;

    public Operacion(double numero1, double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public abstract double calcular();

    public double getResultado() {
        return resultado;
    }
}

// Subclases
class Suma extends Operacion {
    public Suma(double numero1, double numero2) { super(numero1, numero2); }
    @Override
    public double calcular() { resultado = numero1 + numero2; return resultado; }
}

class Resta extends Operacion {
    public Resta(double numero1, double numero2) { super(numero1, numero2); }
    @Override
    public double calcular() { resultado = numero1 - numero2; return resultado; }
}

class Multiplicacion extends Operacion {
    public Multiplicacion(double numero1, double numero2) { super(numero1, numero2); }
    @Override
    public double calcular() { resultado = numero1 * numero2; return resultado; }
}

class Division extends Operacion {
    public Division(double numero1, double numero2) { super(numero1, numero2); }
    @Override
    public double calcular() {
        if (numero1 == 0 || numero2 == 0) {
            throw new ArithmeticException("Error: División con 0 no permitida");
        }
        resultado = numero1 / numero2;
        return resultado;
    }
}

// Clase principal
public class CalculadoraHerencia {
    private double ultimoResultado = 0;
    private boolean tieneResultado = false;

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Calculadora ---");
            if (tieneResultado) {
                System.out.println("Último resultado: " + ultimoResultado);
                System.out.println("¿Quieres usar el resultado como primer número? (s/n)");
                String opcion = sc.nextLine();
                if (opcion.equalsIgnoreCase("s")) {
                    System.out.print("Ingresa operación (+, -, *, /): ");
                    String op = sc.nextLine();
                    System.out.print("Ingresa segundo número: ");
                    double num2 = sc.nextDouble();
                    sc.nextLine();
                    elegirOperacion(ultimoResultado, num2, op);
                } else {
                    reiniciar(sc);
                }
            } else {
                reiniciar(sc);
            }

            System.out.println("¿Deseas continuar? (s/n)");
            String seguir = sc.nextLine();
            if (seguir.equalsIgnoreCase("n")) continuar = false;
        }
        sc.close();
    }

    private void reiniciar(Scanner sc) {
        System.out.print("Ingresa primer número: ");
        double num1 = sc.nextDouble();
        sc.nextLine();
        System.out.print("Ingresa operación (+, -, *, /): ");
        String op = sc.nextLine();
        System.out.print("Ingresa segundo número: ");
        double num2 = sc.nextDouble();
        sc.nextLine();
        elegirOperacion(num1, num2, op);
    }

    private void elegirOperacion(double num1, double num2, String op) {
        Operacion operacion;
        switch (op) {
            case "+": operacion = new Suma(num1, num2); break;
            case "-": operacion = new Resta(num1, num2); break;
            case "*": operacion = new Multiplicacion(num1, num2); break;
            case "/": operacion = new Division(num1, num2); break;
            default: System.out.println("Operación inválida"); return;
        }

        try {
            ultimoResultado = operacion.calcular();
            tieneResultado = true;
            System.out.println("Resultado: " + ultimoResultado);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            tieneResultado = false;
        }
    }

    public static void main(String[] args) {
        CalculadoraHerencia calc = new CalculadoraHerencia();
        calc.iniciar();
    }
}
