package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Detalle_Orden;

public interface Detalle_OrdenRepository extends JpaRepository<Detalle_Orden, Long> {

}
