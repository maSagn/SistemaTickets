package com.Msanchez.SistemaTickets.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Msanchez.SistemaTickets.JPA.Pagosticket;

import jakarta.transaction.Transactional;

public interface IRepositoryPagosticket extends JpaRepository<Pagosticket, Integer> {

    @Query("SELECT p FROM Pagosticket p WHERE p.Ticketcompra.IdTicket = :idTicket")
    List<Pagosticket> findPagosByTicket(@Param("idTicket") int idTicket);

    @Transactional
    @Modifying
    @Query("DELETE FROM Pagosticket p WHERE p.Ticketcompra.IdTicket = :idTicket")
    int deletePagosByTicket(@Param("idTicket") int idTicket);
}
