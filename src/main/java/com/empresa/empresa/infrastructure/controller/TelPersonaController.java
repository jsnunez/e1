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

import com.empresa.empresa.application.service.ITelPersonaService;
import com.empresa.empresa.domain.TelPersona;



@RestController
@RequestMapping("/api/telpersona")
public class TelPersonaController {
    @Autowired
    private ITelPersonaService telPersonaService;

    @GetMapping
    public ResponseEntity<List<TelPersona>> list() {
        List<TelPersona> telefonos = telPersonaService.getAll();
        return new ResponseEntity<>(telefonos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelPersona> show(@PathVariable Long id) {
        return telPersonaService.findById(id)
                .map(telefono -> new ResponseEntity<>(telefono, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TelPersona> create(@RequestBody TelPersona telPersona) {
        TelPersona createdTelefono = telPersonaService.save(telPersona);
        return new ResponseEntity<>(createdTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelPersona> update(@PathVariable Long id, @RequestBody TelPersona telPersona) {
        TelPersona updatedTelefono = telPersonaService.update(id, telPersona);
        if (updatedTelefono != null) {
            return new ResponseEntity<>(updatedTelefono, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (telPersonaService.findById(id).isPresent()) {
            telPersonaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/proveedor/{nroDoc}")
    public ResponseEntity<List<TelPersona>> getTelefonos(@PathVariable Long nroDoc) {
        List<TelPersona> telefonos = telPersonaService.findByNroDoc(nroDoc);
        if (telefonos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(telefonos, HttpStatus.OK);
    }
}
