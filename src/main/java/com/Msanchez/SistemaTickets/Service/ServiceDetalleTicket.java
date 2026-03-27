package com.Msanchez.SistemaTickets.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.DTO.DetalleticketDTO;
import com.Msanchez.SistemaTickets.DTO.ProductoDTO;
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

    // Uno solo
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

    // Todos los detalles en base al ticket
    public Result GetDetalleByTicket(int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticket = iRepositoryTicketcompra.findById(IdTicket);

            if (ticket.isPresent()) {
                List<Detalleticket> detalles = iRepositoryDetalleticket.findDetalleByTickets(IdTicket);

                List<DetalleticketDTO> detallesDTO = new ArrayList<>();

                for (Detalleticket d : detalles) {
                    DetalleticketDTO dto = new DetalleticketDTO();
                    dto.setCantidad(d.getCantidad());
                    dto.setPrecioUnitario(d.getPrecioUnitario());
                    dto.setTotalLinea(d.getTotalLinea());

                    // Mapeamos Producto a ProductoDTO
                    ProductoDTO prodDTO = new ProductoDTO();
                    prodDTO.setIdProducto(d.getProducto().getIdProducto());
                    prodDTO.setNombre(d.getProducto().getNombre());
                    prodDTO.setPrecioUnitario(d.getProducto().getPrecioUnitario());
                    prodDTO.setDescripcion(d.getProducto().getDescripcion());

                    dto.setProductoDTO(prodDTO);

                    detallesDTO.add(dto);
                }

                result.object = detallesDTO;
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
                for (Detalleticket detalleItem : ticketcompra.Detalleticket) {

                    Detalleticket detalleticket = new Detalleticket();

                    detalleticket.Ticketcompra = new Ticketcompra();
                    detalleticket.Ticketcompra.setIdTicket(ticketcompra.getIdTicket());

                    detalleticket.Producto = new Producto();
                    detalleticket.Producto.setIdProducto(
                            detalleItem.Producto.getIdProducto());

                    detalleticket.setCantidad(detalleItem.getCantidad());
                    detalleticket.setPrecioUnitario(detalleItem.getPrecioUnitario());
                    detalleticket.setTotalLinea(detalleItem.getTotalLinea());

                    iRepositoryDetalleticket.save(detalleticket);
                }

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

    // Uno solo
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

    // Todos los detalles en base al ticket
    public Result DeleteDetallesByTicket(int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticket = iRepositoryTicketcompra.findById(IdTicket);

            if (ticket.isPresent()) {
                iRepositoryDetalleticket.deleteDetalleByTicket(IdTicket);
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
