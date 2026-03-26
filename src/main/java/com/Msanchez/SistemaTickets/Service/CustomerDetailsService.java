package com.Msanchez.SistemaTickets.Service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.JPA.Usuario;
import com.Msanchez.SistemaTickets.Repository.IRepositoryUsuario;

@Service
public class CustomerDetailsService implements UserDetailsService {

    private final IRepositoryUsuario iRepositoryUsuario;

    public CustomerDetailsService(IRepositoryUsuario iRepositoryUsuario) {
        this.iRepositoryUsuario = iRepositoryUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iRepositoryUsuario.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }

        return User.withUsername(usuario.getEmail())
                .password(usuario.getPassword())
                .roles(usuario.Rol.getNombre())
                .build();
    }

}
