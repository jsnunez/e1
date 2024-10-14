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

import com.empresa.empresa.application.service.IPersonaService;
import com.empresa.empresa.domain.Persona;



@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> list() {
        List<Persona> personas = personaService.getAll();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{nroDoc}")
    public ResponseEntity<Persona> show(@PathVariable Long nroDoc) {
        return personaService.findById(nroDoc)
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Persona> create(@RequestBody Persona persona) {
        Persona createdPersona = personaService.save(persona);
        return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{nroDoc}")
    public ResponseEntity<Persona> update(@PathVariable Long nroDoc, @RequestBody Persona persona) {
        Persona updatedPersona = personaService.update(nroDoc, persona);
        if (updatedPersona != null) {
            return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nroDoc}")
    public ResponseEntity<Void> delete(@PathVariable Long nroDoc) {
        if (personaService.findById(nroDoc).isPresent()) {
            personaService.deleteById(nroDoc);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}