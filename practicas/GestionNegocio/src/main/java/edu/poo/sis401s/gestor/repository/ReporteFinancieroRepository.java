/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.ReporteFinanciero;
import edu.poo.sis401s.gestor.model.Venta;

public class ReporteFinancieroRepository {

    private final VentaRepository ventaRepository = new VentaRepository();

    public ReporteFinanciero findAll() {
        ReporteFinanciero reporte = new ReporteFinanciero();

        for (Venta venta : ventaRepository.findAll()) {
            reporte.agregarVenta(venta);
        }

        return reporte;
    }
}