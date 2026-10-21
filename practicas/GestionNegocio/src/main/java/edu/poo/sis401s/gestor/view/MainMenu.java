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

public class MainMenu {
    private Usuario usuario;

    // Se crean una sola vez por sesión para que los datos no se pierdan entre una apertura y otra
    private final EncuestaController encuestaController = new EncuestaController();
    private ReservaService reservaService;
    private ReservaController reservaController;
    private PedidoController pedidoController;
    private EmpleadoController empleadoController;

    public MainMenu(Usuario usuario) {
        this.usuario = usuario;
    }

    public void mostrarMenu() {
        System.out.println("\nBienvenido " + usuario.getUsername() + " - Rol: " + usuario.getRol());

        String rol = usuario.getRol() == null ? "" : usuario.getRol().toLowerCase();
        switch (rol) {
            case "admin":
                menuAdmin();
                break;
            case "empleado":
                menuEmpleado();
                break;
            case "cliente":
                menuCliente();
                break;
            default:
                System.out.println("Rol no reconocido.");
        }
    }

    private void menuAdmin() {
        int opcion;
        do {
            System.out.println("\n=== Menú Administrador ===");
            System.out.println("1. Gestionar Inventario");
            System.out.println("2. Gestionar Empleados");
            System.out.println("3. Reportes Financieros");
            System.out.println("4. Gestionar Clientes");
            System.out.println("5. Encuestas de Satisfacción");
            System.out.println("6. Salir");
            opcion = ConsolaUtil.leerEntero("Elige una opción: ", 1, 6);

            switch (opcion) {
                case 1 -> VentanaUtil.abrirYEsperar(() -> new ProductoMenuView("Admin").setVisible(true));
                case 2 -> abrirEmpleados();
                case 3 -> VentanaUtil.abrirYEsperar(() -> new ReporteFinancieroView().setVisible(true));
                case 4 -> VentanaUtil.abrirYEsperar(() -> new ClienteView("Admin").setVisible(true));
                case 5 -> abrirEncuestas();
                default -> despedirse();
            }
        } while (opcion != 6);
    }

    private void menuEmpleado() {
        int opcion;
        do {
            System.out.println("\n=== Menú Empleado ===");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Gestionar Pedidos");
            System.out.println("3. Consultar Inventario");
            System.out.println("4. Consultar Clientes");
            System.out.println("5. Salir");
            opcion = ConsolaUtil.leerEntero("Elige una opción: ", 1, 5);

            switch (opcion) {
                case 1 -> VentanaUtil.abrirYEsperar(() -> new VentaView1().setVisible(true));
                case 2 -> VentanaUtil.abrirYEsperar(() -> pedidos().openMerchandiseScreen(() -> { }));
                case 3 -> VentanaUtil.abrirYEsperar(() -> new ProductoView("Empleado").setVisible(true));
                case 4 -> VentanaUtil.abrirYEsperar(() -> new ClienteView("Empleado").setVisible(true));
                default -> despedirse();
            }
        } while (opcion != 5);
    }

    private void menuCliente() {
        int opcion;
        do {
            System.out.println("\n=== Menú Cliente ===");
            System.out.println("1. Reservar Servicio");
            System.out.println("2. Responder Encuesta de Satisfacción");
            System.out.println("3. Consultar Pedidos");
            System.out.println("4. Salir");
            opcion = ConsolaUtil.leerEntero("Elige una opción: ", 1, 4);

            switch (opcion) {
                case 1 -> abrirReservas();
                case 2 -> abrirEncuestas();
                case 3 -> VentanaUtil.abrirYEsperar(() -> pedidos().openCustomerScreen(() -> { }));
                default -> despedirse();
            }
        } while (opcion != 4);
    }

    /** Encuestas: se puede usar en modo texto (Scanner) o en ventana (JFrame). */
    private void abrirEncuestas() {
        System.out.println("\n--- ENCUESTAS DE SATISFACCIÓN ---");
        System.out.println("1. Usar el menú de texto");
        System.out.println("2. Usar la ventana");
        System.out.println("0. Volver");
        int modo = ConsolaUtil.leerEntero("Elige una opción: ", 0, 2);

        if (modo == 1) {
            new EncuestaConsolaView(encuestaController, usuario).mostrar();
        } else if (modo == 2) {
            VentanaUtil.abrirYEsperar(
                    () -> new EncuestaView(encuestaController, usuario).setVisible(true));
        }
    }

    private void abrirReservas() {
        if (reservaService == null) {
            reservaService = new ReservaService(new ReservaRepository());
            reservaController = new ReservaController(reservaService);
        }
        VentanaUtil.abrirYEsperar(
                () -> new ReservaView(reservaController, reservaService).setVisible(true));
    }

    private void abrirEmpleados() {
        if (empleadoController == null) {
            empleadoController = new EmpleadoController(new EmpleadoService(new EmpleadoRepository()));
        }
        VentanaUtil.abrirYEsperar(() -> {
            EmpleadoView ventana = new EmpleadoView(empleadoController);
            // Su botón "Salir" termina todo el programa; aquí solo debe cerrar la ventana
            VentanaUtil.botonSoloCierraVentana(ventana, "Salir");
            ventana.mostrarMenu();
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
