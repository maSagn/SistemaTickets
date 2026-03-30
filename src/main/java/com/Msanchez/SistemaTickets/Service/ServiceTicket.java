package com.Msanchez.SistemaTickets.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.DTO.TicketDTO;
import com.Msanchez.SistemaTickets.DTO.UsuarioDTO;
import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Ticketcompra;
import com.Msanchez.SistemaTickets.Repository.IRepositoryTicketcompra;

@Service
public class ServiceTicket {

    @Autowired
    private IRepositoryTicketcompra iRepositoryTicketcompra;

    public Result GetAll(Ticketcompra ticket) {
        Result result = new Result();

        try {
            if (ticket == null || ticket.getEstatus() == null || ticket.getEstatus().isEmpty()) {
                List<Ticketcompra> ticketscompras = iRepositoryTicketcompra.findAllOrderByDesc();

                List<TicketDTO> listaDTO = new ArrayList<>();

                for (Ticketcompra t : ticketscompras) {
                    TicketDTO dto = new TicketDTO();
                    dto.setIdTicket(t.getIdTicket());
                    dto.setFolio(t.getFolio());
                    dto.setTotal(t.getTotal());
                    dto.setFechaCreacion(t.getFechaCreacion());
                    dto.setFechaPago(t.getFechaPago());
                    dto.setEstatus(t.getEstatus());

                    UsuarioDTO userDTO = new UsuarioDTO();
                    userDTO.setIdUsuario(t.getUsuario().getIdUsuario());

                    dto.setUsuarioDTO(userDTO);

                    listaDTO.add(dto);
                }

                result.object = listaDTO;
                result.correct = true;
            }
            
            else if ("PENDIENTE".equalsIgnoreCase(ticket.getEstatus())) {
                List<Ticketcompra> tickets = iRepositoryTicketcompra.findAllOrderByDesc();
                List<Ticketcompra> ticketsPendientes = tickets.stream()
                        .filter(t -> ticket.getEstatus() == null || ticket.getEstatus().isEmpty()
                                || t.getEstatus().toUpperCase().equals(ticket.getEstatus().toUpperCase()))
                        .collect(Collectors.toList());

                List<TicketDTO> listaDTOPendientes = new ArrayList<>();

                for (Ticketcompra t : ticketsPendientes) {
                    TicketDTO dto = new TicketDTO();
                    dto.setIdTicket(t.getIdTicket());
                    dto.setFolio(t.getFolio());
                    dto.setTotal(t.getTotal());
                    dto.setFechaCreacion(t.getFechaCreacion());
                    dto.setFechaPago(t.getFechaPago());
                    dto.setEstatus(t.getEstatus());

                    UsuarioDTO userDTO = new UsuarioDTO();
                    userDTO.setIdUsuario(t.getUsuario().getIdUsuario());

                    dto.setUsuarioDTO(userDTO);

                    listaDTOPendientes.add(dto);
                }


                result.object = listaDTOPendientes;
                result.correct = true;
            }

            else if ("PAGADO".equalsIgnoreCase(ticket.getEstatus())) {
                List<Ticketcompra> tickets = iRepositoryTicketcompra.findAllOrderByDesc();
                List<Ticketcompra> ticketsPagados = tickets.stream()
                        .filter(t -> ticket.getEstatus() == null || ticket.getEstatus().isEmpty()
                                || t.getEstatus().toUpperCase().equals(ticket.getEstatus().toUpperCase()))
                        .collect(Collectors.toList());

                List<TicketDTO> listaDTOPagados = new ArrayList<>();

                for (Ticketcompra t : ticketsPagados) {
                    TicketDTO dto = new TicketDTO();
                    dto.setIdTicket(t.getIdTicket());
                    dto.setFolio(t.getFolio());
                    dto.setTotal(t.getTotal());
                    dto.setFechaCreacion(t.getFechaCreacion());
                    dto.setFechaPago(t.getFechaPago());
                    dto.setEstatus(t.getEstatus());

                    UsuarioDTO userDTO = new UsuarioDTO();
                    userDTO.setIdUsuario(t.getUsuario().getIdUsuario());

                    dto.setUsuarioDTO(userDTO);

                    listaDTOPagados.add(dto);
                }

                result.object = listaDTOPagados;
                result.correct = true;
            }

            

        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    // public Result GetAll() {
    // Result result = new Result();

    // try {
    // List<Ticketcompra> ticketscompras =
    // iRepositoryTicketcompra.findAllOrderByDesc();

    // List<TicketDTO> listaDTO = new ArrayList<>();

    // for (Ticketcompra t : ticketscompras) {
    // TicketDTO dto = new TicketDTO();
    // dto.setIdTicket(t.getIdTicket());
    // dto.setFolio(t.getFolio());
    // dto.setTotal(t.getTotal());
    // dto.setFechaCreacion(t.getFechaCreacion());
    // dto.setFechaPago(t.getFechaPago());
    // dto.setEstatus(t.getEstatus());

    // UsuarioDTO userDTO = new UsuarioDTO();
    // userDTO.setIdUsuario(t.getUsuario().getIdUsuario());

    // dto.setUsuarioDTO(userDTO);

    // listaDTO.add(dto);
    // }

    // result.object = listaDTO;
    // result.correct = true;

    // } catch (Exception ex) {
    // result.correct = false;
    // result.errorMessage = ex.getLocalizedMessage();
    // result.ex = ex;
    // }

    // return result;
    // }

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

    public Result UpdateEstatus(Ticketcompra ticketcompra, int IdTicket) {
        Result result = new Result();

        try {
            Optional<Ticketcompra> ticketFind = iRepositoryTicketcompra.findById(IdTicket);

            if (ticketFind.isPresent()) {
                Ticketcompra ticketExistente = ticketFind.get();

                ticketExistente.setEstatus(ticketcompra.getEstatus());
                ticketExistente.setFechaPago(new Date());

                Ticketcompra updatedTicket = iRepositoryTicketcompra.save(ticketExistente);
                // result.object = updatedTicket;
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
