package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.TipoPersona;

public interface ITipoPersonaService {
    Optional<TipoPersona> findById(Long id);
    List<TipoPersona> getAll();
    TipoPersona save(TipoPersona tipoPersona);
    TipoPersona update(Long id, TipoPersona tipoPersona);
    void deleteById(Long id);
    
}
