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
import com.Msanchez.SistemaTickets.Service.ServiceTicket;

@RestController
@RequestMapping("api/ticket")
public class TicketRestController {

    @Autowired
    private ServiceTicket serviceTicket;

    @GetMapping
    public ResponseEntity GetAll() {
        Result result = serviceTicket.GetAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{IdTicket}")
    public ResponseEntity GetById(@PathVariable int IdTicket) {
        Result result = serviceTicket.GetById(IdTicket);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity Add(@RequestBody Ticketcompra ticketcompra) {
        Result result = serviceTicket.Add(ticketcompra);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{IdTicket}")
    public ResponseEntity Update(@RequestBody Ticketcompra ticketcompra, @PathVariable int IdTicket) {
        Result result = serviceTicket.Update(ticketcompra, IdTicket);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/ActualizarEstatus/{IdTicket}")
    public ResponseEntity UpdateEstatus(@RequestBody Ticketcompra ticketcompra, @PathVariable int IdTicket) {
        Result result = serviceTicket.UpdateEstatus(ticketcompra, IdTicket);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{IdTicket}")
    public ResponseEntity Delete(@PathVariable int IdTicket) {
        Result result = serviceTicket.Delete(IdTicket);
        return ResponseEntity.ok(result);
    }
}
