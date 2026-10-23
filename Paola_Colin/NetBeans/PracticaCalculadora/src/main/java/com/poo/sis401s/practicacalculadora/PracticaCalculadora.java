/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.poo.sis401s.practicacalculadora;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class PracticaCalculadora {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Pedimos las dos cifras
        
        System.out.println("BIENVENIDO A CALCULADORA");
        System.out.println("==========CACULADORA==========");
        System.out.println("Ingresa el primer numero: ");
        double a = teclado.nextDouble();
        
        System.out.println("Ingresa el segundo numero: ");
        double b = teclado.nextDouble();
        //Menu
        System.out.println("Elige la operacion: ");
        System.out.println("1.-Suma");
        System.out.println("2.-Resta");
        System.out.println("3.-Multiplicacion");
        System.out.println("4.-Division");
        System.out.print("Elegiste: ");
        int opcion = teclado.nextInt();
        OperacionesPadre operacion;
        //Elegir que operacion ejecutar
        switch(opcion){
            case 1:
                operacion = new HijaSuma(a,b);
                System.out.println("Resultado: " + a + " + " + b + " = " + operacion.calcular());
                break;
            case 2:
                operacion = new HijaResta(a,b);
                System.out.println("Resultado: " + a + " - " + b + " = " + operacion.calcular());
                break;
            case 3:
                operacion = new HijaMultiplicacion(a,b);
                System.out.println("Resultado: " + a + " * " + b + " = " + operacion.calcular());
                break;
            case 4:
                operacion = new HijaDivision(a,b);
                System.out.println("Resultado: " + a + " / " + b + " = " + operacion.calcular());
                break;
            default:
                System.out.println("Opcion no valida");
        }
        teclado.close();
    }
}
