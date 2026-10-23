/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;

import edu.poo.sis401s.gestor.model.Usuario;
import edu.poo.sis401s.gestor.services.LoginService;

/**
 *
 * @author Hp
 */
public class LoginController {
    private LoginService service;

    public LoginController(LoginService service) {
        this.service = service;
    }

    public Usuario login(String username, String password) {
        return service.autenticar(username, password);
    }
}

