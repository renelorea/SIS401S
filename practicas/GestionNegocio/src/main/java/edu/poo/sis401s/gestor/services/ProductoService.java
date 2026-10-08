/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.services;
import edu.poo.sis401s.gestor.model.Producto;
import edu.poo.sis401s.gestor.repository.ProductoRepository;
import java.util.List;
/**
 *
 * @author Dante
 */
public class ProductoService {
    private ProductoRepository productoRepository;

    public ProductoService() {
        this.productoRepository = new ProductoRepository();
    }
    public boolean registrarNuevoProducto(Producto nuevoProducto) {
        if (nuevoProducto.getPrecio() <= 0) {
            System.out.println("Error: El precio del producto debe ser mayor a 0.");
            return false;
        }
        if (nuevoProducto.getStock() < 0) {
            System.out.println("Error: El stock no puede ser negativo.");
            return false;
        
    }
        return productoRepository.agregar(nuevoProducto);
        
    }
    
    public List<Producto> listarInventario() {
        return productoRepository.listarTodos();
    }
    public Producto buscarProductoPorNombre(String nombre) {
        return productoRepository.buscarPorNombre(nombre);
    }
    
}
