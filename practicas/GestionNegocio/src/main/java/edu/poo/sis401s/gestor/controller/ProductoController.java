/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poo.sis401s.gestor.controller;
import edu.poo.sis401s.gestor.model.Producto;
import edu.poo.sis401s.gestor.services.ProductoService;
import java.util.List;
/**
 *
 * @author Dante
 */
public class ProductoController {
    private ProductoService productoService;
    
    public boolean eliminarProducto(int id) {
        return productoService.eliminarProducto(id);
    }

    public ProductoController() {
       this.productoService = new ProductoService(); 
    
    }
    public boolean agregarAlmacen(int id, String nombre, double precio, int stock) {
        Producto nuevoProducto = new Producto(id, nombre, precio, stock);
        return productoService.registrarNuevoProducto(nuevoProducto);
    }
    public List<Producto> obtenerInventario() {
        return productoService.listarInventario();
    }
    public Producto buscarPorNombre(String nombre) {
        return productoService.buscarProductoPorNombre(nombre);
    }
}
