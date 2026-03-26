package com.Msanchez.SistemaTickets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Msanchez.SistemaTickets.JPA.Usuario;

public interface IRepositoryUsuario extends JpaRepository<Usuario, Integer> {
    Usuario findByEmail(String email);
}
