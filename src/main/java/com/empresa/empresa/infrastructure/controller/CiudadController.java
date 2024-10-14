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

import com.empresa.empresa.application.service.ICiudadService;
import com.empresa.empresa.domain.Ciudad;

@RestController
@RequestMapping("/api/ciudad")
public class CiudadController {

    @Autowired
    private ICiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> list() {
        List<Ciudad> ciudades = ciudadService.getAll();
        return new ResponseEntity<>(ciudades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> show(@PathVariable Long id) {
        return ciudadService.findById(id)
                .map(ciudad -> new ResponseEntity<>(ciudad, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Ciudad> create(@RequestBody Ciudad ciudad) {
        Ciudad createdCiudad = ciudadService.save(ciudad);
        return new ResponseEntity<>(createdCiudad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id, @RequestBody Ciudad ciudad) {
        Ciudad updatedCiudad = ciudadService.update(id, ciudad);
        if (updatedCiudad != null) {
            return new ResponseEntity<>(updatedCiudad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (ciudadService.findById(id).isPresent()) {
            ciudadService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        return null;
    }
}
