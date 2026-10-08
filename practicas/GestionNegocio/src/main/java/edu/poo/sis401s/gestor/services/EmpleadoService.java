/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.Empleado;
import java.util.ArrayList;

/**
 *
 * @author pao
 */
public class EmpleadoService {
    private ArrayList <Empleado> listaEmpleados;
    public EmpleadoService(){
        listaEmpleados = new ArrayList<>();
    }
    //Agregar empleado
    public void agregarEmpleado(Empleado e){
        listaEmpleados.add(e);
        System.out.println("Empleado registrado correctamente");
    }
    //Mostrar todos
    public void mostrarTodos(){
        if (listaEmpleados.isEmpty()){
            System.out.println("No hay empleados registrados");
            return;
        }
        System.out.println("----------LISTA DE EMPLEADOS----------");
        for (Empleado e: listaEmpleados){
            System.out.println(e);
        }
    }
    //Aqui para buscar por ID
    public Empleado buscarPorId(int id){
        for (Empleado e: listaEmpleados){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }
    //Poder modificar
    public boolean modificarEmpleado(int id, String nuevoPuesto, double nuevoSalario){
        Empleado e = buscarPorId(id);
        if (e != null){
            e.setPuesto(nuevoPuesto);
            e.setSalario(nuevoSalario);
            return true;
        }
        return false;
    }
    //Eliminar
    public boolean eliminarEmpleado(int id){
        Empleado e = buscarPorId(id);
        if(e != null){
            listaEmpleados.remove(e);
            return true;
        }
        return false;
    }
}
