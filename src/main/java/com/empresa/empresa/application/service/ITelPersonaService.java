package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.TelPersona;

public interface ITelPersonaService {
    Optional<TelPersona> findById(Long id);
    List<TelPersona> getAll();
    TelPersona save(TelPersona telPersona);
    TelPersona update(Long id, TelPersona telPersona);
    void deleteById(Long id);
    List<TelPersona> findByNroDoc(Long nroDoc);
}

