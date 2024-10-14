package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.TipoEmail;

public interface ITipoEmailService {
    Optional<TipoEmail> findById(Long id);
    List<TipoEmail> getAll();
    TipoEmail save(TipoEmail tipoEmail);
    TipoEmail update(Long id, TipoEmail tipoEmail);
    void deleteById(Long id);
}

