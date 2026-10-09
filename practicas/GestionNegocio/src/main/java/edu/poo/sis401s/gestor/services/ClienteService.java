/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;
import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.repository.ClienteRepository;
import java.util.List;
/**
 *
 * @author arman
 */
public class ClienteService {
    private ClienteRepository clienteRepository;
    public ClienteService() {
        this.clienteRepository = new ClienteRepository();
    }
    public boolean registrarNuevoCliente(Cliente nuevoCliente) {
        if (!nuevoCliente.getCorreo().contains("@") || !nuevoCliente.getCorreo().contains(".")) {
            System.out.println("Error: El correo no tiene un formato válido.");
            return false;
        }
        if (nuevoCliente.getTelefono().length() < 10) {
            System.out.println("Error: El teléfono debe tener al menos 10 dígitos.");
            return false;
        }
        return clienteRepository.guardar(nuevoCliente);
    }
    public List<Cliente> listarTodosLosClientes() {
        return clienteRepository.obtenerTodos();
    }
    public Cliente buscarCliente(int id) {
        return clienteRepository.buscarPorId(id);
    }
}
