/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;

import edu.poo.sis401s.gestor.model.Empleado;
import java.util.ArrayList;
/**
 *
 * @author Equipo 6
 */
public class EmpleadoRepository {
    private ArrayList<Empleado> listaEmpleados;

    public EmpleadoRepository() {
        listaEmpleados = new ArrayList<>();
    }

    // Guardar un empleado
    public void guardar(Empleado e) {
        listaEmpleados.add(e);
    }

    // Regresar todos los empleados
    public ArrayList<Empleado> obtenerTodos() {
        return new ArrayList<>(listaEmpleados);
    }

    // Buscar por ID (regresa null si no existe)
    public Empleado buscarPorId(int id) {
        for (Empleado e : listaEmpleados) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    // Eliminar un empleado
    public boolean eliminar(Empleado e) {
        return listaEmpleados.remove(e);
    }
}

