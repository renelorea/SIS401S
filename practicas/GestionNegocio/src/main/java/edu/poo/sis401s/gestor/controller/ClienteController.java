/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;
import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.services.ClienteService;
import java.util.List;
/**
 *
 * @author arman
 */
public class ClienteController {
    private ClienteService clienteService;
    public ClienteController() {
        this.clienteService = new ClienteService();
    }
    public boolean registrarCliente(int id, String nombre, String correo, String telefono) {
        Cliente nuevoCliente = new Cliente(id, nombre, correo, telefono);
        return clienteService.registrarNuevoCliente(nuevoCliente);
        
    }
    public List<Cliente> obtenerListaClientes() {
        return clienteService.listarTodosLosClientes();
    }
    public Cliente buscarClientePorId(int id) {
        return clienteService.buscarCliente(id);
    }
}
