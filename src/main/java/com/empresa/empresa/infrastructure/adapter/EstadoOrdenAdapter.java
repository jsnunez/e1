package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEstadoOrdenService;
import com.empresa.empresa.domain.EstadoOrden;
import com.empresa.empresa.infrastructure.repository.EstadoOrdenRepository;



@Service
public class EstadoOrdenAdapter implements IEstadoOrdenService {

    @Autowired
    private EstadoOrdenRepository estadoOrdenRepository;

    @Override
    public Optional<EstadoOrden> findById(Long id) {
        return estadoOrdenRepository.findById(id);
    }

    @Override
    public List<EstadoOrden> getAll() {
        return estadoOrdenRepository.findAll();
    }

    @Override
    public EstadoOrden save(EstadoOrden estadoOrden) {
        return estadoOrdenRepository.save(estadoOrden);
    }

    @Override
    public EstadoOrden update(Long id, EstadoOrden estadoOrden) {
        return estadoOrdenRepository.findById(id)
            .map(existingEstado -> {
                existingEstado.setNombre(estadoOrden.getNombre());
                return estadoOrdenRepository.save(existingEstado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estadoOrdenRepository.deleteById(id);
    }
}
