package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.TipoEmpresa;

public interface ITipoEmpresaService {
    Optional<TipoEmpresa> findById(Long id);
    List<TipoEmpresa> getAll();
    TipoEmpresa save(TipoEmpresa tipoEmpresa);
    TipoEmpresa update(Long id, TipoEmpresa tipoEmpresa);
    void deleteById(Long id);
}
