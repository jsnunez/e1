package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IDetalleOrdenTrabajoService;
import com.empresa.empresa.domain.DetalleOrdenTrabajo;
import com.empresa.empresa.infrastructure.repository.DetalleOrdenTrabajoRepository;



@Service
public class DetalleOrdenTrabajoAdapter implements IDetalleOrdenTrabajoService {

    @Autowired
    private DetalleOrdenTrabajoRepository detalleOrdenTrabajoRepository;

    @Override
    public Optional<DetalleOrdenTrabajo> findById(Long id) {
        return detalleOrdenTrabajoRepository.findById(id);
    }

    @Override
    public List<DetalleOrdenTrabajo> getAll() {
        return detalleOrdenTrabajoRepository.findAll();
    }

    @Override
    public DetalleOrdenTrabajo save(DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return detalleOrdenTrabajoRepository.save(detalleOrdenTrabajo);
    }

    @Override
    public DetalleOrdenTrabajo update(Long id, DetalleOrdenTrabajo detalleOrdenTrabajo) {
        return detalleOrdenTrabajoRepository.findById(id)
            .map(existingDetalle -> {
                // Actualiza los campos relevantes aquí
                return detalleOrdenTrabajoRepository.save(existingDetalle);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        detalleOrdenTrabajoRepository.deleteById(id);
    }
}
