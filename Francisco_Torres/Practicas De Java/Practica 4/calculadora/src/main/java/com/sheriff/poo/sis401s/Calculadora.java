package com.sheriff.poo.sis401s;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Operaciones operaciones = new Operaciones();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\nCalculadora");
                System.out.println("1- Sumar");
                System.out.println("2- Restar");
                System.out.println("3- Multiplicar");
                System.out.println("4- Dividir");
                System.out.println("5- Salir");

                int choice = readChoice(scanner);
                if (choice == 5) {
                    break;
                }

                double PrimerNumero = readNumber(scanner, "Escribe el primer numero: ");
                double SegundoNumero = readNumber(scanner, "Escribe el segundo numero: ");

                try {
                    double result = operaciones.calculate(choice, PrimerNumero, SegundoNumero);
                    System.out.println("El resultado es: " + result);
                } catch (ArithmeticException exception) {
                    System.out.println("Error: " + exception.getMessage());
                }

                running = askToContinue(scanner);
            }
        }

        System.out.println("Calculadora finalizada.");
    }

    private static int readChoice(Scanner scanner) {
        while (true) {
            System.out.print("Escoge una operacion a realizar (1-5): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalido. Ingresa un numero del 1 al 5 para continuar.");
        }
    }

    private static double readNumber(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double number = Double.parseDouble(input);
                if (Double.isFinite(number)) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Numero invalido. Ingresa un valor numerico finito.");
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Realizar otra operacion? (si/no): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("si") || answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("no") || answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Escoge si o no.");
        }
    }
}