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

import com.empresa.empresa.application.service.IServicioInsumoService;
import com.empresa.empresa.domain.ServicioInsumo;
import com.empresa.empresa.domain.ServicioInsumoPK;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servicioinsumo")
public class ServicioInsumoController {

    @Autowired
    private IServicioInsumoService servicioInsumoService;

    @GetMapping
    public ResponseEntity<List<ServicioInsumo>> list() {
        List<ServicioInsumo> serviciosInsumos = servicioInsumoService.getAll();
        return new ResponseEntity<>(serviciosInsumos, HttpStatus.OK);
    }

  
    @PostMapping
    public ResponseEntity<ServicioInsumo> create(@RequestBody ServicioInsumo servicio) {
        ServicioInsumo createdServicio = servicioInsumoService.save(servicio);
        return new ResponseEntity<>(createdServicio, HttpStatus.CREATED);
    }
@GetMapping("/{idServicio}/{idInsumo}")
public ResponseEntity<ServicioInsumo> show(@PathVariable Long idServicio, @PathVariable Long idInsumo) {
    ServicioInsumoPK id = new ServicioInsumoPK(idInsumo, idServicio);
    return servicioInsumoService.findById(id)
            .map(servicio -> new ResponseEntity<>(servicio, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

@PutMapping("/{idServicio}/{idInsumo}")
public ResponseEntity<ServicioInsumo> update(@PathVariable Long idServicio, @PathVariable Long idInsumo, @RequestBody @Valid ServicioInsumo servicio) {
    ServicioInsumoPK id = new ServicioInsumoPK(idInsumo, idServicio);
    try {
        ServicioInsumo updatedServicio = servicioInsumoService.update(id, servicio);
        return new ResponseEntity<>(updatedServicio, HttpStatus.OK);
    } catch (EntityNotFoundException e) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

@DeleteMapping("/{idServicio}/{idInsumo}")
public ResponseEntity<Void> delete(@PathVariable Long idServicio, @PathVariable Long idInsumo) {
    ServicioInsumoPK id = new ServicioInsumoPK(idInsumo, idServicio);
    if (servicioInsumoService.findById(id).isPresent()) {
        servicioInsumoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}


    


}