/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;

import edu.poo.sis401s.gestor.model.Empleado;
import edu.poo.sis401s.gestor.services.EmpleadoService;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class EmpleadoController {
    private EmpleadoService servicio;
    public EmpleadoController(EmpleadoService servicio){
        this.servicio = servicio;
    }
    //Metdodos que la vista va a llamar
    public void agregarEmpleado(Empleado empleado){
        servicio.agregarEmpleado(empleado);
    }
    public ArrayList<Empleado> obtenerTodosEmpleados(){
        return servicio.obtenerTodos();
    }
    public Empleado buscarEmpleadoPorId(int id){
        return servicio. buscarPorId(id);
    }
    public boolean modificarEmpleado(int id ,String nuevoPuesto, double nuevoSalario){
        return servicio.modificarEmpleado(id, nuevoPuesto, nuevoSalario);
    }
    public boolean eliminarEmpleado(int id){
        return servicio.eliminarEmpleado(id);
    }
}