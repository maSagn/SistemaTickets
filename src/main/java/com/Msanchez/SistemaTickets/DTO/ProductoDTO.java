package com.Msanchez.SistemaTickets.DTO;

public class ProductoDTO {
    private int IdProducto;
    private String Nombre;
    private double PrecioUnitario;
    private String Descripcion;
    private String Imagen;

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
    public String getImagen() {
        return Imagen;
    }
    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
