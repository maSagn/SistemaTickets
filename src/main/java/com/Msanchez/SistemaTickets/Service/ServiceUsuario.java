package com.Msanchez.SistemaTickets.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Usuario;
import com.Msanchez.SistemaTickets.Repository.IRepositoryUsuario;

@Service
public class ServiceUsuario {

    @Autowired
    private IRepositoryUsuario iRepositoryUsuario;

    public Result GetAll() {
        Result result = new Result();

        try {
            List<Usuario> usuarios = iRepositoryUsuario.findAll();
            result.object = usuarios;
            result.correct = true;
            
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
        }

        return result;
    }

    public Result GetById(int IdUsuario) {
        Result result = new Result();

        try {
            Optional<Usuario> usuario = iRepositoryUsuario.findById(IdUsuario);

            if (usuario.isPresent()) {
                result.object = usuario;
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
