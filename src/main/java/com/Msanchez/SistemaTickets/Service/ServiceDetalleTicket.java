package com.Msanchez.SistemaTickets.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Msanchez.SistemaTickets.JPA.Detalleticket;
import com.Msanchez.SistemaTickets.JPA.Producto;
import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Ticketcompra;
import com.Msanchez.SistemaTickets.Repository.IRepositoryDetalleticket;
import com.Msanchez.SistemaTickets.Repository.IRepositoryTicketcompra;

@Service
public class ServiceDetalleTicket {

    @Autowired
    private IRepositoryDetalleticket iRepositoryDetalleticket;

    @Autowired
    private IRepositoryTicketcompra iRepositoryTicketcompra;

    public Result GetById(int IdDetalle) {
        Result result = new Result();

        try {
            Optional<Detalleticket> detalleticket = iRepositoryDetalleticket.findById(IdDetalle);

            if (detalleticket.isPresent()) {
                result.object = detalleticket;
                result.correct = true;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Add(@RequestBody Ticketcompra ticketcompra) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketFind = iRepositoryTicketcompra.findById(ticketcompra.getIdTicket());

            if (ticketFind.isPresent()) {
                Detalleticket detalleticket = new Detalleticket();
                detalleticket.Ticketcompra = new Ticketcompra();
                detalleticket.Ticketcompra.setIdTicket(ticketcompra.getIdTicket());
                detalleticket.Producto = new Producto();
                detalleticket.Producto.setIdProducto(ticketcompra.Detalleticket.get(0).Producto.getIdProducto());
                detalleticket.setCantidad(ticketcompra.Detalleticket.get(0).getCantidad());
                detalleticket.setPrecioUnitario(ticketcompra.Detalleticket.get(0).getPrecioUnitario());
                detalleticket.setTotalLinea(ticketcompra.Detalleticket.get(0).getTotalLinea());

                Detalleticket savedDetalle = iRepositoryDetalleticket.save(detalleticket);

                result.object = savedDetalle;
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
            Detalleticket detalle = new Detalleticket();
            detalle.setIdDetalle(ticketcompra.Detalleticket.get(0).getIdDetalle());
            Optional<Detalleticket> detalleFind = iRepositoryDetalleticket.findById(detalle.getIdDetalle());

            if (detalleFind.isPresent()) {
                detalle.setCantidad(ticketcompra.Detalleticket.get(0).getCantidad());
                detalle.setPrecioUnitario(ticketcompra.Detalleticket.get(0).getPrecioUnitario());
                detalle.setTotalLinea(ticketcompra.Detalleticket.get(0).getTotalLinea());

                detalle.Ticketcompra = new Ticketcompra();
                detalle.Ticketcompra.setIdTicket(ticketcompra.getIdTicket());

                detalle.Producto = new Producto();
                detalle.Producto.setIdProducto(ticketcompra.Detalleticket.get(0).Producto.getIdProducto());

                Detalleticket savedDetalleticket = iRepositoryDetalleticket.save(detalle);

                result.object = savedDetalleticket;
                result.correct = true;
            }
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result Delete(int IdDetalle) {
        Result result = new Result();

        try {
            Optional<Detalleticket> detalleFind = iRepositoryDetalleticket.findById(IdDetalle);

            if (detalleFind.isPresent()) {
                iRepositoryDetalleticket.deleteById(IdDetalle);
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
