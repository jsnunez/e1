package com.empresa.empresa.application.service;
import java.util.List;
import java.util.Optional;

import com.empresa.empresa.domain.PersonaInsumoPK;
import com.empresa.empresa.domain.Persona_Insumo;

public interface IPersonaInsumoService {
    Optional<Persona_Insumo> findById(PersonaInsumoPK id);
    List<Persona_Insumo> getAll();
    Persona_Insumo save(Persona_Insumo personaInsumo);
    Persona_Insumo update(PersonaInsumoPK id, Persona_Insumo personaInsumo);
    void deleteById(PersonaInsumoPK id);
}

