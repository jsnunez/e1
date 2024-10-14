package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IPaisService;
import com.empresa.empresa.domain.*;
import com.empresa.empresa.infrastructure.repository.*;
@Service
public class PaisAdapter implements IPaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }

    @Override
    public List<Pais> getAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public Pais update(Long id, Pais pais) {
        return paisRepository.findById(id)
            .map(existingPais -> {
                existingPais.setNombre(pais.getNombre());
                return paisRepository.save(existingPais);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}
