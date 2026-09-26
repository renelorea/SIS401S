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
import java.util.Scanner;

public class LoginView {
    private LoginController controller;

    public LoginView(LoginController controller) {
        this.controller = controller;
    }

    public Usuario mostrarLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Usuario: ");
        String username = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();

        Usuario u = controller.login(username, password);
        if (u != null) {
            System.out.println("Login exitoso. Rol: " + u.getRol());
            return u;
        } else {
            System.out.println("Credenciales incorrectas.");
        }
        return null;
    }
}

