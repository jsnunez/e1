package com.empresa.empresa.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.TelPersona;

public interface TelPersonaRepository extends JpaRepository<TelPersona, Long> {
    List<TelPersona> findByPersona_NroDoc(Long nroDoc);

}
