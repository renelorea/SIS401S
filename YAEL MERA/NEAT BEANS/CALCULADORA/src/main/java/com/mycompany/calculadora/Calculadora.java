package com.mycompany.calculadora;


import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== CALCULADORA ===");
        System.out.print("Ingresa el primer número: ");
        double num1 = sc.nextDouble();

        Operaciones op = new Operaciones(num1);

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nResultado actual: " + op.getResultado());
            System.out.println("Opciones: (+, -, *, /) | reiniciar | salir");
            System.out.print("Elige: ");
            String operacion = sc.next();

            if (operacion.equalsIgnoreCase("salir")) {
                continuar = false;
                System.out.println("¡Hasta luego!");
            } else if (operacion.equalsIgnoreCase("reiniciar")) {
                System.out.print("Ingresa nuevo número inicial: ");
                double nuevo = sc.nextDouble();
                op.reiniciar(nuevo);
            } else {
                System.out.print("Ingresa el siguiente número: ");
                double num2 = sc.nextDouble();

                try {
                    switch (operacion) {
                        case "+":
                            op.sumar(num2);
                            break;
                        case "-":
                            op.restar(num2);
                            break;
                        case "*":
                            op.multiplicar(num2);
                            break;
                        case "/":
                            op.dividir(num2);
                            break;
                        default:
                            System.out.println("Operación no válida");
                    }
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
