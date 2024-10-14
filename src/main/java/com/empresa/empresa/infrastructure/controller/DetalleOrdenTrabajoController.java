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

import com.empresa.empresa.application.service.IDetalleOrdenTrabajoService;
import com.empresa.empresa.domain.DetalleOrdenTrabajo;



@RestController
@RequestMapping("/api/detalleordentrabajo")
public class DetalleOrdenTrabajoController {
    @Autowired
    private IDetalleOrdenTrabajoService detalleOrdenTrabajoService;

    @GetMapping
    public ResponseEntity<List<DetalleOrdenTrabajo>> list() {
        List<DetalleOrdenTrabajo> detalles = detalleOrdenTrabajoService.getAll();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleOrdenTrabajo> show(@PathVariable Long id) {
        return detalleOrdenTrabajoService.findById(id)
                .map(detalle -> new ResponseEntity<>(detalle, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetalleOrdenTrabajo> create(@RequestBody DetalleOrdenTrabajo detalle) {
        DetalleOrdenTrabajo createdDetalle = detalleOrdenTrabajoService.save(detalle);
        return new ResponseEntity<>(createdDetalle, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleOrdenTrabajo> update(@PathVariable Long id, @RequestBody DetalleOrdenTrabajo detalle) {
        DetalleOrdenTrabajo updatedDetalle = detalleOrdenTrabajoService.update(id, detalle);
        if (updatedDetalle != null) {
            return new ResponseEntity<>(updatedDetalle, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (detalleOrdenTrabajoService.findById(id).isPresent()) {
            detalleOrdenTrabajoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}