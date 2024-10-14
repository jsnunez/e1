package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.EstadoOrden;

public interface EstadoOrdenRepository extends JpaRepository<EstadoOrden, Long> {

}
