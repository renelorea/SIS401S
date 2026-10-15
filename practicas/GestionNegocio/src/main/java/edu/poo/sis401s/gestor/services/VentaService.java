/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;
import edu.poo.sis401s.gestor.model.Venta;
import edu.poo.sis401s.gestor.repository.VentaRepository;
import java.util.List;
/**
 *
 * @author lobog
 */
public class VentaService {
    private final VentaRepository repository;

    public VentaService() {
        repository = new VentaRepository();
    }

    public boolean registrarVenta(Venta venta) {
        if (venta == null) {
            return false;
        }

        if (venta.getProducto() == null
                || venta.getProducto().trim().isEmpty()) {
            return false;
        }

        if (venta.getCantidad() <= 0 || venta.getPrecio() <= 0) {
            return false;
        }

        if (venta.getFecha() == null
                || venta.getFecha().trim().isEmpty()) {
            return false;
        }

        return repository.guardar(venta);
    }

    public List<Venta> buscarTodas() {
        return repository.findAll();
    }

    public int contarVentas() {
        return repository.contarVentas();
    }

    public double calcularTotal() {
        return repository.calcularTotal();
    }
    
}
