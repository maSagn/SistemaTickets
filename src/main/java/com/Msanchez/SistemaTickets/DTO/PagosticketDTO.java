package com.Msanchez.SistemaTickets.DTO;

import java.util.Date;

public class PagosticketDTO {
    private int IdPago;
    private int NumeroPago;
    private int Folio;
    private double Monto;
    private Date FechaCreacion;

    private TicketDTO ticketDTO;

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

    public TicketDTO getTicketDTO() {
        return ticketDTO;
    }

    public void setTicketDTO(TicketDTO ticketDTO) {
        this.ticketDTO = ticketDTO;
    }
}
