package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.controller.EncuestaController;
import edu.poo.sis401s.gestor.model.Cliente;
import edu.poo.sis401s.gestor.model.Encuesta;
import edu.poo.sis401s.gestor.model.Usuario;
import java.util.List;

/**
 * Menú de texto (Scanner) para el módulo de encuestas.
 */
public class EncuestaConsolaView {
    private final EncuestaController controller;
    private final Usuario usuario;

    public EncuestaConsolaView(EncuestaController controller, Usuario usuario) {
        this.controller = controller;
        this.usuario = usuario;
    }

    public void mostrar() {
        boolean esAdmin = "admin".equalsIgnoreCase(usuario.getRol());
        int opcion;
        do {
            System.out.println("\n--- ENCUESTAS ---");
            System.out.println("1. Registrar encuesta");
            System.out.println("2. Ver encuestas");
            System.out.println("3. Ver promedio de calificaciones");
            if (esAdmin) {
                System.out.println("4. Eliminar encuesta");
            }
            System.out.println("0. Volver");
            opcion = ConsolaUtil.leerEntero("Elige una opción: ", 0, esAdmin ? 4 : 3);

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> listar();
                case 3 -> mostrarPromedio();
                case 4 -> eliminar();
                default -> { }
            }
        } while (opcion != 0);
    }

    private void registrar() {
        System.out.println("\nClientes disponibles:");
        for (Cliente c : controller.listarClientes()) {
            System.out.println("  " + c.getId() + " - " + c.getNombre());
        }
        int idCliente = ConsolaUtil.leerEntero("ID del cliente: ", 1, Integer.MAX_VALUE);
        int calificacion = ConsolaUtil.leerEntero("Calificación (1 a 5): ", 1, 5);
        String comentario = ConsolaUtil.leerTexto("Comentario: ");

        try {
            Encuesta e = controller.registrarEncuesta(idCliente, calificacion, comentario);
            System.out.println("Encuesta #" + e.getId() + " registrada correctamente.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private boolean listar() {
        List<Encuesta> lista = controller.listarEncuestas();
        if (lista.isEmpty()) {
            System.out.println("No hay encuestas registradas.");
            return false;
        }
        System.out.println();
        for (Encuesta e : lista) {
            System.out.printf("#%d | %s | %d/5 | %s%n", e.getId(),
                    e.getCliente().getNombre(), e.getCalificacion(), e.getComentario());
        }
        return true;
    }

    private void mostrarPromedio() {
        System.out.printf("Promedio de calificaciones: %.2f / 5 (%d encuestas)%n",
                controller.calcularPromedio(), controller.listarEncuestas().size());
    }

    private void eliminar() {
        if (!listar()) {
            return;
        }
        int id = ConsolaUtil.leerEntero("ID de la encuesta a eliminar (0 para cancelar): ",
                0, Integer.MAX_VALUE);
        if (id == 0) {
            return;
        }
        if (controller.eliminarEncuesta(id)) {
            System.out.println("Encuesta eliminada.");
        } else {
            System.out.println("No existe una encuesta con ese ID.");
        }
    }
}
