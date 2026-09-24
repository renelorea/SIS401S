/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculadora;

/**
 *
 * @author yeyos
 */
public class Operaciones {
    private double resultado;

    // Constructor inicializa con un número
    public Operaciones(double numeroInicial) {
        this.resultado = numeroInicial;
    }

    public double sumar(double b) {
        resultado = resultado + b;
        return resultado;
    }

    public double restar(double b) {
        resultado = resultado - b;
        return resultado;
    }

    public double multiplicar(double b) {
        resultado = resultado * b;
        return resultado;
    }

    public double dividir(double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Error: División entre 0 no permitida");
        }
        resultado = resultado / b;
        return resultado;
    }

    public void reiniciar(double nuevoValor) {
        resultado = nuevoValor;
    }

    public double getResultado() {
        return resultado;
    }
}
