package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.model.Encuesta;
import edu.poo.sis401s.gestor.repository.EncuestaRepository;
import java.util.List;

/**
 * Reglas de negocio de las encuestas. Las validaciones lanzan
 * IllegalArgumentException con un mensaje listo para mostrar al usuario.
 */
public class EncuestaService {
    private final EncuestaRepository encuestaRepository;
    private final ClienteService clienteService;

    public EncuestaService() {
        this(new ClienteService());
    }

    public EncuestaService(ClienteService clienteService) {
        this.encuestaRepository = new EncuestaRepository();
        this.clienteService = clienteService;
    }

    public Encuesta registrarEncuesta(int idCliente, int calificacion, String comentario) {
        Cliente cliente = clienteService.buscarCliente(idCliente);
        if (cliente == null) {
            throw new IllegalArgumentException("No existe un cliente con ID " + idCliente + ".");
        }
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        if (comentario == null || comentario.isBlank()) {
            throw new IllegalArgumentException("El comentario no puede estar vacío.");
        }
        Encuesta encuesta = new Encuesta(encuestaRepository.generarId(), cliente,
                calificacion, comentario.trim());
        encuestaRepository.guardar(encuesta);
        return encuesta;
    }

    public List<Encuesta> listarEncuestas() {
        return encuestaRepository.obtenerTodas();
    }

    public List<Cliente> listarClientes() {
        return clienteService.listarTodosLosClientes();
    }

    public boolean eliminarEncuesta(int id) {
        return encuestaRepository.eliminar(id);
    }

    public double calcularPromedio() {
        List<Encuesta> todas = encuestaRepository.obtenerTodas();
        if (todas.isEmpty()) {
            return 0;
        }
        int suma = 0;
        for (Encuesta e : todas) {
            suma += e.getCalificacion();
        }
        return (double) suma / todas.size();
    }
}
