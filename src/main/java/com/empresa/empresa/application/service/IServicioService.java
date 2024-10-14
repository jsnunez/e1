package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Servicio;

public interface IServicioService {
    Optional<Servicio> findById(Long id);
    List<Servicio> getAll();
    Servicio save(Servicio servicio);
    Servicio update(Long id, Servicio servicio);
    void deleteById(Long id);
}


