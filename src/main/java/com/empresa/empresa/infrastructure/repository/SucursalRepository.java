package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Long> {

}
