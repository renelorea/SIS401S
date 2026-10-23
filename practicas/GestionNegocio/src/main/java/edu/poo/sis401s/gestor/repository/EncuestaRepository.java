package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.Encuesta;
import java.util.ArrayList;
import java.util.List;

/**
 * Almacén en memoria de las encuestas.
 */
public class EncuestaRepository {
    private final List<Encuesta> encuestas = new ArrayList<>();
    private int siguienteId = 1;

    public int generarId() {
        return siguienteId++;
    }

    public boolean guardar(Encuesta encuesta) {
        if (encuesta != null) {
            return encuestas.add(encuesta);
        }
        return false;
    }

    public List<Encuesta> obtenerTodas() {
        return new ArrayList<>(encuestas);
    }

    public Encuesta buscarPorId(int id) {
        for (Encuesta e : encuestas) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public boolean eliminar(int id) {
        return encuestas.removeIf(e -> e.getId() == id);
    }
}
