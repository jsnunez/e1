package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Insumo;

public interface IInsumoService {
    Optional<Insumo> findById(Long id);
    List<Insumo> getAll();
    Insumo save(Insumo insumo);
    Insumo update(Long id, Insumo insumo);
    void deleteById(Long id);
}
