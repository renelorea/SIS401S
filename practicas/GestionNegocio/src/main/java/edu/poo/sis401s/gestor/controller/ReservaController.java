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
import edu.poo.gestionnegocio.service.ReservaService;
import java.util.List;

public class ReservaController {   // <-- aquí está el cambio
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

    public void cambiarEstatus(String codigo, String nuevo) {
        for (Reserva r : service.listarReservas()) {
            if (r.getCodigo().equals(codigo)) {
                r.setEstatus(nuevo);
            }
        }
    }

    public void actualizarComentario(String codigo, String comentario) {
        Reserva reserva = service.buscarPorCodigo(codigo);
        if (reserva != null) {
            reserva.setComentarios(comentario);
        }
    }
}


