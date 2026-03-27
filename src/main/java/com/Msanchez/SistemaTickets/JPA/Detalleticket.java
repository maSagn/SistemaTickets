package com.Msanchez.SistemaTickets.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Detalleticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddetalle")
    private int IdDetalle;

    @Column(name = "cantidad")
    private int Cantidad;

    @Column(name = "preciounitario")
    private double PrecioUnitario;

    @Column(name = "totallinea")
    private double TotalLinea;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idticket")
    public Ticketcompra Ticketcompra;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproducto")
    public Producto Producto;

    public int getIdDetalle() {
        return IdDetalle;
    }
    public void setIdDetalle(int idDetalle) {
        IdDetalle = idDetalle;
    }
    public int getCantidad() {
        return Cantidad;
    }
    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }
    public double getPrecioUnitario() {
        return PrecioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        PrecioUnitario = precioUnitario;
    }
    public double getTotalLinea() {
        return TotalLinea;
    }
    public void setTotalLinea(double totalLinea) {
        TotalLinea = totalLinea;
    }
    public Producto getProducto() {
        return Producto;
    }
    public void setProducto(Producto producto) {
        Producto = producto;
    }
    public Ticketcompra getTicketcompra() {
        return Ticketcompra;
    }
    public void setTicketcompra(Ticketcompra ticketcompra) {
        Ticketcompra = ticketcompra;
    }
}
