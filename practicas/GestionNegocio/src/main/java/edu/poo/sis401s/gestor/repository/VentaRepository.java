/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;
import edu.poo.sis401s.gestor.model.Venta;
import java.util.ArrayList;
import java.util.List;

public class VentaRepository {

    private static final List<Venta> ventas = new ArrayList<>();

    public boolean guardar(Venta venta) {
        if (venta == null) {
            return false;
        }

        ventas.add(venta);
        return true;
    }

    public List<Venta> findAll() {
        return new ArrayList<>(ventas);
    }

    public int contarVentas() {
        return ventas.size();
    }

    public double calcularTotal() {
        double total = 0;

        for (Venta venta : ventas) {
            total += venta.getCantidad() * venta.getPrecio();
        }

        return total;
    }
}