package com.Msanchez.SistemaTickets.ML;

public class Producto {
    private int IdProducto;
    private String Nombre;
    private String Descripcion;

    public int getIdProducto() {
        return IdProducto;
    }
    public void setIdProducto(int idProducto) {
        IdProducto = idProducto;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
