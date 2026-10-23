/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.practicacalculadora;

/**
 *
 * @author HP
 */
public class HijaDivision extends OperacionesPadre {
    public HijaDivision(double n1, double n2){
        super(n1,n2);
    }
    @Override
    public double calcular (){
        if (cif2==0){
            System.out.println("No se puede dividir entre cero");
           return 0;
        }
        return cif1/cif2;
    }
}
