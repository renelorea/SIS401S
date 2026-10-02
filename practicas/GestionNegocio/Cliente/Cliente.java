package edu.poo.sis401s.gestor.negocio;

import java.time.LocalDate;

public class Cliente {
    // 1. ATRIBUTOS PRIVADOS
    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private String tipoPerfil;
    private LocalDate fechaRegistro;

    // 2. CONSTRUCTORES
    public Cliente(int id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoPerfil = "Persona";
        this.fechaRegistro = LocalDate.now();
    }

    public Cliente(int id, String nombre, String correo, String telefono, String tipoPerfil, LocalDate fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoPerfil = tipoPerfil;
        this.fechaRegistro = fechaRegistro;
    }

    // 3. GETTERS AND SETTERS
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getTipoPerfil() { return tipoPerfil; }
    public void setTipoPerfil(String tipoPerfil) { this.tipoPerfil = tipoPerfil; }

    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDate fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    // 4. MÉTODO TOSTRING
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipoPerfil='" + tipoPerfil + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
