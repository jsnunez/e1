package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.DetalleOrdenTrabajo;

public interface IDetalleOrdenTrabajoService {
    Optional<DetalleOrdenTrabajo> findById(Long id);
    List<DetalleOrdenTrabajo> getAll();
    DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo);
    DetalleOrdenTrabajo update(Long id, DetalleOrdenTrabajo detalleOrdenTrabajo);
    void deleteById(Long id);
}
