package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ITipoEmailService;
import com.empresa.empresa.domain.TipoEmail;
import com.empresa.empresa.infrastructure.repository.TipoEmailRepository;
@Service
public class TipoEmailAdapter implements ITipoEmailService {

    @Autowired
    private TipoEmailRepository tipoEmailRepository;

    @Override
    public Optional<TipoEmail> findById(Long id) {
        return tipoEmailRepository.findById(id);
    }

    @Override
    public List<TipoEmail> getAll() {
        return tipoEmailRepository.findAll();
    }

    @Override
    public TipoEmail save(TipoEmail tipoEmail) {
        return tipoEmailRepository.save(tipoEmail);
    }

    @Override
    public TipoEmail update(Long id, TipoEmail tipoEmail) {
        return tipoEmailRepository.findById(id)
            .map(existingTipo -> {
                existingTipo.setNombre(tipoEmail.getNombre());
                return tipoEmailRepository.save(existingTipo);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipoEmailRepository.deleteById(id);
    }
}
