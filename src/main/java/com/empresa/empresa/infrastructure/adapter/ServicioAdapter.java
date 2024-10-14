package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IServicioService;
import com.empresa.empresa.domain.Servicio;
import com.empresa.empresa.infrastructure.repository.ServicioRepository;
@Service
public class ServicioAdapter implements IServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public Optional<Servicio> findById(Long id) {
        return servicioRepository.findById(id);
    }

    @Override
    public List<Servicio> getAll() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public Servicio update(Long id, Servicio servicio) {
        return servicioRepository.findById(id)
            .map(existingServicio -> {
                existingServicio.setNombre(servicio.getNombre());
                return servicioRepository.save(existingServicio);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        servicioRepository.deleteById(id);
    }
}
