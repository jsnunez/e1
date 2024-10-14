package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.PersonaInsumoPK;
import com.empresa.empresa.domain.Persona_Insumo;

public interface Persona_InsumoRepository extends JpaRepository<Persona_Insumo, PersonaInsumoPK> {

}
