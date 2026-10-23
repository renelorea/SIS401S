package edu.poo.sis401s.gestor.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Utilidad para leer datos por consola. Usa un único Scanner compartido por
 * todas las vistas de texto, para no tener varios Scanner sobre System.in.
 */
final class ConsolaUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsolaUtil() {
    }

    /** Lee una línea y le quita los espacios de los extremos. */
    static String leerTexto(String mensaje) {
        return leerLinea(mensaje).trim();
    }

    /** Lee una línea tal cual se escribió (para contraseñas, no se recorta). */
    static String leerClave(String mensaje) {
        return leerLinea(mensaje);
    }

    /** Pide un entero y repite la pregunta hasta que esté entre min y max. */
    static int leerEntero(String mensaje, int min, int max) {
        while (true) {
            String texto = leerTexto(mensaje);
            try {
                int valor = Integer.parseInt(texto);
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Ingresa un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private static String leerLinea(String mensaje) {
        System.out.print(mensaje);
        try {
            return SCANNER.nextLine();
        } catch (NoSuchElementException e) {
            // Se cerró la entrada (por ejemplo Ctrl+D): salimos sin mostrar errores.
            System.out.println("\nEntrada finalizada. Saliendo del sistema...");
            System.exit(0);
            return "";
        }
    }
}
