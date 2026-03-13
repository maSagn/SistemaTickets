package com.Msanchez.SistemaTickets.ML;

import java.util.Date;

public class Pagosticket {
    private int IdPago;
    private int NumeroPago;
    private int Folio;
    private double Monto;
    private Date FechaCreacion;

    public Ticketcompra Ticketcompra;

    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int idPago) {
        IdPago = idPago;
    }

    public int getNumeroPago() {
        return NumeroPago;
    }

    public void setNumeroPago(int numeroPago) {
        NumeroPago = numeroPago;
    }

    public int getFolio() {
        return Folio;
    }

    public void setFolio(int folio) {
        Folio = folio;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }

    public Date getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }

    public Ticketcompra getTicketcompra() {
        return Ticketcompra;
    }

    public void setTicketcompra(Ticketcompra ticketcompra) {
        Ticketcompra = ticketcompra;
    }
}
