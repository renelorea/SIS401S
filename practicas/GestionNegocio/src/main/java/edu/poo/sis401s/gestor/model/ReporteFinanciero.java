/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
    public double calcularUnidades(){
        int unidades = 0;
        for (Venta venta : ventas){
          unidades += venta.getCantidad();  
        }
        return unidades;
                }
    public int buscarPorProducto(String producto){
        int unidades = 0;
        for(Venta venta : ventas){
            if(venta.getProducto().equalsIgnoreCase(producto)){
                unidades += venta.getCantidad();
            }
        }
        return unidades;
    }
    public double buscarTotalPorFecha(String fecha){
            double total = 0;
            for (Venta venta : ventas){
                if (venta.getFecha().equalsIgnoreCase(fecha)){
                    total += venta.getCantidad()*venta.getPrecio();
                }
            }
            return total;
    }
    public int contarVentasPorFecha(String fecha){
        int cantidad = 0;
        for(Venta venta : ventas){
            if(venta.getFecha().equalsIgnoreCase(fecha)){
                cantidad++;
            }
        }
        return cantidad;
    }
    public String buscarProductoMasVendido(){
        Map<String, Integer> ventasPorProducto = new HashMap<>();
        for(Venta venta : ventas){
            String producto = venta.getProducto();
            int unidades = venta.getCantidad();
            ventasPorProducto.put(producto, ventasPorProducto.getOrDefault(producto, 0)+ unidades);
            
        }
String productoMayor = "Sin ventas";
int unidadesMayores = 0;
for(Map.Entry<String, Integer> entrada : ventasPorProducto.entrySet()){
    if(entrada.getValue()> unidadesMayores){
        unidadesMayores = entrada.getValue();
        productoMayor = entrada.getKey();
    }
}
return productoMayor;
    }
    public String buscarProductoMayorIngreso(){
        Map<String, Double> ingresosPorProducto = new HashMap<>();
        for (Venta venta : ventas){
            String producto = venta.getProducto();
            double ingreso = venta.getCantidad()*venta.getPrecio();
            ingresosPorProducto.put(producto, ingresosPorProducto.getOrDefault(producto, 0.0)+ingreso);
        }
        String productoMayor = "Sin ventas";
        double ingresoMayor = 0;
        for(Map.Entry<String, Double> entrada : ingresosPorProducto.entrySet()){
            if(entrada.getValue()>ingresoMayor){
                ingresoMayor = entrada.getValue();
                productoMayor = entrada.getKey();
            }
        }
        return productoMayor;
    }
    public double buscarIngresoPorProducto(String producto){
        double ingresoTotal = 0;
        for(Venta venta : ventas){
            if(venta.getProducto().equalsIgnoreCase(producto)){
                ingresoTotal += venta.getCantidad()*venta.getPrecio();
            }
        }
        return ingresoTotal;
    }
    public int contarVentasSobreLimite(double limite){
        int cantidad = 0;
        for(Venta venta : ventas){
            double importe = venta.getCantidad()*venta.getPrecio();
            if(importe > limite){
                cantidad ++;
            }
        }
        return cantidad;
    }
    public int contarVentasBajoLimite(double limite){
        int cantidad = 0;
        for(Venta venta : ventas){
            double importe = venta.getCantidad()*venta.getPrecio();
            if (importe > limite){
                cantidad++;
            }
        }
        return cantidad;
    }
    public double calcularPromedioVenta(){
        if(ventas.isEmpty()){
            return 0;
        }
        double total = 0;
        for(Venta venta: ventas){
            total +=venta.getCantidad()*venta.getPrecio();
        }
        return total/ventas.size();
    }
    public int calcularVentasMuyPorEncimaDelPromedio(double factor){
    double promedio = calcularPromedioVenta();
    if(promedio == 0 || factor <= 1){
    return 0;
}
    int cantidad = 0;
    for(Venta venta : ventas){
    double importe = venta.getCantidad()*venta.getPrecio();
    if (importe > promedio*factor){
    cantidad++;
}
    }
    return cantidad;
}
    public int contarVentasSobrePromedio(){
        double promedio = calcularPromedioVenta();
        int cantidad = 0;
        for(Venta venta: ventas){
            double importe = venta.getCantidad()*venta.getPrecio();
            if(importe > promedio){
                cantidad++;
            }
        }
        return cantidad;
    }
    public double calcularDiferenciaIngresos(double ingresoActual, double ingresoAnterior){
        return ingresoActual - ingresoAnterior;
    }
    public double calcularVariacionPorcentual(double ingresoActual, double ingresoAnterior){
        if (ingresoAnterior == 0){
            return  0;
        }
        return ((ingresoActual - ingresoAnterior) / ingresoAnterior)*100;
    }
    
    public double compararIngresosPorFecha(String fechaActual, String fechaAnterior){
        double ingresoActual = buscarTotalPorFecha(fechaActual);
        double ingresoAnterior = buscarTotalPorFecha(fechaAnterior);
        return calcularDiferenciaIngresos(ingresoActual, ingresoAnterior);
    }
    public double calcularVariacionPorcentualPorFecha(String fechaActual, String fechaAnterior){
        double ingresoActual = buscarTotalPorFecha(fechaActual);
        double ingresoAnterior = buscarTotalPorFecha(fechaAnterior);
        return calcularVariacionPorcentual(ingresoActual, ingresoAnterior);
    }
}

