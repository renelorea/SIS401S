/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.Producto;
import edu.poo.sis401s.gestor.model.Reserva;
import edu.poo.sis401s.gestor.repository.ProductoRepository;
import edu.poo.sis401s.gestor.repository.ReservaRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {

    private final ReservaRepository repo;
    private final ProductoRepository productoRepo = new ProductoRepository();
    private final List<String> historial = new ArrayList<>();

    public ReservaService(ReservaRepository repo) {
        this.repo = repo;
    }

    // AGREGAR RESERVA
    public void agregarReserva(Reserva r) {
        repo.agregar(r);
    }

    // LISTAR RESERVAS
    public List<Reserva> listarReservas() {
        return repo.listar();
    }

    // BUSCAR POR CÓDIGO
    public Reserva buscarPorCodigo(String codigo) {
        return repo.listar().stream()
                .filter(r -> r.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    // GENERAR RESERVAS AUTOMÁTICAS POR STOCK BAJO
    public void verificarInventario() {

        for (Producto p : productoRepo.listarTodos()) {

            if (p.getStock() < 10) {

                boolean existe = repo.listar().stream()
                        .anyMatch(r ->
                                r.getServicio().equalsIgnoreCase(p.getNombre()));

                if (!existe) {

                    Reserva reserva = new Reserva(
        "R-" + (repo.listar().size() + 1),
        "Automático",
        "Pendiente"
);

reserva.setServicio("Reposición automática");

                    reserva.setServicio(p.getNombre());
                    
                    reserva.setFecha(LocalDateTime.now());
                    reserva.setPrioridad("Alta");

                    reserva.setComentarios(
                            "Reserva automática generada porque el stock es menor a 10. Stock actual: "
                                    + p.getStock()
                    );

                    repo.agregar(reserva);

                    historial.add(
                            "[" + LocalDateTime.now() + "] "
                                    + "Reserva automática creada para "
                                    + p.getNombre()
                                    + " (Stock: "
                                    + p.getStock()
                                    + ")"
                    );
                }
            }
        }
    }

    // CAMBIAR ESTATUS
    public void cambiarEstatus(String codigo,
                               String nuevo,
                               String usuario) {

        Reserva reserva = buscarPorCodigo(codigo);

        if (reserva != null) {

            String anterior = reserva.getEstatus();

            reserva.setEstatus(nuevo);

            historial.add(
                    "[" + LocalDateTime.now() + "] "
                            + usuario
                            + " cambió ESTATUS de '"
                            + anterior
                            + "' a '"
                            + nuevo
                            + "' en reserva "
                            + codigo
            );
        }
    }

    // ACTUALIZAR COMENTARIO
    public void actualizarComentario(String codigo,
                                     String comentario,
                                     String usuario) {

        Reserva reserva = buscarPorCodigo(codigo);

        if (reserva != null) {

            String anterior = reserva.getComentarios();

            reserva.setComentarios(comentario);

            historial.add(
                    "[" + LocalDateTime.now() + "] "
                            + usuario
                            + " cambió COMENTARIO de '"
                            + anterior
                            + "' a '"
                            + comentario
                            + "' en reserva "
                            + codigo
            );
        }
    }

    // LISTAR HISTORIAL
    public List<String> listarHistorial() {
        return historial;
    }

    // EXPORTAR HISTORIAL
    public void exportarHistorialTxt(String rutaArchivo) {

        try (FileWriter writer = new FileWriter(rutaArchivo)) {

            for (String h : historial) {
                writer.write(h + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // EXPORTAR RESERVAS
    public void exportarReservasTxt(String rutaArchivo) {

        try (FileWriter writer = new FileWriter(rutaArchivo)) {

            for (Reserva r : repo.listar()) {

                writer.write(
                        r.getCodigo() + " | "
                                + r.getPersona() + " | "
                                + r.getServicio() + " | "
                                + r.getCantidad() + " | "
                                + r.getPrecio() + " | "
                                + r.getFecha() + " | "
                                + r.getPrioridad() + " | "
                                + r.getEstatus() + " | "
                                + r.getComentarios()
                                + System.lineSeparator()
                );
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // BUSCAR POR NOMBRE
    public List<Reserva> buscarPorNombre(String nombre) {

        return repo.listar().stream()
                .filter(r ->
                        r.getPersona().toLowerCase()
                                .contains(nombre.toLowerCase()))
                .toList();
    }

    // BUSCAR POR ESTATUS
    public List<Reserva> buscarPorEstatus(String estatus) {

        return repo.listar().stream()
                .filter(r ->
                        r.getEstatus().equalsIgnoreCase(estatus))
                .toList();
    }

    // BUSCAR POR PRIORIDAD
    public List<Reserva> buscarPorPrioridad(String prioridad) {

        return repo.listar().stream()
                .filter(r ->
                        r.getPrioridad().equalsIgnoreCase(prioridad))
                .toList();
    }
}