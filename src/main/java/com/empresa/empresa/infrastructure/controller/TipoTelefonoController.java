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

import com.empresa.empresa.application.service.ITipoTelefonoService;
import com.empresa.empresa.domain.TipoTelefono;



@RestController
@RequestMapping("/api/tipotelefono")
public class TipoTelefonoController {

    @Autowired
    private ITipoTelefonoService tipoTelefonoService;

    @GetMapping
    public ResponseEntity<List<TipoTelefono>> list() {
        List<TipoTelefono> tiposTelefono = tipoTelefonoService.getAll();
        return new ResponseEntity<>(tiposTelefono, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoTelefono> show(@PathVariable Long id) {
        return tipoTelefonoService.findById(id)
                .map(tipoTelefono -> new ResponseEntity<>(tipoTelefono, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoTelefono> create(@RequestBody TipoTelefono tipoTelefono) {
        TipoTelefono createdTipoTelefono = tipoTelefonoService.save(tipoTelefono);
        return new ResponseEntity<>(createdTipoTelefono, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoTelefono> update(@PathVariable Long id, @RequestBody TipoTelefono tipoTelefono) {
        TipoTelefono updatedTipoTelefono = tipoTelefonoService.update(id, tipoTelefono);
        if (updatedTipoTelefono != null) {
            return new ResponseEntity<>(updatedTipoTelefono, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tipoTelefonoService.findById(id).isPresent()) {
            tipoTelefonoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}