package com.Msanchez.SistemaTickets.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Msanchez.SistemaTickets.JPA.Ticketcompra;

public interface IRepositoryTicketcompra extends JpaRepository<Ticketcompra, Integer> {

    @Query("SELECT t FROM Ticketcompra t ORDER BY t.IdTicket DESC")
    List<Ticketcompra> findAllOrderByDesc();
}
