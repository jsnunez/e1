package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.EstadoAprobacion;

public interface IEstadoAprobacionService {
    Optional<EstadoAprobacion> findById(Long id);
    List<EstadoAprobacion> getAll();
    EstadoAprobacion save(EstadoAprobacion estadoAprobacion);
    EstadoAprobacion update(Long id, EstadoAprobacion estadoAprobacion);
    void deleteById(Long id);
}

