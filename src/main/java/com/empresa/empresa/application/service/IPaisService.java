package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Pais;

public interface IPaisService {
    Optional<Pais> findById(Long id);
    List<Pais> getAll();
    Pais save(Pais pais);
    Pais update(Long id, Pais pais);
    void deleteById(Long id);
}
