package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.OrdenServicio;

public interface IOrdenServicioService {
    Optional<OrdenServicio> findById(Long id);
    List<OrdenServicio> getAll();
    OrdenServicio save(OrdenServicio ordenServicio);
    OrdenServicio update(Long id, OrdenServicio ordenServicio);
    void deleteById(Long id);
}

