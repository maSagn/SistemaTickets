package com.Msanchez.SistemaTickets.ML;

import java.util.Date;

public class Ticketcompra {
    private int IdTicket;
    private int Folio;
    private Date FechaCreacion;
    private Date FechaPago;
    private int CantidadComprada;
    private int PrecioUnitario;
    private double TotalLinea;
    private String Estatus;

    public Producto producto;

    public int getIdTicket() {
        return IdTicket;
    }

    public void setIdTicket(int idTicket) {
        IdTicket = idTicket;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int folio) {
        Folio = folio;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Date getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        FechaPago = fechaPago;
    }

    public int getCantidadComprada() {
        return CantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        CantidadComprada = cantidadComprada;
    }

    public int getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        PrecioUnitario = precioUnitario;
    }

    public double getTotalLinea() {
        return TotalLinea;
    }

    public void setTotalLinea(double totalLinea) {
        TotalLinea = totalLinea;
    }

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String estatus) {
        Estatus = estatus;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
