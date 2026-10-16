/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Persona {

    // 1. ATRIBUTOS
    private String nombre;
    private int edad;
    private String color;
    private double tamaño;
    private double peso;
    
    private String direccion;
    private String calle;
    private String numero;
    private String colonia;
    private String cp;
    private String estado;
    private String pais;

    // 2. CONSTRUCTOR VACÍO (Para que funcione tu código anterior)
    public Persona() {
    }

    // 3. CONSTRUCTOR COMPLETO (Para crear la persona con todos los datos)
    public Persona(String nombre, int edad, String color, double tamaño, double peso, 
                   String direccion, String calle, String numero, String colonia, 
                   String cp, String estado, String pais) {
        this.nombre = nombre;
        this.edad = edad;
        this.color = color;
        this.tamaño = tamaño;
        this.peso = peso;
        this.direccion = direccion;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.cp = cp;
        this.estado = estado;
        this.pais = pais;
    }

    // 4. MÉTODO TOSTRING
    @Override
    public String toString() {
        return "Persona: " + nombre + "\n" +
               "Edad: " + edad + " años\n" +
               "Color: " + color + "\n" +
               "Tamaño: " + tamaño + " m\n" +
               "Peso: " + peso + " kg\n" +
               "Dirección Completa: " + direccion + "\n" +
               "Calle: " + calle + " No. " + numero + "\n" +
               "Colonia: " + colonia + " C.P.: " + cp + "\n" +
               "Estado: " + estado + ", País: " + pais;
    }

    // 5. GETTERS Y SETTERS
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public double getTamaño() { return tamaño; }
    public void setTamaño(double tamaño) { this.tamaño = tamaño; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getColonia() { return colonia; }
    public void setColonia(String colonia) { this.colonia = colonia; }

    public String getCp() { return cp; }
    public void setCp(String cp) { this.cp = cp; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
}