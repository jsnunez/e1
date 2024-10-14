package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IDetalleOrdenService;
import com.empresa.empresa.domain.Detalle_Orden;
import com.empresa.empresa.infrastructure.repository.Detalle_OrdenRepository;



@Service
public class DetalleOrdenAdapter implements IDetalleOrdenService {

    @Autowired
    private Detalle_OrdenRepository detalleOrdenRepository;

    @Override
    public Optional<Detalle_Orden> findById(Long id) {
        return detalleOrdenRepository.findById(id);
    }

    @Override
    public List<Detalle_Orden> getAll() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public Detalle_Orden save(Detalle_Orden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

    @Override
    public Detalle_Orden update(Long id, Detalle_Orden detalleOrden) {
        return detalleOrdenRepository.findById(id)
            .map(existingDetalle -> {
                existingDetalle.setNombre(detalleOrden.getNombre());
                return detalleOrdenRepository.save(existingDetalle);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        detalleOrdenRepository.deleteById(id);
    }
}
