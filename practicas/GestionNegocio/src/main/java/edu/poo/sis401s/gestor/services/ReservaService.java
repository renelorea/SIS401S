/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.service;

/**
 *
 * @author yeyos
 */


import edu.poo.gestionnegocio.model.Reserva;
import edu.poo.gestionnegocio.repository.ReservaRepository;
import java.util.List;

public class ReservaService {
    private final ReservaRepository repo;

    public ReservaService(ReservaRepository repo) {
        this.repo = repo;
    }

    // Agregar reserva
    public void agregarReserva(Reserva r) {
        repo.agregar(r);
    }

    // Listar reservas
    public List<Reserva> listarReservas() {
        return repo.listar();
    }

    // Buscar reserva por código
    public Reserva buscarPorCodigo(String codigo) {
        return repo.listar().stream()
                   .filter(r -> r.getCodigo().equals(codigo))
                   .findFirst()
                   .orElse(null);
    }

    // Cambiar estatus
    public void cambiarEstatus(String codigo, String nuevo) {
        Reserva reserva = buscarPorCodigo(codigo);
        if (reserva != null) {
            reserva.setEstatus(nuevo);
        }
    }

    // Actualizar comentario
    public void actualizarComentario(String codigo, String comentario) {
        Reserva reserva = buscarPorCodigo(codigo);
        if (reserva != null) {
            reserva.setComentarios(comentario);
        }
    }
}