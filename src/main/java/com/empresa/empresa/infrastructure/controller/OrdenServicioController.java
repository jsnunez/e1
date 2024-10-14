package com.empresa.empresa.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.empresa.application.service.IOrdenServicioService;
import com.empresa.empresa.domain.OrdenServicio;



@RestController
@RequestMapping("/api/ordenservicio")
public class OrdenServicioController {
    @Autowired
    private IOrdenServicioService ordenServicioService;

    @GetMapping
    public ResponseEntity<List<OrdenServicio>> list() {
        List<OrdenServicio> ordenes = ordenServicioService.getAll();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }
    @GetMapping("/{noOrden}")
    public ResponseEntity<OrdenServicio> show(@PathVariable Long noOrden) {
        return ordenServicioService.findById(noOrden)
                .map(orden -> new ResponseEntity<>(orden, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OrdenServicio> create(@RequestBody OrdenServicio ordenServicio) {
        OrdenServicio createdOrden = ordenServicioService.save(ordenServicio);
        return new ResponseEntity<>(createdOrden, HttpStatus.CREATED);
    }

    @PutMapping("/{noOrden}")
    public ResponseEntity<OrdenServicio> update(@PathVariable Long noOrden, @RequestBody OrdenServicio ordenServicio) {
        OrdenServicio updatedOrden = ordenServicioService.update(noOrden, ordenServicio);
        if (updatedOrden != null) {
            return new ResponseEntity<>(updatedOrden, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{noOrden}")
    public ResponseEntity<Void> delete(@PathVariable Long noOrden) {
        if (ordenServicioService.findById(noOrden).isPresent()) {
            ordenServicioService.deleteById(noOrden);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

