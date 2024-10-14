package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Persona;

public interface IPersonaService {
    Optional<Persona> findById(Long id);
    List<Persona> getAll();
    Persona save(Persona persona);
    Persona update(Long id, Persona persona);
    void deleteById(Long id);
}
