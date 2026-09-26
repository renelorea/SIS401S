package com.poo.sis401s;

public class Direccion {

    String calle;
    int numero;
    String colonia;
    int codigopostal;
    String Estado;
    String Pais;
  
       public Direccion(String string, int i, String string2, int j, String string3, String string4) {
        this.calle = string;
        this.numero = i;
        this.colonia = string2;
        this.codigopostal = j;
        this.Estado = string3;
        this.Pais = string4;
    }

       public String getCalleString(String string) {
        return calle;

    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero(int numero) {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getColonia(String colonia) {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCodigoPostal(int codigopostal) {
        return codigopostal;
    }

    public void setCodigoPostal(int codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getEstado(String Estado) {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getPais(String Pais) {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }
}