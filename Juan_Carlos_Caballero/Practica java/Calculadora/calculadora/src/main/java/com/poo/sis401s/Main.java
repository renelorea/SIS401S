package com.poo.sis401s;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                System.out.println("\nBasic Calculator");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("5. Exit");

                int choice = readChoice(scanner);
                if (choice == 5) {
                    break;
                }

                double firstNumber = readNumber(scanner, "Enter the first number: ");
                double secondNumber = readNumber(scanner, "Enter the second number: ");

                try {
                    double result = calculator.calculate(choice, firstNumber, secondNumber);
                    System.out.println("Result: " + result);
                } catch (ArithmeticException exception) {
                    System.out.println("Error: " + exception.getMessage());
                }

                running = askToContinue(scanner);
            }
        }

        System.out.println("Calculator closed.");
    }

    private static int readChoice(Scanner scanner) {
        while (true) {
            System.out.print("Choose an operation (1-5): ");
            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 5) {
                    return choice;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid choice. Enter a number from 1 to 5.");
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
            System.out.println("Invalid number. Please enter a finite numeric value.");
        }
    }

    private static boolean askToContinue(Scanner scanner) {
        while (true) {
            System.out.print("Perform another operation? (y/n): ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                return true;
            }
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println("Please answer y or n.");
        }
    }
}