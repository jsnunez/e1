package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IOrdenServicioService;
import com.empresa.empresa.domain.OrdenServicio;
import com.empresa.empresa.infrastructure.repository.OrdenServicioRepository;
@Service
public class OrdenServicioAdapter implements IOrdenServicioService {

    @Autowired
    private OrdenServicioRepository ordenServicioRepository;

    @Override
    public Optional<OrdenServicio> findById(Long id) {
        return ordenServicioRepository.findById(id);
    }

    @Override
    public List<OrdenServicio> getAll() {
        return ordenServicioRepository.findAll();
    }

    @Override
    public OrdenServicio save(OrdenServicio ordenServicio) {
        return ordenServicioRepository.save(ordenServicio);
    }

    @Override
    public OrdenServicio update(Long id, OrdenServicio ordenServicio) {
        return ordenServicioRepository.findById(id)
            .map(existingOrden -> {
                existingOrden.setNoOrden(ordenServicio.getNoOrden());
                return ordenServicioRepository.save(existingOrden);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ordenServicioRepository.deleteById(id);
    }
}
