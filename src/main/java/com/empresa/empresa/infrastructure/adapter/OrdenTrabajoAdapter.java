package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IOrdenTrabajoService;
import com.empresa.empresa.domain.OrdenTrabajo;
import com.empresa.empresa.infrastructure.repository.OrdenTrabajoRepository;

@Service
public class OrdenTrabajoAdapter implements IOrdenTrabajoService {

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Override
    public Optional<OrdenTrabajo> findById(Long id) {
        return ordenTrabajoRepository.findById(id);
    }

    @Override
    public List<OrdenTrabajo> getAll() {
        return ordenTrabajoRepository.findAll();
    }

    @Override
    public OrdenTrabajo save(OrdenTrabajo ordenTrabajo) {
        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo update(Long id, OrdenTrabajo ordenTrabajo) {
        return ordenTrabajoRepository.findById(id)
            .map(existingOrden -> {
                existingOrden.setNroOrdenT(ordenTrabajo.getNroOrdenT());
                return ordenTrabajoRepository.save(existingOrden);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ordenTrabajoRepository.deleteById(id);
    }
}
