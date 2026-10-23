/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;

import edu.poo.sis401s.gestor.model.Empleado;
import edu.poo.sis401s.gestor.repository.EmpleadoRepository;
import java.util.ArrayList;

/**
 *
 * @author pao
 */
public class EmpleadoService {
    private EmpleadoRepository repositorio;

    // Constructor que recibe el repositorio
    public EmpleadoService(EmpleadoRepository repositorio){
        this.repositorio = repositorio;
    }

    // Constructor sin parametros (crea su propio repositorio)
    public EmpleadoService(){
        this(new EmpleadoRepository());
    }

    //Agregar empleado
    public void agregarEmpleado(Empleado e){
        repositorio.guardar(e);
        System.out.println("Empleado registrado correctamente");
    }
    //Mostrar todos
    public void mostrarTodos(){
        ArrayList<Empleado> lista = repositorio.obtenerTodos();
        if (lista.isEmpty()){
            System.out.println("No hay empleados registrados");
            return;
        }
        System.out.println("----------LISTA DE EMPLEADOS----------");
        for (Empleado e: lista){
            System.out.println(e);
        }
    }
    //Regresar la lista de empleados (la usa la vista con ventanas)
    public ArrayList<Empleado> obtenerTodos(){
        return repositorio.obtenerTodos();
    }
    //Aqui para buscar por ID
    public Empleado buscarPorId(int id){
        return repositorio.buscarPorId(id);
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
            return repositorio.eliminar(e);
        }
        return false;
    }
}