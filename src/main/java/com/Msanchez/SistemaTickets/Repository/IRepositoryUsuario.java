package com.Msanchez.SistemaTickets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Msanchez.SistemaTickets.JPA.Producto;

public interface IRepositoryUsuario extends JpaRepository<Producto, Integer> {
    
}
