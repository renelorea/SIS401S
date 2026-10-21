package edu.poo.sis401s.gestor.view;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.Container;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.AWTEventListener;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Abre ventanas (JFrame) desde el menú de texto y espera a que se cierren
 * antes de volver a mostrar el menú, para que consola y ventanas no se mezclen.
 *
 * Algunas ventanas de otros módulos se crean con EXIT_ON_CLOSE, que cerraría
 * todo el programa al presionar la X. Mientras se espera, esas ventanas se
 * cambian a DISPOSE_ON_CLOSE (solo cierran la ventana) sin modificar sus clases.
 */
final class VentanaUtil {
    private VentanaUtil() {
    }

    static void abrirYEsperar(Runnable abrir) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("Esta opción necesita un entorno gráfico para abrir ventanas.");
            return;
        }

        AWTEventListener oyente = evento -> {
            if (evento instanceof WindowEvent we
                    && we.getID() == WindowEvent.WINDOW_OPENED
                    && we.getWindow() instanceof JFrame marco
                    && marco.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE) {
                marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        };
        Toolkit.getDefaultToolkit().addAWTEventListener(oyente, AWTEvent.WINDOW_EVENT_MASK);

        try {
            CountDownLatch abierta = new CountDownLatch(1);
            SwingUtilities.invokeLater(() -> {
                try {
                    abrir.run();
                } catch (RuntimeException ex) {
                    System.out.println("No se pudo abrir la ventana: " + ex.getMessage());
                } finally {
                    abierta.countDown();
                }
            });
            abierta.await();

            // Si el módulo no abre ninguna ventana (por ejemplo, aún no está terminado), se avisa.
            for (int i = 0; i < 5 && !hayVentanasVisibles(); i++) {
                Thread.sleep(100);
            }
            if (!hayVentanasVisibles()) {
                System.out.println("Esta pantalla todavía no está disponible.");
                return;
            }

            while (hayVentanasVisibles()) {
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } finally {
            Toolkit.getDefaultToolkit().removeAWTEventListener(oyente);
        }
    }

    /**
     * Hace que el botón con ese texto solo cierre la ventana, en lugar de ejecutar lo que
     * tenía (por ejemplo System.exit, que terminaría también el menú de texto).
     * No modifica la clase de la ventana: solo cambia esa instancia mientras el programa corre.
     */
    static void botonSoloCierraVentana(JFrame ventana, String texto) {
        AbstractButton boton = buscarBoton(ventana.getContentPane(), texto);
        if (boton == null) {
            return;
        }
        for (ActionListener accion : boton.getActionListeners()) {
            boton.removeActionListener(accion);
        }
        boton.addActionListener(e -> ventana.dispose());
    }

    private static AbstractButton buscarBoton(Container contenedor, String texto) {
        for (Component componente : contenedor.getComponents()) {
            if (componente instanceof AbstractButton boton && texto.equals(boton.getText())) {
                return boton;
            }
            if (componente instanceof Container hijo) {
                AbstractButton encontrado = buscarBoton(hijo, texto);
                if (encontrado != null) {
                    return encontrado;
                }
            }
        }
        return null;
    }

    private static boolean hayVentanasVisibles() {
        for (Window ventana : Window.getWindows()) {
            if (ventana.isShowing()) {
                return true;
            }
        }
        return false;
    }
}
