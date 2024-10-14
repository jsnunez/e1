package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IEstadoSerOrdenService;
import com.empresa.empresa.domain.Estado_Ser_Orden;
import com.empresa.empresa.infrastructure.repository.Estado_Ser_OrdenRepository;



@Service
public class EstadoSerOrdenAdapter implements IEstadoSerOrdenService {

    @Autowired
    private Estado_Ser_OrdenRepository estadoSerOrdenRepository;

    @Override
    public Optional<Estado_Ser_Orden> findById(Long id) {
        return estadoSerOrdenRepository.findById(id);
    }

    @Override
    public List<Estado_Ser_Orden> getAll() {
        return estadoSerOrdenRepository.findAll();
    }

    @Override
    public Estado_Ser_Orden save(Estado_Ser_Orden estadoSerOrden) {
        return estadoSerOrdenRepository.save(estadoSerOrden);
    }

    @Override
    public Estado_Ser_Orden update(Long id, Estado_Ser_Orden estadoSerOrden) {
        return estadoSerOrdenRepository.findById(id)
            .map(existingEstado -> {
                existingEstado.setNombre(estadoSerOrden.getNombre());
                return estadoSerOrdenRepository.save(existingEstado);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        estadoSerOrdenRepository.deleteById(id);
    }
}
