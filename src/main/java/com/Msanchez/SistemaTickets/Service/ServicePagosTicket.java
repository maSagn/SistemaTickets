package com.Msanchez.SistemaTickets.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.JPA.Pagosticket;
import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Ticketcompra;
import com.Msanchez.SistemaTickets.Repository.IRepositoryPagosticket;
import com.Msanchez.SistemaTickets.Repository.IRepositoryTicketcompra;

@Service
public class ServicePagosTicket {

    @Autowired
    private IRepositoryPagosticket iRepositoryPagosticket;

    @Autowired IRepositoryTicketcompra iRepositoryTicketcompra;

    public Result GetById(int IdPago) {
        Result result = new Result();

        try {
            Optional<Pagosticket> pagoticket = iRepositoryPagosticket.findById(IdPago);
            
            if (pagoticket.isPresent()) {
                result.object = pagoticket;
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Add(Ticketcompra ticketcompra) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketFind = iRepositoryTicketcompra.findById(ticketcompra.getIdTicket());

            if (ticketFind.isPresent()) {
                Pagosticket pagoticket = new Pagosticket();

                pagoticket.Ticketcompra = new Ticketcompra();
                pagoticket.Ticketcompra.setIdTicket(ticketcompra.getIdTicket());

                pagoticket.setNumeroPago(ticketcompra.Pagosticket.get(0).getNumeroPago());
                pagoticket.setFolio(ticketcompra.Pagosticket.get(0).getFolio());
                pagoticket.setMonto(ticketcompra.Pagosticket.get(0).getMonto());
                pagoticket.setFechaCreacion(ticketcompra.Pagosticket.get(0).getFechaCreacion());

                Pagosticket savePago = iRepositoryPagosticket.save(pagoticket);

                result.object = savePago;
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Update(Ticketcompra ticketcompra) {
        Result result = new Result();

        try {
            Pagosticket pago = new Pagosticket();
            pago.setIdPago(ticketcompra.Pagosticket.get(0).getIdPago());
            Optional<Pagosticket> pagoFind = iRepositoryPagosticket.findById(pago.getIdPago());

            if (pagoFind.isPresent()) {
                pago.Ticketcompra = new Ticketcompra();
                pago.Ticketcompra.setIdTicket(ticketcompra.getIdTicket());
                pago.setNumeroPago(ticketcompra.Pagosticket.get(0).getNumeroPago());
                pago.setFolio((ticketcompra.Pagosticket.get(0).getFolio()));
                pago.setMonto(ticketcompra.Pagosticket.get(0).getMonto());
                pago.setFechaCreacion(ticketcompra.Pagosticket.get(0).getFechaCreacion());

                Pagosticket savedPago = iRepositoryPagosticket.save(pago);

                result.object = savedPago;
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Delete(int IdPago) {
        Result result = new Result();

        try {
            Optional<Pagosticket> pagoFind = iRepositoryPagosticket.findById(IdPago);

            if (pagoFind.isPresent()) {
                iRepositoryPagosticket.deleteById(IdPago);
                result.correct = true;
            }

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }
}
