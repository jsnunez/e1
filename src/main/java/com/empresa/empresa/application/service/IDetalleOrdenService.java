package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Detalle_Orden;

public interface IDetalleOrdenService {
    Optional<Detalle_Orden> findById(Long id);
    List<Detalle_Orden> getAll();
    Detalle_Orden save(Detalle_Orden detalleOrden);
    Detalle_Orden update(Long id, Detalle_Orden detalleOrden);
    void deleteById(Long id);
}
