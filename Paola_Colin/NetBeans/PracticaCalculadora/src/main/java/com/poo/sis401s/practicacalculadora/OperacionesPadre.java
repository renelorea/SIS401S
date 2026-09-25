/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.practicacalculadora;

/**
 *
 * @author pao
 */
public class OperacionesPadre {
    //Cifras protegidas a las que las hijas tienen acceso
    protected double cif1;
    protected double cif2;
    //Constructor para guardar las cifras
    public OperacionesPadre(double n1, double n2){
        this.cif1 = n1;
        this.cif2 = n2;
    }
    //Metodo que las hijas van a reescribir
    public double calcular (){
        return 0;
    }
}
