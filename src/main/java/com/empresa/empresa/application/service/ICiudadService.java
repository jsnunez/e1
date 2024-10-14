package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Ciudad;

public interface ICiudadService {
    Optional<Ciudad> findById(Long id);
    List<Ciudad> getAll();
    Ciudad save(Ciudad ciudad);
    Ciudad update(Long id, Ciudad ciudad);
    void deleteById(Long id);
}

