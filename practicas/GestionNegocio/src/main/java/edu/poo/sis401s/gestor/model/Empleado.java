/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author pao
 */
public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private String puesto;
    private double salario;
    private String telefono;
    private String direccion;
    private String fechaIngreso;
    //Agregue atributos edad, telefono, direccion y fecha de ingreso.
    public Empleado(int id, String nombre,int Edad, String puesto, double salario, String telefono, String direccion, String fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.salario = salario;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaIngreso = fechaIngreso;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    //Mostrar los datos 
    @Override
    public String toString (){
        return "ID: " + id + "Nombre: " + nombre + "Edad: " + edad + "Puesto: " + puesto + "| Salario: " + salario + "| Telefono: " + telefono + "| Direccion: " + direccion + "| Fecha de Ingreso: " + fechaIngreso;
    }
}


