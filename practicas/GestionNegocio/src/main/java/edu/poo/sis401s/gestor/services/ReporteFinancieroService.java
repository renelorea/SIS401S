/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.ReporteFinanciero;
import edu.poo.sis401s.gestor.model.Venta;
import edu.poo.sis401s.gestor.repository.ReporteFinancieroRepository;
import java.util.ArrayList;

/**
 *
 * @author lobog
 */
public class ReporteFinancieroService {
    
     private ArrayList<Venta> ventas;
     
     ReporteFinancieroRepository repository = new ReporteFinancieroRepository();
    public ReporteFinancieroService(){
        ventas = new ArrayList<>();
    }
    public void agregarVenta(Venta venta){
        ventas.add(venta);
    }
    public double calcularTotal(){
        double total = 0;
        for (Venta venta : ventas){
        total += venta.getCantidad()* venta.getPrecio();
        }
        return total;
    }
    
    public ReporteFinanciero buscarTodos(){
        return repository.findAll();
    }
    
}
