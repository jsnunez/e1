package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ITipoPersonaService;
import com.empresa.empresa.application.service.ITipoPersonaService;
import com.empresa.empresa.domain.TipoPersona;
import com.empresa.empresa.infrastructure.repository.TipoPersonaRepository;
@Service
public class TipoPersonaAdapter implements ITipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    @Override
    public Optional<TipoPersona> findById(Long id) {
        return tipoPersonaRepository.findById(id);
    }

    @Override
    public List<TipoPersona> getAll() {
        return tipoPersonaRepository.findAll();
    }

    @Override
    public TipoPersona save(TipoPersona tipoPersona) {
        return tipoPersonaRepository.save(tipoPersona);
    }


    @Override
    public void deleteById(Long id) {
        tipoPersonaRepository.deleteById(id);
    }

    @Override
    public TipoPersona update(Long id, TipoPersona tipoPersona) {
        return tipoPersonaRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setNombre(tipoPersona.getNombre());
                return tipoPersonaRepository.save(existingTipo);
            })
            .orElse(null);
        }
}
