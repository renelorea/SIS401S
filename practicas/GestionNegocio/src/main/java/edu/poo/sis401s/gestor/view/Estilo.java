package edu.poo.sis401s.gestor.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Colores, fuentes y botones que comparten las ventanas de login y de menú principal,
 * para que las dos se vean como la misma aplicación.
 */
final class Estilo {
    static final Color AZUL_OSCURO = new Color(0x1F3A5F);
    static final Color AZUL_CLARO = new Color(0xB9CCE6);
    static final Color ACENTO = new Color(0x2F6FB5);
    static final Color FONDO = new Color(0xF4F6F9);
    static final Color BORDE = new Color(0xD5DCE5);
    static final Color TEXTO = new Color(0x1B2733);
    static final Color TEXTO_SUAVE = new Color(0x5B6775);
    static final Color ROJO = new Color(0xB3261E);

    private Estilo() {
    }

    /** Usa Segoe UI (la de Windows) si existe; si no, la fuente sans-serif del sistema. */
    static Font fuente(int estilo, int tamano) {
        Font fuente = new Font("Segoe UI", estilo, tamano);
        return "Segoe UI".equals(fuente.getFamily()) ? fuente : new Font(Font.SANS_SERIF, estilo, tamano);
    }

    static JLabel etiqueta(String texto, Font fuente, Color color) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(fuente);
        etiqueta.setForeground(color);
        return etiqueta;
    }

    /** Franja azul de arriba: nombre de la aplicación, título grande y una línea de apoyo. */
    static JPanel encabezado(String titulo, String subtitulo) {
        JPanel encabezado = new JPanel(new GridLayout(3, 1, 0, 2));
        encabezado.setBackground(AZUL_OSCURO);
        encabezado.setBorder(new EmptyBorder(18, 28, 18, 28));
        encabezado.add(etiqueta("GESTIÓN DE NEGOCIO", fuente(Font.BOLD, 12), AZUL_CLARO));
        encabezado.add(etiqueta(titulo, fuente(Font.BOLD, 26), Color.WHITE));
        encabezado.add(etiqueta(subtitulo, fuente(Font.PLAIN, 13), AZUL_CLARO));
        return encabezado;
    }

    /** Tipos de botón: azul lleno (acción principal), blanco con borde, y rojo (salir). */
    enum TipoBoton {
        PRINCIPAL, SECUNDARIO, PELIGRO
    }

    /** Botón dibujado a mano: se ve igual con cualquier estilo de Swing. */
    static final class Boton extends JButton {
        private final TipoBoton tipo;
        private boolean encima;

        Boton(String texto, TipoBoton tipo, int ancho, Runnable alPresionar) {
            super(texto);
            this.tipo = tipo;
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setFont(fuente(Font.BOLD, 13));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(ancho, 38));
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

            boolean presionado = getModel().isPressed();
            Color relleno;
            Color borde;
            Color texto;
            switch (tipo) {
                case PRINCIPAL -> {
                    relleno = !isEnabled() ? new Color(0xA9B7C9)
                            : presionado ? new Color(0x1F4A7D) : encima ? new Color(0x265C99) : ACENTO;
                    borde = hasFocus() ? AZUL_OSCURO : relleno;
                    texto = Color.WHITE;
                }
                case PELIGRO -> {
                    relleno = presionado ? new Color(0xF6D5D2) : encima ? new Color(0xFBE9E7) : Color.WHITE;
                    borde = ROJO;
                    texto = ROJO;
                }
                default -> {
                    relleno = presionado ? new Color(0xDCE8F7) : encima ? new Color(0xEEF4FC) : Color.WHITE;
                    borde = encima || hasFocus() ? ACENTO : BORDE;
                    texto = TEXTO;
                }
            }

            int ancho = getWidth();
            int alto = getHeight();
            g2.setColor(relleno);
            g2.fillRoundRect(0, 0, ancho - 1, alto - 1, 12, 12);
            g2.setColor(borde);
            g2.setStroke(new BasicStroke(hasFocus() ? 2f : 1f));
            g2.drawRoundRect(0, 0, ancho - 1, alto - 1, 12, 12);

            g2.setColor(texto);
            g2.setFont(getFont());
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(getText(), (ancho - fm.stringWidth(getText())) / 2,
                    (alto + fm.getAscent() - fm.getDescent()) / 2);
            g2.dispose();
        }
    }
}
