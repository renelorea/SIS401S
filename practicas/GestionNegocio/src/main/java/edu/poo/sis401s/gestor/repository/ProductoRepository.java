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
    private static List<Producto> inventario = new ArrayList<>();
    
    public ProductoRepository() {
        
        if (inventario.isEmpty()) {
            cargarMockData();
        }
    }
    
    private void cargarMockData() {
        agregar(new Producto(1, "Jugo de naranja 1Lt", 28.50, 50));
        agregar(new Producto(2, "Galletas de animalitos 250gr", 15.00, 31));
        agregar(new Producto(3, "Galletas Gladiador 250gr", 18.00, 25));
        agregar(new Producto(4, "Nuka cola 600ml", 20.00, 86));
        agregar(new Producto(5, "Vim 600ml", 18.00, 123));
        agregar(new Producto(6, "Monster 600ml", 38.00, 10));
        agregar(new Producto(7, "Harina Zaragoza 1kg", 22.50, 82));
        agregar(new Producto(8, "Cajetilla de cigarros Marlboro", 75.00, 52));
        agregar(new Producto(9, "Cajetilla de cigarros Camel", 70.00, 31));
        agregar(new Producto(10, "Cajetilla de cigarros Faros", 50.00, 94));
        agregar(new Producto(11, "Paquete 6 cervezas Tecate", 115.00, 8));
        agregar(new Producto(12, "Paquete 6 cervezas Carta Blanca", 95.00, 56));
        agregar(new Producto(13, "Paquete 6 cervezas Victoria", 120.00, 16));
        agregar(new Producto(14, "Queso crema 250gr", 36.00, 72));
        agregar(new Producto(15, "Audifonos", 150.00, 15));
        
    }
    public boolean agregar(Producto producto) {
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
