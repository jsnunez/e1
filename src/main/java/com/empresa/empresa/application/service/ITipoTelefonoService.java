package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.TipoTelefono;

public interface ITipoTelefonoService {
    Optional<TipoTelefono> findById(Long id);
    List<TipoTelefono> getAll();
    TipoTelefono save(TipoTelefono tipoTelefono);
    TipoTelefono update(Long id, TipoTelefono tipoTelefono);
    void deleteById(Long id);
}

