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

import com.empresa.empresa.application.service.ITipoEmailService;
import com.empresa.empresa.domain.TipoEmail;



@RestController
@RequestMapping("/api/tipo-email")
public class TipoEmailController {

    @Autowired
    private ITipoEmailService tipoEmailService;

    @GetMapping
    public ResponseEntity<List<TipoEmail>> list() {
        List<TipoEmail> tiposEmail = tipoEmailService.getAll();
        return new ResponseEntity<>(tiposEmail, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEmail> show(@PathVariable Long id) {
        return tipoEmailService.findById(id)
                .map(tipoEmail -> new ResponseEntity<>(tipoEmail, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoEmail> create(@RequestBody TipoEmail tipoEmail) {
        TipoEmail createdTipoEmail = tipoEmailService.save(tipoEmail);
        return new ResponseEntity<>(createdTipoEmail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEmail> update(@PathVariable Long id, @RequestBody TipoEmail tipoEmail) {
        TipoEmail updatedTipoEmail = tipoEmailService.update(id, tipoEmail);
        if (updatedTipoEmail != null) {
            return new ResponseEntity<>(updatedTipoEmail, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tipoEmailService.findById(id).isPresent()) {
            tipoEmailService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}