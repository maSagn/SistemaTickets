package com.Msanchez.SistemaTickets.ML;

public class Detalleticket {
    private int IdDetalle;
    private int Cantidad;
    private double PrecioUnitario;
    private double TotalLinea;

    public Ticketcompra Ticketcompra;
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
