package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.model.Usuario;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

/**
 * Ventana (JFrame escrito a mano) del menú principal.
 *
 * Solo dibuja el menú y avisa qué botón eligió la persona. Qué hace cada opción
 * lo decide MainMenu, que recibe la elección con esperarOpcion().
 */
public class MainMenuView extends JFrame {

    /** Una opción del menú: lo que se ve en el botón y lo que se ejecuta al elegirla. */
    public record Opcion(String titulo, String descripcion, Runnable accion) {
    }

    private static final Font F_TITULO = Estilo.fuente(Font.BOLD, 16);
    private static final Font F_DETALLE = Estilo.fuente(Font.PLAIN, 13);

    private final Usuario usuario;
    private final String nombreRol;
    private final List<Opcion> opciones;

    // Aquí caen las elecciones de la persona; el hilo principal las toma con esperarOpcion()
    private final BlockingQueue<Optional<Opcion>> elecciones = new LinkedBlockingQueue<>();

    // Evita que un doble clic dispare dos opciones. Solo se toca desde el hilo de Swing.
    private boolean ocupada;

    public MainMenuView(Usuario usuario, String nombreRol, List<Opcion> opciones) {
        this.usuario = usuario;
        this.nombreRol = nombreRol;
        this.opciones = opciones;
        construirInterfaz();
    }

    // ------------------------------------------------------------------
    // Lo que usa MainMenu (se puede llamar desde el hilo principal)
    // ------------------------------------------------------------------

    /** Espera a que la persona elija algo. Devuelve null si cerró la sesión. */
    public Opcion esperarOpcion() {
        try {
            return elecciones.take().orElse(null);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    /** Muestra el menú (o lo vuelve a mostrar) y deja elegir otra opción. */
    public void mostrar() {
        VentanaUtil.enHiloSwing(() -> {
            ocupada = false;
            setVisible(true);
            toFront();
            // Que ninguna tarjeta quede marcada de entrada (se marcan al usar Tab o el mouse)
            getContentPane().requestFocusInWindow();
        });
    }

    /** Oculta el menú mientras otra pantalla está abierta. */
    public void ocultar() {
        VentanaUtil.enHiloSwing(() -> setVisible(false));
    }

    /** Cierra la ventana del menú. */
    public void cerrar() {
        VentanaUtil.enHiloSwing(this::dispose);
    }

    /** Muestra un aviso encima del menú. */
    public void avisar(String mensaje) {
        VentanaUtil.enHiloSwing(() -> JOptionPane.showMessageDialog(
                this, mensaje, "Aviso", JOptionPane.INFORMATION_MESSAGE));
    }

    /**
     * Pregunta cómo se quieren usar las encuestas. Devuelve lo mismo que el menú de texto:
     * 1 = menú de texto (consola), 2 = ventana, 0 = cancelar.
     */
    public int preguntarModoEncuestas() {
        int[] modo = {0};
        VentanaUtil.enHiloSwing(() -> {
            Object[] botones = {"Ventana", "Menú de texto (consola)", "Cancelar"};
            int respuesta = JOptionPane.showOptionDialog(this,
                    "¿Cómo quieres usar las encuestas?\n\n"
                    + "El menú de texto se usa en la consola (ventana Output de NetBeans).",
                    "Encuestas de satisfacción", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
            modo[0] = switch (respuesta) {
                case 0 -> 2;
                case 1 -> 1;
                default -> 0;
            };
        });
        return modo[0];
    }

    // ------------------------------------------------------------------
    // Construcción de la ventana
    // ------------------------------------------------------------------

    private void construirInterfaz() {
        setTitle("Gestión de Negocio - Menú principal");
        // La X no cierra sola: pregunta y, si se acepta, cierra la sesión
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pedirCerrarSesion();
            }
        });

        JPanel raiz = new JPanel(new BorderLayout());
        raiz.setBackground(Estilo.FONDO);
        raiz.setFocusable(true);
        raiz.add(crearEncabezado(), BorderLayout.NORTH);
        raiz.add(crearLista(), BorderLayout.CENTER);
        raiz.add(crearPie(), BorderLayout.SOUTH);
        setContentPane(raiz);

        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }

    private JPanel crearEncabezado() {
        return Estilo.encabezado("Hola, " + usuario.getUsername(),
                "Rol: " + nombreRol + "  ·  Elige una opción para continuar");
    }

    private JPanel crearLista() {
        JPanel lista = new JPanel(new GridLayout(0, 1, 0, 10));
        lista.setOpaque(false);
        lista.setBorder(new EmptyBorder(22, 28, 10, 28));

        for (int i = 0; i < opciones.size(); i++) {
            Opcion opcion = opciones.get(i);
            lista.add(new Tarjeta(i + 1, opcion, () -> elegir(opcion)));

            // Atajo de teclado: el número de la opción (del 1 al 9)
            if (i < 9) {
                String clave = "opcion" + i;
                getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                        .put(KeyStroke.getKeyStroke(KeyEvent.VK_1 + i, 0), clave);
                getRootPane().getActionMap().put(clave, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        elegir(opcion);
                    }
                });
            }
        }
        return lista;
    }

    private JPanel crearPie() {
        JPanel pie = new JPanel(new BorderLayout());
        pie.setOpaque(false);
        pie.setBorder(new EmptyBorder(8, 28, 20, 28));
        pie.add(Estilo.etiqueta("Atajo: presiona el número de la opción",
                Estilo.fuente(Font.PLAIN, 12), Estilo.TEXTO_SUAVE), BorderLayout.WEST);
        pie.add(new Estilo.Boton("Cerrar sesión", Estilo.TipoBoton.PELIGRO, 140, this::pedirCerrarSesion),
                BorderLayout.EAST);
        return pie;
    }

    // ------------------------------------------------------------------
    // Qué pasa al elegir
    // ------------------------------------------------------------------

    private void elegir(Opcion opcion) {
        if (ocupada) {
            return;
        }
        ocupada = true;
        elecciones.add(Optional.of(opcion));
    }

    private void pedirCerrarSesion() {
        if (ocupada) {
            return;
        }
        Object[] botones = {"Sí, cerrar sesión", "Cancelar"};
        int respuesta = JOptionPane.showOptionDialog(this, "¿Quieres cerrar tu sesión?",
                "Cerrar sesión", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, botones, botones[1]);
        if (respuesta == 0) {
            ocupada = true;
            elecciones.add(Optional.empty());
        }
    }

    // ------------------------------------------------------------------
    // Botones dibujados a mano (se ven igual con cualquier estilo de Swing)
    // ------------------------------------------------------------------

    /** Botón grande con número, título y descripción de una opción. */
    private static final class Tarjeta extends JButton {
        private final int numero;
        private final Opcion opcion;
        private boolean encima;

        Tarjeta(int numero, Opcion opcion, Runnable alPresionar) {
            this.numero = numero;
            this.opcion = opcion;
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(544, 68));
            getAccessibleContext().setAccessibleName(opcion.titulo());
            addActionListener(e -> alPresionar.run());
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    encima = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    encima = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            int ancho = getWidth();
            int alto = getHeight();
            boolean resaltada = encima || hasFocus();

            // Fondo y borde
            Color relleno = getModel().isPressed() ? new Color(0xDCE8F7)
                    : encima ? new Color(0xEEF4FC) : Color.WHITE;
            g2.setColor(relleno);
            g2.fillRoundRect(0, 0, ancho - 1, alto - 1, 14, 14);
            g2.setColor(resaltada ? Estilo.ACENTO : Estilo.BORDE);
            g2.setStroke(new BasicStroke(hasFocus() ? 2f : 1f));
            g2.drawRoundRect(0, 0, ancho - 1, alto - 1, 14, 14);

            // Círculo con el número de la opción
            int diametro = 36;
            int x = 16;
            int y = (alto - diametro) / 2;
            g2.setColor(resaltada ? Estilo.ACENTO : new Color(0xE3ECF7));
            g2.fillOval(x, y, diametro, diametro);
            g2.setColor(resaltada ? Color.WHITE : Estilo.AZUL_OSCURO);
            g2.setFont(F_TITULO);
            String texto = String.valueOf(numero);
            FontMetrics fmNumero = g2.getFontMetrics();
            g2.drawString(texto, x + (diametro - fmNumero.stringWidth(texto)) / 2,
                    y + (diametro + fmNumero.getAscent() - fmNumero.getDescent()) / 2);

            // Título y descripción, centrados en vertical
            FontMetrics fmTitulo = g2.getFontMetrics(F_TITULO);
            FontMetrics fmDetalle = g2.getFontMetrics(F_DETALLE);
            int altoTexto = fmTitulo.getHeight() + 2 + fmDetalle.getHeight();
            int yTitulo = (alto - altoTexto) / 2 + fmTitulo.getAscent();
            int xTexto = x + diametro + 16;
            g2.setFont(F_TITULO);
            g2.setColor(Estilo.TEXTO);
            g2.drawString(opcion.titulo(), xTexto, yTitulo);
            g2.setFont(F_DETALLE);
            g2.setColor(Estilo.TEXTO_SUAVE);
            g2.drawString(opcion.descripcion(), xTexto,
                    yTitulo + fmTitulo.getDescent() + 2 + fmDetalle.getAscent());

            // Flechita a la derecha
            int xFlecha = ancho - 30;
            int yFlecha = alto / 2;
            g2.setColor(resaltada ? Estilo.ACENTO : new Color(0x9AA6B5));
            g2.setStroke(new BasicStroke(2f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            g2.drawLine(xFlecha, yFlecha - 6, xFlecha + 6, yFlecha);
            g2.drawLine(xFlecha + 6, yFlecha, xFlecha, yFlecha + 6);

            g2.dispose();
        }
    }
}
