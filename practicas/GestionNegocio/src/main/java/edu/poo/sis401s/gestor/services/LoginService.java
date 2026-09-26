/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.Usuario;
import edu.poo.sis401s.gestor.repository.UsuarioRepository;

/**
 *
 * @author Hp
 */
public class LoginService {
    private UsuarioRepository repo;

    public LoginService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public Usuario autenticar(String username, String password) {
        Usuario u = repo.buscarPorUsername(username);
        if (u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }
}


