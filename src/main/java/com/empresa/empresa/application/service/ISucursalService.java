package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.Sucursal;

public interface ISucursalService {
    Optional<Sucursal> findById(Long id);
    List<Sucursal> getAll();
    Sucursal save(Sucursal sucursal);
    Sucursal update(Long id, Sucursal sucursal);
    void deleteById(Long id);
}

