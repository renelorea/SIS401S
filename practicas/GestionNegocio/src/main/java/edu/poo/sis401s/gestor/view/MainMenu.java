/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

/**
 *
 * @author Hp
 */
import edu.poo.sis401s.gestor.controller.EmpleadoController;
import edu.poo.sis401s.gestor.controller.EncuestaController;
import edu.poo.sis401s.gestor.controller.PedidoController;
import edu.poo.sis401s.gestor.controller.ReservaController;
import edu.poo.sis401s.gestor.model.Usuario;
import edu.poo.sis401s.gestor.repository.EmpleadoRepository;
import edu.poo.sis401s.gestor.repository.PedidoRepository;
import edu.poo.sis401s.gestor.repository.ReservaRepository;
import edu.poo.sis401s.gestor.services.EmpleadoService;
import edu.poo.sis401s.gestor.services.PedidoService;
import edu.poo.sis401s.gestor.services.ReservaService;
import edu.poo.sis401s.gestor.view.MainMenuView.Opcion;
import java.awt.GraphicsEnvironment;
import java.util.List;

/**
 * Menú principal. Arma la lista de opciones según el rol y la muestra en una ventana
 * (MainMenuView). Si el equipo no tiene pantalla, la misma lista se muestra como menú de texto.
 */
public class MainMenu {
    private Usuario usuario;

    // Se crean una sola vez por sesión para que los datos no se pierdan entre una apertura y otra
    private final EncuestaController encuestaController = new EncuestaController();
    private ReservaService reservaService;
    private ReservaController reservaController;
    private PedidoController pedidoController;
    private EmpleadoController empleadoController;

    // Ventana del menú; es null cuando se usa el menú de texto
    private MainMenuView ventana;

    public MainMenu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarMenu() {
        String rol = usuario.getRol() == null ? "" : usuario.getRol().toLowerCase();
        List<Opcion> opciones = opcionesDelRol(rol);
        if (opciones.isEmpty()) {
            System.out.println("Rol no reconocido.");
            return;
        }

        String nombreRol = nombreDelRol(rol);
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("\nBienvenido " + usuario.getUsername() + " - Rol: " + usuario.getRol());
            mostrarMenuTexto(nombreRol, opciones);
        } else {
            mostrarMenuVentana(nombreRol, opciones);
        }
    }

    // ------------------------------------------------------------------
    // Opciones de cada rol (las usan la ventana y el menú de texto)
    // ------------------------------------------------------------------

    private List<Opcion> opcionesDelRol(String rol) {
        return switch (rol) {
            case "admin" -> List.of(
                    new Opcion("Gestionar Inventario", "Registrar y consultar los productos",
                            () -> abrirVentana(() -> new ProductoMenuView("Admin").setVisible(true))),
                    new Opcion("Gestionar Empleados", "Altas, bajas, búsqueda y cambios de empleados",
                            this::abrirEmpleados),
                    new Opcion("Reportes Financieros", "Consultar los reportes del negocio",
                            () -> abrirVentana(() -> new ReporteFinancieroView().setVisible(true))),
                    new Opcion("Gestionar Clientes", "Registrar, buscar y actualizar clientes",
                            () -> abrirVentana(() -> new ClienteView("Admin").setVisible(true))),
                    new Opcion("Encuestas de Satisfacción", "Ver, registrar y eliminar encuestas",
                            this::abrirEncuestas));
            case "empleado" -> List.of(
                    new Opcion("Registrar Venta", "Abrir la pantalla de ventas",
                            () -> abrirVentana(() -> new VentaView1().setVisible(true))),
                    new Opcion("Gestionar Pedidos", "Consultar y gestionar pedidos",
                            () -> abrirVentana(() -> pedidos().openMerchandiseScreen(() -> { }))),
                    new Opcion("Consultar Inventario", "Ver los productos disponibles",
                            () -> abrirVentana(() -> new ProductoView("Empleado").setVisible(true))),
                    new Opcion("Consultar Clientes", "Ver la lista de clientes",
                            () -> abrirVentana(() -> new ClienteView("Empleado").setVisible(true))));
            case "cliente" -> List.of(
                    new Opcion("Reservar Servicio", "Hacer una reservación",
                            this::abrirReservas),
                    new Opcion("Responder Encuesta de Satisfacción",
                            "Calificar tu experiencia y dejar un comentario", this::abrirEncuestas),
                    new Opcion("Consultar Pedidos", "Ver tus pedidos",
                            () -> abrirVentana(() -> pedidos().openCustomerScreen(() -> { }))));
            default -> List.of();
        };
    }

    private String nombreDelRol(String rol) {
        return switch (rol) {
            case "admin" -> "Administrador";
            case "empleado" -> "Empleado";
            default -> "Cliente";
        };
    }

    // ------------------------------------------------------------------
    // Las dos formas de mostrar el menú
    // ------------------------------------------------------------------

    private void mostrarMenuVentana(String nombreRol, List<Opcion> opciones) {
        VentanaUtil.enHiloSwing(() -> ventana = new MainMenuView(usuario, nombreRol, opciones));
        ventana.mostrar();
        try {
            // La ventana avisa qué botón se presionó; aquí (hilo principal) se abre esa opción
            Opcion elegida = ventana.esperarOpcion();
            while (elegida != null) {
                RuntimeException fallo = null;
                try {
                    elegida.accion().run();
                } catch (RuntimeException ex) {
                    fallo = ex;
                }
                ventana.mostrar();
                if (fallo != null) {
                    ventana.avisar("No se pudo abrir esta opción: " + fallo.getMessage());
                }
                elegida = ventana.esperarOpcion();
            }
        } finally {
            ventana.cerrar();
            ventana = null;
        }
        despedirse();
    }

    private void mostrarMenuTexto(String nombreRol, List<Opcion> opciones) {
        int salir = opciones.size() + 1;
        int opcion;
        do {
            System.out.println("\n=== Menú " + nombreRol + " ===");
            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i).titulo());
            }
            System.out.println(salir + ". Salir");
            opcion = ConsolaUtil.leerEntero("Elige una opción: ", 1, salir);

            if (opcion == salir) {
                despedirse();
            } else {
                opciones.get(opcion - 1).accion().run();
            }
        } while (opcion != salir);
    }

    // ------------------------------------------------------------------
    // Abrir cada módulo
    // ------------------------------------------------------------------

    /**
     * Abre una ventana de otro módulo y espera a que se cierre. Si el menú está en ventana,
     * se oculta mientras tanto y vuelve cuando termina.
     */
    private void abrirVentana(Runnable abrir) {
        if (ventana != null) {
            ventana.ocultar();
        }
        boolean seAbrio = VentanaUtil.abrirYEsperar(abrir);
        if (!seAbrio && ventana != null) {
            ventana.mostrar();
            ventana.avisar("Esta pantalla todavía no está disponible.");
        }
    }

    /** Encuestas: se puede usar en modo texto (Scanner) o en ventana (JFrame). */
    private void abrirEncuestas() {
        int modo = ventana != null ? ventana.preguntarModoEncuestas() : preguntarModoEncuestasEnTexto();

        if (modo == 1) {
            if (ventana != null) {
                ventana.ocultar();
            }
            new EncuestaConsolaView(encuestaController, usuario).mostrar();
        } else if (modo == 2) {
            abrirVentana(() -> new EncuestaView(encuestaController, usuario).setVisible(true));
        }
    }

    private int preguntarModoEncuestasEnTexto() {
        System.out.println("\n--- ENCUESTAS DE SATISFACCIÓN ---");
        System.out.println("1. Usar el menú de texto");
        System.out.println("2. Usar la ventana");
        System.out.println("0. Volver");
        return ConsolaUtil.leerEntero("Elige una opción: ", 0, 2);
    }

    private void abrirReservas() {
        if (reservaService == null) {
            reservaService = new ReservaService(new ReservaRepository());
            reservaController = new ReservaController(reservaService);
        }
        abrirVentana(() -> new ReservaView(reservaController, reservaService).setVisible(true));
    }

    private void abrirEmpleados() {
        if (empleadoController == null) {
            empleadoController = new EmpleadoController(new EmpleadoService(new EmpleadoRepository()));
        }
        abrirVentana(() -> {
            EmpleadoView ventanaEmpleados = new EmpleadoView(empleadoController);
            // Su botón "Salir" termina todo el programa; aquí solo debe cerrar la ventana
            VentanaUtil.botonSoloCierraVentana(ventanaEmpleados, "Salir");
            ventanaEmpleados.mostrarMenu();
        });
    }

    private PedidoController pedidos() {
        if (pedidoController == null) {
            pedidoController = new PedidoController(
                    new PedidoService(new PedidoRepository()), new PedidoView());
        }
        return pedidoController;
    }

    private void despedirse() {
        System.out.println("Sesión cerrada. ¡Hasta pronto!");
    }
}
