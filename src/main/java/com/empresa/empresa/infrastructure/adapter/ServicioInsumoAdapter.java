package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IServicioInsumoService;
import com.empresa.empresa.domain.ServicioInsumo;
import com.empresa.empresa.domain.ServicioInsumoPK;
import com.empresa.empresa.infrastructure.repository.ServicioInsumoRepository;
@Service
public class ServicioInsumoAdapter implements IServicioInsumoService {

    @Autowired
    private ServicioInsumoRepository servicioInsumoRepository;

    @Override
    public Optional<ServicioInsumo> findById(ServicioInsumoPK id) {
        return servicioInsumoRepository.findById(id);
    }

    @Override
    public List<ServicioInsumo> getAll() {
        return servicioInsumoRepository.findAll();
    }

    @Override
    public ServicioInsumo save(ServicioInsumo servicioInsumo) {
        return servicioInsumoRepository.save(servicioInsumo);
    }

    @Override
    public ServicioInsumo update(ServicioInsumoPK id, ServicioInsumo servicioInsumo) {
        return servicioInsumoRepository.findById(id)
            .map(existingServicioInsumo -> {
                existingServicioInsumo.setId(servicioInsumo.getId());
                return servicioInsumoRepository.save(existingServicioInsumo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(ServicioInsumoPK id) {
        servicioInsumoRepository.deleteById(id);
    }
}
