/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persona1;

/**
 *
 * @author HP
 */
public class Practica2 {

    public static void main(String[] args) {
        
        
        // 1. Creamos un arreglo con espacio para 5 objetos de tipo Personal
        Personal[] listaPersonas = new Personal[5];

        // 2. Llenamos el arreglo con 5 personas diferentes utilizando el constructor
        listaPersonas[0] = new Personal("Juan Pérez", 25, "Azul", 1.75, 70.5, "Av. Reforma", "#123", "Centro", "54100", "CDMX");
        listaPersonas[1] = new Personal("María López", 30, "Rojo", 1.62, 58.0, "Calle Juárez", "#456", "Norte", "64000", "Nuevo León");
        listaPersonas[2] = new Personal("Carlos Gómez", 19, "Verde", 1.80, 82.3, "Blvd. Anaya", "#789-B", "Zapopan", "45100", "Jalisco");
        listaPersonas[3] = new Personal("Ana Martínez", 42, "Rosa", 1.55, 52.1, "Av. Hidalgo", "#12", "Sur", "72000", "Puebla");
        listaPersonas[4] = new Personal("Luis Hernández", 28, "Negro", 1.70, 75.0, "Calle Mina", "#505", "Poniente", "98000", "Zacatecas");

        // 3. Recorremos el arreglo con un ciclo para mostrar los datos en consola
        System.out.println("==================== LISTA DE PERSONAS ====================\n");
        
        for (int i = 0; i < listaPersonas.length; i++) {
            System.out.println("---------- PERSONA #" + (i + 1) + " ----------");
            System.out.println("Nombre: " + listaPersonas[i].getNombre());
            System.out.println("Edad  : " + listaPersonas[i].getEdad() + " años");
            System.out.println("Estado: " + listaPersonas[i].getEstado());
            System.out.println();
        }
    }
}
