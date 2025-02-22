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

import com.empresa.empresa.application.service.IInsumoService;
import com.empresa.empresa.domain.Insumo;



@RestController
@RequestMapping("/api/insumo")
public class InsumoController {

    @Autowired
    private IInsumoService insumoService;

    @GetMapping
    public ResponseEntity<List<Insumo>> list() {
        List<Insumo> insumos = insumoService.getAll();
        return new ResponseEntity<>(insumos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insumo> show(@PathVariable Long id) {
        return insumoService.findById(id)
                .map(insumo -> new ResponseEntity<>(insumo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Insumo> create(@RequestBody Insumo insumo) {
        Insumo createdInsumo = insumoService.save(insumo);
        return new ResponseEntity<>(createdInsumo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Insumo> update(@PathVariable Long id, @RequestBody Insumo insumo) {
        Insumo updatedInsumo = insumoService.update(id, insumo);
        if (updatedInsumo != null) {
            return new ResponseEntity<>(updatedInsumo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (insumoService.findById(id).isPresent()) {
            insumoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}