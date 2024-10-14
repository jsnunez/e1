package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Persona;

public interface personaRepository extends JpaRepository<Persona, Long> {

}
