package edu.poo.gestionnegocio.view;

import java.awt.GraphicsEnvironment;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws InterruptedException {
        View view = new View();
        if (GraphicsEnvironment.isHeadless()) {
            view.printTerminalMessage("This application needs a graphical desktop to open its windows.");
            return;
        }

        Controller controller = new Controller(new Service(new Repository()), view);
        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = true;
            while (running) {
                view.printTerminalMenu();
                String choice = view.readTerminalChoice(scanner);
                switch (choice.trim()) {
                    case "1" -> runScreen(controller::openMerchandiseScreen);
                    case "2" -> runScreen(controller::openCustomerScreen);
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
