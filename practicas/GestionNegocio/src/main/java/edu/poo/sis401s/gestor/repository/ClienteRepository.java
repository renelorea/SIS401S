/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author arman
 */
public class ClienteRepository {
    private List<Cliente> listaClientes;
    public ClienteRepository() {
        this.listaClientes = new ArrayList<>();
        guardar(new Cliente(1, "A", "A@gmail.com", "5512345678"));
        guardar(new Cliente(2, "B", "B@hotmail.com", "5587654321"));
        guardar(new Cliente(3, "C", "C@C.com", "5599887766", "Empresa", LocalDate.now().minusDays(5)));
        guardar(new Cliente(4, "D", "D@D.com", "5544332211", "Empresa", LocalDate.now().minusMonths(1)));
    }
    public boolean guardar(Cliente cliente) {
        if (cliente != null) {
            return listaClientes.add(cliente);
        }
        return false;
    }
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(listaClientes);
    }
    public Cliente buscarPorId(int id) {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    public boolean eliminar(int id) {
        return listaClientes.removeIf(c -> c.getId() == id);
    }
}
