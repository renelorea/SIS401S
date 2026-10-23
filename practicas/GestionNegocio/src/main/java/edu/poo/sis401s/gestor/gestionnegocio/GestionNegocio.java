/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.poo.sis401s.gestor.gestionnegocio;

import edu.poo.sis401s.gestor.controller.LoginController;
import edu.poo.sis401s.gestor.model.Usuario;
import edu.poo.sis401s.gestor.repository.UsuarioRepository;
import edu.poo.sis401s.gestor.services.LoginService;
import edu.poo.sis401s.gestor.view.LoginView;
import edu.poo.sis401s.gestor.view.MainMenu;

public class GestionNegocio {

    public static void main(String[] args) {

        UsuarioRepository repo = new UsuarioRepository();
        LoginService service = new LoginService(repo);
        LoginController controller = new LoginController(service);

        while (true) {

            LoginView view = new LoginView(controller);
            Usuario u = view.mostrarLogin();

            if (u == null) {
                System.out.println("Programa finalizado.");
                break;
            }

            MainMenu menu = new MainMenu(u);
            menu.mostrarMenu();

            System.out.println("\nRegresando al inicio de sesión...");
        }
    }
}


