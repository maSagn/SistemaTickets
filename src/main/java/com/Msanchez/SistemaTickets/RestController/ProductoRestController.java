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

import com.Msanchez.SistemaTickets.JPA.Producto;
import com.Msanchez.SistemaTickets.JPA.Result;
import com.Msanchez.SistemaTickets.Service.ServiceProducto;

@RestController
@RequestMapping("api/producto")
public class ProductoRestController {

    @Autowired
    private ServiceProducto serviceProducto;

    @GetMapping
    public ResponseEntity GetAll() {
        Result result = serviceProducto.GetAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{IdProducto}")
    public ResponseEntity GetById(@PathVariable int IdProducto) {
        Result result = serviceProducto.GetById(IdProducto);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity Add(@RequestBody Producto producto) {
        Result result = serviceProducto.Add(producto);
        return ResponseEntity.ok(result);
    }

    @PatchMapping("/{IdProducto}")
    public ResponseEntity Update(@RequestBody Producto producto, @PathVariable int IdProducto) {
        Result result = serviceProducto.Update(producto, IdProducto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{IdProducto}")
    public ResponseEntity Delete(@PathVariable int IdProducto) {
        Result result = serviceProducto.Delete(IdProducto);
        return ResponseEntity.ok(result);
    }
}
