package com.example.appdemo;

public class Tienda {
    private int id;
    private String nombreTienda;
    private String telefono;

    public Tienda(int id, String nombreTienda, String telefono) {
        this.id = id;
        this.nombreTienda = nombreTienda;
        this.telefono = telefono;
    }

    public Tienda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return nombreTienda;
    }
}
