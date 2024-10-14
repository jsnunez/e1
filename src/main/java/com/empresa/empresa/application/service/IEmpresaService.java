package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Empresa;

public interface IEmpresaService {
    Optional<Empresa> findById(Long id);
    List<Empresa> getAll();
    Empresa save(Empresa empresa);
    Empresa update(Long id, Empresa empresa);
    void deleteById(Long id);
}

