package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IAprobacionService;
import com.empresa.empresa.domain.AprobacionServicio;
import com.empresa.empresa.infrastructure.repository.AprobacionServicioRepository;

@Service
public class AprobacionServicioAdapter implements IAprobacionService {

    @Autowired
    private AprobacionServicioRepository aprobacionServicioRepository;

    @Override
    public Optional<AprobacionServicio> findById(Long id) {
        return aprobacionServicioRepository.findById(id);
    }

    @Override
    public List<AprobacionServicio> getAll() {
        return aprobacionServicioRepository.findAll();
    }

    @Override
    public AprobacionServicio save(AprobacionServicio aprobacionServicio) {
        return aprobacionServicioRepository.save(aprobacionServicio);
    }

    @Override
    public AprobacionServicio update(Long id, AprobacionServicio aprobacionServicio) {
        return aprobacionServicioRepository.findById(id)
            .map(existingAprobacion -> {
                existingAprobacion.setHallazgo(aprobacionServicio.getHallazgo());
                existingAprobacion.setSolucion(aprobacionServicio.getSolucion());
                existingAprobacion.setEstadoAprobacion(aprobacionServicio.getEstadoAprobacion());
                return aprobacionServicioRepository.save(existingAprobacion);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        aprobacionServicioRepository.deleteById(id);
    }
}
