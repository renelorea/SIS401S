package edu.poo.sis401s.gestor.model;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;

     }

    public String getProductos() {
        return productos;

    }

    public void setProductos(String productos) {
        thisproductos = productos

    }

    public int getFecha() {
        return fecha

    }

    public void setFecha(int fecha) {
        this.fecha = fecha

    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", cliente='" + cliente + '\'' + ", productos=" + productos + ", fecha=" + fecha +'}';
    }


}

    

