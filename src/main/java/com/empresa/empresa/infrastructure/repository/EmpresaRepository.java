package com.empresa.empresa.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.empresa.domain.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
