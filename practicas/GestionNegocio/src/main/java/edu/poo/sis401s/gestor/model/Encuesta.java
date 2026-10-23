/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author Hp
 */
public class Encuesta {
    private int id;
    private Cliente cliente;
    private int calificacion; // 1 a 5
    private String comentario;

    public Encuesta(int id, Cliente cliente, int calificacion, String comentario) {
        this.id = id;
        this.cliente = cliente;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }
// Getters
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCalificacion(int calificacion) {
        if (calificacion >= 1 && calificacion <= 5) {
            this.calificacion = calificacion;
        } else {
            System.out.println("⚠️ La calificación debe estar entre 1 y 5.");
        }
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
 
