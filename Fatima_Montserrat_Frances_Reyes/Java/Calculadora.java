package ProyecteCalculadora.Calculadora;

import javax.swing.JOptionPane;

public class CalculadoraBonita {

    public static void main(String[] args) {
        int opcion = 0;

        do {
            String menu = """
                          \u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557
                          \u2551              CALCULADORA JAVA             \u2551
                          \u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563
                          \u2551  1. \u2795 Sumar                                       \u2551
                          \u2551  2. \u2796 Restar                                      \u2551
                          \u2551  3. \u2716 Multiplicar                                 \u2551
                          \u2551  4. \u2797 Dividir                                     \u2551
                          \u2551  5. \u274c Salir                                         \u2551
                          \u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d
                          
                          \ud83d\udc49 Elige una opci\u00f3n (1-5):""";

            opcion = leerEntero(menu);

            if (opcion >= 1 && opcion <= 4) {
                double num1 = leerDouble("🔹 Ingresa el primer número:");
                double num2 = leerDouble("🔹 Ingresa el segundo número:");
                
                ejecutarOperacion(opcion, num1, num2);
            } else if (opcion == 5) {
                JOptionPane.showMessageDialog(null, "👋 Gracias por usar la calculadora.", "Salida", JOptionPane.INFORMATION_MESSAGE);
            } else if (opcion != -1) {
                JOptionPane.showMessageDialog(null, "⚠ Opción inválida. Intenta de nuevo.", "Error", JOptionPane.WARNING_MESSAGE);
            }

        } while (opcion != 5 && opcion != -1);
    }

    private static void ejecutarOperacion(int opcion, double num1, double num2) {
        double resultado;
        switch (opcion) {
            case 1 -> {
                resultado = num1 + num2;
                JOptionPane.showMessageDialog(null, "✅ Resultado de la Suma:\n " + num1 + " + " + num2 + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            case 2 -> {
                resultado = num1 - num2;
                JOptionPane.showMessageDialog(null, "✅ Resultado de la Resta:\n " + num1 + " - " + num2 + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            case 3 -> {
                resultado = num1 * num2;
                JOptionPane.showMessageDialog(null, "✅ Resultado de la Multiplicación:\n " + num1 + " * " + num2 + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            case 4 -> {
                if (num2 != 0) {
                    resultado = num1 / num2;
                    JOptionPane.showMessageDialog(null, "✅ Resultado de la División:\n " + num1 + " / " + num2 + " = " + resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "⚠ Error: No se puede dividir entre cero.", "Error Matemático", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(null, mensaje, "Menú Principal", JOptionPane.QUESTION_MESSAGE);
                if (entrada == null) return -1;
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "⚠ Error: Debes ingresar un número entero válido.", "Entrada Incorrecta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   private static double leerDouble(String mensaje) {
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(null, mensaje, "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
                if (entrada == null) return -1; 
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "⚠ Error: Debes ingresar un número válido.", "Entrada Incorrecta", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}