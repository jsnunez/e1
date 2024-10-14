package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.EstadoAprobacion;

public interface EstadoAprobacionRepository extends JpaRepository<EstadoAprobacion, Long> {

}
