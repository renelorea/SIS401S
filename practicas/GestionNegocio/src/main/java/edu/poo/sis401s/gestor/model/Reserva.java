/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author Hp
 */
import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private int id;
    private Cliente cliente;
    private LocalDate fecha;
    private LocalTime hora;
    private String servicio;

    public Reserva(int id, Cliente cliente, LocalDate fecha, LocalTime hora, String servicio) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.servicio = servicio;
    }

    // Getters y setters
}

