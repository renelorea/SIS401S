/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;

import edu.poo.sis401s.gestor.model.ReporteFinanciero;
import edu.poo.sis401s.gestor.services.ReporteFinancieroService;

/**
 *
 * @author lobog
 */
public class ReporteFinancieroController {
    
    ReporteFinancieroService service = new ReporteFinancieroService();
    
     public ReporteFinanciero buscarTodos(){
        return service.buscarTodos();
    }
     public int buscarPorProducto(String producto){
             return service.buscarPorProducto(producto);
         }
public double buscarTotalPorFecha(String fecha){
    return service.buscarTotalPorFecha(fecha);
}
public int contarVentasPorFecha(String fecha){
    return service.contarVentasPorFecha(fecha);
}
public String buscarProductoMasVendido(){
    return service.buscarProductoMasVendido();
}
public String buscarProductoMayorIngreso(){
    return service.buscarProductoMayorIngreso();
}
public double buscarIngresoPorProducto(String producto){
    return service.buscarIngresoPorProducto(producto);
}
public int contarVentasSobreProducto(double limite){
    return service.contarVentasSobreLimite(limite);
}
public double calcularPromedioVenta(){
    return service.calcularPromedioVenta();
}
public int contarVentasSobrePromedio(){
    return service.contarVentasSobrePromedio();
}
  public int contarVentasBajoLimite(double limite){
      return service.contarVentasBajoLimite(limite);
  }
public int calcularVentasMuyPorEncimaDelPromedio(double factor){
    return service.calcularVentasMuyPorEncimaDelPromedio(factor);
}  
  public double calcularDiferenciaIngresos(double ingresoActual, double ingresoAnterior){
      return service.calcularDifereciaIngresos(ingresoActual, ingresoAnterior);
  }
  public double calcularVariacionPorcentual(double ingresoActual, double ingresoAnterior){
      return service.calcularVariacionPorcentual(ingresoActual, ingresoAnterior);
  }
  public double compararIngresosPorFecha(String fechaActual, String fechaAnterior){
      return service.compararIngresosPorFecha(fechaActual, fechaAnterior);
  }
      public double calcularVariacionPorcentualPorFecha(String fechaActual, String fechaAnterior){
          return service.calcularVariacionPorcentualPorFecha(fechaActual, fechaAnterior);
      }

}
