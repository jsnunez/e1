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

import com.empresa.empresa.application.service.IOrdenTrabajoService;
import com.empresa.empresa.domain.OrdenTrabajo;



@RestController
@RequestMapping("/api/orden-trabajo")
public class OrdenTrabajoController {

    @Autowired
    private IOrdenTrabajoService ordenTrabajoService;

    @GetMapping
    public ResponseEntity<List<OrdenTrabajo>> list() {
        List<OrdenTrabajo> ordenes = ordenTrabajoService.getAll();
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenTrabajo> show(@PathVariable Long id) {
        return ordenTrabajoService.findById(id)
                .map(ordenTrabajo -> new ResponseEntity<>(ordenTrabajo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<OrdenTrabajo> create(@RequestBody OrdenTrabajo ordenTrabajo) {
        OrdenTrabajo createdOrdenTrabajo = ordenTrabajoService.save(ordenTrabajo);
        return new ResponseEntity<>(createdOrdenTrabajo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdenTrabajo> update(@PathVariable Long id, @RequestBody OrdenTrabajo ordenTrabajo) {
        OrdenTrabajo updatedOrdenTrabajo = ordenTrabajoService.update(id, ordenTrabajo);
        if (updatedOrdenTrabajo != null) {
            return new ResponseEntity<>(updatedOrdenTrabajo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ordenTrabajoService.findById(id).isPresent()) {
            ordenTrabajoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}