/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author Hp
 */
import java.util.List;
import java.time.LocalDate;

public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Producto> productos;
    private LocalDate fecha;

    public Pedido(int id, Cliente cliente, List<Producto> productos, LocalDate fecha) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
    }

    // Getters y setters
}

