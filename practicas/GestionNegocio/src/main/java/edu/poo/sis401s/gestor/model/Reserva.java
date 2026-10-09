/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.model;

/**
 *
 * @author yeyos
 */
import java.time.LocalDateTime;

public class Reserva {
    private String codigo;            // código único
    private String persona;           // cliente
    private String servicio;          // servicio o recurso reservado
    private int cantidad;             // número entero (ej. número de lugares)
    private double precio;            // costo de la reserva
    private LocalDateTime fecha;      // fecha y hora de la reserva
    private String prioridad;         // Alta, Media, Baja
    private String estatus;           // Pendiente o Confirmada
    private String comentarios;       // texto opcional

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

   
    // Constructor simple
    public Reserva(String codigo, String persona, String estatus) {
        this.codigo = codigo;
        this.persona = persona;
        this.estatus = estatus;
        this.fecha = LocalDateTime.now();   // valor automático
        this.cantidad = 0;
        this.precio = 0.0;
        this.comentarios = "";
        this.servicio = "";
        this.prioridad = "Media";
    }
}