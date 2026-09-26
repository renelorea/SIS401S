/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

/**
 *
 * @author Hp
 */
import edu.poo.sis401s.gestor.model.Usuario;
import java.util.Scanner;

public class MainMenu {
    private Usuario usuario;

    public MainMenu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBienvenido " + usuario.getUsername() + " - Rol: " + usuario.getRol());

        switch(usuario.getRol()) {
            case "admin":
                menuAdmin(sc);
                break;
            case "empleado":
                menuEmpleado(sc);
                break;
            case "cliente":
                menuCliente(sc);
                break;
            default:
                System.out.println("Rol no reconocido.");
        }
    }

    private void menuAdmin(Scanner sc) {
        System.out.println("=== Menú Administrador ===");
        System.out.println("1. Gestionar Inventario");
        System.out.println("2. Gestionar Empleados");
        System.out.println("3. Reportes Financieros");
        System.out.println("4. Salir");
        int opcion = sc.nextInt();
        // Aquí se invocan los controladores correspondientes
    }

    private void menuEmpleado(Scanner sc) {
        System.out.println("=== Menú Empleado ===");
        System.out.println("1. Registrar Venta");
        System.out.println("2. Gestionar Pedidos");
        System.out.println("3. Consultar Inventario");
        System.out.println("4. Salir");
        int opcion = sc.nextInt();
        // Aquí se invocan los controladores correspondientes
    }

    private void menuCliente(Scanner sc) {
        System.out.println("=== Menú Cliente ===");
        System.out.println("1. Reservar Servicio");
        System.out.println("2. Responder Encuesta de Satisfacción");
        System.out.println("3. Consultar Pedidos");
        System.out.println("4. Salir");
        int opcion = sc.nextInt();
        // Aquí se invocan los controladores correspondientes
    }
}

