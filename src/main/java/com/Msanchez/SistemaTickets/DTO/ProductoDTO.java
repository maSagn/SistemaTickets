package com.Msanchez.SistemaTickets.DTO;

public class ProductoDTO {
    private String Nombre;
    private double PrecioUnitario;
    private String Descripcion;

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public double getPrecioUnitario() {
        return PrecioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        PrecioUnitario = precioUnitario;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
