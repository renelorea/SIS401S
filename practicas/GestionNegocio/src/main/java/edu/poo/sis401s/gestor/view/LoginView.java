/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

/**
 *
 * @author Hp
 */
import edu.poo.sis401s.gestor.controller.LoginController;
import edu.poo.sis401s.gestor.model.Usuario;

public class LoginView {
    private static final int MAX_INTENTOS = 3;

    private LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
    }

    public Usuario mostrarLogin() {
        System.out.println("========================================");
        System.out.println("   GESTIÓN DE NEGOCIO - INICIAR SESIÓN");
        System.out.println("========================================");

        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
            String username = ConsolaUtil.leerTexto("Usuario: ");
            String password = ConsolaUtil.leerClave("Contraseña: ");

            Usuario u = controller.login(username, password);
            if (u != null) {
                System.out.println("Login exitoso. Rol: " + u.getRol());
                return u;
            }
            System.out.println("Credenciales incorrectas. Intento "
                    + intento + " de " + MAX_INTENTOS + ".\n");
        }

        System.out.println("Demasiados intentos fallidos. Saliendo del sistema...");
        return null;
    }
}
