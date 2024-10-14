package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Estado_Ser_Orden;

public interface IEstadoSerOrdenService {
    Optional<Estado_Ser_Orden> findById(Long id);
    List<Estado_Ser_Orden> getAll();
    Estado_Ser_Orden save(Estado_Ser_Orden estadoSerOrden);
    Estado_Ser_Orden update(Long id, Estado_Ser_Orden estadoSerOrden);
    void deleteById(Long id);
}

