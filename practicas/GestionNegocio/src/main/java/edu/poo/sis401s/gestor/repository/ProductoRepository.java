/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.repository;
import edu.poo.sis401s.gestor.model.Producto;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dante
 */
public class ProductoRepository {
    private List<Producto> inventario;
    
    public ProductoRepository() {
        this.inventario = new ArrayList<>();
    }
    public boolean agregar(Producto producto){
        if (producto != null) {
            return inventario.add(producto);
        }
        return false;
    }
    public List<Producto> listarTodos() {
        return new ArrayList<>(inventario);
    }
    public Producto buscarPorId(int id) {
        for (Producto p : inventario) {
            if (p.getId() == id) {
                return p;
                
            }
        }
        return null;
    }
    public Producto buscarPorNombre(String nombre) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }
    public boolean eliminar(int id) {
        return inventario.removeIf(p -> p.getId() == id);
        
    }
}
