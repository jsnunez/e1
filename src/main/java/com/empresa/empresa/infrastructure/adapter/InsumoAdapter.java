package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IInsumoService;
import com.empresa.empresa.domain.Insumo;
import com.empresa.empresa.infrastructure.repository.InsumoRepository;


@Service
public class InsumoAdapter implements IInsumoService {

    @Autowired
    private InsumoRepository insumoRepository;

    @Override
    public Optional<Insumo> findById(Long id) {
        return insumoRepository.findById(id);
    }

    @Override
    public List<Insumo> getAll() {
        return insumoRepository.findAll();
    }

    
    @Override
    public void deleteById(Long id) {
        insumoRepository.deleteById(id);
    }

    @Override
    public Insumo save(Insumo insumo) {
        return insumoRepository.save(insumo);
 }

    @Override
    public Insumo update(Long id, Insumo insumo) {
        return insumoRepository.findById(id)
        .map(existingInsumo -> {
            existingInsumo.setNombreInsumo(insumo.getNombreInsumo());
            return insumoRepository.save(existingInsumo);
        })
        .orElse(null);
}
}
