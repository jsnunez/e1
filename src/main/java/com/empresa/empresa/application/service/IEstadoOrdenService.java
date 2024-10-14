package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.EstadoOrden;

public interface IEstadoOrdenService {
    Optional<EstadoOrden> findById(Long id);
    List<EstadoOrden> getAll();
    EstadoOrden save(EstadoOrden estadoOrden);
    EstadoOrden update(Long id, EstadoOrden estadoOrden);
    void deleteById(Long id);
}
