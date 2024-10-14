package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.OrdenTrabajo;

public interface IOrdenTrabajoService {
    Optional<OrdenTrabajo> findById(Long id);
    List<OrdenTrabajo> getAll();
    OrdenTrabajo save(OrdenTrabajo ordenTrabajo);
    OrdenTrabajo update(Long id, OrdenTrabajo ordenTrabajo);
    void deleteById(Long id);
}
