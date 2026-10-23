/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author lobog
 */
public class Venta {
    private String producto;
    private int cantidad;
    private double precio;
    private String fecha;
    
    public Venta(String producto,int cantidad,double precio,String fecha){
     this.producto = producto;
     this.cantidad = cantidad;
     this.precio = precio;
     this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }
    
}
