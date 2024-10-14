package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEstadoAprobacionService;
import com.empresa.empresa.domain.EstadoAprobacion;
import com.empresa.empresa.infrastructure.repository.EstadoAprobacionRepository;


@Service
public class EstadoAprobacionAdapter implements IEstadoAprobacionService {

    @Autowired
    private EstadoAprobacionRepository estadoAprobacionRepository;

    @Override
    public Optional<EstadoAprobacion> findById(Long id) {
        return estadoAprobacionRepository.findById(id);
    }

    @Override
    public List<EstadoAprobacion> getAll() {
        return estadoAprobacionRepository.findAll();
    }

    @Override
    public EstadoAprobacion save(EstadoAprobacion estadoAprobacion) {
        return estadoAprobacionRepository.save(estadoAprobacion);
    }

    @Override
    public EstadoAprobacion update(Long id, EstadoAprobacion estadoAprobacion) {
        return estadoAprobacionRepository.findById(id)
            .map(existingEstado -> {
                existingEstado.setNombre(estadoAprobacion.getNombre());
                return estadoAprobacionRepository.save(existingEstado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estadoAprobacionRepository.deleteById(id);
    }
}
