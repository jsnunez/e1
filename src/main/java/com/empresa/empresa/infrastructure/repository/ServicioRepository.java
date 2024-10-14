package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

}
