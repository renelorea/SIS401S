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
    
}
