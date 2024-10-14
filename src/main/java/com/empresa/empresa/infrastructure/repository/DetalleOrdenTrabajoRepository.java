package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.DetalleOrdenTrabajo;


public interface DetalleOrdenTrabajoRepository extends JpaRepository<DetalleOrdenTrabajo, Long> {

}
