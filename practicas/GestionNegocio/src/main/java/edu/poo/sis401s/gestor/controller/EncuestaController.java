package edu.poo.sis401s.gestor.controller;

import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.model.Encuesta;
import edu.poo.sis401s.gestor.services.EncuestaService;
import java.util.List;

public class EncuestaController {
    private final EncuestaService encuestaService;

    public EncuestaController() {
        this.encuestaService = new EncuestaService();
    }

    public Encuesta registrarEncuesta(int idCliente, int calificacion, String comentario) {
        return encuestaService.registrarEncuesta(idCliente, calificacion, comentario);
    }

    public List<Encuesta> listarEncuestas() {
        return encuestaService.listarEncuestas();
    }

    public List<Cliente> listarClientes() {
        return encuestaService.listarClientes();
    }

    public boolean eliminarEncuesta(int id) {
        return encuestaService.eliminarEncuesta(id);
    }

    public double calcularPromedio() {
        return encuestaService.calcularPromedio();
    }
}
