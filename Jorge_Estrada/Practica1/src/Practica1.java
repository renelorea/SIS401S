/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author HP
 */
 import java.util.Scanner;
 
public class Practica1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new
    Scanner(System.in);        
        Persona persona = new Persona();
        System.out.print("Escribir el nombre:");
        persona.setNombre(teclado.nextLine());
        System.out.print("Escribir la edad:");
        persona.setEdad(teclado.nextInt());
        teclado.nextLine(); // Limpia el salto pendiente
        System.out.print("Escribir el color:");
        persona. setColor(teclado.nextLine());
        System.out.print("Escribir el tamaño en metros:");
        persona.setTamaño(teclado.nextDouble());
        System.out.print("Escribir el peso en kiligramos:");
        persona.setPeso(teclado.nextDouble());
        
        System.out.print("Escribir la direccion:");
        persona.setDireccion(teclado.nextLine());
        System.out.print("Escribir la calle:");
        persona.setCalle(teclado.nextLine());
        System.out.print("Escribir la numero:");
        persona.setNumero(teclado.nextLine());
        System.out.print("Escribir la colonia:");
        persona.setColonia(teclado.nextLine());
        System.out.print("Escribir la cp:");
        persona.setCp(teclado.nextLine());
        System.out.print("Escribir el estado:");
        persona.setEstado(teclado.nextLine());
        System.out.print("Escribir el pais:");
        persona.setPais(teclado.nextLine());
        
        System.out.println("Datos de la persona:");
        System.out.println("Nombre:" + persona.getNombre());
        System.out.println("Edad:" + persona.getEdad());
        System.out.println("Color:"+ persona.getColor());
        System.out.println("Tamaño:" + persona.getTamaño());
        System.out.println("Peso:"+persona.getPeso());
        System.out.println("Dirección: " + persona.getDireccion());
        System.out.println("Calle: " + persona.getCalle());
        System.out.println("Número: " + persona.getNumero());
        System.out.println("Colonia: " + persona.getColonia());
        System.out.println("C.P.: " + persona.getCp());
        System.out.println("Estado: " + persona.getEstado());
        System.out.println("País: " + persona.getPais()); 
         teclado.close();
        // TODO code application logic here
    }
    
}
