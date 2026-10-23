package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.controller.PedidoController;
import edu.poo.sis401s.gestor.repository.PedidoRepository;
import edu.poo.sis401s.gestor.services.PedidoService;
import edu.poo.sis401s.gestor.view.PedidoView;
import java.awt.GraphicsEnvironment;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;

public final class PedidoMain {
    private PedidoMain() {
    }

    public static void main(String[] args) throws InterruptedException {
        PedidoView view = new PedidoView();
        if (GraphicsEnvironment.isHeadless()) {
            view.printTerminalMessage("This application needs a graphical desktop to open its windows.");
            return;
        }

        PedidoController controller = new PedidoController(new PedidoService(new PedidoRepository()), view);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                view.printTerminalMenu();
                String choice = view.readTerminalChoice(scanner);
                switch (choice.trim()) {
                    case "1" -> runScreen(onClose -> controller.openMerchandiseScreen(onClose));
                    case "2" -> runScreen(onClose -> controller.openCustomerScreen(onClose));
                    case "3" -> running = false;
                    default -> view.printTerminalMessage("Escribe y selecciona una opcion: 1, 2, o 3.");
                }
            }
        }
        view.printTerminalMessage("Gracias por usar nuestra aplicación de pedidos.");
    }

    private static void runScreen(java.util.function.Consumer<Runnable> openScreen)
            throws InterruptedException {
        CountDownLatch screenClosed = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> openScreen.accept(screenClosed::countDown));
        screenClosed.await();
    }
}
