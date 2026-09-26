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

    // Getters y setters
}

