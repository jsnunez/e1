package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.ITelPersonaService;
import com.empresa.empresa.domain.TelPersona;
import com.empresa.empresa.infrastructure.repository.TelPersonaRepository;
@Service
public class TelPersonaAdapter implements ITelPersonaService {

    @Autowired
    private TelPersonaRepository telPersonaRepository;

    @Override
    public Optional<TelPersona> findById(Long id) {
        return telPersonaRepository.findById(id);
    }

    @Override
    public List<TelPersona> getAll() {
        return telPersonaRepository.findAll();
    }

    @Override
    public TelPersona save(TelPersona telPersona) {
        return telPersonaRepository.save(telPersona);
    }

    @Override
    public TelPersona update(Long id, TelPersona telPersona) {
        return telPersonaRepository.findById(id)
            .map(existingTel -> {
                existingTel.setNro(telPersona.getNro());
                return telPersonaRepository.save(existingTel);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        telPersonaRepository.deleteById(id);
    }

    public List<TelPersona> findByNroDoc(Long nroDoc) {
        return telPersonaRepository.findByPersona_NroDoc(nroDoc);
    }
}
