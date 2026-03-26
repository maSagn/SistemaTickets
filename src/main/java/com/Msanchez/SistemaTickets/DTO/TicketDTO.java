package com.Msanchez.SistemaTickets.DTO;

import java.util.Date;
import java.util.List;

public class TicketDTO {
    private int IdTicket;
    private int Folio;
    private Date FechaCreacion;
    private Date FechaPago;
    private double Total;
    private String Estatus;
    private List<DetalleticketDTO> Detalleticket;
    
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
    public double getTotal() {
        return Total;
    }
    public void setTotal(double total) {
        Total = total;
    }
    public String getEstatus() {
        return Estatus;
    }
    public void setEstatus(String estatus) {
        Estatus = estatus;
    }
    public List<DetalleticketDTO> getDetalleticket() {
        return Detalleticket;
    }
    public void setDetalleticket(List<DetalleticketDTO> detalleticket) {
        Detalleticket = detalleticket;
    }
}
