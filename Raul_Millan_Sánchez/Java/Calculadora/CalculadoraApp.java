package com.paralauniversidad.calculadoraapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class Operacion {
    protected double n1;
    protected double n2;
    public Operacion(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }
    public abstract double calcular() throws ArithmeticException;
}
class Suma extends Operacion {
    public Suma(double n1, double n2) { super(n1, n2); }
    @Override
    public double calcular() { return n1 + n2; }
}

class Resta extends Operacion {
    public Resta(double n1, double n2) { super(n1, n2); }
    @Override
    public double calcular() { return n1 - n2; }
}

class Multiplicacion extends Operacion {
    public Multiplicacion(double n1, double n2) { super(n1, n2); }
    @Override
    public double calcular() { return n1 * n2; }
}

class Division extends Operacion {
    public Division(double n1, double n2) { super(n1, n2); }
    
    @Override
    public double calcular() throws ArithmeticException {

        if (n2 == 0) {
            throw new ArithmeticException("No es posible dividir entre cero.");
        }
        return n1 / n2;
    }
}
public class CalculadoraApp extends JFrame implements ActionListener {
    
    private JTextField pantalla;
    private double numeroAnterior = 0;
    private String operadorActual = "";
    private boolean nuevaOperacion = true;

    public CalculadoraApp() {
        setTitle("Proyecto Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); 

        pantalla = new JTextField("0");
        pantalla.setFont(new Font("Arial", Font.BOLD, 30));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false); 
        pantalla.setBackground(Color.WHITE);
        add(pantalla, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5)); 

        String[] botones = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(this); 
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if ("0123456789".contains(comando)) {
            if (nuevaOperacion) {
                pantalla.setText(comando);
                nuevaOperacion = false;
            } else {
                pantalla.setText(pantalla.getText() + comando);
            }
        } 
        else if ("+-*/".contains(comando)) {
            numeroAnterior = Double.parseDouble(pantalla.getText());
            operadorActual = comando;
            nuevaOperacion = true;
        } 
        else if ("=".equals(comando)) {
            double numeroActual = Double.parseDouble(pantalla.getText());
            Operacion op = null;            
            try {
                switch (operadorActual) {
                    case "+": op = new Suma(numeroAnterior, numeroActual); break;
                    case "-": op = new Resta(numeroAnterior, numeroActual); break;
                    case "*": op = new Multiplicacion(numeroAnterior, numeroActual); break;
                    case "/": op = new Division(numeroAnterior, numeroActual); break;
                }
                if (op != null) {
                    pantalla.setText(String.valueOf(op.calcular()));
                }
            } catch (ArithmeticException ex) {
                pantalla.setText("Error"); 
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
            }
            nuevaOperacion = true;
        } 
        else if ("C".equals(comando)) {
            pantalla.setText("0");
            numeroAnterior = 0;
            operadorActual = "";
            nuevaOperacion = true;
        }
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}
        

        SwingUtilities.invokeLater(() -> {
            new CalculadoraApp().setVisible(true);
        });
    }
}