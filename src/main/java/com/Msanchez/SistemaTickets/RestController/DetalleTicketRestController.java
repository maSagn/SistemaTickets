package com.Msanchez.SistemaTickets.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.JPA.Ticketcompra;
import com.Msanchez.SistemaTickets.Service.ServiceDetalleTicket;

@RestController
@RequestMapping("api/detalle")
public class DetalleTicketRestController {

    @Autowired
    private ServiceDetalleTicket serviceDetalleTicket;

    @GetMapping("/{IdDetalle}")
    public ResponseEntity GetById(@PathVariable int IdDetalle) {
        Result result = serviceDetalleTicket.GetById(IdDetalle);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity Add(@RequestBody Ticketcompra ticketcompra) {
        Result result = serviceDetalleTicket.Add(ticketcompra);
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    public ResponseEntity Update(@RequestBody Ticketcompra ticketcompra) {
        Result result = serviceDetalleTicket.Update(ticketcompra);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{IdDetalle}")
    public ResponseEntity Delete(@PathVariable int IdDetalle) {
        Result result = serviceDetalleTicket.Delete(IdDetalle);
        return ResponseEntity.ok(result);
    }
}
