/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.model;

/**
 *
 * @author Hp
 */
public class ReporteFinanciero {
    private int id;
    private double ingresos;
    private double egresos;

    public ReporteFinanciero(int id, double ingresos, double egresos) {
        this.id = id;
        this.ingresos = ingresos;
        this.egresos = egresos;
    }

    public double getBalance() {
        return ingresos - egresos;
    }

    // Getters y setters
}

