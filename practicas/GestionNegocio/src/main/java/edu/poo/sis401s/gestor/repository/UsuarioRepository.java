/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;

/**
 *
 * @author Hp
 */
import edu.poo.sis401s.gestor.model.Usuario;
import java.util.HashMap;

public class UsuarioRepository {
    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public UsuarioRepository() {
        // Usuarios de prueba
        usuarios.put("admin", new Usuario(1, "admin", "1234", "admin"));
        usuarios.put("empleado", new Usuario(2, "empleado", "abcd", "empleado"));
        usuarios.put("cliente", new Usuario(3, "cliente", "pass", "cliente"));
    }

    public Usuario buscarPorUsername(String username) {
        return usuarios.get(username);
    }
}

