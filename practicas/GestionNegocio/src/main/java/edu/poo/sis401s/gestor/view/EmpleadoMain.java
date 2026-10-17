/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.view;

import edu.poo.sis401s.gestor.repository.EmpleadoRepository;
import edu.poo.sis401s.gestor.services.EmpleadoService;

public class EmpleadoMain {
    public static void main(String[] args) {
        //Conectamos las capas
        EmpleadoRepository repo= new EmpleadoRepository();
        EmpleadoService servicio = new EmpleadoService(repo);
        EmpleadoView ventanaPrincipal = new EmpleadoView(servicio);
        //Mostramos la ventana
        ventanaPrincipal.mostrarMenu();
    }
}
