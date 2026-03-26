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
import com.Msanchez.SistemaTickets.Service.ServicePagosTicket;

@RestController
@RequestMapping("api/pago")
public class PagosTicketRestController {

    @Autowired
    private ServicePagosTicket servicePagosTicket;

    @GetMapping("/{IdPago}")
    public ResponseEntity GetById(@PathVariable int IdPago) {
        Result result = servicePagosTicket.GetById(IdPago);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/pagos/{IdTicket}")
    public ResponseEntity GetPagosByTicket(@PathVariable int IdTicket) {
        Result result = servicePagosTicket.GetPagosByTicket(IdTicket);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity Add(@RequestBody Ticketcompra ticketcompra) {
        Result result = servicePagosTicket.Add(ticketcompra);
        return ResponseEntity.ok(result);
    }

    @PatchMapping
    public ResponseEntity Update(@RequestBody Ticketcompra ticketcompra) {
        Result result = servicePagosTicket.Update(ticketcompra);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{IdPago}")
    public ResponseEntity Delete(@PathVariable int IdPago) {
        Result result = servicePagosTicket.Delete(IdPago);
        return ResponseEntity.ok(result);
    }


}
