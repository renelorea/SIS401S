/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poo.sis401s.practicacalculadora;

/**
 *
 * @author HP
 */
public class HijaSuma extends OperacionesPadre {
    //Contructor manda los datos al padre 
    public HijaSuma(double n1, double n2){
        super(n1, n2);
    }
    @Override
    public double calcular(){
        return cif1 + cif2;
    }
}
