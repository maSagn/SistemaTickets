package com.Msanchez.SistemaTickets.JPA;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Pagosticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpago")
    private int IdPago;

    @Column(name = "numeropago")
    private int NumeroPago;

    @Column(name = "folio")
    private int Folio;

    @Column(name = "monto")
    private double Monto;

    @Column(name = "fechacreacion")
    private Date FechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idticket")
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
