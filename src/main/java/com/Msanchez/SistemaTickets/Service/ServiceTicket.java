package com.Msanchez.SistemaTickets.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Ticketcompra;
import com.Msanchez.SistemaTickets.Repository.IRepositoryTicketcompra;

@Service
public class ServiceTicket {

    @Autowired
    private IRepositoryTicketcompra iRepositoryTicketcompra;

    public Result GetAll() {
        Result result = new Result();

        try {
            List<Ticketcompra> ticketscompras = iRepositoryTicketcompra.findAll();
            result.object = ticketscompras;
            result.correct = true;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result GetById(int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketcompra = iRepositoryTicketcompra.findById(IdTicket);
            
            if (ticketcompra.isPresent()) {
                result.object = ticketcompra;
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
            Ticketcompra savedTicketcompra = iRepositoryTicketcompra.save(ticketcompra);
            result.object = savedTicketcompra;
            result.correct = true;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Update(Ticketcompra ticketcompra, int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketFind = iRepositoryTicketcompra.findById(IdTicket);

            if (ticketFind.isPresent()) {
                Ticketcompra ticketExistente = ticketFind.get();

                ticketExistente.setFolio(ticketcompra.getFolio());
                ticketExistente.setFechaCreacion(ticketcompra.getFechaCreacion());
                ticketExistente.setFechaPago(ticketcompra.getFechaPago());
                ticketExistente.setTotal(ticketcompra.getTotal());
                ticketExistente.setEstatus(ticketcompra.getEstatus());

                Ticketcompra updatedTicket = iRepositoryTicketcompra.save(ticketExistente);
                result.object = updatedTicket;
                result.correct = true;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Delete(int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketFind = iRepositoryTicketcompra.findById(IdTicket);

            if (ticketFind.isPresent()) {
                iRepositoryTicketcompra.deleteById(IdTicket);
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
