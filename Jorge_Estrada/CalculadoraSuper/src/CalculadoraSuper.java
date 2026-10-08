import java.util.Scanner;
import java.util.InputMismatchException;

// 1. CLASE PADRE
class DatosOperacion {
    protected int num1;
    protected int num2;

    public DatosOperacion(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

// 2. CLASE HIJA CON HERENCIA
class CalculadoraBucle extends DatosOperacion {
    public CalculadoraBucle(int num1, int num2) {
        super(num1, num2);
    }

    public void calcular(char operador) {
        try {
            int resultado;
            if (operador == '+') {
                resultado = num1 + num2;
                System.out.println("-> Resultado: " + resultado);
            } else if (operador == '-') {
                resultado = num1 - num2;
                System.out.println("-> Resultado: " + resultado);
            } else if (operador == '*') {
                resultado = num1 * num2;
                System.out.println("-> Resultado: " + resultado);
            } else if (operador == '/') {
                resultado = num1 / num2; // Lanza ArithmeticException si num2 es 0
                System.out.println("-> Resultado: " + resultado);
            } else {
                System.out.println("-> Error: Operador no válido.");
            }
        } catch (ArithmeticException e) {
            System.out.println("-> Error capturado: No se puede dividir entre cero (Operación inválida).");
        }
    }
}

// 3. CLASE PRINCIPAL CON CICLO WHILE
public class CalculadoraSuper {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== CALCULADORA SUPER EN JAVA ===");

        // El ciclo while se ejecutará infinitamente hasta que continuar sea false
        while (continuar) {
            try {
                System.out.print("\nIntroduce el primer número entero: ");
                int n1 = entrada.nextInt();

                System.out.print("Introduce un operador (+, -, *, /): ");
                char op = entrada.next().charAt(0);

                System.out.print("Introduce el segundo número entero: ");
                int n2 = entrada.nextInt();

                // Instancia y cálculo utilizando herencia
                CalculadoraBucle calc = new CalculadoraBucle(n1, n2);
                calc.calcular(op);

            } catch (InputMismatchException e) {
                System.out.println("-> Error: Debes ingresar únicamente números enteros.");
                entrada.next(); // Limpia el buffer del escáner para evitar un bucle infinito de errores
            }

            // Pregunta de control para romper o seguir en el ciclo
            System.out.print("\n¿Deseas realizar otra operación? (s/n): ");
            char respuesta = entrada.next().toLowerCase().charAt(0);
            if (respuesta != 's') {
                continuar = false;
                System.out.println("Programa finalizado. ¡Gracias!");
            }
        }
        entrada.close();
    }
}