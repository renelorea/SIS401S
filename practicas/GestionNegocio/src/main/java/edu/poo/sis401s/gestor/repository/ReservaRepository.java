/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.repository;

/**
 *
 * @author yeyos
 */


import edu.poo.gestionnegocio.model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {
    private final List<Reserva> reservas = new ArrayList<>();

    // Agregar reserva
    public void agregar(Reserva r) {
        reservas.add(r);
    }

    // Listar todas las reservas
    public List<Reserva> listar() {
        return reservas;
    }
}

