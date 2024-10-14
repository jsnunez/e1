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

import com.empresa.empresa.application.service.ITipoEmpresaService;
import com.empresa.empresa.domain.TipoEmpresa;



@RestController
@RequestMapping("/api/tipoempresa")
public class TipoEmpresaController {
    @Autowired
    private ITipoEmpresaService tipoEmpresaService;

    @GetMapping
    public ResponseEntity<List<TipoEmpresa>> list() {
        List<TipoEmpresa> tiposEmpresa = tipoEmpresaService.getAll();
        return new ResponseEntity<>(tiposEmpresa, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEmpresa> show(@PathVariable Long id) {
        return tipoEmpresaService.findById(id)
                .map(tipo -> new ResponseEntity<>(tipo, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TipoEmpresa> create(@RequestBody TipoEmpresa tipoEmpresa) {
        TipoEmpresa createdTipo = tipoEmpresaService.save(tipoEmpresa);
        return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoEmpresa> update(@PathVariable Long id, @RequestBody TipoEmpresa tipoEmpresa) {
        TipoEmpresa updatedTipo = tipoEmpresaService.update(id, tipoEmpresa);
        if (updatedTipo != null) {
            return new ResponseEntity<>(updatedTipo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tipoEmpresaService.findById(id).isPresent()) {
            tipoEmpresaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

