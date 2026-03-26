package com.Msanchez.SistemaTickets.JPA;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Ticketcompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idticket")
    private int IdTicket;

    @Column(name = "folio")
    private int Folio;

    @Column(name = "fechacreacion")
    private Date FechaCreacion;

    @Column(name = "fechapago")
    private Date FechaPago;

    @Column(name = "total")
    private double Total;

    @Column(name = "estatus")
    private String Estatus;
    
    @OneToMany(mappedBy = "Ticketcompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Detalleticket> Detalleticket = new ArrayList<>();

    @OneToMany(mappedBy = "Ticketcompra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Pagosticket> Pagosticket = new ArrayList<>();

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
    public List<Detalleticket> getDetalleticket() {
        return Detalleticket;
    }
    public void setDetalleticket(List<Detalleticket> detalleticket) {
        Detalleticket = detalleticket;
    }
    public List<Pagosticket> getPagosticket() {
        return Pagosticket;
    }
    public void setPagosticket(List<Pagosticket> pagosticket) {
        Pagosticket = pagosticket;
    }
}
