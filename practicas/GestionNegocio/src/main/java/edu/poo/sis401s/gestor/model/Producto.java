/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;
    private String categoria;
    private String ubicacionPasillo;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = "General";
        this.ubicacionPasillo = "No Asignado";
    }
    public Producto(int id, String nombre, double precio, int stock, String categoria, String ubicacionPasillo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
        this.ubicacionPasillo = ubicacionPasillo;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUbicacionPasillo() {
        return ubicacionPasillo;
    }

    public void setUbicacionPasillo(String ubicacionPasillo) {
        this.ubicacionPasillo = ubicacionPasillo;
    }
}

