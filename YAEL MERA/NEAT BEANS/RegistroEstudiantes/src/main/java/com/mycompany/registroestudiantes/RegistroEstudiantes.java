package com.mycompany.registroestudiantes;

import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiantes {
    
    private static ArrayList<String> listaEstudiantes = new ArrayList<>();
    private static ArrayList<Boolean> asistencia = new ArrayList<>();
    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n=====  REGISTRO DE ESTUDIANTES — PASE DE LISTA =====");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Ver lista completa");
            System.out.println("3. Marcar asistencia");
            System.out.println("4. Ver pase de lista");
            System.out.println("5. Eliminar estudiante");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1 -> agregarEstudiante();
                case 2 -> mostrarLista();
                case 3 -> marcarAsistencia();
                case 4 -> mostrarPaseLista();
                case 5 -> eliminarEstudiante();
                case 0 -> System.out.println(" Saliendo del sistema...");
                default -> System.out.println(" Opción no válida, intenta de nuevo.");
            }
        } while (opcion != 0);
    }

   
    private static void agregarEstudiante() {
        System.out.print("Escribe el nombre del estudiante: ");
        String nombre = teclado.nextLine();
        listaEstudiantes.add(nombre);
        asistencia.add(false);
        System.out.println(" Estudiante agregado correctamente!");
    }

    
    private static void mostrarLista() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println(" La lista está vacía.");
            return;
        }
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            System.out.println((i+1) + ". " + listaEstudiantes.get(i));
        }
    }

    
    private static void marcarAsistencia() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println(" No hay estudiantes registrados.");
            return;
        }
        mostrarLista();
        System.out.print("Número del estudiante: ");
        int num = teclado.nextInt();
        teclado.nextLine();

        if (num < 1 || num > listaEstudiantes.size()) {
            System.out.println(" Número inválido.");
            return;
        }

        System.out.print("¿Asistió? (s = Sí / n = No): ");
        String resp = teclado.nextLine().trim().toLowerCase();
        asistencia.set(num - 1, resp.equals("s"));
        System.out.println(" Asistencia registrada!");
    }

    
    private static void mostrarPaseLista() {
        if (listaEstudiantes.isEmpty()) {
            System.out.println(" La lista está vacía.");
            return;
        }
        System.out.println("\n===== PASE DE LISTA =====");
        int presentes = 0;
        for (int i = 0; i < listaEstudiantes.size(); i++) {
            String estado = asistencia.get(i) ? "✅ PRESENTE" : "❌ AUSENTE";
            System.out.println((i+1) + ". " + listaEstudiantes.get(i) + " — " + estado);
            if (asistencia.get(i)) presentes++;
        }
        System.out.println("--------------------------");
        System.out.println("Total: " + listaEstudiantes.size() + 
                           " | Presentes: " + presentes + 
                           " | Ausentes: " + (listaEstudiantes.size() - presentes));
    }

   
    private static void eliminarEstudiante() {
        mostrarLista();
        if (listaEstudiantes.isEmpty()) return;
        
        System.out.print("Número a eliminar: ");
        int num = teclado.nextInt();
        teclado.nextLine();

        if (num < 1 || num > listaEstudiantes.size()) {
            System.out.println(" Número inválido.");
            return;
        }
        listaEstudiantes.remove(num - 1);
        asistencia.remove(num - 1);
        System.out.println(" Estudiante eliminado.");
    }
}
