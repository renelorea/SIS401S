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
    public int buscarPorProducto(String producto){
        ReporteFinanciero reporte = buscarTodos();
        return reporte.buscarPorProducto(producto);
    }
    public double buscarTotalPorFecha(String fecha){
        ReporteFinanciero reporte = buscarTodos();
        return reporte.buscarTotalPorFecha(fecha);
    }
    public int contarVentasPorFecha(String fecha){
        ReporteFinanciero reporte = buscarTodos();
        return reporte.contarVentasPorFecha(fecha);
    }
    public String buscarProductoMasVendido(){
        ReporteFinanciero reporte = buscarTodos();
        return reporte.buscarProductoMasVendido();
    }
    public String buscarProductoMayorIngreso(){
        ReporteFinanciero reporte = buscarTodos();
        return reporte.buscarProductoMayorIngreso();
    }
 public double buscarIngresoPorProducto(String producto){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.buscarIngresoPorProducto(producto);
 }
 public int contarVentasSobreLimite(double limite){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.contarVentasSobreLimite(limite);
 }
 public int contarVentasBajoLimite(double limite){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.contarVentasBajoLimite(limite);
 }
 public int calcularVentasMuyPorEncimaDelPromedio(double factor){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.calcularVentasMuyPorEncimaDelPromedio(factor);
 }
 public double calcularPromedioVenta(){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.calcularPromedioVenta();
 }
 public int contarVentasSobrePromedio(){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.contarVentasSobrePromedio();
 }
 public double calcularDifereciaIngresos(double ingresoAcutal, double ingresoAnterior){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.calcularDiferenciaIngresos(ingresoAcutal, ingresoAnterior);
 }
 public double calcularVariacionPorcentual(double ingresoActual, double ingresoAnterior){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.calcularVariacionPorcentual(ingresoActual, ingresoAnterior);
 }
 public double compararIngresosPorFecha(String fechaActual, String fechaAnterior){
     ReporteFinanciero reporte = buscarTodos();
     return reporte.compararIngresosPorFecha(fechaActual, fechaAnterior);
 }
     public double calcularVariacionPorcentualPorFecha(String fechaActual, String fechaAnterior){
         ReporteFinanciero reporte = buscarTodos();
         return reporte.calcularVariacionPorcentualPorFecha(fechaActual, fechaAnterior);
     }

}
