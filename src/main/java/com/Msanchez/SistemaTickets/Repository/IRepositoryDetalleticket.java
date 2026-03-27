package com.Msanchez.SistemaTickets.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Msanchez.SistemaTickets.JPA.Detalleticket;

import jakarta.transaction.Transactional;

public interface IRepositoryDetalleticket extends JpaRepository<Detalleticket, Integer> {

    @Query("SELECT d FROM Detalleticket d WHERE d.Ticketcompra.IdTicket = :idTicket")
    List<Detalleticket> findDetalleByTickets(@Param("idTicket") int idTicket);

    @Transactional
    @Modifying
    @Query("DELETE FROM Detalleticket d WHERE d.Ticketcompra.IdTicket = :idTicket")
    int deleteDetalleByTicket(@Param("idTicket") int idTicket);

    //Contar cuantos registros hay de determinado producto
    @Query("SELECT COUNT(d) FROM Detalleticket d WHERE d.Producto.IdProducto = :idProducto")
    int countByProductoId(@Param("idProducto") int idProducto);

}
