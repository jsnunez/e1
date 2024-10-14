package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.TipoPersona;

public interface TipoPersonaRepository extends JpaRepository<TipoPersona, Long> {

}
