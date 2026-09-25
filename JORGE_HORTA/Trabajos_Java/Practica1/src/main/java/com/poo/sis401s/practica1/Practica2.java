/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.practica1;
import java.util.Scanner;
import com.poo.sis401s.OBJETO.CalculadoraBasica;
/**
 *
 * @author lobog
 */
public class Practica2 {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);
        CalculadoraBasica calculadora = new CalculadoraBasica();
        System.out.print("Ingrese el primer numero: ");
        calculadora.setNumero1(sc.nextDouble());
        System.out.print("Ingrese el segundo numero: ");
        calculadora.setNumero2(sc.nextDouble());
        System.out.println("Suma: "+ calculadora.suma());
        System.out.println("Resta: " + calculadora.resta());
        System.out.println("Multiplicacion: " + calculadora.multiplicacion());
        System.out.println("Divicion: "+ calculadora.division());
     }
}
