package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ITipoTelefonoService;
import com.empresa.empresa.domain.TipoTelefono;
import com.empresa.empresa.infrastructure.repository.TipoTelefonoRepository;
@Service
public class TipoTelefonoAdapter implements ITipoTelefonoService {

    @Autowired
    private TipoTelefonoRepository tipoTelefonoRepository;

    @Override
    public Optional<TipoTelefono> findById(Long id) {
        return tipoTelefonoRepository.findById(id);
    }

    @Override
    public List<TipoTelefono> getAll() {
        return tipoTelefonoRepository.findAll();
    }

    @Override
    public TipoTelefono save(TipoTelefono tipoTelefono) {
        return tipoTelefonoRepository.save(tipoTelefono);
    }

    @Override
    public TipoTelefono update(Long id, TipoTelefono tipoTelefono) {
        return tipoTelefonoRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setDescripcion(tipoTelefono.getDescripcion());
                return tipoTelefonoRepository.save(existingTipo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoTelefonoRepository.deleteById(id);
    }
}
