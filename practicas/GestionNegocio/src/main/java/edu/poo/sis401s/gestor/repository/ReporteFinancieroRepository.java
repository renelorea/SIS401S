/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.ReporteFinanciero;
import edu.poo.sis401s.gestor.model.Venta;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lobog
 */
public class ReporteFinancieroRepository {
      
    public ReporteFinanciero findAll(){
    ReporteFinanciero reporte = new ReporteFinanciero();
        Venta venta1 = new Venta("producto A", 3, 500, "1/Octubre/2026");
         Venta venta2 = new Venta("producto B", 4, 800, "1/Octubre/2026");
          Venta venta3 = new Venta("producto C", 10, 1500, "2/Octubre/2026");
          Venta venta4 = new Venta("producto A", 5, 500, "2/octubre/2026");
          reporte.agregarVenta(venta1);
          reporte.agregarVenta(venta2);
          reporte.agregarVenta(venta3);
          reporte.agregarVenta(venta4);
          System.out.println("Total vendido: $"+ reporte.calcularTotal());
          return reporte;
            
    }
          
    
}
