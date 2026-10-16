/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona1;

/**
 *
 * @author HP
 */
class Personal {
    // Atributos de la clase
    private String nombre;
    private int edad;
    private String colorFavorito;
    private double estatura;
    private double peso;
    private String calle;
    private String numero;
    private String colonia;
    private String codigoPostal;
    private String estado;

    // Constructor para inicializar todos los datos
    public Personal(String nombre, int edad, String colorFavorito, double estatura, double peso, 
                    String calle, String numero, String colonia, String codigoPostal, String estado) {
        this.nombre = nombre;
        this.edad = edad;
        this.colorFavorito = colorFavorito;
        this.estatura = estatura;
        this.peso = peso;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
    }

    // Métodos Getter necesarios para mostrar los datos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstado() {
        return estado;
    }
}