package com.Msanchez.SistemaTickets.JPA;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto")
    private int IdProducto;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "preciounitario")
    private double PrecioUnitario;

    @Column(name = "descripcion")
    private String Descripcion;

    @OneToMany(mappedBy = "Producto")
    public List<Detalleticket> Detalleticket = new ArrayList<>();

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
    public List<Detalleticket> getDetalleticket() {
        return Detalleticket;
    }
    public void setDetalleticket(List<Detalleticket> detalleticket) {
        Detalleticket = detalleticket;
    }
}
