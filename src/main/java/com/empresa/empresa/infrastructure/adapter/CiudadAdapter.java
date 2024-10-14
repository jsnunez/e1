package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ICiudadService;
import com.empresa.empresa.domain.Ciudad;
import com.empresa.empresa.infrastructure.repository.CiudadRepository;

@Service
public class CiudadAdapter implements ICiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;
   
    @Override
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }

    @Override
    public List<Ciudad> getAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad update(Long id, Ciudad ciudad) {
        return ciudadRepository.findById(id)
            .map(existingCiudad -> {
                existingCiudad.setNombre(ciudad.getNombre());
                return ciudadRepository.save(existingCiudad);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }
}
