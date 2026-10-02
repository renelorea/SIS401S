package edu.poo.sis401s.gestor.model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Aqui se encuentran los getters y setters
    // Su funcion es asignarle valores a las variables de la clase Producto
    // Por favor no le muevan a esta parte del codigo ya que con esto se van a identificar los productos y si utilizaran alguna variable, anotenla justo como se encuentra anotada aqui
    

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

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre='" + nombre + '\'' + ", precio=" + precio + ", stock=" + stock +'}';
    }
}
