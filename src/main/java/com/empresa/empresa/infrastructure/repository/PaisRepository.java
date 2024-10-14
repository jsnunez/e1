package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

}
