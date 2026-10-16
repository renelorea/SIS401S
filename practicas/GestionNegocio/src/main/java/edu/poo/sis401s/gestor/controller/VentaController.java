/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;
 import edu.poo.sis401s.gestor.model.Venta;
import edu.poo.sis401s.gestor.services.VentaService;
import java.util.List;   
/**
 *
 * @author lobog
 */
public class VentaController {
    private final VentaService service;

    public VentaController() {
        service = new VentaService();
    }

    public boolean registrarVenta(Venta venta) {
        return service.registrarVenta(venta);
    }

    public List<Venta> buscarTodas() {
        return service.buscarTodas();
    }

    public int contarVentas() {
        return service.contarVentas();
    }

    public double calcularTotal() {
        return service.calcularTotal();
    }
    
}
