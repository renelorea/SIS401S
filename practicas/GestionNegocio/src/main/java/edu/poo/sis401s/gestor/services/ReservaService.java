/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.gestionnegocio.services;

import edu.poo.gestionnegocio.model.Reserva;
import edu.poo.gestionnegocio.repository.ReservaRepository;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class ReservaService {
    private final ReservaRepository repo;
    private final List<String> historial = new ArrayList<>();

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

    // Cambiar estatus con historial
    public void cambiarEstatus(String codigo, String nuevo, String usuario) {
        Reserva reserva = buscarPorCodigo(codigo);
        if (reserva != null) {
            String anterior = reserva.getEstatus();
            reserva.setEstatus(nuevo);
            historial.add("[" + java.time.LocalDateTime.now() + "] "
                + usuario + " cambió ESTATUS de '" + anterior + "' a '" + nuevo
                + "' en reserva " + codigo);
        }
    }

    // Actualizar comentario con historial
    public void actualizarComentario(String codigo, String comentario, String usuario) {
        Reserva reserva = buscarPorCodigo(codigo);
        if (reserva != null) {
            String anterior = reserva.getComentarios();
            reserva.setComentarios(comentario);
            historial.add("[" + java.time.LocalDateTime.now() + "] "
                + usuario + " cambió COMENTARIO de '" + anterior + "' a '" + comentario
                + "' en reserva " + codigo);
        }
    }

    // Listar historial
    public List<String> listarHistorial() {
        return historial;
    }

    // Exportar historial a archivo .txt
    public void exportarHistorialTxt(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (String h : historial) {
                writer.write(h + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Exportar reservas a archivo .txt
    public void exportarReservasTxt(String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            for (Reserva r : repo.listar()) {
                writer.write(r.getCodigo() + " | "
                    + r.getPersona() + " | "
                    + r.getServicio() + " | "
                    + r.getCantidad() + " | "
                    + r.getPrecio() + " | "
                    + r.getFecha() + " | "
                    + r.getPrioridad() + " | "
                    + r.getEstatus() + " | "
                    + r.getComentarios()
                    + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --- Filtros de búsqueda ---
    public List<Reserva> buscarPorNombre(String nombre) {
        return repo.listar().stream()
            .filter(r -> r.getPersona().toLowerCase().contains(nombre.toLowerCase()))
            .toList();
    }

    public List<Reserva> buscarPorEstatus(String estatus) {
        return repo.listar().stream()
            .filter(r -> r.getEstatus().equalsIgnoreCase(estatus))
            .toList();
    }

    public List<Reserva> buscarPorPrioridad(String prioridad) {
        return repo.listar().stream()
            .filter(r -> r.getPrioridad().equalsIgnoreCase(prioridad))
            .toList();
    }
}


