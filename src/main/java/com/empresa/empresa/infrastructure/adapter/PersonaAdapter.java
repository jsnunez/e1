package com.empresa.empresa.infrastructure.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.empresa.application.service.IPersonaService;
import com.empresa.empresa.domain.Persona;

@Service
public class PersonaAdapter implements IPersonaService {

    @Autowired
    private com.empresa.empresa.infrastructure.repository.personaRepository personaRepository;

    @Override
    public Optional<Persona> findById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }

    @Override
    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Long id, Persona persona) {
        return personaRepository.findById(id)
            .map(existingPersona -> {
                existingPersona.setNombre(persona.getNombre());
                return personaRepository.save(existingPersona);
            })
            .orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }
}
