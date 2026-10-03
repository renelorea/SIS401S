/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class ReporteFinanciero {
     private ArrayList<Venta> ventas;
    public ReporteFinanciero(){
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
}

