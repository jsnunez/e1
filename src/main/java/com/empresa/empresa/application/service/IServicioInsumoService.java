package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.ServicioInsumo;
import com.empresa.empresa.domain.ServicioInsumoPK;

public interface IServicioInsumoService {
    Optional<ServicioInsumo> findById(ServicioInsumoPK id);
    List<ServicioInsumo> getAll();
    ServicioInsumo save(ServicioInsumo servicioInsumo);
    ServicioInsumo update(ServicioInsumoPK id, ServicioInsumo servicioInsumo);
    void deleteById(ServicioInsumoPK id);
}

