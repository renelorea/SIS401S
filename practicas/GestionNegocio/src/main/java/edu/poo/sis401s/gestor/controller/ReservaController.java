/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.controller;

/**
 *
 * @author yeyos
 */






import edu.poo.gestionnegocio.model.Reserva;
import edu.poo.gestionnegocio.services.ReservaService;
import java.util.List;

public class ReservaController {
    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    public void agregarReserva(Reserva r) {
        service.agregarReserva(r);
    }

    public List<Reserva> listarReservas() {
        return service.listarReservas();
    }

    // ✅ ahora sí guarda historial
    public void cambiarEstatus(String codigo, String nuevo, String usuario) {
        service.cambiarEstatus(codigo, nuevo, usuario);
    }

    // ✅ ahora sí guarda historial
    public void actualizarComentario(String codigo, String comentario, String usuario) {
        service.actualizarComentario(codigo, comentario, usuario);
    }
}
