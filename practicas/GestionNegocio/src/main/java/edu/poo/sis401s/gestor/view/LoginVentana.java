package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.controller.LoginController;
import edu.poo.sis401s.gestor.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Ventana (JFrame escrito a mano) para iniciar sesión.
 *
 * Pide usuario y contraseña, los valida con LoginController y permite un máximo de intentos.
 * LoginView la abre y espera el resultado con esperarResultado().
 */
public class LoginVentana extends JFrame {
    private final LoginController controller;
    private final int maxIntentos;
    private int intentos;
    private boolean terminado;

    // Resultado: el usuario que entró, o vacío si la persona salió o agotó los intentos
    private final BlockingQueue<Optional<Usuario>> resultado = new LinkedBlockingQueue<>();

    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JLabel lblError;

    public LoginVentana(LoginController controller, int maxIntentos) {
        this.controller = controller;
        this.maxIntentos = maxIntentos;
        construirInterfaz();
    }

    /** Espera (en el hilo principal) a que la persona entre o salga. Devuelve null si salió. */
    public Usuario esperarResultado() {
        try {
            return resultado.take().orElse(null);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    // ------------------------------------------------------------------
    // Construcción de la ventana
    // ------------------------------------------------------------------

    private void construirInterfaz() {
        setTitle("Gestión de Negocio - Iniciar sesión");
        // La X equivale a "Salir"
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                txtUsuario.requestFocusInWindow();
            }

            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }
        });

        JPanel raiz = new JPanel(new BorderLayout());
        raiz.setBackground(Estilo.FONDO);
        raiz.add(Estilo.encabezado("Iniciar sesión", "Escribe tu usuario y tu contraseña"),
                BorderLayout.NORTH);
        raiz.add(crearFormulario(), BorderLayout.CENTER);
        setContentPane(raiz);

        // Escape = Salir
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "salir");
        getRootPane().getActionMap().put("salir", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });

        pack();
        setSize(Math.max(getWidth(), 440), getHeight());
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private JPanel crearFormulario() {
        txtUsuario = new JTextField(22);
        txtClave = new JPasswordField(22);
        estilizarCampo(txtUsuario);
        estilizarCampo(txtClave);

        // Enter en el usuario pasa a la contraseña; Enter en la contraseña inicia sesión
        txtUsuario.addActionListener(e -> txtClave.requestFocusInWindow());
        txtClave.addActionListener(e -> intentarEntrar());

        char ecoOriginal = txtClave.getEchoChar();
        JCheckBox chkMostrar = new JCheckBox("Mostrar contraseña");
        chkMostrar.setOpaque(false);
        chkMostrar.setFont(Estilo.fuente(Font.PLAIN, 12));
        chkMostrar.setForeground(Estilo.TEXTO_SUAVE);
        chkMostrar.setFocusable(false);
        chkMostrar.addActionListener(e ->
                txtClave.setEchoChar(chkMostrar.isSelected() ? (char) 0 : ecoOriginal));

        // Aquí se escribe el aviso de credenciales incorrectas (el espacio evita que la ventana "salte")
        lblError = Estilo.etiqueta(" ", Estilo.fuente(Font.BOLD, 12), Estilo.ROJO);

        JPanel botones = new JPanel(new BorderLayout());
        botones.setOpaque(false);
        botones.add(new Estilo.Boton("Salir", Estilo.TipoBoton.SECUNDARIO, 110, this::salir),
                BorderLayout.WEST);
        botones.add(new Estilo.Boton("Iniciar sesión", Estilo.TipoBoton.PRINCIPAL, 160, this::intentarEntrar),
                BorderLayout.EAST);

        JPanel cuerpo = new JPanel();
        cuerpo.setLayout(new BoxLayout(cuerpo, BoxLayout.Y_AXIS));
        cuerpo.setOpaque(false);
        cuerpo.setBorder(new EmptyBorder(24, 32, 24, 32));
        cuerpo.add(alIzquierda(Estilo.etiqueta("Usuario", Estilo.fuente(Font.BOLD, 13), Estilo.TEXTO)));
        cuerpo.add(Box.createVerticalStrut(6));
        cuerpo.add(alIzquierda(txtUsuario));
        cuerpo.add(Box.createVerticalStrut(14));
        cuerpo.add(alIzquierda(Estilo.etiqueta("Contraseña", Estilo.fuente(Font.BOLD, 13), Estilo.TEXTO)));
        cuerpo.add(Box.createVerticalStrut(6));
        cuerpo.add(alIzquierda(txtClave));
        cuerpo.add(Box.createVerticalStrut(8));
        cuerpo.add(alIzquierda(chkMostrar));
        cuerpo.add(Box.createVerticalStrut(10));
        cuerpo.add(alIzquierda(lblError));
        cuerpo.add(Box.createVerticalStrut(14));
        cuerpo.add(alIzquierda(botones));
        return cuerpo;
    }

    /** Campo con borde redondeado que se marca en azul al escribir en él. */
    private void estilizarCampo(JTextField campo) {
        campo.setFont(Estilo.fuente(Font.PLAIN, 15));
        campo.setForeground(Estilo.TEXTO);
        campo.setBorder(bordeCampo(Estilo.BORDE));
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, campo.getPreferredSize().height + 14));
        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                campo.setBorder(bordeCampo(Estilo.ACENTO));
            }

            @Override
            public void focusLost(FocusEvent e) {
                campo.setBorder(bordeCampo(Estilo.BORDE));
            }
        });
    }

    private static javax.swing.border.Border bordeCampo(Color color) {
        return BorderFactory.createCompoundBorder(
                new LineBorder(color, 1, true), new EmptyBorder(7, 10, 7, 10));
    }

    private static JComponent alIzquierda(JComponent componente) {
        componente.setAlignmentX(Component.LEFT_ALIGNMENT);
        return componente;
    }

    // ------------------------------------------------------------------
    // Qué pasa al presionar los botones
    // ------------------------------------------------------------------

    private void intentarEntrar() {
        if (terminado) {
            return;
        }
        String username = txtUsuario.getText().trim();
        String password = new String(txtClave.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            lblError.setText("Escribe tu usuario y tu contraseña.");
            (username.isEmpty() ? txtUsuario : txtClave).requestFocusInWindow();
            return;
        }

        Usuario usuario = controller.login(username, password);
        if (usuario != null) {
            terminar(Optional.of(usuario));
            return;
        }

        intentos++;
        if (intentos >= maxIntentos) {
            JOptionPane.showMessageDialog(this, "Demasiados intentos fallidos. Saliendo del sistema...",
                    "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            terminar(Optional.empty());
            return;
        }
        lblError.setText("Usuario o contraseña incorrectos. Intento " + intentos + " de " + maxIntentos + ".");
        txtClave.setText("");
        txtClave.requestFocusInWindow();
    }

    private void salir() {
        if (!terminado) {
            terminar(Optional.empty());
        }
    }

    private void terminar(Optional<Usuario> usuario) {
        terminado = true;
        resultado.add(usuario);
    }
}
