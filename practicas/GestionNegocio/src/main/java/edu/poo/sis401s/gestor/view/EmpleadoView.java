    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.controller.EmpleadoController;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Capa vista del modulo Empleado: ventana principal con el menu.
 * Cada boton abre una ventana distinta que trabaja con EmpleadoService.
 */
public class EmpleadoView extends JFrame {

    private final EmpleadoController controlador;

    public EmpleadoView(EmpleadoController controlador) {
        this.controlador = controlador;
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Si falla, se usa el estilo por defecto de Java
        }
        construir();
    }

    private void construir() {
        setTitle("Gestión de Empleados");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 480);
        setLocationRelativeTo(null);
        setResizable(false);

        JLabel titulo = new JLabel("MÓDULO EMPLEADOS", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        JLabel subtitulo = new JLabel("Elige una opción del menú", SwingConstants.CENTER);

        JPanel encabezado = new JPanel(new GridLayout(2, 1, 0, 4));
        encabezado.add(titulo);
        encabezado.add(subtitulo);

        JPanel botones = new JPanel(new GridLayout(7, 1, 0, 8));
        botones.add(crearBoton("Agregar empleado", e -> new EmpleadoAgregarView(this, controlador).setVisible(true)));
        botones.add(crearBoton("Mostrar todos los empleados", e -> new EmpleadoListadoView(this, controlador).setVisible(true)));
        botones.add(crearBoton("Buscar empleado por ID", e -> new EmpleadoBuscarView(this, controlador).setVisible(true)));
        botones.add(crearBoton("Modificar puesto y salario", e -> new EmpleadoModificarView(this, controlador).setVisible(true)));
        botones.add(crearBoton("Eliminar empleado", e -> new EmpleadoEliminarView(this, controlador).setVisible(true)));
        botones.add(crearBoton("Instrucciones", e -> new EmpleadoInstruccionesView(this).setVisible(true)));
        botones.add(crearBoton("Salir", e -> System.exit(0)));

        JPanel contenido = new JPanel(new BorderLayout(10, 15));
        contenido.setBorder(BorderFactory.createEmptyBorder(15, 25, 20, 25));
        contenido.add(encabezado, BorderLayout.NORTH);
        contenido.add(botones, BorderLayout.CENTER);
        setContentPane(contenido);
    }

    private JButton crearBoton(String texto, ActionListener accion) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 14));
        boton.addActionListener(accion);
        return boton;
    }

    // Muestra la ventana principal
    public void mostrarMenu() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
}
