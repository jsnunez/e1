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

import com.empresa.empresa.application.service.IDetalleOrdenService;
import com.empresa.empresa.domain.Detalle_Orden;



@RestController
@RequestMapping("/api/detalleorden")
public class DetalleOrdenController {
    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    @GetMapping
    public ResponseEntity<List<Detalle_Orden>> list() {
        List<Detalle_Orden> detalles = detalleOrdenService.getAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detalle_Orden> show(@PathVariable Long id) {
        return detalleOrdenService.findById(id)
                .map(detalle -> new ResponseEntity<>(detalle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Detalle_Orden> create(@RequestBody Detalle_Orden detalle) {
        Detalle_Orden createdDetalle = detalleOrdenService.save(detalle);
        return new ResponseEntity<>(createdDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Detalle_Orden> update(@PathVariable Long id, @RequestBody Detalle_Orden detalle) {
        Detalle_Orden updatedDetalle = detalleOrdenService.update(id, detalle);
        if (updatedDetalle != null) {
            return new ResponseEntity<>(updatedDetalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (detalleOrdenService.findById(id).isPresent()) {
            detalleOrdenService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}