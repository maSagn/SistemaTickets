package com.Msanchez.SistemaTickets.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.Service.ServiceUsuario;

@RestController
@RequestMapping("api/usuario")
public class UsuarioRestController {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping
    public ResponseEntity GetAll() {
        Result result = serviceUsuario.GetAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{IdUsuario}")
    public ResponseEntity GetById(@PathVariable int IdUsuario) {
        Result result = serviceUsuario.GetById(IdUsuario);
        return ResponseEntity.ok(result);
    }
}
