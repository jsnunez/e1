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

import com.empresa.empresa.application.service.IEstadoOrdenService;
import com.empresa.empresa.domain.EstadoOrden;


@RestController
@RequestMapping("/api/estado-orden")
public class EstadoOrdenController {

    @Autowired
    private IEstadoOrdenService estadoOrdenService;

    @GetMapping
    public ResponseEntity<List<EstadoOrden>> list() {
        List<EstadoOrden> estados = estadoOrdenService.getAll();
        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoOrden> show(@PathVariable Long id) {
        return estadoOrdenService.findById(id)
                .map(estado -> new ResponseEntity<>(estado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EstadoOrden> create(@RequestBody EstadoOrden estado) {
        EstadoOrden createdEstado = estadoOrdenService.save(estado);
        return new ResponseEntity<>(createdEstado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoOrden> update(@PathVariable Long id, @RequestBody EstadoOrden estado) {
        EstadoOrden updatedEstado = estadoOrdenService.update(id, estado);
        if (updatedEstado != null) {
            return new ResponseEntity<>(updatedEstado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (estadoOrdenService.findById(id).isPresent()) {
            estadoOrdenService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}