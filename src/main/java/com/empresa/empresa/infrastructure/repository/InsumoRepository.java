package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Insumo;

public interface InsumoRepository extends JpaRepository<Insumo, Long> {

}
